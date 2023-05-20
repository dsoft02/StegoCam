B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=6.95
@EndOfDesignText@

'   ESTE módulo de escalamento é, em parte, baseado no módulo do Klaus, mas faz  ALGO A MAIS:
'   - permite escalar MAIS de uma vez o mesmo painel, pois as dimensões base usadas são sempre as ORIGINAIS, 
'     enquanto no módulo do Klaus, chamadas adicionais escalariam a partir do último tamanho (já escalado) 
'   - permite escalar para PERCENTUAL do tamanho da tela, com isso pode-se gerar margens e tem outras utilidades...
'     (mas não tentar escalar para menos todo o app, pois todas libs e o SO consideram que um app ocupa 100% da tela)     
'   - o rate aqui tem outro papel e é sempre obedecido, seja qual for o tamanho do dispositivo, 
'     já no módulo do Klaus o rate é um ajuste apenas, e só utilizado para certos tamanhos de telas > 6'',

'            ********** ATENÇÃO ***********
' Este módulo poderia ficar bem mais simples, com menos parametros a passar e com menos coisas a fazer previamente antes de ser usado,  SE fosse possível
' carregar o layout ORIGINAL num container dentro deste módulo/classe. Porém ISSO NÃO É POSSÍVEL (até permite, mas há efeitos colaterais).
' O problema é que ao fazer panel.LoadLayout(L) no contexto de um módulo/classe, perdem-se todas as referências às variáveis do layout (Button1, Label1, etc.)
' que são mantidas lá no contexto da Activity. Ou seja, para essas referências funcionarem, o panel.LoadLayout(L) no container
' que é o ALVO necessariamente DEVE ser a ÚLTIMA coisa feita com o tal layout L, e isso tem que ser feito lá no contexto da Activity.
' EM RESUMO: não usar NUNCA Panel.LoadLayout() dentro de módulo/classe, pois isso é fonte de erros e problemas !!!
'

'Class module
Sub Class_Globals
	Private layValues As LayoutValues
	Private initialAttribs As List
	Private hasTitle As Boolean
	Private isFullScreen As Boolean	
	Private container As Panel         
	Public lastRatioX As Float
	Public lastRatioY As Float
	Public lastPctScreen As Float
	
		
	'tipo usado para armazenar atributos ORIGINAIS das views
	Type ViewAttribs ( _
		top, left As Int, _
		width, height As Int, _
		textSize As Float, _
		ItemHeight As Int, _
		subList As List _
	)
			
End Sub




'Inicializa e carrega o layout no container
'Example:
'<code>scale.Initialize(aContainer As Panel, aLayValues As LayoutValues, aHasTitle As Boolean , aIsFullScreen As Boolean) </code>
Public Sub Initialize(aContainer As Panel, aLayValues As LayoutValues, aHasTitle As Boolean , aIsFullScreen As Boolean) 
	container = aContainer
	layValues = aLayValues
	lastRatioX = 1 
	lastRatioY = 1
	hasTitle = aHasTitle
	isFullScreen = aIsFullScreen
	GuardarAtributosOriginais 'guarda os atributos ORIGINAIS das views
End Sub 


'publica para permitir chamar depois do Initialize, se precisar adicionar algo no container, ANTES do 1o escalamento 
Public  Sub GuardarAtributosOriginais
	Dim lst As List 
	lst.Initialize 
    For Each v As View In container.GetAllViewsRecursive 'estas é uma SUPER-recursão, pega childs de childs,etc.
		If v.Tag <> Null And (v.Tag = "dontresize") Then 'Views podem ter um tag 'dont resize me...' (Designer)
			Continue
		Else 
			Try 'Fazemos um try-catch porque atributos de views nativas tipo AHPager não são acessáveis e dao erro aqui
				Dim attribs As ViewAttribs
				attribs = guardarAttribsView(v)				
				'adiciona o objeto attribs à lista de atributos:
				lst.Add (attribs)
			Catch 
				Log("Erro ao acessar posicoes da suposta view: " & v)
			End Try
		End If
	Next
	initialAttribs = lst
End Sub 



Private Sub guardarAttribsView (v As View)  As ViewAttribs
		Dim attribs As ViewAttribs
		Dim lb As Label : Dim spn As Spinner 
		attribs.Initialize 
		attribs.left = v.Left 
        attribs.Top = v.Top 
        attribs.Width = v.Width 
        attribs.Height = v.Height
		If v Is Label Then 'isso pega varios tipos de objetos que tem 'Label'
			lb = v
			attribs.textSize = lb.TextSize
		End If
		If GetType(v) = "anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner" Then
			spn = v
			attribs.textSize = spn.TextSize
		End If	
		Return attribs
End Sub




'Gets the approximate physical screen size in inches
'Example:
'<code>DeviceSize = Scale.GetDevicePhysicalSize</code>
Public Sub GetDevicePhysicalSize As Float
	Dim lv As LayoutValues
	lv = GetDeviceLayoutValues
	Return Sqrt(Power(lv.Height / lv.Scale / 160, 2) + Power(lv.Width / lv.Scale / 160, 2))
End Sub



' Escala recursivamente o conteúdo do container.
' Escala PARA o tamanho real do dispositivo, usando SEMPRE como base as dimensões ORIGINAIS 
' do layout passado como parametro no metodo Initialize deste modulo/classe.
' (O layout passado precisa JÁ TER SIDO carregado uma vez no container, antes do Initialize desta classe)
' O escalamento é feito PARA o tamanho REAL da tela real do dispositivo ATUALMENTE sendo usado
Public Sub ScaleLayoutToDeviceSize 
	ScaleTo (1)  'Escala para 100% do tamanho da tela do dispositivo
End Sub



Public Sub ScaleLayoutToDeviceSizePercent (pctScreen As Float)
	If pctScreen < 0 Then
		pctScreen = 0
'	Else If pctScreen > 1 Then       'let it be, so we can do upper scale !
'		pctScreen = 1         
	End If
	ScaleTo (pctScreen)
End Sub



Public Sub ScaleTo (pctScreen As Float ) 
	Dim DeviceScale As Double
	DeviceScale = 160dip / 160
	Dim deslocamentoTitle As Int = 0
	Dim deslocamentoFullScreen As Int = 0
	
	Dim ratiox, ratioy As Float

	' Lá no Designer, setando-se ShowTitle = false, faz as views colocadas na parte inferior
	'  da tela terem suas posições Top aumentadas em 25 relativamente às mesmas posições
	'  vistas com ShowTitle=True - MAS, pelo fato de estarmos desescalando algo que o Loadlayout()
	'   já escalou parcialmente, a forma de ter as views corretamente posicionadas, com QUALQUER das flags 
	' setadas no Designer  parece ser SEMPRE usar o deslocamento de 50 fixados abaixo !!!
	If hasTitle = True Then 
	  deslocamentoTitle = 25
	Else
	  deslocamentoTitle = 0
	End If

	If isFullScreen = True Then 
	  deslocamentoFullScreen = 0
	Else
	  deslocamentoFullScreen = 25
	End If

	'deslocamentoTitle = 25
	'deslocamentoFullScreen=25 

	Log ("Layout width = " & layValues.Width) 
	Log ("Layout height = " & layValues.Height)
	
    ratiox = 100%x/layValues.Width/layValues.Scale / DeviceScale 
	ratioy = 100%y / (layValues.Height - deslocamentoTitle - deslocamentoFullScreen) / layValues.Scale / DeviceScale 
	'modulo do Klaus: cScaleY = 100%y / (cRefHeight - 50 * cRefScale) / DeviceScale
	
	'ajusta, de acordo com o percentual da tela do dispostivo que deseja usar:
	ratiox = ratiox * pctScreen
	ratioy = ratioy * pctScreen		
	Log ("ratiox = " & ratiox)
	Log ("ratioy = " & ratioy)
	
	EscalarViewsFromLayout (ratiox, ratioy)
	
	'antes de sairmos, guardamos neste objeto os ratios que foram gerados internamente e utilizados na última chamaada a este metodo:
	lastRatioX = ratiox
	lastRatioY = ratioy	
	lastPctScreen = pctScreen
End Sub 



'Escala recursivamente todas as views do container - criado em Initialize - (não escala o container).
'Example:
'<code>GenialScale.EscalarViewsFromLayout() </code>
Private Sub EscalarViewsFromLayout (ratiox As Float, ratioy As Float) 
	Log ("Iniciando EscalarViewsFromLayout " & " freeX = " & " layoutvalues = " & layValues )
	'Premissas: 
	'  No Designer, ao construir o layout, NÃO usar script commands, (don't use AutoScaleAll  !!  


	
	' RE-Seta todas as views do container alvo com os atributos de posição e size 
	' ORIGINAIS que as views tinham no momento da inicialização, e
	' em seguida, APLICA as taxas de escalamento desejadas
	' (obs: que o containerTemplate NÃO é modificado, fica sempre com valores ORIGINAIS)
	Log("Numero de views: " & container.NumberOfViews ) '<-isso NÃO pega views recursivamente
	Dim i As Int, attribs As ViewAttribs 

	
    i=0: For Each v As View In container.GetAllViewsRecursive 'estas é uma SUPER-recursão, pega childs de childs,etc.

		If v.Tag <> Null And (v.Tag = "dontresize") Then 'Views podem ter um tag 'dont resize me...' (Designer)
			Continue
		Else 
			Try 'Fazemos um try-catch porque atributos de views nativas tipo AHPager não são acessáveis e dariam erro aqui
				attribs = initialAttribs.Get(i)
				escalarView (v, attribs, ratiox, ratioy) 				
			Catch
				Log("Erro ao acessar posicoes da suposta view: " & v)
			End Try 
		End If
		i = i+1
    Next 	
		
End Sub



Private Sub escalarView (v As View, attribs As ViewAttribs, ratiox As Float, ratioy As Float)
        v.Left = attribs.left  * ratiox
        v.Top = attribs.Top   * ratioy 
        v.Width = attribs.Width * ratiox
        v.Height = attribs.Height  * ratioy 
		If v Is Label Then
			Dim lb As Label 
			lb = v
			'lb.TextSize = attribs.textSize * Min(ratiox, ratioy) 
			lb.TextSize = attribs.textSize * (ratiox + ratioy)/2 
		End If
		If GetType(v) = "anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner" Then
			Dim spn As Spinner = v
			spn = v
			'spn.TextSize = attribs.textSize * Min(ratiox, ratioy) 
			spn.TextSize = attribs.textSize * (ratiox + ratioy)/2 
		End If				
				
End Sub


'Centers horizontally the given view in relation to the scaled container
'  OBS - isso SOMENTE pode ser feito depois que fizer add do container na Activity, senão dá NullPointer...!!!
Public Sub HorizontalCenterContainer ( v As View)
	v.Left = (container.Width - v.Width) / 2
End Sub

'Centers vertically the given view ON the scaled container
Public Sub VerticalCenterContainer ( v As View)
	v.Top = (container.Height - v.Height) / 2
End Sub





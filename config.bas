B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=12.2
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Public show As Char = Chr(0xF06E)
	Public hide As Char = Chr(0xF070)
	Dim SharedPrefs As SharedPreferences
	Dim userPin As String =""
	Dim firstRun As Boolean=True
	Dim question As String=""
	Dim answer As String=""
End Sub

Sub getUserPin() As String
	userPin=""
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	'get set up pin
	userPin = SharedPrefs.GetString("PIN","")
	Return userPin
End Sub


Sub setUserPin(pin As String)
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	'get set up pin
	SharedPrefs.SaveString("PIN",pin)
End Sub

Sub saveSecurityQA(quest As String,ans As String)
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	'get set up pin
	SharedPrefs.SaveString("Question",quest)
	SharedPrefs.SaveString("Answer",ans)
End Sub


Sub isFirstRun() As Boolean
	firstRun=True
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	
	' Check if it's the first run
	firstRun = SharedPrefs.GetBoolean("FirstRun", True)
	
	Return firstRun
End Sub


Sub getSecurityQuestion() As String
	question=""
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	
	' get security question
	question = SharedPrefs.GetBoolean("Question", True)
	
	Return question
End Sub


Sub getSecurityAnswer() As String
	answer=""
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	
	' get security answer
	answer = SharedPrefs.GetBoolean("Answer", True)
	
	Return answer
End Sub

Sub AjustImageView(Imv As ImageView, Dir As String, FileName As String)
	Private bmp As Bitmap = LoadBitmap(Dir, FileName)
	Dim Delta, Height, Width As Int
	If bmp.Width / bmp.Height > Imv.Width / Imv.Height Then
		Height = bmp.Height / bmp.Width * Imv.Width
		Delta = (Imv.Height - Height) / 2
		Imv.Height = Height
		Imv.Top = Imv.Top + Delta
	Else
		Width = bmp.Width / bmp.Height * Imv.Height
		Delta = (Imv.Width - Width) / 2
		Imv.Width = Width
		Imv.Left = Imv.Left + Delta
	End If
	Imv.Gravity = Gravity.FILL
	Imv.Bitmap = bmp
End Sub

Sub SetStatusNavBarColor(clr As Int, dark As Boolean)
	Dim p As Phone
	If p.SdkVersion > 20 Then
		'Background color
		Dim jo As JavaObject
		jo.InitializeContext
		Dim window As JavaObject = jo.RunMethodJO("getWindow", Null)
		window.RunMethod("addFlags", Array (0x80000000))
		window.RunMethod("clearFlags", Array (0x04000000))
		window.RunMethod("setStatusBarColor", Array(clr))
		window.RunMethod("setNavigationBarColor", Array(clr))
		Dim view As JavaObject = window.RunMethodJO("getDecorView",Null)
		If dark=True Then
			view.RunMethod("setSystemUiVisibility",Array(Bit.Or(0x00002000,view.RunMethod("getSystemUiVisibility",Null))))
		Else
			view.RunMethod("setSystemUiVisibility",Array(0))
		End If
	End If
End Sub


Sub BitmapToBitmapDrawable (bitmap As Bitmap) As BitmapDrawable
	Dim bd As BitmapDrawable
	bd.Initialize(bitmap)
	Return bd
End Sub
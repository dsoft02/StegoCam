B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.2
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region
#Extends: android.support.v7.app.AppCompatActivity

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private ion As Object
	Private imageChooser As ContentChooser
	Private FileHandler1 As FileHandler
	Private stegoHandler As StegocamHandler
	Public stegoimage As String
	Public fromfile As Boolean=False
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private ACToolBarLight1 As ACToolBarLight
	Private ToolbarHelper As ACActionBar
	Dim SharedPrefs As SharedPreferences
	Dim IME As IME
	Private xui As XUI
	Private Dialog As B4XDialog
	
	Private btnCancel As Button
	Private btnDecode As Button
	Private ImageView2 As ImageView
	Private ImageView3 As ImageView
	Private ImageView4 As ImageView
	Private lblErrorMsg As Label
	Private pnlEncryption As Panel
	Private pnlKey As Panel
	Private pnlMessage As Panel
	Private txtKey As EditText
	Private txtMessage As EditText
	Private imgCover As B4XImageView
	Private pnlCoverImage As Panel
	Private cboEncryption As B4XComboBox
	Private btnBrowse As ImageView
	Private lblShowPassword As Label
	Private imgPreview As ImageView
	Private btnExtract As Button
	Private btnShare As Button
	Private lblImgLocation As Label
	Private pnlPreview As Panel
	Private imgDelete As ImageView
	Private imgExtract As ImageView
	Private imgShare As ImageView
	Private Label1 As Label
	Private Label2 As Label
	Private Label4 As Label
	Private pnlDelete As Panel
	Private pnlExtract As Panel
	Private pnlShare As Panel
	Private txtFileName As EditText
	Private btnCamera As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("decode")
	SharedPrefs.Initialize("StegoCamPrefs")
	ToolbarHelper.Initialize
	ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
	ACToolBarLight1.InitMenuListener
	Dim jo As JavaObject = txtMessage
	txtMessage.InputType=txtMessage.INPUT_TYPE_NONE
	jo.RunMethod("setTextIsSelectable", Array(True))
	txtMessage.SingleLine=False
	txtMessage.Wrap=True
	FileHandler1.Initialize
	stegoHandler.Initialize
	Dialog.Initialize(Activity)
	Dialog.Title = "Stego Image View"
	getPermissions
	If fromfile=False And stegoimage <>"" Then
		txtFileName.Text=stegoimage
		txtFileName.Tag=""
		'imgCover.Bitmap =xui.LoadBitmapResize(stegoimage,"",imgCover.Width,imgCover.Height,True)
		imgCover.Load(stegoimage,"")
	Else
		clearForm
	End If
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub ACToolBarLight1_NavigationItemClick
	clearForm
	StartActivity(mainmenu)
	Activity.Finish
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		clearForm
		StartActivity(mainmenu)
		Activity.Finish
		Return True
	End If
	Return False
End Sub



Private Sub btnCancel_Click
	clearForm
	StartActivity(mainmenu)
	Activity.Finish
End Sub

Private Sub btnDecode_Click
	txtMessage.Text=""
	'Msgbox("_STEGOCAM_" & CRLF & "_STEGOCAM_".GetBytes("UTF8"),"TEST")
	If imgCover.Bitmap=Null Then
		'lblErrorMsg.Text="Please select stego Image"
		config.displayMessage("Please select stego Image",lblErrorMsg,False)
		ToastMessageShow("Please select stego Image",False)
	else if txtKey.Text="" Then
		'lblErrorMsg.Text="Please enter your decryption key"
		config.displayMessage("Please enter your decryption key",lblErrorMsg,False)
		ToastMessageShow("Please enter your decryption key",False)
		txtKey.RequestFocus
	else if txtKey.Text.Length<4 Then
		config.displayMessage("Decryption key must be 4 or more letters",lblErrorMsg,False)
		ToastMessageShow("Decryption key must be 4 or more letters",False)
		txtKey.RequestFocus
	Else
		lblErrorMsg.Text=""
		Dim stegoImageFile As String=txtFileName.Text
		Dim stegoImageFileName As String="stegoimage." & IIf(txtFileName.Tag="fromfile",config.getFileExtension(imgCover.tag),config.getFileExtension(txtFileName.Text))
		'Msgbox("stegoImageFile: " & stegoImageFile & CRLF & "stegoImageFileName: " & stegoImageFileName,"Check Point 1")
		If fromfile=True Or txtFileName.Tag="fromfile" Then
			stegoImageFile =stegoHandler.copyFiletoTemp(txtFileName.Text,stegoImageFileName)
		End If
		'Msgbox(File.Exists(stegoImageFile,""),"Stego Image Exist")
		'stegoHandler.ExtractText(stegoImageFile,txtKey.Text)
'		Msgbox(stegoHandler.isStegoImage(stegoImageFile),"Stego Check")
'		If stegoHandler.isStegoImage(stegoImageFile) Then
			Dim newstegofile As String =stegoImageFile 'stegoHandler.RemoveStegoCamBytes(stegoImageFile)
			If File.Exists(newstegofile,"") Then
				stegoHandler.ExtractText(newstegofile,txtKey.Text)
				'stegoHandler.ExtractText(stegoImageFile,txtKey.Text)
				Sleep(5)
				If stegoHandler.extractionSuccessful Then
					txtMessage.Text=stegoHandler.extractedString
					config.displayMessage(stegoHandler.lastErrorMessage,lblErrorMsg,True)
					ToastMessageShow(stegoHandler.lastErrorMessage,True)
				Else if stegoHandler.extractionSuccessful = False And stegoHandler.lastErrorMessage <> "" Then
					config.displayMessage(stegoHandler.lastErrorMessage,lblErrorMsg,False)
					ToastMessageShow(stegoHandler.lastErrorMessage,True)
				End If
				stegoHandler.lastErrorMessage=""
				stegoHandler.extractionSuccessful = False
				stegoHandler.extractedString=""
			Else
				config.displayMessage("An error has occured please Try Again!",lblErrorMsg,False)
				ToastMessageShow("An error has occured please Try Again!",True)
			End If
'		Else
'			config.displayMessage("Not a valid stego Image",lblErrorMsg,False)
'			ToastMessageShow("Not a valid stego Image",True)
'		End If
	End If
End Sub





Private Sub clearForm
	'If imgCover.Bitmap.IsInitialized Then imgCover.Bitmap=Null
	txtMessage.Text=""
	imgCover.Tag=""
	txtKey.Text=""
	lblShowPassword.Text=config.hide
	txtKey.PasswordMode=True
	stegoimage=""
	fromfile=False
	txtFileName.Text=""
	txtFileName.Tag=""
End Sub


Private Sub btnCamera_Click
	txtMessage.Text=""
	BrowseStegoImage
End Sub

Sub getPermissions
	For Each permission As String In Array(Starter.rp.PERMISSION_CAMERA,Starter.rp.PERMISSION_READ_EXTERNAL_STORAGE, Starter.rp.PERMISSION_WRITE_EXTERNAL_STORAGE)
		Starter.rp.CheckAndRequest(permission)
		Wait For Activity_PermissionResult (permission As String, Result As Boolean)
		If Result = False Then
			MsgboxAsync("Please grant the neccessary permission to continue","No Permission granted")
			'ToastMessageShow("No permission!", True)
			Activity.Finish
			Return
		End If
	Next
	
End Sub

Sub BrowseStegoImage
	Dim xui As XUI
	Wait For (FileHandler1.LoadCoverImage) Complete (Result As LoadResult)
	If Result.Success Then
		Try
			imgCover.Load(Result.Dir,Result.FileName)
			'imgCover.Bitmap =xui.LoadBitmapResize(Result.Dir,Result.FileName,imgCover.Width,imgCover.Height,True)
			imgCover.Tag= Result.RealName 'Result.Dir & "/" &  GetPathFromContentResult(Result.FileName) '
			lblErrorMsg.Text=""
			txtFileName.Text=Result.FileName
			txtFileName.Tag="fromfile"
			fromfile=True
		Catch
			imgCover.Bitmap=Null
			imgCover.Tag=""
			txtFileName.Text=""
			txtFileName.Tag=""
			fromfile=False
			Log(LastException)
			
			config.displayMessage(LastException.Message,lblErrorMsg,False)
			'lblErrorMsg.Text=LastException.Message
		End Try
	End If
End Sub

Private Sub lblShowPassword_Click
	If lblShowPassword.Text=config.hide Then
		lblShowPassword.Text=config.show
		txtKey.PasswordMode=False
	Else
		lblShowPassword.Text=config.hide
		txtKey.PasswordMode=True
	End If
	txtKey.SelectionStart=txtKey.Text.Length
End Sub



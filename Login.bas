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
	Private Biometric As BiometricManager
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private btnResetPin As Label
	Private btnSignin As B4XView
	Private imgFingerprint As B4XView
	Private imgIcon As B4XView
	Private lblShowPassword As B4XView
	Private txtPin As EditText
	Private Label3 As B4XView
	
	Dim userPin As String
	Dim SharedPrefs As SharedPreferences
	
	Private lblErrorMsg As B4XView
	Dim IME As IME
	Private ACToolBarLight1 As ACToolBarLight
	Private ToolbarHelper As ACActionBar
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("login")
	SharedPrefs.Initialize("StegoCamPrefs")
	txtPin.InputType=Bit.Or(txtPin.InputType, 2)
	IME.Initialize("IME")
	IME.SetLengthFilter(txtPin,4)
	clearForm
	ToolbarHelper.Initialize
	ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
	ACToolBarLight1.InitMenuListener
	txtPin.Text=""
	lblErrorMsg.Text=""
			
	Biometric.Initialize(Me, "Authenticate")
	Dim res As String = Biometric.CanAuthenticate
	If res = "SUCCESS" Then
		Label3.Visible=True
		imgFingerprint.Visible=True
	Else
		Label3.Visible=False
		imgFingerprint.Visible=False
	End If
	
End Sub

Private Sub clearForm
	txtPin.Text=""
	lblShowPassword.Text=config.hide
	txtPin.PasswordMode=True
	txtPin.RequestFocus
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub ACToolBarLight1_NavigationItemClick
	'ExitApplication
	Activity.Finish
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		'ExitApplication
		Activity.Finish
	End If
	Return False
End Sub

Private Sub imgFingerprint_Click
	Dim fingerPrintEnabled As Boolean=config.getBiometric
	
	If fingerPrintEnabled=True Then
		Biometric.Show("Verifying Finegerprint")
		Wait For Authenticate_Complete (Success As Boolean, ErrorMessage As String)
		If Success Then
			Activity.Finish
			StartActivity(mainmenu)
			'ToastMessageShow("Authentication Successful! ",False)
		Else
			ToastMessageShow("Error: " & ErrorMessage,False)
		End If
	Else
		Msgbox2Async("Fingerprint login is not available for this account. You can change this in the settings page after login","Notice","OK","","",Null,False)
	End If
End Sub

Private Sub btnSignin_Click
	' Initialize SharedPreferences
	'get set up pin
	userPin = config.getUserPin
	
	Dim curPIN As String = txtPin.Text 
	If curPIN="" Or curPIN.Length<4 Then
		lblErrorMsg.Text="Please enter 4 digits PIN"
	Else if curPIN=userPin Then
		Activity.Finish
		StartActivity(mainmenu)
	Else
		lblErrorMsg.Text="Invalid PIN"
	End If
End Sub

Private Sub lblShowPassword_Click
	If lblShowPassword.Text=config.hide Then
		lblShowPassword.Text=config.show
		txtPin.PasswordMode=False
	Else
		lblShowPassword.Text=config.hide
		txtPin.PasswordMode=True
	End If
	txtPin.SelectionStart=txtPin.Text.Length
End Sub

Private Sub txtPin_TextChanged (Old As String, New As String)
	lblErrorMsg.Text=""
End Sub


Private Sub btnResetPin_Click
	StartActivity(forgotpin)
End Sub
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
	
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private ACToolBarLight1 As ACToolBarLight
	Private ToolbarHelper As ACActionBar
	Dim SharedPrefs As SharedPreferences
	Dim IME As IME
	Private btnCancel As Button
	Private btnSave As Button
	Private lblErrorMsg As Label
	Private lblErrorMsg2 As Label
	Private lblShowPswd As Label
	Private lblShowPswd2 As Label
	Private txtConfirmNewPIN As EditText
	Private txtNewPin As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("pinreset")
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	ToolbarHelper.Initialize
	ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
	ACToolBarLight1.InitMenuListener
	txtNewPin.InputType=Bit.Or(txtNewPin.InputType, 2)
	txtConfirmNewPIN.InputType=Bit.Or(txtConfirmNewPIN.InputType, 2)
	IME.SetLengthFilter(txtNewPin,4)
	IME.SetLengthFilter(txtConfirmNewPIN,4)
	clearForm
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	
End Sub

Private Sub clearForm
	txtNewPin.Text=""
	txtConfirmNewPIN.Text=""
	lblErrorMsg.Text=""
	lblErrorMsg2.Text=""
	lblShowPswd.Text  = config.hide
	lblShowPswd2.Text = config.hide
	txtNewPin.PasswordMode=True
	txtNewPin.RequestFocus
	
End Sub


Private Sub lblShowPassword_Click
	If lblShowPswd.Text=config.hide Then
		lblShowPswd.Text=config.show
		txtNewPin.PasswordMode=False
	Else
		lblShowPswd.Text=config.hide
		txtNewPin.PasswordMode=True
	End If
	txtNewPin.SelectionStart=txtNewPin.Text.Length
End Sub

Private Sub lblShowPassword2_Click
	If lblShowPswd2.Text=config.hide Then
		lblShowPswd2.Text=config.show
		txtConfirmNewPIN.PasswordMode=False
	Else
		lblShowPswd2.Text=config.hide
		txtConfirmNewPIN.PasswordMode=True
	End If
	txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.Text.Length
End Sub

Sub ACToolBarLight1_NavigationItemClick
	StartActivity(settings)
	Activity.Finish
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		StartActivity(settings)
		Activity.Finish
		Return True
	End If
	Return False
End Sub


Private Sub btnSave_Click
	If txtNewPin.Text.Length<4 Then
		lblErrorMsg.Text="Please enter new PIN of 4 digits"
		txtNewPin.RequestFocus
	else if txtConfirmNewPIN.Text <> txtConfirmNewPIN.Text Then
		lblErrorMsg2.Text ="New PIN and confirm PIN mismatch"
		txtConfirmNewPIN.RequestFocus
	Else
		config.setUserPin(txtNewPin.Text)
		Msgbox2Async("PIN updated successfully!","PIN updated","OK","","",LoadBitmap(File.DirAssets,"icons8-success-100.png"),False)
		Wait For Msgbox_Result (Result As Int)
		If Result = DialogResponse.POSITIVE Then
			Activity.Finish
		End If
	End If
End Sub


Private Sub txtNewPIN_TextChanged (Old As String, New As String)
	lblErrorMsg.Text=""
End Sub

Private Sub txtConfirmNewPIN_TextChanged (Old As String, New As String)
	If txtNewPin.Text <> txtConfirmNewPIN.Text Then
		lblErrorMsg2.Text="New PIN and confirm PIN mismatch"
	Else
		lblErrorMsg2.Text=""
	End If
	
End Sub

Private Sub lblShowPswd_Click
	If lblShowPswd.Text=config.hide Then
		lblShowPswd.Text=config.show
		txtNewPin.PasswordMode=False
	Else
		lblShowPswd.Text=config.hide
		txtNewPin.PasswordMode=True
	End If
	txtNewPin.SelectionStart=txtNewPin.Text.Length
End Sub


Private Sub lblShowPswd2_Click
	If lblShowPswd2.Text=config.hide Then
		lblShowPswd2.Text=config.show
		txtConfirmNewPIN.PasswordMode=False
	Else
		lblShowPswd2.Text=config.hide
		txtConfirmNewPIN.PasswordMode=True
	End If
	txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.Text.Length
End Sub

Private Sub btnCancel_Click
	Activity.Finish
End Sub
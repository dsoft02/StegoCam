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
	
	Private imgIcon As ImageView
	Private lblErrorMsg As Label
	Private lblErrorMsg2 As Label
	Private lblErrorMsg3 As Label
	Private pnlContainer As Panel
	Private txtPin As EditText
	Private btnSave As Button
	
	
	Dim sweet As SweetAlertDialog
	
	Dim IME As IME
	
	Private ImageView1 As ImageView
	Private ImageView2 As ImageView
	Private lblShowPswd As Label
	Private lblShowPswd2 As Label
	Private lblShowPswd3 As Label
	Private txtConfirmNewPIN As EditText
	Private txtNewPIN As EditText
	Private User_img As ImageView
	Private User_panel As Panel
	Private btnCancel As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("pinchange")
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	ToolbarHelper.Initialize
	ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
	ACToolBarLight1.InitMenuListener
	txtPin.InputType=Bit.Or(txtPin.InputType, 2)
	txtNewPIN.InputType=Bit.Or(txtNewPIN.InputType, 2)
	txtConfirmNewPIN.InputType=Bit.Or(txtConfirmNewPIN.InputType, 2)
	IME.Initialize("IME")
	IME.SetLengthFilter(txtPin,4)
	IME.SetLengthFilter(txtNewPIN,4)
	IME.SetLengthFilter(txtConfirmNewPIN,4)
	clearForm
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	
End Sub

Private Sub clearForm
	txtPin.Text=""
	txtNewPIN.Text=""
	txtConfirmNewPIN.Text=""
	lblErrorMsg.Text=""
	lblErrorMsg2.Text=""
	lblErrorMsg3.Text=""
	lblShowPswd.Text  = config.hide
	lblShowPswd2.Text = config.hide
	lblShowPswd3.Text = config.hide
	txtPin.PasswordMode=True
	txtPin.RequestFocus
	
End Sub
Private Sub lblShowPassword_Click
	If lblShowPswd.Text=config.hide Then
		lblShowPswd.Text=config.show
		txtPin.PasswordMode=False
	Else
		lblShowPswd.Text=config.hide
		txtPin.PasswordMode=True
	End If
	txtPin.SelectionStart=txtPin.Text.Length
End Sub

Private Sub lblShowPassword2_Click
	If lblShowPswd2.Text=config.hide Then
		lblShowPswd2.Text=config.show
		txtNewPIN.PasswordMode=False
	Else
		lblShowPswd2.Text=config.hide
		txtNewPIN.PasswordMode=True
	End If
	txtNewPIN.SelectionStart=txtNewPIN.Text.Length
End Sub

Private Sub lblShowPassword3_Click
	If lblShowPswd3.Text=config.hide Then
		lblShowPswd3.Text=config.show
		txtConfirmNewPIN.PasswordMode=False
	Else
		lblShowPswd3.Text=config.hide
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
	sweet.Initialize("Alert")
	If txtPin.Text.Length<4 Then
		lblErrorMsg.Text="Please enter current PIN of 4 digits"
	else if txtPin.Text <>config.getUserPin Then
		lblErrorMsg.Text="current PIN is invalid"
		txtPin.SelectionStart=txtPin.Text.Length
		txtPin.RequestFocus
	Else If txtNewPIN.Text.Length<4 Then
		lblErrorMsg2.Text="Please enter new PIN of 4 digits"
		txtNewPIN.RequestFocus
	else if txtNewPIN.Text <> txtConfirmNewPIN.Text Then
		lblErrorMsg3.Text ="New PIN and confirm PIN mismatch"
		txtConfirmNewPIN.RequestFocus
	Else
		config.setUserPin(txtNewPIN.Text)
		Msgbox2Async("PIN updated successfully!","PIN updated","OK","","",LoadBitmap(File.DirAssets,"icons8-success-100.png"),False)
		Wait For Msgbox_Result (Result As Int)
		If Result = DialogResponse.POSITIVE Then
			StartActivity(settings)
			Activity.Finish
			'sweet.AlertType=sweet.TypeSuccess
			'sweet.showCancelButton(False).showContentText(True).withConfirmText("OK").withContentText("PIN updated successfully!").withTitleText("PIN updated").show
		End If
	End If
End Sub




Sub Alert_onCancel()
	Log($"Alert_onCancel()"$)
	sweet.AlertType = sweet.TypeError
	'sweet.withContentText("BLA bla BLA bla BLA")
	sweet.dismissWithAnimation
End Sub
Sub Alert_onConfirm()
	Log($"Alert_onConfirm()"$)
	
	sweet.dismissWithAnimation
End Sub

Private Sub txtPin_TextChanged (Old As String, New As String)
	lblErrorMsg.Text=""
End Sub

Private Sub txtNewPIN_TextChanged (Old As String, New As String)
	lblErrorMsg2.Text=""
End Sub

Private Sub txtConfirmNewPIN_TextChanged (Old As String, New As String)
	If txtNewPIN.Text <> txtConfirmNewPIN.Text Then
		lblErrorMsg3.Text="New PIN and confirm PIN mismatch"
	Else
		lblErrorMsg3.Text=""
	End If
	
End Sub

Private Sub lblShowPswd_Click
	If lblShowPswd.Text=config.hide Then
		lblShowPswd.Text=config.show
		txtPin.PasswordMode=False
	Else
		lblShowPswd.Text=config.hide
		txtPin.PasswordMode=True
	End If
	txtPin.SelectionStart=txtPin.Text.Length
End Sub


Private Sub lblShowPswd2_Click
	If lblShowPswd2.Text=config.hide Then
		lblShowPswd2.Text=config.show
		txtNewPIN.PasswordMode=False
	Else
		lblShowPswd2.Text=config.hide
		txtNewPIN.PasswordMode=True
	End If
	txtNewPIN.SelectionStart=txtNewPIN.Text.Length
End Sub

Private Sub lblShowPswd3_Click
	If lblShowPswd3.Text=config.hide Then
		lblShowPswd3.Text=config.show
		txtConfirmNewPIN.PasswordMode=False
	Else
		lblShowPswd3.Text=config.hide
		txtConfirmNewPIN.PasswordMode=True
	End If
	txtConfirmNewPIN.SelectionStart=txtConfirmNewPIN.Text.Length
End Sub

Private Sub btnCancel_Click
	StartActivity(settings)
	Activity.Finish
End Sub
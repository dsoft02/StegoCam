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
	
	Private imgIcon As B4XView
	Private lblErrorMsg As B4XView
	Private lblErrorMsg2 As B4XView
	Private lblErrorMsg3 As B4XView
	Private lblShowPassword As B4XView
	Private pnlContainer As B4XView
	Private txtAnswer As EditText
	Private txtPin As EditText
	Private txtQuestion As EditText
	Private btnSave As B4XView
	
	Dim SharedPrefs As SharedPreferences
	Dim sweet As SweetAlertDialog
	
	Dim IME As IME
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("pinsetup")
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	ToolbarHelper.Initialize
	ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
	ACToolBarLight1.InitMenuListener
	txtPin.InputType=Bit.Or(txtPin.InputType, 2)
	IME.Initialize("IME")
	IME.SetLengthFilter(txtPin,4)
	clearForm
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	
End Sub

Private Sub clearForm
	txtPin.Text=""
	txtQuestion.Text=""
	txtAnswer.Text=""
	lblErrorMsg.Text=""
	lblErrorMsg2.Text=""
	lblErrorMsg3.Text=""
	lblShowPassword.Text=config.hide
	txtPin.PasswordMode=True
	txtPin.RequestFocus
	
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


Sub ACToolBarLight1_NavigationItemClick
	Activity.Finish
	ExitApplication
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		Activity.Finish
		ExitApplication
		Return True
	End If
	Return False
End Sub


Private Sub btnSave_Click
	sweet.Initialize("Alert")
	If txtPin.Text.Length<4 Then
		lblErrorMsg.Text="Please enter 4 digits"
	Else If txtQuestion.Text="" Then
		lblErrorMsg2.Text="Please enter security question"
	Else If txtAnswer.Text="" Then
		lblErrorMsg3.Text ="Please enter answer"
	Else
		config.setUserPin(txtPin.Text)
		config.saveSecurityQA(txtQuestion.Text,txtAnswer.Text)
		Msgbox2Async("PIN updated successfully!","PIN updated","OK","","",LoadBitmap(File.DirAssets,"icons8-success-100.png"),False)
		Wait For Msgbox_Result (Result As Int)
		If Result = DialogResponse.POSITIVE Then
			StartActivity(Login)
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

Private Sub txtQuestion_TextChanged (Old As String, New As String)
	lblErrorMsg2.Text=""
End Sub

Private Sub txtAnswer_TextChanged (Old As String, New As String)
	lblErrorMsg3.Text=""
End Sub
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
	
	Private txtAnswer As EditText
	Private btnCancel As Button
	Private btnSave As Button
	Private lblErrorMsg As Label
	Private lblSecQuestion As Label
	Private Panel1 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("forgotpin")
	SharedPrefs.Initialize("StegoCamPrefs")
	ToolbarHelper.Initialize
	ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
	ACToolBarLight1.InitMenuListener
	clearForm
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub ACToolBarLight1_NavigationItemClick
	Activity.Finish
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		Activity.Finish
		Return True
	End If
	Return False
End Sub


Private Sub btnSave_Click
	If txtAnswer.Text="" Then
		lblErrorMsg.Text ="Please enter security answer"
	Else if txtAnswer.Text=config.getSecurityAnswer Then
		StartActivity(pinreset)
		Activity.Finish
	Else
		lblErrorMsg.Text ="invalid security answer"
	End If
End Sub


Private Sub btnCancel_Click
	Activity.Finish
End Sub


Private Sub clearForm
	txtAnswer.Text=""
	lblSecQuestion.Text=config.getSecurityQuestion
	lblErrorMsg.Text=""
	config.ResizeLabelHeight(lblSecQuestion)
	Panel1.Top=lblSecQuestion.Top+lblSecQuestion.Height+3
End Sub

Private Sub txtAnswer_TextChanged (Old As String, New As String)
	lblErrorMsg.Text=""
End Sub

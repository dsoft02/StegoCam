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
	Private ImageView1 As ImageView
	Private ImageView2 As ImageView
	Private imgIcon As ImageView
	Private Label1 As Label
	Private Label3 As Label
	Private Label4 As Label
	Private lblErrorMsg2 As Label
	Private lblErrorMsg3 As Label
	Private Panel1 As Panel
	Private Panel2 As Panel
	Private pnlContainer As Panel
	Private txtAnswer As EditText
	Private txtQuestion As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("securityquestion")
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
	If txtQuestion.Text="" Then
		lblErrorMsg2.Text="Please enter security question"
	Else If txtAnswer.Text="" Then
		lblErrorMsg3.Text ="Please enter security answer"
	Else
		config.saveSecurityQA(txtQuestion.Text,txtAnswer.Text)
		Msgbox2Async("Security Question and Answer updated successfully!","Updated","OK","","",LoadBitmap(File.DirAssets,"icons8-success-100.png"),False)
		Wait For Msgbox_Result (Result As Int)
		If Result = DialogResponse.POSITIVE Then
			StartActivity(settings)
			Activity.Finish
		End If
		
	End If
End Sub


Private Sub btnCancel_Click
	StartActivity(settings)
	Activity.Finish
End Sub


Private Sub clearForm
	txtQuestion.Text=config.getSecurityQuestion
	txtAnswer.Text=config.getSecurityAnswer
	lblErrorMsg2.Text=""
	lblErrorMsg3.Text=""
	txtQuestion.RequestFocus
End Sub


Private Sub txtQuestion_TextChanged (Old As String, New As String)
	lblErrorMsg2.Text=""
End Sub

Private Sub txtAnswer_TextChanged (Old As String, New As String)
	lblErrorMsg3.Text=""
End Sub
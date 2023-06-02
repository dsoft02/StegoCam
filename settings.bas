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
	Private B4XSwitch1 As B4XSwitch
	Dim SharedPrefs As SharedPreferences
	Private Biometric As BiometricManager
	Private lblSignout As Label
	Private pnlPinChange As Panel
	Private pnlSecurityQuestion As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("settings")
	ToolbarHelper.Initialize
	ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
	ACToolBarLight1.InitMenuListener
	
	'Initialize SharedPreferences
	SharedPrefs.Initialize("StegoCamPrefs")
	B4XSwitch1.Value=config.getBiometric
	Biometric.Initialize(Me, "Authenticate")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub ACToolBarLight1_NavigationItemClick
	Activity.Finish
	StartActivity(mainmenu)
End Sub


Private Sub B4XSwitch1_ValueChanged (Value As Boolean)
	Dim icFingerprint As Bitmap
	Dim bioVal As Boolean= B4XSwitch1.Value
	If B4XSwitch1.Value=False Then
		Msgbox2Async("Are you sure you want to disable fingerprint login?","Disable Fingerprint","Confirm","Cancel","",LoadBitmap(File.DirAssets,"icons8-fingerprint-94.png"),False)
		Wait For Msgbox_Result(Result As Int)
		If Result=DialogResponse.POSITIVE Then
			SharedPrefs.SaveBoolean("Biometric",B4XSwitch1.Value)
		Else
			B4XSwitch1.Value=True
		End If
	Else
		Dim res As String = Biometric.CanAuthenticate
		If res = "SUCCESS" Then
			Biometric.Show("Verifying Finegerprint")
			Wait For Authenticate_Complete (Success As Boolean, ErrorMessage As String)
			If Success Then
				SharedPrefs.SaveBoolean("Biometric",B4XSwitch1.Value)
				Msgbox2Async("Fingerprint login enabled","Fingerprint Enabled","Done","","",LoadBitmap(File.DirAssets,"icons8-fingerprint-94.png"),False)
			Else
				B4XSwitch1.Value=False
			End If
		Else
			B4XSwitch1.Value=False
		End If
	End If
End Sub

Private Sub lblSignout_Click
	Activity.Finish
	StartActivity(Login)
End Sub

Private Sub pnlSecurityQuestion_Click
	Activity.Finish
	StartActivity(securityquestion)
End Sub

Private Sub pnlPinChange_Click
	Activity.Finish
	StartActivity(PinChange)
End Sub
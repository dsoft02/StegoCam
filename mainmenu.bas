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
	Private Drawer As B4XDrawer
	
	Private lb1Menu As Label
	Private lb2Menu As Label
	Private lb3Menu As Label
	Private ic1Menu As ImageView
	Private ic2Menu As ImageView
	Private ic3Menu As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Try
		Drawer.Initialize(Me, "Drawer", Activity, 270dip)
		Drawer.CenterPanel.LoadLayout("mainmenu")
		ToolbarHelper.Initialize
		ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
		ToolbarHelper.UpIndicatorDrawable = config.BitmapToBitmapDrawable(LoadBitmap(File.DirAssets, "hamburger.png"))
		ACToolBarLight1.InitMenuListener
		Drawer.LeftPanel.LoadLayout("leftmenu")
		load_Images
	Catch
		Log(LastException)
	End Try
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub ACToolBarLight1_NavigationItemClick
	Drawer.LeftOpen = Not(Drawer.LeftOpen)
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK And Drawer.LeftOpen Then
		Drawer.LeftOpen = False
		Return True
	End If
	Return False
End Sub

Private Sub ACToolBarLight1_MenuItemClick (Item As ACMenuItem)
	
End Sub


Sub load_Images
	config.AjustImageView(ic1Menu,File.DirAssets,"icons8_moisture_96px.png")
	config.AjustImageView(ic2Menu,File.DirAssets,"icons8_content_96px.png")
	config.AjustImageView(ic3Menu,File.DirAssets,"icons8_info_96px.png")
End Sub


Private Sub lb2Menu_Click
	If Drawer.LeftOpen Then Drawer.LeftOpen = False
	Sleep(150)
	'StartActivity(ListCoutry)
End Sub
Private Sub lb1Menu_Click
	If Drawer.LeftOpen Then Drawer.LeftOpen = False
	Sleep(10)
End Sub
Private Sub lb3Menu_Click
	If Drawer.LeftOpen Then Drawer.LeftOpen = False
	Sleep(10)
	MsgboxAsync("Application developed by Abdul Cadre Hassamo in the scope of * Recruitment Challenge * made by Wit. "& CRLF & CRLF &" The application should show time at the current location and 10 European cities, for this I used bridges (JSON APIs) to obtain such data. " & CRLF & CRLF & "Used APIs:" & CRLF & "Meteorological Data: http://openweathermap.org/api"&CRLF&"Lista do countries: http://vocab.nic.in/rest.php/country/json"&CRLF&CRLF&CRLF&"Eventual contacts I place the layout: achassamo@gmail.com | +258840122758 "," About the application ")
End Sub
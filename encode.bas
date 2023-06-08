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
	Private const tempImageFile As String = "stegocam_coverimage.jpg"
	Private lastPicture As B4XBitmap
	Private imageChooser As ContentChooser
	Private FileHandler1 As FileHandler
	Private stegoHandler As StegocamHandler
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
	Private btnEncode As Button
	Private ImageView2 As ImageView
	Private ImageView3 As ImageView
	Private ImageView4 As ImageView
	Private lblErrorMsg As Label
	Private pnlEncryption As Panel
	Private pnlKey As Panel
	Private pnlMessage As Panel
	Private txtKey As EditText
	Private txtMessage As EditText
	Private pnlCoverImage As Panel
	Private cboEncryption As B4XComboBox
	Dim toast As BCToast
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
	Dim sClipboard As BClipboard
	Private imgCover As B4XImageView
	Private btnCamera As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("encode")
	SharedPrefs.Initialize("StegoCamPrefs")
	ToolbarHelper.Initialize
	ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
	ACToolBarLight1.InitMenuListener
	'imgCover.ResizeMode="FILL_NO_DISTORTIONS"
	clearForm
	If lastPicture.IsInitialized Then imgCover.Bitmap = lastPicture
	FileHandler1.Initialize
	stegoHandler.Initialize
	Dialog.Initialize(Activity)
	Dialog.Title = "Stego Image View"
	getPermissions
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub ACToolBarLight1_NavigationItemClick
	StartActivity(mainmenu)
	Activity.Finish
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean
	If KeyCode = KeyCodes.KEYCODE_BACK Then
		StartActivity(mainmenu)
		Activity.Finish
		Return True
	End If
	Return False
End Sub



Private Sub btnCancel_Click
	StartActivity(mainmenu)
	Activity.Finish
End Sub

Private Sub btnEncode_Click
	If imgCover.Bitmap=Null Then
		lblErrorMsg.Text="Please select cover Image"
		ToastMessageShow("Please select cover Image",False)
	Else If txtMessage.Text="" Then
		lblErrorMsg.Text="Please enter your secret message"
		ToastMessageShow("Please enter your secret message",False)
		txtMessage.RequestFocus
	else if txtKey.Text="" Then
		lblErrorMsg.Text="Please enter your encryption key"
		ToastMessageShow("Please enter your encryption key",False)
		txtKey.RequestFocus
	else if txtKey.Text.Length<4 Then
		lblErrorMsg.Text="Encryption key must be 4 or more letters"
		ToastMessageShow("Encryption key must be 4 or more letters",False)
		txtKey.RequestFocus
	Else
		lblErrorMsg.Text=""
		stegoHandler.createTempCoverImage(imgCover)
		If stegoHandler.isCoverImage Then
			stegoHandler.EmbedText(txtMessage.Text,txtKey.Text)
			If stegoHandler.embeddingSuccessful=True Then
				ToastMessageShow("Secret has been hidden successfully!",True)
				sClipboard.setText(txtKey.Text)
				ToastMessageShow("Encryption Key has been copied to clipboard",True)
				Msgbox2Async("Encryption Key has been copied to clipboard","Encryption Key Copied","OK","","",Null,False)
				Wait For Msgbox_Result (Result As Int)
				If Result = DialogResponse.POSITIVE Then
					showCompleteDialog(File.Combine(config.stegoImagePath,stegoHandler.curFilename))
				End If
			Else
				lblErrorMsg.Text=stegoHandler.lastErrorMessage
			End If
		Else
			ToastMessageShow("An error has occured please Try Again!",True)
		End If
	End If
	stegoHandler.deleteTempResources("stegocover")
End Sub


Sub showCompleteDialog(img As String)
	Try
		stegopreview.stegoimage= LoadBitmap("",img)
		stegopreview.stegoImagePath=img
		stegopreview.fromActivity="encode"
		StartActivity(stegopreview)
		Activity.Finish
	Catch
		ToastMessageShow(LastException.Message,True)
		Log(LastException)
	End Try
End Sub


Private Sub clearForm
	lastPicture=Null
	If imgCover.Bitmap.IsInitialized Then imgCover.Bitmap=Null
	txtMessage.Text=""
	imgCover.Tag=""
	txtKey.Text=""
	lblShowPassword.Text=config.hide
	txtKey.PasswordMode=True
End Sub


Private Sub btnCamera_Click
	Dim bmp As Bitmap
	bmp.Initialize(File.DirAssets, "question.png")
	Msgbox2Async("Click on Yes to take picture from camera, or No to browse from a file?", "Browse Cover Image", "Yes", "Cancel", "No", bmp, False)
	Wait For Msgbox_Result (Result As Int)
	If Result = DialogResponse.POSITIVE Then
		TakePicture
	Else if Result = DialogResponse.NEGATIVE Then
		BrowseCoverImage
	End If
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

Sub BrowseCoverImage
	Dim xui As XUI
	Wait For (FileHandler1.LoadCoverImage) Complete (Result As LoadResult)
	If Result.Success Then
		Try
			imgCover.load(Result.Dir,Result.FileName)
			'imgCover.Bitmap =xui.LoadBitmapResize(Result.Dir,Result.FileName,imgCover.Width,imgCover.Height,True)
			imgCover.Tag= Result.FileName 'Result.Dir & "/" &  GetPathFromContentResult(Result.FileName) '
			lblErrorMsg.Text=""
		Catch
			imgCover.Bitmap=Null
			imgCover.Tag=""
			Log(LastException)
			lblErrorMsg.Text=LastException.Message
		End Try
	End If
End Sub


Sub TakePicture
	Dim i As Intent
	i.Initialize("android.media.action.IMAGE_CAPTURE", "")
	File.Delete(Starter.provider.SharedFolder, tempImageFile)
	Dim u As Object = Starter.provider.GetFileUri(tempImageFile)
	i.PutExtra("output", u) 'the image will be saved to this path
	Try
		StartActivityForResult(i)
	Catch
		ToastMessageShow("Camera is not available.", True)
		Log(LastException)
	End Try
End Sub

'result arrives here
Sub ion_Event (MethodName As String, Args() As Object) As Object
	Dim xui As XUI
	If Args(0) = -1 Then
		Try
			Dim in As Intent = Args(1)
			If File.Exists(Starter.provider.SharedFolder, tempImageFile) Then
				lastPicture =xui.LoadBitmapResize(Starter.provider.SharedFolder, tempImageFile,imgCover.mBase.Width,imgCover.mBase.Height,True)
				imgCover.Bitmap = lastPicture
			Else If in.HasExtra("data") Then 'try to get thumbnail instead
				Dim jo As JavaObject = in
				lastPicture = jo.RunMethodJO("getExtras", Null).RunMethod("get", Array("data"))
			End If
		Catch
			Log(LastException)
		End Try
	End If
	If lastPicture.IsInitialized Then imgCover.Bitmap = lastPicture
	Return Null
End Sub


Sub StartActivityForResult(i As Intent)
	Dim jo As JavaObject = GetBA
	ion = jo.CreateEvent("anywheresoftware.b4a.IOnActivityResult", "ion", Null)
	jo.RunMethod("startActivityForResult", Array As Object(ion, i))
End Sub

Sub GetBA As Object
	Dim jo As JavaObject
	Dim cls As String = Me
	cls = cls.SubString("class ".Length)
	jo.InitializeStatic(cls)
	Return jo.GetField("processBA")
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


Sub GetPathFromContentResult(UriString As String) As String
	If UriString.StartsWith("/") Then Return UriString 'If the user used a file manager to choose the image
	Dim Cursor1 As Cursor
	Dim Uri1 As Uri
	Dim Proj() As String = Array As String("_data")
	Dim cr As ContentResolver
	cr.Initialize("")
	If UriString.StartsWith("content://com.android.providers.media.documents") Then
		Dim i As Int = UriString.IndexOf("%3A")
		Dim id As String = UriString.SubString(i + 3)
		Uri1.Parse("content://media/external/images/media")
		Cursor1 = cr.Query(Uri1, Proj, "_id = ?", Array As String(id), "")
	Else
		Uri1.Parse(UriString)
		Cursor1 = cr.Query(Uri1, Proj, "", Null, "")
	End If
	Cursor1.Position = 0
	Dim res As String
	res = Cursor1.GetString("_data")
	Cursor1.Close
	Return res
End Sub


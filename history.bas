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
	Private rp As RuntimePermissions
	Private NumberOfColumns As Int = 3
	Dim curRow As Int
	Dim curCol As Int
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private ACToolBarLight1 As ACToolBarLight
	Private ToolbarHelper As ACActionBar
	Dim SharedPrefs As SharedPreferences
	Private xui As XUI
	Private B4XTable1 As B4XTable
	Private Dialog As B4XDialog
	Private btnPrev As Button
	Private btnNext As Button
	Private btnCancel As Button
	Private btnExtract As Button
	Private btnShare As Button
	Private imgPreview As ImageView
	Private pnlPreview As Panel
	
	Dim startX, startY As Float
	Private lblImgLocation As Label
	Private imgDelete As ImageView
	Private imgExtract As ImageView
	Private imgShare As ImageView
	Private pnlDelete As Panel
	Private pnlExtract As Panel
	Private pnlShare As Panel
	Private Label1 As Label
	Private Label4 As Label
	Private Label2 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("history")
	SharedPrefs.Initialize("StegoCamPrefs")
	ToolbarHelper.Initialize
	ToolbarHelper.ShowUpIndicator = True 'set to true to show the up arrow
	ACToolBarLight1.InitMenuListener
	Dialog.Initialize(Activity)
	Dialog.Title = "Stego Image View"
	FindPictures
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
	If KeyCode = KeyCodes.KEYCODE_BACK And Dialog.Close(xui.DialogResponse_Cancel) Then 
		Return True
	Else
		If KeyCode = KeyCodes.KEYCODE_BACK Then
			StartActivity(mainmenu)
			Activity.Finish
			Return True
		End If
	End If
	
	Return False
End Sub


Sub FindPictures
	Dim AllPictures As List
	AllPictures.Initialize
	Dim PicturesFolder As String = config.stegoImagePath
	If File.Exists(PicturesFolder, "") = False Then Continue
	Wait For (File.ListFilesAsync(PicturesFolder)) Complete (Success As Boolean, Files As List)
	If Success Then
		For Each f As String In Files
			AllPictures.Add(File.Combine(PicturesFolder, f))
		Next
	End If
	
	CreateTable(AllPictures)
End Sub

Sub CreateTable (Files As List)
	B4XTable1.Clear
	B4XTable1.AllowSmallRowHeightModifications = False
	B4XTable1.RowHeight = 100dip
	B4XTable1.SearchField.TextField.Enabled = False
	B4XTable1.SearchField.TextField.Visible=False
	B4XTable1.SearchField.mBase.Visible=False
	For i = 0 To NumberOfColumns - 1
		B4XTable1.AddColumn(i, B4XTable1.COLUMN_TYPE_TEXT)
	Next
	'Force the creation of the cells.
	B4XTable1.MaximumRowsPerPage = 20
	B4XTable1.BuildLayoutsCache(B4XTable1.MaximumRowsPerPage)
	For Each col As B4XTableColumn In B4XTable1.Columns
		col.Sortable = False
		col.Width = 100%x / NumberOfColumns
		For i = 0 To col.CellsLayouts.Size - 1
			Dim pnl As B4XView = col.CellsLayouts.Get(i)
			pnl.GetView(0).Visible = False 'hide the label
			If i > 0 Then 'i = 0 is the header
				Dim iv As ImageView
				iv.Initialize("")
				pnl.AddView(iv, 2dip, 2dip, col.Width - 4dip, B4XTable1.RowHeight - 4dip)
			End If
		Next
	Next
	LoadData(Files)
	B4XTable1.mBase.Visible = True
End Sub

Private Sub LoadData (Files As List)
	Dim Data As List
	Data.Initialize
	Dim row(NumberOfColumns) As Object
	Dim index As Int = -1
	For Each f As String In Files
		If f.EndsWith(".jpg") Or f.EndsWith(".png") Then
			index = (index + 1) Mod NumberOfColumns
			row(index) = f
			If index = NumberOfColumns - 1 Then
				Data.Add(row)
				Dim row(NumberOfColumns) As Object
			End If
		End If
	Next
	If index < NumberOfColumns - 1 Then
		'last incomplete row
		For i = index + 1 To NumberOfColumns - 1
			row(i) = ""
		Next
		Data.Add(row)
	End If
	B4XTable1.SetData(Data)
End Sub

Sub B4XTable1_DataUpdated
	Dim row As Map
	For i = 0 To B4XTable1.VisibleRowIds.Size - 1
		Dim RowId As Long = B4XTable1.VisibleRowIds.Get(i)
		If RowId > 0 Then
			row = B4XTable1.GetRow(RowId)
		Else
			row = CreateMap()
		End If
		For Each column As B4XTableColumn In B4XTable1.Columns
			Dim pnl As B4XView = column.CellsLayouts.Get(i + 1) '+1 because the first cell is the header
			Dim iv As B4XView = pnl.GetView(1) 'ImageView will be the 2nd child of the panel. The built-in label is the first.
			If row.GetDefault(column.Id, "") <> "" Then
				iv.SetBitmap(xui.LoadBitmapResize("", row.Get(column.Id), iv.Width, iv.Height, False))
			Else
				iv.SetBitmap(Null)
			End If
		Next
	Next
	btnNext.Enabled = B4XTable1.lblNext.Tag
	btnPrev.Enabled = B4XTable1.lblBack.Tag
End Sub

Sub B4XTable1_CellClicked (ColumnId As String, RowId As Long)
	Dim img As String = B4XTable1.GetRow(RowId).Get(ColumnId)
	curCol=ColumnId
	curRow = RowId
	If img <> "" Then
		Dim pnl As B4XView = xui.CreatePanel("")
		'Dim iv As ImageView
		'iv.Initialize("")
		pnl.SetLayoutAnimated(0, 0, 0, 90%x, 80%y)
		pnl.LoadLayout("embedDialog")
		'pnlPreview.RemoveView
		'pnl.AddView(pnlPreview, 0, 0, pnl.Width, pnl.Height)
		
		imgPreview.Width=pnlPreview.Width-20
		imgPreview.Height=imgPreview.Width
		imgPreview.Left=pnlPreview.Width/2 - imgPreview.Width/2
		imgPreview.Bitmap = xui.LoadBitmapResize("", img, imgPreview.Width, imgPreview.Height, True)
		
		pnlExtract.Top=imgPreview.Top+imgPreview.Height+10dip
		pnlDelete.Top=imgPreview.Top+imgPreview.Height+10dip
		pnlShare.Top=imgPreview.Top+imgPreview.Height+10dip
		
		Dim panelWidth, panelSpacing As Int
		panelSpacing = 5dip
		panelWidth = (pnlPreview.Width / 3)
		
		pnlExtract.Width  = panelWidth
		pnlDelete.Width   = panelWidth
		pnlShare.Width    = panelWidth
		
		pnlExtract.Left=0
		pnlDelete.Left=panelWidth
		pnlShare.Left=(panelWidth * 2)
'		pnlExtract.Color=Colors.Yellow
'		pnlDelete.Color=Colors.Red
'		pnlShare.Color=Colors.Blue
		
		imgExtract.Left=pnlExtract.Width/2-imgExtract.Width/2
		imgDelete.Left=pnlDelete.Width/2-imgDelete.Width/2
		imgShare.Left=pnlShare.Width/2-imgShare.Width/2
		
		Label1.Left=0
		Label1.Width=pnlExtract.Width
		
		Label4.Left=0
		Label4.Width=pnlDelete.Width
		
		Label2.Left=0
		Label2.Width=pnlShare.Width
		
	
		lblImgLocation.Text=img
		Dialog.ShowCustom(pnl, "Close", "", "")
	End If
End Sub


Sub Activity_Touch (Action As Int, X As Float, Y As Float)
	Select Action
		Case Activity.ACTION_DOWN
			startX = X
			startY = Y
		Case Activity.ACTION_UP
			If Abs(y - startY) > 20%y Then Return
			If X - startX > 30%x Then
				If btnPrev.Enabled=True Then CallSub("",btnPrev_Click)
			Else If startX - x > 30%x Then
				If btnNext.Enabled=True Then CallSub("",btnNext_Click)
			End If
	End Select
	
End Sub

Sub btnNext_Click
	B4XTable1.CurrentPage = B4XTable1.CurrentPage + 1
End Sub

Sub btnPrev_Click
	B4XTable1.CurrentPage = B4XTable1.CurrentPage - 1
End Sub


Private Sub btnShare_Click
	
End Sub


Private Sub btnCancel_Click
	
End Sub

Private Sub imgShare_Click
	Try
		Dim filename As String=lblImgLocation.Text.SubString(lblImgLocation.Text.LastIndexOf("/")+1)
		File.Copy(lblImgLocation.Text,"", Starter.Provider.SharedFolder,filename)
		Dim u As Uri 'ContentResolver library
		u.Parse(Starter.Provider.GetFileUri(filename))
		Dim inten As Intent
		Dim tmpt As String = ""
		inten.Initialize(inten.ACTION_SEND,"")
		inten.SetType("image/*")
		inten.PutExtra("android.intent.extra.STREAM",u)
		'inten.PutExtra("android.intent.extra.TEXT",tmpt)
		'inten.SetComponent("com.instagram.android/.activity.ShareHandlerActivity")
		StartActivity(inten)
	Catch
		ToastMessageShow(LastException.Message,True)
	End Try
End Sub

Private Sub imgExtract_Click
	
End Sub

Private Sub imgDelete_Click
	Msgbox2Async("Are you sure you want to delete file?","Delete Image","Yes","No","",Null,True)
	Wait For Msgbox_Result (Result As Int)
	If Result = DialogResponse.POSITIVE Then
		File.Delete(lblImgLocation.Text,"")
		FindPictures
		Dialog.Close(xui.DialogResponse_Cancel)
	End If
End Sub
B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=11
@EndOfDesignText@
Sub Class_Globals
	Private ion As Object
	Private OldIntent As Intent
	Type LoadResult (Success As Boolean, Dir As String, FileName As String, RealName As String, Size As Long, Modified As Long, MimeType As String)
	
End Sub

Public Sub Initialize

End Sub


Public Sub Load As ResumableSub
	Dim cc As ContentChooser
	cc.Initialize("cc")
	cc.Show("*/*", "Choose file to hide")
	Wait For CC_Result (Success As Boolean, Dir As String, FileName As String)
	Dim res As LoadResult = CreateLoadResult(Success, Dir, FileName)
	If res.Success Then ExtractInformationFromURI(res.FileName, res)
	Return res
End Sub

Public Sub LoadCoverImage As ResumableSub
	Dim cc As ContentChooser
	cc.Initialize("cc")
	cc.Show("image/*", "Choose Cover Image file")
	Wait For CC_Result (Success As Boolean, Dir As String, FileName As String)
	Dim res As LoadResult = CreateLoadResult(Success, Dir, FileName)
	If res.Success Then ExtractInformationFromURI(res.FileName, res)
	Return res
End Sub

Private Sub StartActivityForResult(i As Intent)
	Dim jo As JavaObject = GetBA
	ion = jo.CreateEvent("anywheresoftware.b4a.IOnActivityResult", "ion", Null)
	jo.RunMethod("startActivityForResult", Array(ion, i))
End Sub

Private Sub GetBA As Object
	Return Me.As(JavaObject).RunMethod("getBA", Null)
End Sub

Private Sub ExtractInformationFromURI (Uri As String, res As LoadResult)
	Try
		
	Dim resolver As ContentResolver
	resolver.Initialize("")
	Dim u As Uri
	u.Parse(Uri)
	Dim rs As ResultSet = resolver.Query(u, Null, "", Null, "")
	If rs.NextRow Then
		Dim columns As B4XSet = B4XCollections.CreateSet
		For i = 0 To rs.ColumnCount - 1
			columns.Add(rs.GetColumnName(i))
		Next
		If columns.Contains("_display_name") Then res.RealName = rs.GetString("_display_name")
		If columns.Contains("_size") Then res.Size = rs.GetLong("_size")
		If columns.Contains("last_modified") Then res.Modified = rs.GetLong("last_modified")
		If columns.Contains("mime_type") Then res.MimeType = rs.GetString("mime_type")
	End If
	rs.Close
	
	Catch
		Log("error extracting information from file provider")
		Log(LastException)
	End Try
End Sub

Private Sub IsRelevantIntent(in As Intent) As Boolean
	If in.IsInitialized And in <> OldIntent And in.Action = in.ACTION_VIEW Then
		OldIntent = in
		Return True
	End If
	Return False
End Sub

Private Sub CreateLoadResult (Success As Boolean, Dir As String, FileName As String) As LoadResult
	Dim t1 As LoadResult
	t1.Initialize
	t1.Success = Success
	t1.Dir = Dir
	t1.FileName = FileName
	Return t1
End Sub

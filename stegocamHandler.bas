B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=12.2
@EndOfDesignText@
Sub Class_Globals
	Private steg As F5Steg
	Private stegoCamBytes() As Byte = "STEGOCAM_".GetBytes("UTF8")
	Private str As StringUtils
	Public curFilename As String
	Public embeddingSuccessful As Boolean=False
	Public lastErrorMessage As String = ""
	Public file_extension As String = ""
End Sub

' Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
End Sub

Sub GenerateFilename() As String
    Dim timestamp As Long = DateTime.Now
    Dim filename As String = "IMG_" & timestamp & ".jpg"
	curFilename=filename
    Return filename
End Sub


' Embeds the specified text with a password in the given image file
public Sub EmbedText(secretText As String, password As String)
	embeddingSuccessful=False
	Dim imageFilePath As String  = File.Combine(File.DirInternalCache, "stegocover.png")
	Dim outputFilePath  As String = File.Combine(File.DirInternalCache, GenerateFilename)
	steg.EmbedString2(imageFilePath, outputFilePath, secretText, 100, password, "text")
End Sub

Sub text_Embedded(OutFileName As String)
	Try
		' Read the image file into bytes
		Dim imageBytes() As Byte = File.ReadBytes(OutFileName,"")
	    
		' Convert the text to bytes
		Dim textBytes() As Byte = "TEXT".GetBytes("UTF8")
	    
		' Concatenate the image bytes and text bytes
		Dim modifiedBytes() As Byte =CombineBytes(stegoCamBytes, textBytes)
		
		' Concatenate the image bytes and modified bytes
		Dim newImageBytes() As Byte = CombineBytes(imageBytes, modifiedBytes)
	    
		' Write the new image bytes to the output file
		File.WriteBytes(OutFileName,"", newImageBytes)
		
		'copy the file from the cache to the stegoimages folder in the app folder
		File.Copy(OutFileName,"",config.stegoImagePath,curFilename)
		embeddingSuccessful =File.Exists(config.stegoImagePath,curFilename)
		lastErrorMessage=""
		' Delete the temporary output file without extension
		File.Delete(OutFileName,"")
	Catch
		embeddingSuccessful =False
		lastErrorMessage="Embedding Failed: " & LastException.Message
		ToastMessageShow("Embedding Failed: " & LastException.Message,True)
	End Try
End Sub


Sub EmbedFile(SecretFile As String,Password As String)
	Try
		embeddingSuccessful=False
		Dim stegoFilePath As String = copyFiletoTemp(SecretFile)
		Dim SecretMessage() As Byte = Bit.InputStreamToBytes(File.OpenInput(stegoFilePath,""))
		'Dim SecretMessage() As Byte=File.ReadBytes(SecretFile,"")
'		Msgbox(SecretFile,"secret file")
'		Msgbox(stegoFilePath,"stegoFilePath")
'		Msgbox(File.Exists(stegoFilePath,""),"secret message")
		
		Dim imageFilePath As String  = File.Combine(File.DirInternalCache, "stegocover.png")
		Dim outputFilePath  As String = File.Combine(File.DirInternalCache, GenerateFilename)
		steg.EmbedArray2 (imageFilePath, outputFilePath, SecretMessage, 100, Password, "file")
	Catch
		Msgbox(LastException.Message,"")
		
	End Try
End Sub


Sub GetStreamFromContentResult(UriString As String) As InputStream
	Dim r As Reflector
	Dim Uri As Object
	Dim iStream As InputStream
	Uri = r.RunStaticMethod("android.net.Uri", "parse", Array As Object(UriString), Array As String("java.lang.String"))
	r.Target = r.GetContext
	r.Target = r.RunMethod("getContentResolver")
	iStream = r.RunMethod4( "openInputStream", Array As Object(Uri), Array As String("android.net.Uri"))

	
'	Dim jo As JavaObject
'	Dim cd As String = jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File").GetField("ContentDir")
'	iStream = File.OpenInput(cd , UriString)


	Return iStream
End Sub

Sub copyFiletoTemp(cfilename As String) As String
	Dim returnFilePath As String =""
	Try
		'Msgbox(cfilename,"cfile")
		Dim jo As JavaObject
		Dim Inp As InputStream  = GetStreamFromContentResult(cfilename)
		Dim ofilename As String = "stegofile." & file_extension
		Dim Out As OutputStream = File.OpenOutput(File.DirInternalCache, ofilename, False)
		File.copy2(Inp, Out)
		Inp.Close
		Out.Close
		returnFilePath=File.combine(File.DirInternalCache, ofilename)
	Catch
		returnFilePath=""
		Msgbox(LastException.Message,"")
		Log(":: issue " & LastException)
	End Try
	Return returnFilePath
End Sub

Sub file_Embedded(OutFileName As String)
	Try
		' Read the image file into bytes
		Dim imageBytes() As Byte = File.ReadBytes(OutFileName,"")
	    
		Dim textStr As String = "FILE_" & file_extension
		
		' Convert the text to bytes
		Dim textBytes() As Byte = textStr.GetBytes("UTF8")
	    
		' Concatenate the image bytes and text bytes
		Dim modifiedBytes() As Byte =CombineBytes(stegoCamBytes, textBytes)
		
		' Concatenate the image bytes and modified bytes
		Dim newImageBytes() As Byte = CombineBytes(imageBytes, modifiedBytes)
	    
		' Write the new image bytes to the output file
		File.WriteBytes(OutFileName,"", newImageBytes)
		
		'copy the file from the cache to the stegoimages folder in the app folder
		File.Copy(OutFileName,"",config.stegoImagePath,curFilename)
		embeddingSuccessful =File.Exists(config.stegoImagePath,curFilename)
		lastErrorMessage=""
		' Delete the temporary output file without extension
		File.Delete(OutFileName,"")
	Catch
		embeddingSuccessful =False
		lastErrorMessage="Embedding Failed: " & LastException.Message
		ToastMessageShow("Embedding Failed: " & LastException.Message,True)
	End Try
End Sub

Sub CombineBytes(arr1() As Byte, arr2() As Byte) As Byte()
	Dim res(arr1.Length + arr2.Length) As Byte
	Dim bc As ByteConverter 'ByteConverter library
	bc.ArrayCopy(arr1, 0, res, 0, arr1.Length)
	bc.ArrayCopy(arr2, 0, res, arr1.Length, arr2.Length)
	Return res
End Sub


' Extracts the text with a password from the given image file
Public Sub ExtractTextWithPassword(imageFilePath As String, password As String) As String
	' Extract the hidden text from the image using the password
	steg.ExtractToString2(imageFilePath, password, "steg")
End Sub

Sub steg_StringExtracted(SecretMessage As String)
	Log("Extracted Text: " & SecretMessage)
End Sub


Sub createTempCoverImage(img As ImageView)
'	If img.Tag="" Then
		Dim Bitmap1 As Bitmap = img.Bitmap
		Dim Out As OutputStream
		'Out = File.OpenOutput(config.stegoImagePath, "stegocover.png", False)
		Out = File.OpenOutput(File.DirInternalCache, "stegocover.png", False)
		Bitmap1.WriteToStream(Out, 100, "PNG")
		Out.Close
'	Else
'		Dim tpath() As String
'		tpath= Regex.Split("\|",img.Tag)
'		Dim pathlist As List
'		pathlist.Initialize2(tpath)
'		Dim fpath As String =pathlist.Get(0).As(String)
'		Dim fname As String =pathlist.Get(1).As(String)
'		'Msgbox(img.Tag & CRLF &  "Path: " & fpath & CRLF & "File: " & fname,Application.LabelName)
'		Try
'			If File.Exists(File.DirInternalCache, "stegocover.png")=True Then File.Delete(File.DirInternalCache, "stegocover.png")
'			File.Copy(fpath,fname,File.DirInternalCache, "stegocover.png")
'		Catch
'			'Msgbox(LastException.Message,Application.LabelName)
'		End Try
'	End If
End Sub

Sub isCoverImage() As Boolean
	Return File.Exists(File.DirInternalCache, "stegocover.png")
End Sub



Sub deleteTempResources(res As String)
	If res ="stegocover" Then
		File.Delete(File.DirInternalCache, "stegocover.png")
	End If
End Sub

Sub BytesToFile (Dir As String, FileName As String, Data() As Byte)
	Dim out As OutputStream = File.OpenOutput(Dir, FileName, False)
	out.WriteBytes(Data, 0, Data.Length)
	out.Close
End Sub

Sub FileToBytes (Dir As String, FileName As String) As Byte()
	Return Bit.InputStreamToBytes(File.OpenInput(Dir, FileName))
End Sub

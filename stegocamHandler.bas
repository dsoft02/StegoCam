B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=12.2
@EndOfDesignText@
Sub Class_Globals
	Private steg As F5Steg
	Private stegoCamBytes() As Byte = "_STEGOCAM_".GetBytes("UTF8")
	Private str As StringUtils
	Public curFilename As String
	Public embeddingSuccessful As Boolean=False
	Public extractionSuccessful As Boolean=False
	Public lastErrorMessage As String = ""
	Public file_extension As String = ""
	Public extractedString As String = ""
	Public stegoMarkerByte() As Byte = FileToBytes(File.DirAssets,"stegomarker.jpg")
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

' Extracts the text with a password from the given image file
Public Sub ExtractText(imageFilePath As String, password As String) As String
	' Extract the hidden text from the image using the password
	Try
		steg.ExtractToString2(imageFilePath, password, "steg")
		'extractionSuccessful=True
		lastErrorMessage="Success: Extraction completed successfully!"
	Catch
		Log(LastException)
		Dim errMessage() As String =Regex.Split(":", LastException.Message)
		If errMessage(errMessage.Length-1) ="BAD_DECRYPT" Then
			Msgbox2Async("Error: Invalid Decryption Key Please Try Again!", "Extraction Fail", "OK", "", "", Null, False)
			lastErrorMessage="Error: Invalid Decryption Key Please Try Again!"
		Else
			Msgbox2Async("Error: Invalid Stego Image or wrong Decryption Key Please Try Again!", "Extraction Fail", "OK", "", "", Null, False)
			lastErrorMessage="Error: Invalid Stego Image or wrong Decryption Key"
		End If
		
		extractionSuccessful=False
	End Try
End Sub

Sub steg_StringExtracted(SecretMessage As String)
	extractedString = SecretMessage
	extractionSuccessful = True
	lastErrorMessage = "Success: Extraction completed successfully!"
End Sub


Sub CombineBytes(arr1() As Byte, arr2() As Byte) As Byte()
	Dim res(arr1.Length + arr2.Length) As Byte
	Dim bc As ByteConverter 'ByteConverter library
	bc.ArrayCopy(arr1, 0, res, 0, arr1.Length)
	bc.ArrayCopy(arr2, 0, res, arr1.Length, arr2.Length)
	Return res
End Sub

Public Sub isStegoImage(imageFilePath As String) As Boolean
	Dim bc As ByteConverter
    ' Check if the image file exists.
    If Not(File.Exists(imageFilePath,"")) Then
        ' Return False if the image file does not exist.
        Return False
    End If
	
    ' Get the bytes of the image file.
    Dim fileBytes() As Byte = FileToBytes(imageFilePath, "")
	Dim fileBytesString As String= bc.StringFromBytes(fileBytes,"UTF8")
	Dim stegoBytesString As String =bc.StringFromBytes(stegoMarkerByte,"UTF8")
	If fileBytesString.Contains(stegoBytesString) Then
		Return True
	Else
		Return False
	End If
	
	Return False
End Sub

Public Sub RemoveStegoCamBytes(imageFilePath As String) As String
	Dim newFilePath As String = ""
	Try
		Dim fileBytes() As Byte = File.ReadBytes(imageFilePath, "")

		Dim stegoCamLength As Int = stegoMarkerByte.Length
		
		Dim newLength As Int = fileBytes.Length - stegoCamLength
		
		Dim modifiedBytes(newLength) As Byte
		Dim bc As ByteConverter 'ByteConverter library
		
		' Copy the bytes from fileBytes to modifiedBytes excluding the stegoCamBytes
		bc.ArrayCopy(fileBytes,0, modifiedBytes,0, newLength)
		
		' Write the modified bytes to a new file
		newFilePath = File.Combine(File.DirInternalCache, "ModifiedStegoImage.jpg")
		File.WriteBytes(newFilePath,"", modifiedBytes)
		
	Catch
		' Display an error message if any exception occurs
		ToastMessageShow("Error: " & LastException.Message, True)
	End Try
	
	Return newFilePath
End Sub

Sub createTempCoverImage(img As B4XImageView)
		Dim Bitmap1 As Bitmap = img.Bitmap
		Dim Out As OutputStream
		'Out = File.OpenOutput(config.stegoImagePath, "stegocover.png", False)
		Out = File.OpenOutput(File.DirInternalCache, "stegocover.png", False)
		Bitmap1.WriteToStream(Out, 100, "PNG")
		Out.Close

End Sub

Sub isCoverImage() As Boolean
	Return File.Exists(File.DirInternalCache, "stegocover.png")
End Sub

Sub deleteTempResources(res As String)
	If res ="stegocover" Then
		File.Delete(File.DirInternalCache, "stegocover.png")
	End If
End Sub

Sub BytesToFile (Data() As Byte,Dir As String, FileName As String)
	Dim out As OutputStream = File.OpenOutput(Dir, FileName, False)
	out.WriteBytes(Data, 0, Data.Length)
	out.Close
End Sub

Sub FileToBytes (Dir As String, FileName As String) As Byte()
   Return Bit.InputStreamToBytes(File.OpenInput(Dir, FileName))
End Sub

Sub GetStreamFromContentResult(UriString As String) As InputStream
	Dim r As Reflector
	Dim Uri As Object
	Dim iStream As InputStream
	Uri = r.RunStaticMethod("android.net.Uri", "parse", Array As Object(UriString), Array As String("java.lang.String"))
	r.Target = r.GetContext
	r.Target = r.RunMethod("getContentResolver")
	iStream = r.RunMethod4( "openInputStream", Array As Object(Uri), Array As String("android.net.Uri"))
	Return iStream
End Sub

Sub copyFiletoTemp(srcFile As String,destFile As String) As String
	Dim returnFilePath As String =""
	Try
		'Msgbox(cfilename,"cfile")
		Dim jo As JavaObject
		Dim Inp As InputStream  = GetStreamFromContentResult(srcFile)
		'Dim ofilename As String = "stegofile." & file_extension
		Dim Out As OutputStream = File.OpenOutput(File.DirInternalCache, destFile, False)
		File.copy2(Inp, Out)
		Inp.Close
		Out.Close
		returnFilePath=File.combine(File.DirInternalCache, destFile)
	Catch
		returnFilePath=""
		'Msgbox(LastException.Message,"")
		Log(":: issue " & LastException)
	End Try
	Return returnFilePath
End Sub

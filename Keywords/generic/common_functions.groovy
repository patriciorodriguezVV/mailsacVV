package generic

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class common_functions {

	public static void login(String username, String pass) {
		WebUI.setText(findTestObject('Page_Login_VisualVault/input_UserName'), username)

		WebUI.setText(findTestObject('Page_Login_VisualVault/input_Password'), pass)

		WebUI.click(findTestObject('Page_Login_VisualVault/span_LoginButton'))
	}


	public static void uploadFilePath(String filePath) {
		KeywordUtil.logInfo("Upload file document")

		WebUI.uploadFileWithDragAndDrop(findTestObject('File Uplaod Dialog/div_Drop files here to upload'), filePath)

		WebUI.delay(10)

		WebUI.click(findTestObject('File Uplaod Dialog/button_Finish'))

		KeywordUtil.markPassed("The Document was uploaded")
	}
}

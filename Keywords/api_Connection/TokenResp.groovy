package api_Connection

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
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import internal.GlobalVariable
import com.kms.katalon.core.testobject.ResponseObject

public class TokenResp {

	private TestObject requesGetLicenseDetails						= findTestObject('RequestApiInformation/GetLicenseDetails')
	String expirationDate



	@Keyword
	def getToken (ResponseObject tokenResp) {
		// Verify Request was completed correctly
		WS.verifyResponseStatusCode(tokenResp, 200)

		// Assign token to Global Variable
		GlobalVariable.G_Token = WS.getElementPropertyValue(tokenResp, 'access_token')
	}
}

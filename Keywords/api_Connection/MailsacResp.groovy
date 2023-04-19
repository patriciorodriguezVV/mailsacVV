//package api_Connection
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
import com.kms.katalon.core.util.KeywordUtil

public class MailsacResp {

	private TestObject requesGetLicenseDetails						= findTestObject('RequestApiInformation/GetLicenseDetails')



	@Keyword
	def getLinkVerification (ResponseObject emailList) {
		KeywordUtil.logInfo("Get link from email verification")

		String link = WS.getElementPropertyValue(emailList	, '[0].links[0]')

		KeywordUtil.markPassed("Link received for account verification: " + link)

		return link
	}

	@Keyword
	def getMessageId (ResponseObject emailList) {

		String MessageId = WS.getElementPropertyValue(emailList, '[0]._id')

		return MessageId
	}



}

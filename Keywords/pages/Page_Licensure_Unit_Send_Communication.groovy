package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.support.FindBy

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
import com.thoughtworks.selenium.webdriven.commands.Click
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class Page_Licensure_Unit_Send_Communication {


	private TestObject labelForm							= findTestObject('Page_Licensure Unit Send Communication/label_Licensure Unit Send Communication')
	private TestObject inputEmailRecipients					= findTestObject('Page_Licensure Unit Send Communication/textarea_Email Recipients')




	@Keyword
	def verifyLabelForm () {
		WebUI.waitForElementVisible(labelForm, 40)

		WebUI.verifyElementVisible(labelForm)
	}


	@Keyword
	def verifyEmailRecipients (String emailRecipient) {
		KeywordUtil.logInfo("Verify Email Recipient")

		WebUI.waitForElementVisible(labelForm, 40)

		if(WebUI.verifyElementAttributeValue(inputEmailRecipients, 'value', emailRecipient, 0, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Email Recipient was verified: " + emailRecipient)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Email didn't match or couldn't be verified: Expected Email" + emailRecipient)
		}
	}
}

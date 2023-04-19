package pages

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


public class Page_Reset_Password_Complete_Registration {

	private TestObject inputNewPassword							= findTestObject('Page_Reset Password - Complete Registration/input_New Password')
	private TestObject inputConfirmNewPassword					= findTestObject('Page_Reset Password - Complete Registration/input_Confirm New Password')
	private TestObject buttonResetPassword						= findTestObject('Page_Reset Password - Complete Registration/button_ResetPassword')
	private TestObject spanUserId								= findTestObject('Page_Reset Password - Complete Registration/span_User Id')


	@Keyword
	def completePasswords () {
		KeywordUtil.logInfo("Complete Password fields")

		WebUI.waitForElementVisible(inputNewPassword, 40)

		WebUI.setEncryptedText(inputNewPassword, GlobalVariable.G_ApplicantPass)

		WebUI.setEncryptedText(inputConfirmNewPassword, GlobalVariable.G_ApplicantPass)

		KeywordUtil.markPassed("The password fields were completed")
	}


	@Keyword
	def clickOnResetPasswordbtn () {
		KeywordUtil.logInfo("Click on Reset Password button")

		WebUI.waitForElementVisible(buttonResetPassword, 40)

		WebUI.click(buttonResetPassword)

		KeywordUtil.markPassed("Reset Password button was clicked")
	}


	@Keyword
	def verifyUserId (String expectedUserId) {
		KeywordUtil.logInfo("Verify user id")

		String currentUserId = WebUI.getText(spanUserId)

		if(WebUI.verifyMatch(currentUserId, expectedUserId, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("User id was verfied correctly: " + expectedUserId)
		} else {
			KeywordUtil.markFailed("User id was not the expected: Expected User Id: '" + expectedUserId +"', current User Id: '" + currentUserId + "'")
		}
	}
}

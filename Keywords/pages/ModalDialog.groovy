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
import com.sun.net.httpserver.Authenticator.Failure
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class ModalDialog {

	private TestObject modalDialogTitle							= findTestObject('Modal Dialog Components/h5_ModalDialogTitleText')
	private TestObject modalDialogValidationMessage				= findTestObject('Modal Dialog Components/Body Validatinon Elements/p_modalDialogBodyValidationMessage')
	private TestObject modalDialogValidationDetails				= findTestObject('Modal Dialog Components/Body Validatinon Elements/p_modalDialogBodyValidationDetails')
	private TestObject modalDialogContent						= findTestObject('Modal Dialog Components/h5_ModalDialogBodyText')
	private TestObject modalDialogCloseButton					= findTestObject('Modal Dialog Components/button_Close')
	private TestObject modalDialogCancelButton					= findTestObject('Modal Dialog Components/button_Cancel')
	private TestObject modalDialogOkButton						= findTestObject('Modal Dialog Components/button_Close_Ok')
	private TestObject modalDialogOkayButton					= findTestObject('Modal Dialog Components/button_Okay')
	private TestObject inputStartDate							= findTestObject('Modal Dialog Components/input_Start Date')
	private TestObject inputEndDate								= findTestObject('Modal Dialog Components/input_End Date')
	private TestObject inputLicenseBoard						= findTestObject('Modal Dialog Components/input_License Board_fname')
	private TestObject modalDialogConfirmButton					= findTestObject('Modal Dialog Components/button_Confirm')
	private TestObject modalDialogRetrunApplicationBtn			= findTestObject('Modal Dialog Components/button_Return Application')
	private TestObject modalDialogKeepApplicationBtn			= findTestObject('Modal Dialog Components/button_Keep Application')
	private TestObject buttonMergeValue							= findTestObject('Modal Dialog Components/button_Merge Values')
	private TestObject linkStartAReinstatementApplication		= findTestObject('Modal Dialog Components/a_Start a Reinstatement Application')
	private TestObject linkSelectADifferentLicenseType			= findTestObject('Modal Dialog Components/a_Select a different license type')





	@Keyword
	def verifyTitleAndBodyText (String title, String body) {
		KeywordUtil.logInfo("Verify Title and Body on Modal Dialog. Then click Ok")

		WebUI.waitForElementVisible(modalDialogTitle, 40)

		WebUI.verifyElementText(modalDialogTitle, title, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(modalDialogContent, body, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(modalDialogOkButton)

		KeywordUtil.markPassed("Title and Body were verified on Modal Dialog")
	}


	@Keyword
	def clickOnOkbutton () {
		KeywordUtil.logInfo("Click on Ok button")

		WebUI.waitForElementVisible(modalDialogOkButton, 40)

		WebUI.click(modalDialogOkButton)

		KeywordUtil.markPassed("Ok button was clicked")
	}

	@Keyword
	def clickOnOkaybutton () {
		KeywordUtil.logInfo("Click on Ok button")

		WebUI.waitForElementVisible(modalDialogOkayButton, 40)

		WebUI.click(modalDialogOkayButton)

		KeywordUtil.markPassed("Ok button was clicked")
	}

	@Keyword
	def clickOnCloseButton () {
		KeywordUtil.logInfo("Click on Close button")

		WebUI.waitForElementVisible(modalDialogCloseButton, 40)

		WebUI.click(modalDialogCloseButton)

		KeywordUtil.markPassed("Close button was clicked")
	}

	@Keyword
	def clickOnCancelButton () {
		KeywordUtil.logInfo("Click on Cancel button")

		WebUI.waitForElementVisible(modalDialogCancelButton, 40)

		WebUI.click(modalDialogCancelButton)

		KeywordUtil.markPassed("Cancel button was clicked")
	}

	@Keyword
	def clickOnConfirmbutton () {
		KeywordUtil.logInfo("Click on Confirm button")

		WebUI.waitForElementVisible(modalDialogConfirmButton, 40)

		WebUI.click(modalDialogConfirmButton)

		KeywordUtil.markPassed("Confirm button was clicked")
	}

	@Keyword
	def clickOnMergeValue () {
		KeywordUtil.logInfo("Click on Merge Value")

		WebUI.waitForElementVisible(buttonMergeValue, 40)

		WebUI.click(buttonMergeValue)

		KeywordUtil.markPassed("Merge Value button was clicked")
	}

	@Keyword
	def clickOnLinkStartAReinstatementApplication () {
		KeywordUtil.logInfo("Click on 'Start a Reinstatement Application.'")

		WebUI.waitForElementVisible(linkStartAReinstatementApplication, 40)

		WebUI.click(linkStartAReinstatementApplication)

		KeywordUtil.markPassed("'Start a Reinstatement Application.' was clicked")
	}

	@Keyword
	def enterRangeOfDate (String startDate) {
		KeywordUtil.logInfo("Complete Start Date: " + startDate)

		WebUI.waitForElementVisible(inputStartDate, 40)

		WebUI.sendKeys(inputStartDate, startDate)

		KeywordUtil.markPassed("Start Date was completed: " + startDate)
	}

	@Keyword
	def enterLicenseBoard (String token1) {
		KeywordUtil.logInfo("Complete License Board: " + token1)

		WebUI.waitForElementVisible(inputLicenseBoard, 40)

		WebUI.sendKeys(inputLicenseBoard, token1)

		KeywordUtil.markPassed("License Board was completed: " + token1)
	}

	@Keyword
	def verifyTitle (String title) {
		KeywordUtil.logInfo("Verify Modal Dialog title: '" + title + "'")

		WebUI.waitForElementVisible(modalDialogTitle, 40)

		if (WebUI.verifyElementText(modalDialogTitle, title, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Modal Dialog title was verified correctly: '" + title + "'")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Modal Dialog title was not the expected or couldn't be verified. The expected title is: " + title)
		}
	}

	@Keyword
	def verifyBody (String body) {
		KeywordUtil.logInfo("Verify Modal Dialog body: '" + body + "'")

		WebUI.waitForElementVisible(modalDialogContent, 40)

		if (WebUI.verifyElementText(modalDialogContent, body, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Modal Dialog body was verified correctly: '" + body + "'")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Modal Dialog body was not the expected or couldn't be verified. The expected message is: " + body)
		}
	}

	@Keyword
	def verifyBodyValidationMessage (String body) {
		KeywordUtil.logInfo("Verify Modal Dialog body: '" + body + "'")

		WebUI.waitForElementVisible(modalDialogValidationMessage, 40)

		if (WebUI.verifyElementText(modalDialogValidationMessage, body, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Modal Dialog body was verified correctly: '" + body + "'")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Modal Dialog body was not the expected or couldn't be verified. The expected message is: " + body)
		}
	}

	@Keyword
	def verifyBodyValidationDetails (String body) {
		KeywordUtil.logInfo("Verify Modal Dialog body: '" + body + "'")

		WebUI.waitForElementVisible(modalDialogValidationDetails, 40)

		if (WebUI.verifyElementText(modalDialogValidationDetails, body, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Modal Dialog body was verified correctly: '" + body + "'")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Modal Dialog body was not the expected or couldn't be verified. The expected message is: " + body)
		}
	}

	@Keyword
	def clickOnReturnApplicationBtn () {
		KeywordUtil.logInfo("Click on Return Application")

		WebUI.waitForElementVisible(modalDialogRetrunApplicationBtn, 40)

		WebUI.click(modalDialogRetrunApplicationBtn)

		KeywordUtil.markPassed("Return Application button was clicked")
	}

	@Keyword
	def clickOnKeepApplicationBtn () {
		KeywordUtil.logInfo("Click on Keep Application")

		WebUI.waitForElementVisible(modalDialogKeepApplicationBtn, 40)

		WebUI.click(modalDialogKeepApplicationBtn)

		KeywordUtil.markPassed("Keep Application button was clicked")
	}

	@Keyword
	def verifyTokensNotFoundMsg () {
		KeywordUtil.logInfo("Verify if Modal Dialog for Tokens Not Found is displayed")

		WebUI.waitForElementVisible(modalDialogTitle, 40)

		if (WebUI.verifyElementNotVisible(modalDialogTitle, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Modal Dialog for Tokens Not Found was not displayed")
		} else {
			WebUI.takeFullPageScreenshot()

			String title = WebUI.getText(modalDialogTitle)

			String body = WebUI.getText(modalDialogContent)

			KeywordUtil.markFailed("Modal Dialog for Tokens Not Found was displayed. " + '\nModal Dialog Title: ' + title + '\nModal Dialog Content: ' + body + '\n')

			WebUI.click(modalDialogOkButton)
		}
	}
}


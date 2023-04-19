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

public class Page_Licensure_Unit_Letter_Management {


	private TestObject dropdownLicenseType						= findTestObject('Page_Licensure Unit Letter Management/dropdown_License Type arrow')
	private TestObject optionPhysicalTherapist					= findTestObject('Page_Licensure Unit Letter Management/li_Physical Therapist')
	private TestObject dropdownTemplateList						= findTestObject('Page_Licensure Unit Letter Management/dropdown_Template List')
	private TestObject optionDeficiencyNotification				= findTestObject('Page_Licensure Unit Letter Management/li_Deficiency Notification - Initial License')
	private TestObject optionDenialNotification					= findTestObject('Page_Licensure Unit Letter Management/li_Denial Notification - Initial License')
	private TestObject pdfContent								= findTestObject('Page_Licensure Unit Letter Management/kendo-PDF container')
	private TestObject buttonSave								= findTestObject('Page_Licensure Unit Letter Management/button_Save')
	private TestObject buttonCancelAndContinue					= findTestObject('Page_Licensure Unit Letter Management/button_Cancel and Continue')
	private TestObject buttonMergeLanceData						= findTestObject('Page_Licensure Unit Letter Management/button_Merge LANCE Data')
	private TestObject buttonSetDynamicValues					= findTestObject('Page_Licensure Unit Letter Management/button_Set Dynamic Values')
	private TestObject buttonPreviewPrint						= findTestObject('Page_Licensure Unit Letter Management/button_PreviewPrint')
	private TestObject buttonSendEmail							= findTestObject('Page_Licensure Unit Letter Management/button_Send Email')
	private TestObject popupPrintTab							= findTestObject('Page_Licensure Unit Letter Management/embed_PrintPopUP')







	@Keyword
	def selectPhysicalTherapistOnLicenseType () {
		KeywordUtil.logInfo("Select a License Type: Physical Therapist")

		WebUI.waitForElementVisible(dropdownLicenseType, 40)

		WebUI.click(dropdownLicenseType)

		WebUI.click(optionPhysicalTherapist)

		KeywordUtil.markPassed("A License Type was selected: Physical Therapist")
	}


	@Keyword
	def selectDeficiencyNotificationtOnTemplate () {
		KeywordUtil.logInfo("Select an option on Template List: Deficiency Notification")

		WebUI.waitForElementVisible(dropdownTemplateList, 40)

		WebUI.click(dropdownTemplateList)

		WebUI.click(optionDeficiencyNotification)

		KeywordUtil.markPassed("An option was selected on Template List: Deficiency Notification")
	}


	@Keyword
	def selectDenialNotificationtOnTemplate () {
		KeywordUtil.logInfo("Select an option on Template List: Denial Notification")

		WebUI.waitForElementVisible(dropdownTemplateList, 40)

		WebUI.click(dropdownTemplateList)

		WebUI.click(optionDenialNotification)

		KeywordUtil.markPassed("An option was selected on Template List: Denial Notification")
	}


	@Keyword
	def getPdfContent () {
		KeywordUtil.logInfo("Get PDF content")

		WebUI.waitForElementVisible(pdfContent, 40)

		String pdfContent = WebUI.getText(pdfContent)

		return pdfContent
	}


	@Keyword
	def clickOnSaveBtn () {
		KeywordUtil.logInfo("Click on Save button")

		WebUI.waitForElementVisible(buttonSave, 40)

		WebUI.click(buttonSave)

		KeywordUtil.markPassed("Save button was clicked")
	}


	@Keyword
	def clickOnCancelAndContinueBtn () {
		KeywordUtil.logInfo("Click on Cancel and Continue button")

		WebUI.waitForElementVisible(buttonCancelAndContinue, 40)

		WebUI.click(buttonCancelAndContinue)

		KeywordUtil.markPassed("Cancel and Continue button was clicked")
	}

	@Keyword
	def clickOnPreviewPrintBtn () {
		KeywordUtil.logInfo("Click on Preview/Print button")

		WebUI.waitForElementVisible(buttonPreviewPrint, 40)

		WebUI.click(buttonPreviewPrint)

		KeywordUtil.markPassed("Preview/Print button was clicked")
	}

	@Keyword
	def clickOnSendEmailBtn () {
		KeywordUtil.logInfo("Click on Send Email button")

		WebUI.waitForElementVisible(buttonSendEmail, 40)

		WebUI.click(buttonSendEmail)

		KeywordUtil.markPassed("Send Email button was clicked")
	}


	@Keyword
	def clickOnMergeLanceDataBtn () {
		KeywordUtil.logInfo("Click on Merge LANCE Data button")

		WebUI.waitForElementVisible(buttonMergeLanceData, 40)

		WebUI.click(buttonMergeLanceData)

		KeywordUtil.markPassed("Merge LANCE Data button was clicked")
	}


	@Keyword
	def clickOnSetDynamicValuesBtn () {
		KeywordUtil.logInfo("Click on Set Dynamic Values button")

		WebUI.waitForElementVisible(buttonSetDynamicValues, 40)

		WebUI.click(buttonSetDynamicValues)

		KeywordUtil.markPassed("Set Dynamic Values button was clicked")
	}


	@Keyword
	def verifyTokensReplacedForDenial () {
		KeywordUtil.logInfo("Verify all Tokes were Replaced")

		if(!WebUI.verifyTextNotPresent('[Current Date]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Current Date] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[Full Name]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Full Name] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[Individual Record street]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Individual Record street] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[Individual Record street1]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Individual Record street1] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[Individual Record street2]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Individual Record street2] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[Individual Record city]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Individual Record city] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[Individual Record state]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Individual Record state] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[Individual Record zip Code]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Individual Record zip Code] was not replaced")
		}


		if (!WebUI.verifyTextNotPresent('[Individual Record email Address]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Individual Record email Address] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[Full Name]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Full Name] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[License Type]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [License Type] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[License Application reason for Denial]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [License Application reason for Denial] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[License Application denial Code]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [License Application denial Code] was not replaced")
		}

		if (!WebUI.verifyTextNotPresent('[License Coordinator Full Name]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [License Coordinator Full Name] was not replaced")
		}
		
		if (!WebUI.verifyTextNotPresent('[License Coordinator emailAddress]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [License Coordinator emailAddress] was not replaced")
		}
		
		if (!WebUI.verifyTextNotPresent('[License Coordinator phoneNumber]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [License Coordinator phoneNumber] was not replaced")
		}
		
		if (!WebUI.verifyTextNotPresent('[Chief Medical Officer full Name]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Chief Medical Officer full Name] was not replaced")
		}
		
		if (!WebUI.verifyTextNotPresent('[Chief Medical Officer Suffix]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Chief Medical Officer Suffix] was not replaced")
		}
		
		if (!WebUI.verifyTextNotPresent('[Chief Medical Officer job Title]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [Chief Medical Officer job Title] was not replaced")
		}
		
		if (!WebUI.verifyTextNotPresent('[P and O Administrator full Name]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [P and O Administrator full Name] was not replaced")
		}
		
		if (!WebUI.verifyTextNotPresent('[License Application reason for Denial]', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Token [License Application reason for Denial] was not replaced")
		}
	}

	@Keyword
	def verifyDynamicValuesReplacedForDenial () {
		KeywordUtil.logInfo("Verify Dynamic Values were replaced")
		
		if (WebUI.verifyTextNotPresent('{License Board}', false, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Dynamic Values were replaced correctly")
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Dynamic Values were not replaced")
		}
	}


	@Keyword
	def verifyBtnsPrintAndEmailAreVisible () {
		KeywordUtil.logInfo("Verify 'Preview/Print' and 'Send Email' buttons are visible")
		
		WebUI.waitForElementVisible(buttonPreviewPrint, 40)

		if (WebUI.verifyElementVisible(buttonPreviewPrint, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Preview/Print is visible as expected")
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Preview/Print buttin is not visible")
		}

		if (WebUI.verifyElementVisible(buttonSendEmail, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Send Email is visible as expected")
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Send Email buttin is not visible")
		}
	}

	@Keyword
	def verifyPrintTabIsVisible () {
		KeywordUtil.logInfo("Verify Print table buttons are visible")
		
		WebUI.waitForElementVisible(popupPrintTab, 40)

		if (WebUI.verifyElementVisible(popupPrintTab, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Print table is visible as expected")
		} else {
			KeywordUtil.markFailed("Print table is not visible")
		}
	}
}

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
import java.util.Calendar as Calendar
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil



public class Page_Licensure_Unit_License {

	private TestObject inputFirstName 						= findTestObject('Page_Licensure Unit License/input_First Name')
	private TestObject inputLastName 						= findTestObject('Page_Licensure Unit License/input_Last Name')
	private TestObject inputIssueDate 						= findTestObject('Page_Licensure Unit License/input_Issue Date')
	private TestObject inputEffectiveDate 					= findTestObject('Page_Licensure Unit License/input_Effective Date')
	private TestObject inputExpirationDate					= findTestObject('Page_Licensure Unit License/input_Expiration Date')
	private TestObject selectLicenseType					= findTestObject('Page_Licensure Unit License/span_Select License Type')
	private TestObject tabManage							= findTestObject('Page_Licensure Unit License/button_Manage')
	private TestObject tabDiscipline						= findTestObject('Page_Licensure Unit License/button_Discipline')
	private TestObject buttonMakeLicenseInactive			= findTestObject('Page_Licensure Unit License/button_Make License Inactive')
	private TestObject spanLicenseId						= findTestObject('Page_Licensure Unit License/READ ONLY SECTION/input_License ID')
	private TestObject dropdownStatus						= findTestObject('Page_Licensure Unit License/READ ONLY SECTION/kendo-dropdownlist_Status')
	private TestObject buttonAddFee							= findTestObject('Page_Licensure Unit License/button_Add Fee')
	private TestObject buttonClose							= findTestObject('Page_Licensure Unit License/button_Close')
	private TestObject buttonCancelAndContinue				= findTestObject('Page_Licensure Unit License/button_Cancel and Continue')
	private TestObject buttonSaveAndContinue				= findTestObject('Page_Licensure Unit License/button_Save and Continue')
	private TestObject buttonPrintWallCertificate			= findTestObject('Page_Licensure Unit License/button_Print Wall Certificate')
	private TestObject buttonPrintWaWalletCard				= findTestObject('Page_Licensure Unit License/button_Print Wallet Card')
	private TestObject divWalletCardContent					= findTestObject('Page_Licensure Unit License/div_Wallet Card Content')
	private TestObject buttonDisciplinary					= findTestObject('Page_Licensure Unit License/Tab_Dischipline/button_Disciplinary or Licensure Event')
	private TestObject OpenLinkDiscipline1					= findTestObject('Page_Licensure Unit License/Tab_Dischipline/a_Open Link_Discipline1')
	private TestObject buttonPlaceOnHold					= findTestObject('Page_Licensure Unit License/button_Place on Hold')
	private TestObject buttonReleaseHold					= findTestObject('Page_Licensure Unit License/button_Release Hold')
	private TestObject dropdownReasonHold					= findTestObject('Page_Licensure Unit License/drop-down Hold Reason/span_drop-down_Hold Reason')
	private TestObject optionReasonHold_ActionOtherState	= findTestObject('Page_Licensure Unit License/drop-down Hold Reason/li_Action Other State')
	private TestObject optionReasonHold_Discipline			= findTestObject('Page_Licensure Unit License/drop-down Hold Reason/li_Discipline')







	// General Actions
	@Keyword
	def clickOnManageTab () {
		KeywordUtil.logInfo("Click on Manage tab")

		WebUI.waitForElementVisible(tabManage, 40)

		WebUI.click(tabManage)

		KeywordUtil.markPassed("Manage tab was clicked")
	}

	@Keyword
	def clickOnDischiplineTab () {
		KeywordUtil.logInfo("Click on Discipline tab")

		WebUI.waitForElementVisible(tabDiscipline, 40)

		WebUI.click(tabDiscipline)

		KeywordUtil.markPassed("Discipline tab was clicked")
	}

	@Keyword
	def verifyStatus (String status) {
		KeywordUtil.logInfo("Verify Status")

		WebUI.waitForElementVisible(dropdownStatus, 40)

		String licenseStatus = WebUI.getText(dropdownStatus)

		if (WebUI.verifyMatch(licenseStatus, status, true, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The Status was verfied correctly: " + status)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The Status was not the expected")
		}
	}

	@Keyword
	def clickOnCloseButton () {
		KeywordUtil.logInfo("Click on Close button")

		WebUI.waitForElementVisible(buttonClose, 40)

		WebUI.click(buttonClose)

		KeywordUtil.markPassed("Close button was clicked")
	}

	@Keyword
	def clickOnCancelAndContinueButton () {
		KeywordUtil.logInfo("Click on Cancel And Continue button")

		WebUI.waitForElementVisible(buttonCancelAndContinue, 40)

		WebUI.click(buttonCancelAndContinue)

		KeywordUtil.markPassed("Cancel And Continue button was clicked")
	}

	@Keyword
	def clickOnSaveAndContinueButton () {
		KeywordUtil.logInfo("Click on Save and Continue button")

		WebUI.waitForElementVisible(buttonSaveAndContinue, 40)

		WebUI.click(buttonSaveAndContinue)

		KeywordUtil.markPassed("Save And Continue button was clicked")
	}





	// Actions On Detail Tab
	@Keyword
	def verifyLicenseInformation (String firstName, String lastName, String licenseType) {
		WebUI.waitForElementVisible(inputFirstName, 40)

		KeywordUtil.logInfo("Verify First Name")

		if (WebUI.verifyElementAttributeValue(inputFirstName, 'value', firstName, 40, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The First Name was verfied correctly: " + firstName)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The First Name was not the expected")
		}

		KeywordUtil.logInfo("Verify Last Name")

		if (WebUI.verifyElementAttributeValue(inputLastName, 'value', lastName, 40, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The Last Name was verfied correctly: " + lastName)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The Last Name was not the expected")
		}

		KeywordUtil.logInfo("Verify License Type")

		if(WebUI.verifyElementText(selectLicenseType, licenseType, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The License Type was verfied correctly: " + licenseType)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The License Type was not the expected")
		}
	}

	@Keyword
	def verifyIssueDate (String issueDate) {
		KeywordUtil.logInfo("Verify Issue Date")

		WebUI.waitForElementVisible(inputIssueDate, 40)

		if(WebUI.verifyElementAttributeValue(inputIssueDate, 'value', issueDate, 40)) {
			KeywordUtil.markPassed("The Issue Date was verfied correctly: " + issueDate)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The Issue Date was not the expected")
		}
	}

	@Keyword
	def verifyEffectiveDate (String effectiveDate) {
		KeywordUtil.logInfo("Verify Effective Date Date")

		WebUI.waitForElementVisible(inputEffectiveDate, 40)

		if(WebUI.verifyElementAttributeValue(inputEffectiveDate, 'value', effectiveDate, 40, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The Effective Date was verfied correctly: " + effectiveDate)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The Effective Date was not the expected")
		}
	}

	@Keyword
	def verifyExpirationDate (String expirationDate) {
		KeywordUtil.logInfo("Verify Expiration Date Date")

		WebUI.waitForElementVisible(inputExpirationDate, 40)

		if (WebUI.verifyElementAttributeValue(inputExpirationDate, 'value', expirationDate, 40, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The Expiration Date was verfied correctly: " + expirationDate)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The Expiration Date was not the expected")
		}
	}

	@Keyword
	def obtainLicenseId () {
		KeywordUtil.logInfo("Get License Id")

		WebUI.waitForElementVisible(spanLicenseId, 40)

		String licenseId = WebUI.getAttribute(spanLicenseId, 'value')

		KeywordUtil.markPassed('LicenseID:' + licenseId)

		return licenseId
	}

	@Keyword
	def obtainIssueDate () {
		KeywordUtil.logInfo("Get License Id")

		WebUI.waitForElementVisible(inputIssueDate, 40)

		String issueDate = WebUI.getAttribute(inputIssueDate, 'value')

		KeywordUtil.markPassed('Issue Date:' + issueDate)

		return issueDate
	}

	@Keyword
	def completeIssueDate (String issueDate) {
		KeywordUtil.logInfo("Complete Issue Date")

		WebUI.clearText(inputIssueDate)

		WebUI.waitForElementVisible(inputIssueDate, 40)

		WebUI.sendKeys(inputIssueDate, issueDate)

		KeywordUtil.markPassed("Issue Date was completed: " + issueDate)
	}





	// Actions on Discipline Tab
	@Keyword
	def clickOnDisciplinaryButton () {
		KeywordUtil.logInfo("Click on Add Disciplinary or Licensure Event button")

		WebUI.waitForElementVisible(buttonDisciplinary, 40)

		WebUI.click(buttonDisciplinary)

		KeywordUtil.markPassed("Add Disciplinary or Licensure Event button was clicked")
	}

	@Keyword
	def verifyDisciplineIsNotPresent () {
		KeywordUtil.logInfo("Verify Disciplinary or Licensure Event record is NOT present")

		WebUI.waitForElementVisible(OpenLinkDiscipline1, 40)

		if(WebUI.verifyElementNotPresent(OpenLinkDiscipline1, 40, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("No  Disciplinary or Licensure Event record was present as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("A Disciplinary or Licensure Event record was present")
		}

	}

	@Keyword
	def verifyDisciplineIsPresent () {
		KeywordUtil.logInfo("Verify Disciplinary or Licensure Event record is present")

		WebUI.waitForElementVisible(OpenLinkDiscipline1, 40)

		if (WebUI.verifyElementVisible(OpenLinkDiscipline1, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Disciplinary or Licensure Event record was present")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("No Disciplinary or Licensure Event record was present")
		}
	}





	//Actions on Manage TAB
	@Keyword
	def clickOnMakeLicenseInactive () {
		KeywordUtil.logInfo("Click on Make License Inactive button")

		WebUI.waitForElementVisible(buttonMakeLicenseInactive, 40)

		WebUI.click(buttonMakeLicenseInactive)

		KeywordUtil.markPassed("Make License Inactive button was clicked")
	}

	@Keyword
	def clickOnAddFee () {
		KeywordUtil.logInfo("Click on Add Fee button")

		WebUI.waitForElementVisible(buttonAddFee, 40)

		WebUI.click(buttonAddFee)

		KeywordUtil.markPassed("Add Fee button was clicked")
	}

	@Keyword
	def verifyCloseButtonNotVisible () {
		KeywordUtil.logInfo("Verify Close Button is not visible")

		if(WebUI.verifyElementNotPresent(buttonClose, 40, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Close button was not visible as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Close button was visible")
		}
	}

	@Keyword
	def clickOnPrintWallCertificateButton () {
		KeywordUtil.logInfo("Click on Print Wall Certificate button")

		WebUI.waitForElementVisible(buttonPrintWallCertificate, 40)

		WebUI.click(buttonPrintWallCertificate)

		KeywordUtil.markPassed("Print Wall Certificate button was clicked")
	}

	@Keyword
	def clickOnPrintWalletCardButton () {
		KeywordUtil.logInfo("Click on Print Wallet Card button")

		WebUI.waitForElementVisible(buttonPrintWaWalletCard, 40)

		WebUI.click(buttonPrintWaWalletCard)

		KeywordUtil.markPassed("Print Wallet Card button was clicked")
	}

	@Keyword
	def clickOnPlaceOnHoldBtn () {
		KeywordUtil.logInfo("Click on Place on Hold button")

		WebUI.waitForElementVisible(buttonPlaceOnHold, 40)

		WebUI.click(buttonPlaceOnHold)

		KeywordUtil.markPassed("Place on Hold button was clicked")
	}

	@Keyword
	def clickOnReleaseHoldBtn () {
		KeywordUtil.logInfo("Click on Release Hold button")

		WebUI.waitForElementVisible(buttonReleaseHold, 40)

		WebUI.click(buttonReleaseHold)

		KeywordUtil.markPassed("Release Hold button was clicked")
	}

	@Keyword
	def verifyReleaseHoldBtnIsNotVisible () {
		KeywordUtil.logInfo("Verify Release Hold button is not visible")

		WebUI.waitForElementVisible(buttonReleaseHold, 40)

		if (WebUI.verifyElementNotVisible(buttonReleaseHold, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Release Hold button was not visible")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Release Hold button was visible")
		}
	}

	@Keyword
	def verifyReleaseHoldBtnIsNotPresent () {
		KeywordUtil.logInfo("Verify Release Hold button is not present")

		WebUI.waitForElementVisible(buttonReleaseHold, 40)

		if (WebUI.verifyElementNotPresent(buttonReleaseHold, 40, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Release Hold button was not present")
		} else {
			KeywordUtil.markFailed("Release Hold button was present")
		}
	}

	@Keyword
	def selectHoldReason () {
		KeywordUtil.logInfo("Select a Hold Reason")

		WebUI.waitForElementVisible(dropdownReasonHold, 40)

		WebUI.click(dropdownReasonHold)

		WebUI.click(optionReasonHold_Discipline)

		KeywordUtil.markPassed("A Hold Reason was selected: Discipline")
	}

}

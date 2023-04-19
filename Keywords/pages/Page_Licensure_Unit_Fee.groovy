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

public class Page_Licensure_Unit_Fee {


	private TestObject dropdownLicenseName						= findTestObject('Page_Licensure Unit Fee/dropdown License Name/dropdown_License Name-arrow')
	private TestObject dropdownPhysicalTherapistOpt				= findTestObject('Page_Licensure Unit Fee/dropdown License Name/li_Physical Therapist')
	private TestObject dropdownFeeType							= findTestObject('Page_Licensure Unit Fee/dropdown Fee Type/dropdown_Fee Type-arrow')
	private TestObject dropdownLapFeeOpt						= findTestObject('Page_Licensure Unit Fee/dropdown Fee Type/li_LAP Fee')
	private TestObject inputFeeAmount							= findTestObject('Page_Licensure Unit Fee/input_Fee Amount')
	private TestObject dropdownAllowPayments					= findTestObject('Page_Licensure Unit Fee/dropdown Allow Payments/dropdown_Allow Payments-arrow')
	private TestObject optAllowPaymentsYes						= findTestObject('Page_Licensure Unit Fee/dropdown Allow Payments/li_Yes')
	private TestObject optAllowPaymentsNo						= findTestObject('Page_Licensure Unit Fee/dropdown Allow Payments/li_No')
	private TestObject buttonSave								= findTestObject('Page_Licensure Unit Fee/button_Save')
	private TestObject buttonSaveAndContinue					= findTestObject('Page_Licensure Unit Fee/button_Save and Continue')
	private TestObject buttonCancelAndContinue					= findTestObject('Page_Licensure Unit Fee/button_Cancel and Continue')
	private TestObject columnTotalDue							= findTestObject('Page_Licensure Unit Fee/Repeating Row Control/td_Total Due')
	private TestObject columnTotalPaid							= findTestObject('Page_Licensure Unit Fee/Repeating Row Control/td_Total Paid')
	private TestObject columnDescription						= findTestObject('Page_Licensure Unit Fee/Repeating Row Control/div_Description')
	private TestObject columnStatus								= findTestObject('Page_Licensure Unit Fee/Repeating Row Control/td_Status')
	private TestObject spanRecordId								= findTestObject('Page_Licensure Unit Fee/Read Only Section/span_Record Id')






	@Keyword
	def selectPhysicalTherapistOnLicenseName () {
		KeywordUtil.logInfo("Select a Physical Therapist On License Name")

		WebUI.waitForElementVisible(dropdownLicenseName, 40)

		WebUI.click(dropdownLicenseName)

		WebUI.click(dropdownPhysicalTherapistOpt)

		KeywordUtil.markPassed("Physical Therapist On License Name selected")
	}


	@Keyword
	def selectLapFeeOnFeeType () {
		KeywordUtil.logInfo("Select a Lap Fee On Fee Type")

		WebUI.waitForElementVisible(dropdownFeeType, 40)

		WebUI.click(dropdownFeeType)

		WebUI.click(dropdownLapFeeOpt)

		KeywordUtil.markPassed("Lap Fee On Fee Type selected")
	}


	@Keyword
	def completeFeeAmount (String amount) {
		KeywordUtil.logInfo("Complete Fee amount: " + amount)

		WebUI.sendKeys(inputFeeAmount, amount)

		KeywordUtil.markPassed("Fee amount was completed: " + amount)
	}


	@Keyword
	def selectAllowPayments (String answer) {
		KeywordUtil.logInfo("Select Allow Payments: " + answer)

		WebUI.click(dropdownAllowPayments)

		if (answer == 'Yes') {
			WebUI.click(optAllowPaymentsYes)

			KeywordUtil.markPassed("Allow Payments selected: " + answer)
		} else {
			WebUI.click(optAllowPaymentsNo)

			KeywordUtil.markPassed("Allow Payments selected: " + answer)
		}
	}


	@Keyword
	def clickOnSave () {
		KeywordUtil.logInfo("Click on save button")

		WebUI.click(buttonSave)

		KeywordUtil.markPassed("Save button clicked")
	}


	@Keyword
	def clickOnSaveAndContinue () {
		KeywordUtil.logInfo("Click on save and continue button")

		WebUI.click(buttonSaveAndContinue)

		KeywordUtil.markPassed("Save and continue button clicked")
	}


	@Keyword
	def clickOnCancelAndContinue () {
		KeywordUtil.logInfo("Click on cancel and continue button")

		WebUI.click(buttonCancelAndContinue)

		KeywordUtil.markPassed("Cancel and continue button clicked")
	}

	@Keyword
	def verifyRepeatingRawControlInfo (String expectedTotalDue, String expectedTotalPaid, String expectedDescription, String expectedStatus) {
		KeywordUtil.logInfo("Verify first payment record item")

		WebUI.waitForElementVisible(columnTotalDue, 40)

		String totalDue = WebUI.getText(columnTotalDue)

		System.out.println('\nTotalDue = ' + totalDue + '\nTotalDue2= ' + expectedTotalDue + '\n')

		if (WebUI.verifyMatch(totalDue, expectedTotalDue, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Total due amount is verified")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Total due amount is incorrect")
		}

		String totalPaid = WebUI.getText(columnTotalPaid)

		System.out.println('\nTotalPaid = ' + totalPaid + '\nTotalPaid2= ' + expectedTotalPaid + '\n')

		if (WebUI.verifyMatch(totalPaid, expectedTotalPaid, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Total paid amount is verified")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Total paid amount is incorrect")
		}

		String description = WebUI.getText(columnDescription)

		System.out.println('\nDescription = ' + description + '\nDescription2= ' + expectedDescription + '\n')

		if (WebUI.verifyMatch(description, expectedDescription, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Description is verified")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Description is incorrect")
		}

		String status = WebUI.getText(columnStatus)

		System.out.println('\nDescription = ' + status + '\nDescription2= ' + expectedStatus + '\n')

		if (WebUI.verifyMatch(status, expectedStatus, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Status is verified")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Status is incorrect")
		}
	}

	@Keyword
	def getRecordId () {
		KeywordUtil.logInfo("Obtaining Record Id Number")

		String feeId = WebUI.getText(spanRecordId)

		System.out.println(feeId)

		KeywordUtil.markPassed("Record Id Number obtained")

		return feeId
	}
}

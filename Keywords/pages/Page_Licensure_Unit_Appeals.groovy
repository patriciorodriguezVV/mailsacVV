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
import com.kms.katalon.core.mobile.keyword.builtin.WaitForElementAttributeValueKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.WaitForElementVisibleKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

/*************
 * Objects
 *************/
public class Page_Licensure_Unit_Appeals {

	private TestObject inputAppealCode			= findTestObject('Page_Licensure_Unit_Appeals/input_Appeal_Code')
	private TestObject btnNext					= findTestObject('Page_Licensure_Unit_Appeals/button_Next')
	private TestObject btnSubmit				= findTestObject('Page_Licensure_Unit_Appeals/button_Submit')
	private TestObject checkboxOutsideUSA		= findTestObject('Page_Licensure_Unit_Appeals/checkbox_OutsideUSA')
	private TestObject inputPhone				= findTestObject('Page_Licensure_Unit_Appeals/input_Applicant_Phone')
	private TestObject inputPhoneExt			= findTestObject('Page_Licensure_Unit_Appeals/input_Applicant_Phone_Ext')
	private TestObject inputAddressL1			= findTestObject('Page_Licensure_Unit_Appeals/input_Applicant_Address_L1')
	private TestObject inputAddressL2			= findTestObject('Page_Licensure_Unit_Appeals/input_Applicant_Address_L2')
	private TestObject inputAddressL3			= findTestObject('Page_Licensure_Unit_Appeals/input_Applicant_Address_L3')
	private TestObject inputZip					= findTestObject('Page_Licensure_Unit_Appeals/input_Applicant_Zip')
	private TestObject textareaAppealReason		= findTestObject('Page_Licensure_Unit_Appeals/textarea_ReasonForAppeal')
	private TestObject h1AppealSubmitted		= findTestObject('Page_Licensure_Unit_Appeals/h1_Your appeal has been submitted')

	/*************
	 * Inputs
	 *************/	
	@Keyword
	def enterAppealCode (String appealCode) {
		KeywordUtil.logInfo("Enter Appeal Code")

		WebUI.waitForElementVisible(inputAppealCode, 40)

		WebUI.sendKeys(inputAppealCode, appealCode)

		KeywordUtil.markPassed("Appeal Code entered: "  + appealCode)
	}

	@Keyword
	def enterUpdatedPhone (String phone) {
		KeywordUtil.logInfo("Enter updated Phone Number")

		WebUI.waitForElementVisible(inputPhone, 40)

		WebUI.setText(inputPhone, phone)

		KeywordUtil.markPassed("Updated Phone Number entered: "  + phone)
	}
	@Keyword
	def enterUpdatedPhonExt (String ext) {
		KeywordUtil.logInfo("Enter updated Phone Extension")

		WebUI.waitForElementVisible(inputPhoneExt, 40)

		WebUI.setText(inputPhoneExt, ext)

		KeywordUtil.markPassed("Updated Phone Extension entered: "  + ext)
	}

	@Keyword
	def enterUpdatedAddressL1 (String address) {
		KeywordUtil.logInfo("Enter updated Address Line 1")

		WebUI.waitForElementVisible(inputAddressL1, 40)

		WebUI.setText(inputAddressL1, address)

		KeywordUtil.markPassed("Updated Address Line 1 entered: "  + address)
	}
	@Keyword
	def enterUpdatedAddressL2 (String address) {
		KeywordUtil.logInfo("Enter updated Address Line 2")

		WebUI.waitForElementVisible(inputAddressL2, 40)

		WebUI.setText(inputAddressL2, address)

		KeywordUtil.markPassed("Updated Address Line 2 entered: "  + address)
	}

	@Keyword
	def enterUpdatedAddressL3 (String address) {
		KeywordUtil.logInfo("Enter updated Address Line 3:")

		WebUI.waitForElementVisible(inputAddressL3, 40)

		WebUI.setText(inputAddressL3, address)

		KeywordUtil.markPassed("Updated Address Line 3 entered: "  + address)
	}

	@Keyword
	def enterUpdatedZip (String zip) {
		KeywordUtil.logInfo("Enter updated Zip Code")

		WebUI.waitForElementVisible(inputZip, 40)

		WebUI.setText(inputZip, zip)

		KeywordUtil.markPassed("Updated Zip Code entered: " + zip)
	}

	@Keyword
	def enterAppealReason (String text) {
		KeywordUtil.logInfo("Enter Appeal Reason")

		WebUI.waitForElementVisible(textareaAppealReason, 40)

		WebUI.sendKeys(textareaAppealReason, text)

		KeywordUtil.markPassed("Appeal Reason entered: " + text)
	}

	/*************
	 * Buttons
	 *************/
	@Keyword
	def clickOnNextBtn () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(btnNext, 40)

		WebUI.click(btnNext)

		KeywordUtil.markPassed("Next button clicked")
	}

	@Keyword
	def clickOnSubmitBtn () {
		KeywordUtil.logInfo("Click on Submit button")

		WebUI.waitForElementVisible(btnSubmit, 40)

		WebUI.click(btnSubmit)

		KeywordUtil.markPassed("Submit button clicked")
	}

	/****************
	 * Validations
	 ****************/
	@Keyword
	def verifyAppealSubmitted () {
		KeywordUtil.logInfo("Verify Appeal Submitted")

		WebUI.waitForElementVisible(h1AppealSubmitted, 40)

		if (WebUI.verifyElementPresent(h1AppealSubmitted, 40, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Appeal submission confirmation webpage loaded")
		} else {
			KeywordUtil.markFailed("The test case can not be completed. Appeal submission confirmation webpage did not load")
		}
	}

	@Keyword
	def verifyErrorAlert (String alertObj, String errorText) {
		KeywordUtil.logInfo("Verify Error Alert")

		if (!alertObj.contains(errorText)) {
			// Stop tc execution
			KeywordUtil.markFailed("The test case can not be completed. Error alert won't show due VALID denial code entered")

		} else {
			KeywordUtil.markPassed("Error alert msj verified: " + errorText)
		}
	}
}
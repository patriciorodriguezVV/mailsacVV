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

public class Page_Licensure_Unit_License_Application_Demographics {


	private TestObject checkboxExperience				= findTestObject('Page_Licensure Unit License Application/Demographics/input_Experience Check-box')
	private TestObject inputAKA							= findTestObject('Page_Licensure Unit License Application/Demographics/input_AKA')
	private TestObject selectSameAddress				= findTestObject('Page_Licensure Unit License Application/Demographics/span_Is the Physical address the same_arrow')
	private TestObject selectSameAddressYesOpt			= findTestObject('Page_Licensure Unit License Application/Demographics/li_Yes_Same Address')
	private TestObject selectSameAddressNoOpt			= findTestObject('Page_Licensure Unit License Application/Demographics/li_No Same Address')
	private TestObject inputPlaceOfBirth				= findTestObject('Page_Licensure Unit License Application/Demographics/input_Place of Birth')
	private TestObject selectSpouseOfUSAF				= findTestObject('Page_Licensure Unit License Application/Demographics/span_Select Spouse of member USAF')
	private TestObject selectSpouseOfUSAFYesOpt			= findTestObject('Page_Licensure Unit License Application/Demographics/li_Yes spouse USAF')
	private TestObject selectSpouseOfUSAFNoOpt			= findTestObject('Page_Licensure Unit License Application/Demographics/li_No spouse USAF')
	private TestObject selectProvisionalLicense			= findTestObject('Page_Licensure Unit License Application/Demographics/span_dropdown Applicant Want Provisional License')
	private TestObject selectProvisionalLicenseYesOpt	= findTestObject('Page_Licensure Unit License Application/Demographics/li_Applicant Want Provisional License_Yes')
	private TestObject selectProvisionalLicenseNoOpt	= findTestObject('Page_Licensure Unit License Application/Demographics/li_Applicant Want Provisional License_No')
	private TestObject buttonNext						= findTestObject('Page_Licensure Unit License Application/Demographics/button_Next')
	private TestObject buttonUploadDocument             = findTestObject('Object Repository/Page_Licensure Unit License Application/Demographics/input_btnUploadMilitarySpouse')
	private TestObject buttonViewUploadedDoc            = findTestObject('Object Repository/Page_Licensure Unit License Application/Demographics/button_View Uploaded Documents')
	private TestObject selectTemporaryLicense			= findTestObject('Object Repository/Page_Licensure Unit License Application/Demographics/Temporary license Military Spouse/Select_temporary_License_Military_Spouse_Arrow')
	private TestObject selectTemporaryLicenseYesOpt	    = findTestObject('Object Repository/Page_Licensure Unit License Application/Demographics/Temporary license Military Spouse/span_Yes')
	private TestObject selectTemporaryLicenseNoOpt		= findTestObject('Object Repository/Page_Licensure Unit License Application/Demographics/Temporary license Military Spouse/span_No')

	@Keyword
	def checkCheckboxExperience () {
		KeywordUtil.logInfo("Check Expirience checkbox")

		WebUI.waitForElementVisible(checkboxExperience, 40)

		WebUI.check(checkboxExperience)

		KeywordUtil.markPassed("Expirience was checked")
	}


	@Keyword
	def enterAKA (String aka) {
		KeywordUtil.logInfo("Complete AKA field")

		WebUI.waitForElementVisible(inputAKA, 40)

		WebUI.sendKeys(inputAKA, aka)

		KeywordUtil.markPassed("AKA was completed: " + aka)
	}


	@Keyword
	def selectSameAddres (String sameAddress) {
		KeywordUtil.logInfo("Select an answer for 'Is the Physical address the same?'")

		if (sameAddress == 'Yes') {
			WebUI.waitForElementVisible(selectSameAddress, 40)

			WebUI.click(selectSameAddress)

			WebUI.click(selectSameAddressYesOpt)
		} else {
			WebUI.waitForElementVisible(selectSameAddress, 40)

			WebUI.click(selectSameAddress)

			WebUI.click(selectSameAddressNoOpt)
		}

		KeywordUtil.markPassed("An answer was selected for the question 'Is the Physical address the same?': " + sameAddress)
	}


	@Keyword
	def verifyPlaceOfBirth (String placeOfBirth) {
		KeywordUtil.logInfo("Verify Place Of Brith was auto-completed correctly")

		WebUI.waitForElementVisible(inputPlaceOfBirth, 40)

		WebUI.verifyElementAttributeValue(inputPlaceOfBirth, 'value', placeOfBirth, 40)

		KeywordUtil.markPassed("Place Of Birth was auto-completed correctly: " + placeOfBirth)
	}


	@Keyword
	def selectSpouseMemberUSAF (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Is the applicant the spouse of a member of the United States Armed Forces who has an active-duty assignment in Nebraska?'")

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(selectSpouseOfUSAF, 40)

			WebUI.click(selectSpouseOfUSAF)

			WebUI.click(selectSpouseOfUSAFYesOpt)
		} else {
			WebUI.waitForElementVisible(selectSpouseOfUSAF, 40)

			WebUI.click(selectSpouseOfUSAF)

			WebUI.click(selectSpouseOfUSAFNoOpt)
		}

		KeywordUtil.markPassed("An answer was slected for 'Is the applicant the spouse of a member of the United States Armed Forces who has an active-duty assignment in Nebraska?': " + answer)
	}


	@Keyword
	def selectProvisionalLicense (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Does the applicant want to apply for a provisional license?'")

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(selectProvisionalLicense, 40)

			WebUI.click(selectProvisionalLicense)

			WebUI.click(selectProvisionalLicenseYesOpt)
		} else {
			WebUI.waitForElementVisible(selectProvisionalLicense, 40)

			WebUI.click(selectProvisionalLicense)

			WebUI.click(selectProvisionalLicenseNoOpt)
		}

		KeywordUtil.markPassed("An answer was selected for 'Does the applicant want to apply for a provisional license?': " + answer)
	}
	
	@Keyword
	def selectTemporaryLicense (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Does the applicant want to apply for a temporary license as a military spouse?'")

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(selectTemporaryLicense, 40)

			WebUI.click(selectTemporaryLicense)

			WebUI.click(selectTemporaryLicenseYesOpt)
		} else {
			WebUI.waitForElementVisible(selectTemporaryLicense, 40)

			WebUI.click(selectTemporaryLicense)

			WebUI.click(selectTemporaryLicenseNoOpt)
		}

		KeywordUtil.markPassed("An answer was selected for 'Does the applicant want to apply for a temporary license as a military spouse?': " + answer)
	}
	
	
	/****************************************************
	 * Actions with buttons
	 ****************************************************/

	
	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button was clicked")
	}
	
	@Keyword
	def clickOnUploadDocumentButton () {
		KeywordUtil.logInfo("Click on Upload Document button")

		WebUI.waitForElementVisible(buttonUploadDocument, 40)

		WebUI.click(buttonUploadDocument)

		KeywordUtil.markPassed("Upload Document was clicked")
	}
	
	@Keyword
	def verifyViewUploadedDocumentsIsVisible () {
		KeywordUtil.logInfo("Verify View Upload Documents button is visible")

		WebUI.waitForElementVisible(buttonViewUploadedDoc, 0)

		if (WebUI.verifyElementVisible(buttonViewUploadedDoc, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("View Upload Documents button is visible as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("View Upload Documents button is not visible")
		}
	}
	
	@Keyword
	def verifyUploadDocumentIsVisible () {
		KeywordUtil.logInfo("Verify Upload Document button is visible")

		WebUI.waitForElementVisible(buttonUploadDocument, 0)

		if (WebUI.verifyElementVisible(buttonUploadDocument, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Upload Document button is visible as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Upload Document button is not visible")
		}
	}
}

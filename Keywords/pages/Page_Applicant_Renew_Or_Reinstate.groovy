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

public class Page_Applicant_Renew_Or_Reinstate {

	private TestObject dropdownLicenseType					= findTestObject('Page_Applicant Pages VV/Page_Renew or Reinstate/span_Select License Drop-down')
	private TestObject dropdownCosmetologistOpt				= findTestObject('Page_Applicant Pages VV/Page_Renew or Reinstate/li_Cosmetologist')
	private TestObject buttonNext							= findTestObject('Page_Applicant Pages VV/Page_Renew or Reinstate/button_Next')

	// Selecting Physical Therapy ---
	@Keyword
	def selectLicenseCosmetologist () {
		KeywordUtil.logInfo("Select License Type Cosmetologist")

		WebUI.waitForElementVisible(dropdownLicenseType, 40)

		WebUI.click(dropdownLicenseType)

		WebUI.click(dropdownCosmetologistOpt)

		KeywordUtil.markPassed("License Type Cosmetologist selected")
	}


	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button clicked")
	}


}

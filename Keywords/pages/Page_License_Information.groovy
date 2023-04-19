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

public class Page_License_Information {


	private TestObject dropdownProfessionalLicense			= findTestObject('Page_Licensure Unit License Application/License Type/span_Professioanl License')
	private TestObject dropdownPhysicalTherapyOpt			= findTestObject('Page_Licensure Unit License Application/License Type/li_Physical Therapy')
	private TestObject dropdownProfessionalLicenseType		= findTestObject('Page_Licensure Unit License Application/License Type/span_Professioanl License Type')
	private TestObject dropdownPhysicalTherapistOpt			= findTestObject('Page_Licensure Unit License Application/License Type/License Type for Physical Therapy/li_Physical Therapist')
	private TestObject dropdownCosmetologyOpt				= findTestObject('Page_Licensure Unit License Application/License Type/License Type for Cosmetologist/li_Cosmetology')
	private TestObject dropdownCosmetologistOpt				= findTestObject('Page_Licensure Unit License Application/License Type/License Type for Cosmetologist/li_Cosmetologist')
	private TestObject buttonNext							= findTestObject('Page_Licensure Unit License Application/License Type/button_Next')


	// Selecting Physical Therapy ---
	@Keyword
	def selectPhisicalTherapyProfessionalLicense () {
		KeywordUtil.logInfo("Select Physical Therapy Professional License")
		
		WebUI.waitForElementVisible(dropdownProfessionalLicense, 40)

		WebUI.click(dropdownProfessionalLicense)

		WebUI.click(dropdownPhysicalTherapyOpt)
		
		KeywordUtil.markPassed("Physical Therapy Professional License selected")
	}


	@Keyword
	def selectPhisicalTherapistProfessionalLicenseType () {
		KeywordUtil.logInfo("Select Physical Therapist Professional License type")
		
		WebUI.waitForElementVisible(dropdownProfessionalLicenseType, 40)

		WebUI.click(dropdownProfessionalLicenseType)

		WebUI.click(dropdownPhysicalTherapistOpt)
		
		KeywordUtil.markPassed("Physical Therapist Professional License type selected")
	}



	//Selecting Cosmetology ---
	@Keyword
	def selectCosmetologyProfessionalLicense () {
		KeywordUtil.logInfo("Select Cosmetology Professional License")
		
		WebUI.waitForElementVisible(dropdownProfessionalLicense, 40)

		WebUI.click(dropdownProfessionalLicense)

		WebUI.click(dropdownCosmetologyOpt)
		
		KeywordUtil.markPassed("Cosmetology Professional License selected")
	}


	@Keyword
	def selectCosmetologistProfessionalLicenseType () {
		KeywordUtil.logInfo("Select Cosmetologist Professional License type")
		
		WebUI.waitForElementVisible(dropdownProfessionalLicenseType, 40)

		WebUI.click(dropdownProfessionalLicenseType)

		WebUI.click(dropdownCosmetologistOpt)
		
		KeywordUtil.markPassed("Cosmetologist Professional License type selected")
	}


	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")
		
		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)
		
		KeywordUtil.markPassed("Next button clicked")
	}
}
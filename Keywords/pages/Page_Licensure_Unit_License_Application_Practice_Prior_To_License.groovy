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

public class Page_Licensure_Unit_License_Application_Practice_Prior_To_License {


	private TestObject dropdownHasPracticedWithoutLic		= findTestObject('Page_Licensure Unit License Application/Practice Prior to License/span_Select Has practiced without license-arrow')
	private TestObject selectHasPracticedWthoutLicYesOpt	= findTestObject('Page_Licensure Unit License Application/Practice Prior to License/li_Has practiced without license - Yes')
	private TestObject selectHasPracticedWthoutLicNoOpt		= findTestObject('Page_Licensure Unit License Application/Practice Prior to License/li_Has practiced without license - No')
	private TestObject buttonNext							= findTestObject('Page_Licensure Unit License Application/Practice Prior to License/button_Next')
	private TestObject inputNumberOfDays					= findTestObject('Page_Licensure Unit License Application/Practice Prior to License/input_Number of Days')
	private TestObject inputNameOfBusiness					= findTestObject('Page_Licensure Unit License Application/Practice Prior to License/input_Name of Business')
	private TestObject inputCity							= findTestObject('Page_Licensure Unit License Application/Practice Prior to License/input_City')
	private TestObject inputWorkPhone						= findTestObject('Page_Licensure Unit License Application/Practice Prior to License/input_Work Phone')




	@Keyword
	def selectHasPracticedWithoutLicense (String answer) {
		KeywordUtil.logInfo("Select answer for 'Has the applicant practiced as a(n) Physical Therapist in Nebraska without a Nebraska license?': " + answer)

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(dropdownHasPracticedWithoutLic, 40)

			WebUI.click(dropdownHasPracticedWithoutLic)

			WebUI.click(selectHasPracticedWthoutLicYesOpt)
		} else {
			WebUI.waitForElementVisible(dropdownHasPracticedWithoutLic, 40)

			WebUI.click(dropdownHasPracticedWithoutLic)

			WebUI.click(selectHasPracticedWthoutLicNoOpt)
		}

		KeywordUtil.markPassed("An answer was selected for  'Has the applicant practiced as a(n) Physical Therapist in Nebraska without a Nebraska license?': " + answer)
	}


	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button was clicked")
	}
	
	@Keyword
	def completeNumberOfDays (String numbOfDays) {
		KeywordUtil.logInfo("Complete Number of Days: " + numbOfDays)

		WebUI.waitForElementVisible(inputNumberOfDays, 40)

		WebUI.sendKeys(inputNumberOfDays, numbOfDays)

		KeywordUtil.markPassed("Number of Days completed: " + numbOfDays)
	}
	
	@Keyword
	def completeNameOfBusiness (String bussinessName) {
		KeywordUtil.logInfo("Complete Name of Business: " + bussinessName)

		WebUI.waitForElementVisible(inputNameOfBusiness, 40)

		WebUI.sendKeys(inputNameOfBusiness, bussinessName)

		KeywordUtil.markPassed("Name of Business completed: " + bussinessName)
	}
	
	@Keyword
	def completeCity (String city) {
		KeywordUtil.logInfo("Complete City: " + city)

		WebUI.waitForElementVisible(inputCity, 40)

		WebUI.sendKeys(inputCity, city)

		KeywordUtil.markPassed("City completed: " + city)
	}
	
	@Keyword
	def completeWorkPhone (String workPhone) {
		KeywordUtil.logInfo("Complete Work Phone: " + workPhone)

		WebUI.waitForElementVisible(inputWorkPhone, 40)

		WebUI.sendKeys(inputWorkPhone, workPhone)

		KeywordUtil.markPassed("Work Phone completed: " + workPhone)
	}

}

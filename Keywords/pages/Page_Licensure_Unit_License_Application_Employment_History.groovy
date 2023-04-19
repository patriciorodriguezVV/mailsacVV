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

public class Page_Licensure_Unit_License_Application_Employment_History {


	private TestObject buttonNext							= findTestObject('Page_Licensure Unit License Application/Employment History/button_Next')
	private TestObject dropdownEmploymentConsiderationNo    = findTestObject('Object Repository/Page_Licensure Unit License Application/Employment History/dropdown_Employment_Consideration/li_No')
	private TestObject dropdownEmploymentConsiderationYes   = findTestObject('Object Repository/Page_Licensure Unit License Application/Employment History/dropdown_Employment_Consideration/li_Yes') 
	private TestObject dropdownEmploymentConsideration      = findTestObject('Object Repository/Page_Licensure Unit License Application/Employment History/dropdown_Employment_Consideration/dropdown_Employment_Consideration')
	

	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button was clicked")
	}
	
	@Keyword
	def selectEmploymentConsideration (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Are you requesting full-time practice be considered towards the 1,800 hours of training in cosmetology, then use the 'Add Employment' to provide the Name of the Salon, City, State, Telephone Number, and Dates of Full Time Practice as a cosmetologist in the previous 5 years? Select Yes below if you want to enter employment to be considered towards your 1,800 hours of training in cosmetology or no if you believe you have fulfilled the 1,800 hour training requirement.'")

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(dropdownEmploymentConsideration, 40)

			WebUI.click(dropdownEmploymentConsideration)

			WebUI.click(dropdownEmploymentConsiderationYes)
		} else {
			WebUI.waitForElementVisible(dropdownEmploymentConsideration, 40)

			WebUI.click(dropdownEmploymentConsideration)

			WebUI.click(dropdownEmploymentConsiderationNo)
		}

		KeywordUtil.markPassed("An answer was selected for 'Are you requesting full-time practice be considered towards the 1,800 hours of training in cosmetology, then use the 'Add Employment' to provide the Name of the Salon, City, State, Telephone Number, and Dates of Full Time Practice as a cosmetologist in the previous 5 years? Select Yes below if you want to enter employment to be considered towards your 1,800 hours of training in cosmetology or no if you believe you have fulfilled the 1,800 hour training requirement.': " + answer)
	}
	
}

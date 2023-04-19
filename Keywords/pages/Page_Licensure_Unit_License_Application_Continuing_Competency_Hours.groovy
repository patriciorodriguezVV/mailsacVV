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

public class Page_Licensure_Unit_License_Application_Continuing_Competency_Hours {


	private TestObject dropdownContinuingCompetencyRequirementMet					= findTestObject('Page_Licensure Unit License Application/Continuing Competency Hours/Continuing Competency Requirement Met dropdown/span_Continuing Competency Requirement Met_dropdown')
	private TestObject selectContinuingCompetencyRequirementMetYesOpt				= findTestObject('Page_Licensure Unit License Application/Continuing Competency Hours/Continuing Competency Requirement Met dropdown/li_Yes')
	private TestObject selectContinuingCompetencyRequirementMetNoOpt				= findTestObject('Page_Licensure Unit License Application/Continuing Competency Hours/Continuing Competency Requirement Met dropdown/li_No')
	private TestObject buttonNext													= findTestObject('Page_Licensure Unit License Application/Continuing Competency Hours/button_Next')
	private TestObject checkboxHaveNotCompetencyEducationInitial					= findTestObject('Page_Licensure Unit License Application/Continuing Competency Hours/input_have not_Competency Education Initial')
	private TestObject checkboxIllnessDisabilityActiveMilitaryCompetencyWaiver		= findTestObject('Page_Licensure Unit License Application/Continuing Competency Hours/input_IllnessDisability_Active Military Competency Waiver')
	private TestObject checkboxSubmitCompetencyCircumstancesWaiver					= findTestObject('Page_Licensure Unit License Application/Continuing Competency Hours/input_Submit_Competency Circumstances Waiver')




	@Keyword
	def selectContinuingCompetencyRequirementMet (String answer) {
		KeywordUtil.logInfo("Select answer for 'Has the applicant met the continuing competency requirements for their profession?': " + answer)

		switch (answer) {
			case "Yes":
				WebUI.waitForElementVisible(dropdownContinuingCompetencyRequirementMet, 40)

				WebUI.click(dropdownContinuingCompetencyRequirementMet)

				WebUI.click(selectContinuingCompetencyRequirementMetYesOpt)
				break;
			case "No":
				WebUI.waitForElementVisible(dropdownContinuingCompetencyRequirementMet, 40)

				WebUI.click(dropdownContinuingCompetencyRequirementMet)

				WebUI.click(selectContinuingCompetencyRequirementMetNoOpt)
				break;
			default:
				break;
		}

		KeywordUtil.markPassed("An answer was selected for 'Has the applicant met the continuing competency requirements for their profession?': " + answer)
	}


	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button was clicked")
	}
}

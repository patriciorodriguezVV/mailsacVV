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

public class Page_Licensure_Unit_License_Application_Convictions {


	private TestObject dropdownIsOnProbation				= findTestObject('Page_Licensure Unit License Application/Convictions/span_Select Is on probation-arrow')
	private TestObject selectIsOnProbationNoOpt				= findTestObject('Page_Licensure Unit License Application/Convictions/li_Is on probation - No')
	private TestObject selectIsOnProbationYesOpt			= findTestObject('Page_Licensure Unit License Application/Convictions/li_Is on probation - Yes')
	private TestObject dropdownHasBeenConvicted				= findTestObject('Page_Licensure Unit License Application/Convictions/span_Select Has been convicted-arrow')
	private TestObject inputOffenseDescription				= findTestObject('Page_Licensure Unit License Application/Convictions/input_Description_of_Offense')
	private TestObject buttonAddNewRow						= findTestObject('Page_Licensure Unit License Application/Convictions/button_Add New Row')
	private TestObject selectJurisdiction 					= findTestObject('Page_Licensure Unit License Application/Convictions/span_Select Jurisdiction-arrow')
	private TestObject selectJurisdiction_NebraskaOpt 		= findTestObject('Page_Licensure Unit License Application/Convictions/li_Nebraska')
	private TestObject inputFinalOutcome					= findTestObject('Page_Licensure Unit License Application/Convictions/input_Final_Outcome')
	private TestObject inputDoC								= findTestObject('Page_Licensure Unit License Application/Convictions/input_DoC')
	private TestObject buttonSaveConvictionItem				= findTestObject('Page_Licensure Unit License Application/Convictions/button_Save_Conviction_Item')
	private TestObject inputConvictionExplanation			= findTestObject('Page_Licensure Unit License Application/Convictions/textarea_Conviction Explanation')
	private TestObject selectHasBeenConvictedNoOpt			= findTestObject('Page_Licensure Unit License Application/Convictions/li_Has been convicted - No')
	private TestObject selectHasBeenConvictedYesOpt			= findTestObject('Page_Licensure Unit License Application/Convictions/li_Has been convicted - Yes')
	private TestObject buttonUploadExplainConvictions		= findTestObject('Page_Licensure Unit License Application/Convictions/input_explain convictions UploadButton')
	private TestObject buttonNext							= findTestObject('Page_Licensure Unit License Application/Convictions/button_Next')





	@Keyword
	def selectIsOnProbation (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Is the applicant currently on a court-ordered probation?'")

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(dropdownIsOnProbation, 40)

			WebUI.click(dropdownIsOnProbation)

			WebUI.click(selectIsOnProbationYesOpt)
		} else {
			WebUI.waitForElementVisible(dropdownIsOnProbation, 40)

			WebUI.click(dropdownIsOnProbation)

			WebUI.click(selectIsOnProbationNoOpt)
		}

		KeywordUtil.markPassed("An answer was selected for 'Is the applicant currently on a court-ordered probation?': " + answer)
	}


	@Keyword
	def selectHasBeenConvicted (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Has the applicant EVER been convicted of a misdemeanor or felony?'")

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(dropdownHasBeenConvicted, 40)

			WebUI.click(dropdownHasBeenConvicted)

			WebUI.click(selectHasBeenConvictedYesOpt)
		} else {
			WebUI.waitForElementVisible(dropdownHasBeenConvicted, 40)

			WebUI.click(dropdownHasBeenConvicted)

			WebUI.click(selectHasBeenConvictedNoOpt)
		}

		KeywordUtil.markPassed("An answer was selected for 'Has the applicant EVER been convicted of a misdemeanor or felony?': " + answer)
	}

	@Keyword
	def clickOnAddNewRow () {
		KeywordUtil.logInfo("Click on Add New Row button")

		WebUI.waitForElementVisible(buttonAddNewRow, 40)

		WebUI.click(buttonAddNewRow)

		KeywordUtil.markPassed("Add New Row button was clicked")
	}

	@Keyword
	def completeOffenseDescription (String offenseDescription) {
		KeywordUtil.logInfo("Complete Description of Offense")

		WebUI.waitForElementVisible(inputOffenseDescription, 40)

		WebUI.sendKeys(inputOffenseDescription, offenseDescription)

		KeywordUtil.markPassed("Description of Offense was completed: " + offenseDescription)
	}

	@Keyword
	def selectJurisdictionNebraska () {
		KeywordUtil.logInfo("Select Jurisdiction - Nebraska")

		WebUI.waitForElementVisible(selectJurisdiction, 40)

		WebUI.click(selectJurisdiction)

		WebUI.click(selectJurisdiction_NebraskaOpt)

		KeywordUtil.markPassed("Jurisdiction was selected: Nebraska")
	}

	@Keyword
	def completeDoC (String month, String day, String year) {
		KeywordUtil.logInfo("Complete Date of Conviction")

		WebUI.waitForElementVisible(inputDoC, 40)

		WebUI.click(inputDoC)

		WebUI.sendKeys(inputDoC, month)
		WebUI.sendKeys(inputDoC, day)
		WebUI.sendKeys(inputDoC, year)

		KeywordUtil.markPassed("Date of Conviction was completed: " + month + "/" + day + "/" + year)
	}

	@Keyword
	def completeFinalOutcome (String finalOutcome) {
		KeywordUtil.logInfo("Complete Final Outcome")

		WebUI.waitForElementVisible(inputFinalOutcome, 40)

		WebUI.sendKeys(inputFinalOutcome, finalOutcome)

		KeywordUtil.markPassed("Final Outcome was completed: " + finalOutcome)
	}

	@Keyword
	def clickOnSaveConvictionItemButton () {
		KeywordUtil.logInfo("Click on Save Conviction Item button")

		WebUI.waitForElementVisible(buttonSaveConvictionItem, 40)

		WebUI.click(buttonSaveConvictionItem)

		KeywordUtil.markPassed("Save Conviction Item button was clicked")
	}

	@Keyword
	def completeConvictionExplanation (String convictionExplanation) {
		KeywordUtil.logInfo("Complete Conviction Explanation")

		WebUI.waitForElementVisible(inputConvictionExplanation, 40)

		WebUI.sendKeys(inputConvictionExplanation, convictionExplanation)

		KeywordUtil.markPassed("Conviction Explanation was completed: " + convictionExplanation)
	}

	@Keyword
	def clickOnUploadExplainConvictionsButton () {
		KeywordUtil.logInfo("Click on Upload Explain Convictions button")

		WebUI.waitForElementVisible(buttonUploadExplainConvictions, 40)

		WebUI.click(buttonUploadExplainConvictions)

		KeywordUtil.markPassed("Upload Explain Convictions button was clicked")
	}

	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button was clicked")
	}
}

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

public class Page_Licensure_Unit_License_Application_Examination {


	private TestObject buttonNext						  = findTestObject('Page_Licensure Unit License Application/Examination/button_Next')
	private TestObject buttonSaveAndContinue			  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/button_Save and Continue')
	private TestObject buttonAddExamination 			  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/button_Add Examination')
	private TestObject buttonOkDialog					  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/button_Ok')
	private TestObject examTypeDropdown     			  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Exam Type/Exam_Type_Arrow')
	private TestObject selectExamTypeJurisprudenceOpt     = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Exam Type/li_Jurisprudence')
	private TestObject selectExamTypeNPTEOpt     		  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Exam Type/li_NPTE')
	private TestObject stateDropdown       		          = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/State/state_Arrow')
	private TestObject selectStateNebraskaOpt     		  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/State/li_Nebraska')
	private TestObject passFailDropdown     		      = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Pass_Fail/pass_Fail_Arrow')
	private TestObject selectPassFailPassOpt     		  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Pass_Fail/li_Pass')
	private TestObject selectPassFailFailOpt     		  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Pass_Fail/li_Fail')
	private TestObject selectPassFailNoShowOpt     		  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Pass_Fail/li_No Show')
	private TestObject selectPassFailPendingOpt     	  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Pass_Fail/li_Pending')
	private TestObject selectPassFailWaivedOpt     		  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Pass_Fail/li_Waived')
	private TestObject selectExamdate 		    		  = findTestObject('Object Repository/Page_Licensure Unit License Application/Examination/Exam Date/input__Exam Date')



	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button was clicked")
	}

	@Keyword
	def clickOnOkDialog () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonOkDialog, 40)

		WebUI.click(buttonOkDialog)

		KeywordUtil.markPassed("Next button was clicked")
	}

	@Keyword
	def clickOnSaveAndContinue () {
		KeywordUtil.logInfo("Click on Save and Continue button")

		WebUI.waitForElementVisible(buttonSaveAndContinue, 40)

		WebUI.click(buttonSaveAndContinue)

		KeywordUtil.markPassed("Save and Continue button was clicked")
	}

	@Keyword
	def clickOnAddExaminationButton () {
		KeywordUtil.logInfo("Click on Add Examination button")

		WebUI.waitForElementVisible(buttonAddExamination, 40)

		WebUI.click(buttonAddExamination)

		KeywordUtil.markPassed("Add Examination button was clicked")
	}

	@Keyword
	def selectExamType (String answer) {
		KeywordUtil.logInfo("Select Exam Type")

		WebUI.waitForElementVisible(examTypeDropdown, 40)

		WebUI.click(examTypeDropdown)

		switch (answer) {
			case "Jurisprudence":
				WebUI.click(selectExamTypeJurisprudenceOpt)
				break;

			case "NPTE":
				WebUI.click(selectExamTypeNPTEOpt)
				break;

			default:
				break;
		}

		KeywordUtil.markPassed("Exam Type was selected: " + answer)
	}

	@Keyword
	def selectState (String answer) {
		KeywordUtil.logInfo("Select State")

		WebUI.waitForElementVisible(stateDropdown, 40)

		WebUI.click(stateDropdown)

		switch (answer) {
			case "Nebraska":
				WebUI.click(selectExamTypeJurisprudenceOpt)
				break;

			default:
				break;
		}

		KeywordUtil.markPassed("State was selected: " + answer)
	}

	@Keyword
	def selectPassFail (String answer) {
		KeywordUtil.logInfo("Select Pass/Fail")

		WebUI.waitForElementVisible(passFailDropdown, 40)

		WebUI.click(passFailDropdown)

		switch (answer) {
			case "Pass":
				WebUI.click(selectPassFailPassOpt)
				break;

			case "Fail":
				WebUI.click(selectPassFailFailOpt)
				break;

			case "No Show":
				WebUI.click(selectPassFailNoShowOpt)
				break;

			case "Waived":
				WebUI.click(selectPassFailWaivedOpt)
				break;

			case "Pending":
				WebUI.click(selectPassFailPendingOpt)
				break;

			default:
				break;
		}

		KeywordUtil.markPassed("Pass/Fail was selected: " + answer)
	}

	@Keyword
	def examDate (String DATE) {
		KeywordUtil.logInfo("Complete Exam date")

		WebUI.waitForElementVisible(selectExamdate, 40)

		WebUI.sendKeys(selectExamdate, DATE)

		KeywordUtil.markPassed("Exam date was completed: " + DATE)
	}
}

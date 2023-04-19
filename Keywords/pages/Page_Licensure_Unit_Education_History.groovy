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

public class Page_Licensure_Unit_Education_History {


	private TestObject inputNameOfSchool				= findTestObject('Page_Licensure Unit License Application/Education Information FORM/input__Name Of School')
	private TestObject dropdownEducationType			= findTestObject('Page_Licensure Unit License Application/Education Information FORM/span_Select Education Type-s')
	private TestObject selectEducationTypeDiplomaOpt	= findTestObject('Page_Licensure Unit License Application/Education Information FORM/li_Diploma')
	private TestObject buttonSaveAndContinue			= findTestObject('Page_Licensure Unit License Application/Education Information FORM/button_Save and Continue')
	private TestObject h5MessageTitle					= findTestObject('Page_Licensure Unit License Application/Education Information FORM/h5_Record Saved')
	private TestObject buttonOkDialog					= findTestObject('Page_Licensure Unit License Application/Education Information FORM/button_Ok')



	@Keyword
	def enterSchoolName (String schoolName) {
		KeywordUtil.logInfo("Enter School name: " + schoolName)

		WebUI.waitForElementVisible(inputNameOfSchool, 40)

		WebUI.sendKeys(inputNameOfSchool, schoolName)

		KeywordUtil.markPassed("School name was completed: " + schoolName)
	}


	@Keyword
	def selectEducationTypeDiploma () {
		KeywordUtil.logInfo("Select Education Type Diploma")

		WebUI.waitForElementVisible(dropdownEducationType, 40)

		WebUI.click(dropdownEducationType)

		WebUI.click(selectEducationTypeDiplomaOpt)

		KeywordUtil.markPassed("Education Type Diploma selected")
	}


	@Keyword
	def clickOnSaveAndContinue () {
		KeywordUtil.logInfo("Click On Save and Continue button")

		WebUI.waitForElementVisible(buttonSaveAndContinue, 40)

		WebUI.click(buttonSaveAndContinue)

		KeywordUtil.markPassed("Save and Continue button was clicked")
	}


	@Keyword
	def verifyRecordSavedCorrectly (String messageTitle) {
		KeywordUtil.logInfo("Verify Modal Dialog title " + messageTitle)

		WebUI.waitForElementVisible(h5MessageTitle, 40)

		if (WebUI.verifyElementText(h5MessageTitle, messageTitle, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Modal Dialog title is correct: " + messageTitle)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The Modal Dialog title is not correct. The expected title is: " + messageTitle)
		}

		WebUI.click(buttonOkDialog)

	}
}

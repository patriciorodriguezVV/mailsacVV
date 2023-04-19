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

public class Page_Licensure_Unit_License_Application_Checklist_Management {


	private TestObject buttonNext				= findTestObject('Page_Licensure Unit License Application/Checklist Management/button_Next')
	private TestObject buttonBack				= findTestObject('Page_Licensure Unit License Application/Checklist Management/button_Back')
	private TestObject buttonUploadFile			= findTestObject('Page_Licensure Unit License Application/Checklist Management/input_Open Related Form_btnChecklistTaskUpload')
	private TestObject buttonDialogConfirmation	= findTestObject('Page_Licensure Unit License Application/Checklist Management/button_Ok')
	private TestObject buttonAcknowledge		= findTestObject('Page_Licensure Unit License Application/Checklist Management/button_Acknowledge')
	private TestObject buttonOpenRelatedForm	= findTestObject('Page_Licensure Unit License Application/Checklist Management/button_Open Related Form')
	private TestObject messageTaskDescription	= findTestObject('Page_Licensure Unit License Application/Checklist Management/div_Task Instructions')




	@Keyword
	def clickOnOkDialogButton () {
		KeywordUtil.logInfo("Click on Ok button")

		WebUI.waitForElementVisible(buttonDialogConfirmation, 40)

		WebUI.click(buttonDialogConfirmation)

		KeywordUtil.markPassed("Ok button was clicked from Modal Dialog")
	}

	@Keyword
	def clickOnBackButton () {
		KeywordUtil.logInfo("Click on Back button")

		WebUI.waitForElementVisible(buttonBack, 40)

		WebUI.click(buttonBack)

		KeywordUtil.markPassed("Back button was clicked from Modal Dialog")
	}

	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button was clicked from Modal Dialog")
	}

	@Keyword
	def clickOnAcknowledgeButton () {
		KeywordUtil.logInfo("Click on Acknowledge button")

		WebUI.waitForElementVisible(buttonAcknowledge, 40)

		WebUI.click(buttonAcknowledge)

		KeywordUtil.markPassed("Acknowledge button was clicked from Modal Dialog")
	}


	@Keyword
	def clickOnUploadButton () {
		KeywordUtil.logInfo("Click on Upload button")

		WebUI.waitForElementVisible(buttonUploadFile, 40)

		WebUI.click(buttonUploadFile)

		KeywordUtil.markPassed("Upload button was clicked from Modal Dialog")
	}


	@Keyword
	def clickOnOpenRelatedFormButton () {
		KeywordUtil.logInfo("Click on Open Related Form button")

		WebUI.waitForElementVisible(buttonOpenRelatedForm, 40)

		WebUI.click(buttonOpenRelatedForm)

		KeywordUtil.markPassed("Open Related Form button was clicked from Modal Dialog")
	}

	@Keyword
	def verifyTaskDescription (String taskDescription) {
		WebUI.waitForElementVisible(messageTaskDescription, 40)

		WebUI.verifyElementText(messageTaskDescription, taskDescription)
	}
}

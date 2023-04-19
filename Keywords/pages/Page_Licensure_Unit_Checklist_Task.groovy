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



public class Page_Licensure_Unit_Checklist_Task {


	private TestObject tabApprove						= findTestObject('Page_Licensure Unit Checklist Task/button_Approve')
	private TestObject tabComplete						= findTestObject('Page_Licensure Unit Checklist Task/button_Complete')
	private TestObject buttonComplete					= findTestObject('Page_Licensure Unit Checklist Task/Complete Section/button_Complete')
	private TestObject buttonApprove					= findTestObject('Page_Licensure Unit Checklist Task/Approve Section/button_Approve')
	private TestObject dropdownStatus					= findTestObject('Page_Licensure Unit Checklist Task/kendo-dropdownlist_Status')
	private TestObject buttonClose						= findTestObject('Page_Licensure Unit Checklist Task/Approve Section/button_Close')
	private TestObject buttonRequestMoreInfo			= findTestObject('Page_Licensure Unit Checklist Task/Approve Section/button_Request More Info')
	private TestObject textareaTaskName					= findTestObject('Page_Licensure Unit Checklist Task/Details tab/textarea_Task Name')
	private TestObject dateDueDate						= findTestObject('Page_Licensure Unit Checklist Task/Details tab/input_Due Date')



	/****************************************************
	 * Tabs
	 ****************************************************/

	@Keyword
	def clickOnApproveTab () {
		KeywordUtil.logInfo("Click on Approve tab")

		WebUI.waitForElementVisible(tabApprove, 40)

		System.sleep(3000)

		WebUI.click(tabApprove)

		KeywordUtil.markPassed("Approve tab was clicked")
	}


	@Keyword
	def clickOnCompleteTab () {
		KeywordUtil.logInfo("Click on Complete tab")

		WebUI.waitForElementVisible(tabComplete, 40)

		System.sleep(3000)

		WebUI.click(tabComplete)

		KeywordUtil.markPassed("Complete tab was clicked")
	}




	/****************************************************
	 * Tab Details
	 ****************************************************/

	@Keyword
	def verifyTaskName (String taskName) {
		KeywordUtil.logInfo('Verify Task Name content: ' + taskName)

		if (WebUI.verifyElementAttributeValue(textareaTaskName, 'value', taskName, 0, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed('Task Name was verified: "' + taskName + '"')
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed('Task Name was not the expected: ' + taskName)
		}
	}




	/****************************************************
	 * Tab Complete
	 ****************************************************/

	@Keyword
	def clickOnCompleteBtn () {
		KeywordUtil.logInfo("Click on Complete button")

		WebUI.waitForElementVisible(buttonComplete, 40)

		System.sleep(3000)

		WebUI.click(buttonComplete)

		KeywordUtil.markPassed("Complete button was clicked")
	}




	/****************************************************
	 * Tab Approve
	 ****************************************************/

	@Keyword
	def clickOnApproveButton () {
		KeywordUtil.logInfo("Click on Approve button")

		WebUI.waitForElementVisible(buttonApprove, 40)

		System.sleep(3000)

		WebUI.click(buttonApprove)

		KeywordUtil.markPassed("Approve button was clicked")
	}


	@Keyword
	def clickOnRequestMoreInfoButton () {
		KeywordUtil.logInfo("Click on Request More Info button")

		WebUI.waitForElementVisible(buttonRequestMoreInfo, 40)

		System.sleep(3000)

		WebUI.click(buttonRequestMoreInfo)

		KeywordUtil.markPassed("Request More Info button was clicked")
	}




	/****************************************************
	 * General
	 ****************************************************/

	@Keyword
	def clickOnCloseButton () {
		KeywordUtil.logInfo("Click on Close button")

		WebUI.waitForElementVisible(buttonClose, 40)

		System.sleep(3000)

		WebUI.click(buttonClose)

		KeywordUtil.markPassed("Close buttons was clicked")
	}

	@Keyword
	def verifyStatus (String statutsExpected) {
		KeywordUtil.logInfo('Verify Status: ' + statutsExpected)

		System.sleep(2000)

		String currentStatus =  WebUI.getText(dropdownStatus)

		if(WebUI.verifyMatch(currentStatus, statutsExpected, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The Status was verfied correctly: " + statutsExpected)
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The Status was not the expected. Expected status: " + statutsExpected)
		}
	}
}
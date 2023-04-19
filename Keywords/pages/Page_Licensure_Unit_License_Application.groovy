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
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class Page_Licensure_Unit_License_Application {

	// Tabs
	private TestObject buttonChecklistTab					= findTestObject('Page_Licensure Unit License Application/Tabs/button_Checklist')
	private TestObject buttonManageTab						= findTestObject('Page_Licensure Unit License Application/Tabs/button_Manage')
	private TestObject inputAppealCode						= findTestObject('Page_Licensure Unit License Application/Manage/input_Appeal Code')
	private TestObject buttonChecklistMang					= findTestObject('Page_Licensure Unit License Application/Tabs/button_Checklist Management')
	private TestObject buttonSubbmit						= findTestObject('Page_Licensure Unit License Application/Pay/button_Submit')
	private TestObject buttonClose							= findTestObject('Page_Licensure Unit License Application/Pay/button_Close')


	// Manage section
	private TestObject buttonApplicantDeficient				= findTestObject('Page_Licensure Unit License Application/Manage/button_Application Deficient')
	private TestObject dropdownStatus						= findTestObject('Page_Licensure Unit License Application/Pay/kendo-Dropdown-Status')


	// Application Instruction Section
	private TestObject buttonAcknowledge					= findTestObject('Page_Licensure Unit License Application/Instructions/button_Acknowledge')


	// Go to x Tab
	@Keyword
	def clickOnChecklistTab () {
		KeywordUtil.logInfo("Click on Checklist Tab")

		WebUI.waitForElementVisible(buttonChecklistTab, 40)

		WebUI.click(buttonChecklistTab)

		KeywordUtil.markPassed("Checklist Tab was clicked")
	}

	@Keyword
	def clickOnManageTab () {
		KeywordUtil.logInfo("Click on Manage Tab")

		WebUI.waitForElementVisible(buttonManageTab, 40)

		WebUI.click(buttonManageTab)

		KeywordUtil.markPassed("Manage Tab was clicked")
	}

	@Keyword
	def clickOnChecklistManagementTab () {
		KeywordUtil.logInfo("Click on Checklist Management Tab")

		WebUI.waitForElementVisible(buttonChecklistMang, 40)

		WebUI.click(buttonChecklistMang)

		KeywordUtil.markPassed("Checklist Management Tab was clicked")
	}

	@Keyword
	def clickOnSubmitBtn () {
		KeywordUtil.logInfo("Click on Submit button")

		WebUI.waitForElementVisible(buttonSubbmit, 40)

		WebUI.click(buttonSubbmit)

		KeywordUtil.markPassed("Submit button was clicked")
	}

	@Keyword
	def clickOnCloseBtn () {
		KeywordUtil.logInfo("Click on Close button")

		WebUI.waitForElementVisible(buttonClose, 40)

		WebUI.click(buttonClose)

		KeywordUtil.markPassed("Close button was clicked")
	}



	// Section APPLICATION INSTRUCTIONS
	@Keyword
	def clickOnAcknowledgeBtn () {
		KeywordUtil.logInfo("Click on Acknowledge button")

		WebUI.waitForElementVisible(buttonAcknowledge, 40)

		WebUI.click(buttonAcknowledge)

		KeywordUtil.markPassed("Acknowledge button was clicked")
	}




	// Actions on Manage TAB
	@Keyword
	def clickOnApplicationApprove () {
		KeywordUtil.logInfo("Click on Application Approve button")

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/button_Application Approve'), 40)

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/button_Application Approve'))

		KeywordUtil.markPassed("Application Approve button was clicked")
	}

	@Keyword
	def StartReview () {
		// Click on Start Review
		KeywordUtil.logInfo("Click on Start Review button")

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/button_Start Review'), 40)

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/button_Start Review'))

		KeywordUtil.markPassed("Start Review button was clicked")

		// Verify Modal Dialog Title
		KeywordUtil.logInfo("Verify Modal Dialog Title is 'Create Application'")

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 40)

		if (WebUI.verifyElementText(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 'Create Application', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Modal Dialgo Title is correct")
		} else {
			KeywordUtil.markFailed("Modal Dialog Title was not the expected")
		}

		// Click on Ok button
		KeywordUtil.logInfo("Click on Ok button'")

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/button_Okay'))

		KeywordUtil.markPassed("Ok button was clicked")

		System.sleep(2000)

		// Verify Status
		KeywordUtil.logInfo("Verify Status is 'Pending'")

		if (WebUI.verifyElementText(findTestObject('Page_Licensure Unit License Application/Pay/kendo-Dropdown-Status'), 'Pending')) {
			KeywordUtil.markPassed("The Status is correct")
		} else {
			KeywordUtil.markFailed("The Status was not the expected")
		}
	}

	@Keyword
	def ApproveApplication () {
		KeywordUtil.logInfo("Click on Application Approve button")

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/button_Application Approve'), 40)

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/button_Application Approve'))

		KeywordUtil.markPassed("Application Approve button was clicked")

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 40)

		KeywordUtil.logInfo("Verify Modal Dialog Title is 'Application Approved'")

		if(WebUI.verifyElementText(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 'Application Approved', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Modal Dialgo Title is correct")
		} else {
			KeywordUtil.markFailed("Modal Dialog Title was not the expected")
		}

		KeywordUtil.logInfo("Click on Return to Form button")

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/button_Return to Form'))

		KeywordUtil.markPassed("Return to Form button was clicked")

		System.sleep(2000)

		KeywordUtil.logInfo("Verify Status is 'Approved'")

		if (WebUI.verifyElementText(findTestObject('Page_Licensure Unit License Application/Pay/kendo-Dropdown-Status'), 'Approved', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The Status is correct")
		} else {
			KeywordUtil.markFailed("The Status was not the expected")
		}
	}


	// Deny License Application, complete the process and verify Message displayed and Status
	@Keyword
	def DenyApplication () {
		KeywordUtil.logInfo("Deny License Application")

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/button_Application Deny'), 40)

		// Select Reason for Denial
		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/span_ReaseonForDenial-arrow'))

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/li_Bad Check_Option'))

		// Click on button Application Deny
		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/button_Application Deny'))

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 40)

		// Verify Title of the Message
		WebUI.verifyElementText(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 'Application Denied', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/button_Close'))

		System.sleep(2000)

		WebUI.verifyElementText(findTestObject('Page_Licensure Unit License Application/Pay/kendo-Dropdown-Status'), 'Denied', FailureHandling.CONTINUE_ON_FAILURE)

		KeywordUtil.markPassed("License Application was denied successfully")
	}

	@Keyword
	def IssueLicense () {
		KeywordUtil.logInfo("Issue License Application")

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/button_Issue License'), 40)

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/button_Issue License'))

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 40)

		WebUI.verifyElementText(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 'Issue License', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/button_Ok'))

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 40)

		WebUI.verifyElementText(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title'), 'License Issued', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/button_Okay'))

		KeywordUtil.markPassed("License Application was issued successfully")
	}

	@Keyword
	def setApplicationDeficient () {
		KeywordUtil.logInfo("Click on Application Deficient button")

		WebUI.waitForElementVisible(buttonApplicantDeficient, 40)

		WebUI.click(buttonApplicantDeficient)

		KeywordUtil.markPassed("Application Deficient button was clicked")
	}


	@Keyword
	def getAppealCode () {
		KeywordUtil.logInfo("Obtain Appeal Code")

		String appealCode = WebUI.getAttribute(inputAppealCode, 'value')

		KeywordUtil.markPassed("Appeal Code was obtained: " + appealCode)

		return appealCode
	}




	// Other functions
	@Keyword
	def verifyLicenseApplicationOpened (String FirstName, String LastName) {
		KeywordUtil.logInfo("Verify First Name and Last Name of the License Application opened")

		WebUI.waitForElementVisible(findTestObject('Page_Licensure Unit License Application/Demographics/input_First Name'), 40)

		if (WebUI.verifyElementAttributeValue(findTestObject('Page_Licensure Unit License Application/Demographics/input_First Name'), 'value', FirstName, 0, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("First Name was verfied: " + FirstName)
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("First Name has not matched. Expected First Name: " + FirstName)
		}

		if (WebUI.verifyElementAttributeValue(findTestObject('Page_Licensure Unit License Application/Demographics/input_Last Name'), 'value', LastName, 0, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Last Name was verfied: " + LastName)
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Last Name has not matched. Expected Last Name: " + LastName)
		}
		
	}


	@Keyword
	def verifyStatus (String status) {
		KeywordUtil.logInfo("Verify Status of the License Application")
		
		WebUI.waitForElementVisible(dropdownStatus, 40)

		if (WebUI.verifyElementText(dropdownStatus, status, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Status was verfied correctly: " + status)
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Status has not matched. Expected Status: " + status)
		}
	}

}

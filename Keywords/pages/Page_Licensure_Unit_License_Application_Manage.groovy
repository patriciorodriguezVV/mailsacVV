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

public class Page_Licensure_Unit_License_Application_Manage {


	private TestObject inputAppealCode						= findTestObject('Page_Licensure Unit License Application/Manage/input_Appeal Code')
	private TestObject buttonApplicantDeficient				= findTestObject('Page_Licensure Unit License Application/Manage/button_Application Deficient')
	private TestObject buttonApplicantApprove				= findTestObject('Page_Licensure Unit License Application/Manage/button_Application Approve')
	private TestObject dropdownStatus						= findTestObject('Page_Licensure Unit License Application/Pay/kendo-Dropdown-Status')
	private TestObject buttonCancelAndClose					= findTestObject('Page_Licensure Unit License Application/Manage/button_Cancel and Close')
	private TestObject buttonStartReview					= findTestObject('Page_Licensure Unit License Application/Manage/button_Start Review')
	private TestObject buttonPayReview						= findTestObject('Page_Licensure Unit License Application/Pay/button_Submit')
	private TestObject modalDialogTitle						= findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/h5_Title')
	private TestObject buttonMDOkay							= findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/button_Okay')
	private TestObject buttonMDOk							= findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/button_Ok')
	private TestObject buttonMDOReturnToForm				= findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/button_Return to Form')
	private TestObject buttonMDClose						= findTestObject('Page_Licensure Unit License Application/Manage/Dialog Message/button_Close')
	private TestObject buttonApplicationDeny				= findTestObject('Page_Licensure Unit License Application/Manage/button_Application Deny')
	private TestObject buttonIssueLicense					= findTestObject('Page_Licensure Unit License Application/Manage/button_Issue License')
	private TestObject buttonCreateLetter					= findTestObject('Page_Licensure Unit License Application/Manage/button_Create Letter')
	private TestObject dropdownReasonForDenial				= findTestObject('Page_Licensure Unit License Application/Manage/span_ReaseonForDenial-arrow')
	private TestObject optDenialBadCheck					= findTestObject('Page_Licensure Unit License Application/Manage/li_Bad Check_Option')
	private TestObject buttonPayNow							= findTestObject('Page_Licensure Unit License Application/Pay/button_Pay Now')






	// Actions on Manage TAB
	@Keyword
	def clickOnApplicationApprove () {
		KeywordUtil.logInfo("Click on Application Approve button")
		
		WebUI.waitForElementVisible(buttonApplicantApprove, 40)

		WebUI.click(buttonApplicantApprove)
		
		KeywordUtil.markPassed("Application Approve button was clicked")
	}


	@Keyword
	def clickOnCancelAndClose () {
		KeywordUtil.logInfo("Click on Cancel and Close button")
		
		WebUI.waitForElementVisible(buttonCancelAndClose, 40)

		WebUI.click(buttonCancelAndClose)
		
		KeywordUtil.markPassed("Cancel and Close button was clicked")
	}


	@Keyword
	def clickOnCreateLetter () {
		KeywordUtil.logInfo("Click on Create Letter button")
		
		WebUI.waitForElementVisible(buttonCreateLetter, 40)

		WebUI.click(buttonCreateLetter)
		
		KeywordUtil.markPassed("Create Letter button was clicked")
	}


	@Keyword
	def clickOnStartReview () {
		KeywordUtil.logInfo("Click on Start Review button")
		
		WebUI.waitForElementVisible(buttonStartReview, 40)

		WebUI.click(buttonStartReview)
		
		KeywordUtil.markPassed("Start Review button was clicked")
	}


	@Keyword
	def ApproveApplication () {
		KeywordUtil.logInfo("Approve License Application")
		
		WebUI.waitForElementVisible(buttonApplicantApprove, 40)

		WebUI.click(buttonApplicantApprove)

		WebUI.waitForElementVisible(modalDialogTitle, 40)

		if (WebUI.verifyElementText(modalDialogTitle, 'Application Approved', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Modal Dialog displayed correctly")
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Modal Dialog was not displayed correctly")
		}

		WebUI.click(buttonMDOReturnToForm)

		if (WebUI.verifyElementText(dropdownStatus, 'Approved', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Status was verified correctly: Approved")
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Status was not the expected (Approved) or couldn't be verified")
		}
	}

	@Keyword
	def DenyApplication () {
		KeywordUtil.logInfo("Deny License Application")
		
		WebUI.waitForElementVisible(buttonApplicationDeny, 40)

		WebUI.click(dropdownReasonForDenial)

		WebUI.click(optDenialBadCheck)

		WebUI.click(buttonApplicationDeny)

		WebUI.waitForElementVisible(modalDialogTitle, 40)

		if (WebUI.verifyElementText(modalDialogTitle, 'Application Denied', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Modal Dialog displayed correctly")
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Modal Dialog was not displayed correctly")
		}

		WebUI.click(buttonMDClose)

		if (WebUI.verifyElementText(dropdownStatus, 'Denied', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Status was verified correctly: Denied")
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Status was not the expected (Denied) or couldn't be verified")
		}
	}

	@Keyword
	def IssueLicense () {
		KeywordUtil.logInfo("Issue License Application")
		
		WebUI.waitForElementVisible(buttonIssueLicense, 40)

		WebUI.click(buttonIssueLicense)

		WebUI.waitForElementVisible(modalDialogTitle, 40)

		if (WebUI.verifyElementText(modalDialogTitle, 'Issue License', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Modal Dialog displayed correctly")
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Modal Dialog was not displayed correctly")
		}
		
		WebUI.click(buttonMDOk)

		WebUI.waitForElementVisible(modalDialogTitle, 40)

		if (WebUI.verifyElementText(modalDialogTitle, 'License Issued', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Modal Dialog displayed correctly")
		} else {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Modal Dialog was not displayed correctly")
		}

		WebUI.click(buttonMDOkay)
	}

	@Keyword
	def setApplicationDeficient () {
		KeywordUtil.logInfo("Click on Application Deficient")
		
		WebUI.waitForElementVisible(buttonApplicantDeficient, 40)

		WebUI.click(buttonApplicantDeficient)
		
		KeywordUtil.markPassed("Application Deficient button was clicked")
	}


	@Keyword
	def getAppealCode () {
		KeywordUtil.logInfo("Get Appeal Code")
		
		String appealCode = WebUI.getAttribute(inputAppealCode, 'value')
		
		KeywordUtil.markPassed("Appeal Code was obtained: " + appealCode)

		return appealCode
	}


	@Keyword
	def verifyStatus (String status) {
		KeywordUtil.logInfo("Verify License Applicatin Status")
		
		WebUI.waitForElementVisible(dropdownStatus, 40)

		if (WebUI.verifyElementText(dropdownStatus, status, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The Status was verfied correctly: " + status)
		} else {
			KeywordUtil.markPassed("The Status was not the expected (" + status + ") or couldn't be verified")
		}
	}

	@Keyword
	def verifyStartReviewBtnIsNotVisible () {
		KeywordUtil.logInfo("Verify License Applicatin Status")
		
		WebUI.waitForElementVisible(buttonStartReview, 40)

		if(!WebUI.verifyElementNotVisible(buttonStartReview, FailureHandling.OPTIONAL)) {
			WebUI.takeFullPageScreenshot()
			
			KeywordUtil.markFailed("Failure: The button 'Start Review' was present.")
		} else {
			KeywordUtil.markPassed("Pass: Start Review button was not present")
		}
	}



}

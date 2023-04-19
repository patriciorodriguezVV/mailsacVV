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

public class Page_Applicant_Home {

	private TestObject linkApplyForALicense			= findTestObject('Page_Applicant Pages VV/Home/a_Apply for aLicense (1)')
	private TestObject linkViewYourFinances			= findTestObject('Page_Applicant Pages VV/Home/a_View your Finances (1)')
	private TestObject linkViewYourProfile			= findTestObject('Page_Applicant Pages VV/Home/a_View your Profile (1)')
	private TestObject linkOpenApplication			= findTestObject('Page_Applicant Pages VV/Home/a_Open Application (1)')
	private TestObject linkViewAndPrintLicense		= findTestObject('Page_Applicant Pages VV/Home/a_View and Print')
	private TestObject linkOpenTask1				= findTestObject('Page_Applicant Pages VV/Home/a_Open Task1')
	private TestObject linkOpenTask2				= findTestObject('Page_Applicant Pages VV/Home/a_Open Task2')
	private TestObject iframePrincipal				= findTestObject('Page_Applicant Pages VV/Home/iframe 1')
	private TestObject iframeViewYourFinances		= findTestObject('Page_Applicant Pages VV/Home/iframe View Your Finances')
	private TestObject iframeApplyForALicense		= findTestObject('Page_Applicant Pages VV/Home/iframe Apply For a License')
	private TestObject spanUserId					= findTestObject('Page_Applicant Pages VV/Home/span_User Id')
	private TestObject menuOptNew					= findTestObject('Page_Applicant Pages VV/Page_Applicant Menu Options/span_New')
	private TestObject menuOptReinstateALicense		= findTestObject('Page_Applicant Pages VV/Page_Applicant Menu Options/span_Reinstate a License')




	@Keyword
	def clickOnApplyForALicense () {
		KeywordUtil.logInfo("Click on Apply for a License button")

		WebUI.waitForElementVisible(iframePrincipal, 40)

		WebUI.switchToFrame(iframePrincipal, 40)

		WebUI.switchToFrame(iframeApplyForALicense, 40)

		WebUI.waitForElementVisible(linkApplyForALicense, 40)

		WebUI.click(linkApplyForALicense)

		WebUI.switchToDefaultContent()

		KeywordUtil.markPassed("Apply for a License button was clicked")
	}


	@Keyword
	def clickOnViewYourFinances () {
		KeywordUtil.logInfo("Click on View Your Finances button")

		WebUI.waitForElementVisible(iframePrincipal, 40)

		WebUI.switchToFrame(iframePrincipal, 40)

		WebUI.switchToFrame(iframeViewYourFinances, 40)

		WebUI.waitForElementVisible(linkViewYourFinances, 40)

		WebUI.click(linkViewYourFinances)

		WebUI.switchToDefaultContent()

		KeywordUtil.markPassed("View Your Finances button was clicked")
	}


	@Keyword
	def clickOnViewYourProfile () {
		KeywordUtil.logInfo("Click on View Your Profile button")

		WebUI.waitForElementVisible(linkViewYourProfile, 40)

		WebUI.click(linkViewYourProfile)

		KeywordUtil.markPassed("View Your Profile button was clicked")
	}


	@Keyword
	def clickOnViewAndPrintLicense () {
		KeywordUtil.logInfo("Click on View and Print License link")

		WebUI.waitForElementVisible(iframePrincipal, 40)

		WebUI.switchToFrame(iframePrincipal, 40)

		WebUI.waitForElementVisible(linkViewAndPrintLicense, 40)

		WebUI.click(linkViewAndPrintLicense)

		WebUI.switchToDefaultContent()

		KeywordUtil.markPassed("View and Print License link was clicked")
	}


	@Keyword
	def clickOnOpenTask1 () {
		KeywordUtil.logInfo("Click on Open Task link")

		WebUI.waitForElementVisible(iframePrincipal, 40)

		WebUI.switchToFrame(iframePrincipal, 40)

		WebUI.waitForElementVisible(linkOpenTask1, 40)

		WebUI.click(linkOpenTask1)

		WebUI.switchToDefaultContent()

		KeywordUtil.markPassed("Open Task link was clicked")
	}


	@Keyword
	def clickOnOpenTask2 () {
		KeywordUtil.logInfo("Click on Open Task link")

		WebUI.waitForElementVisible(iframePrincipal, 40)

		WebUI.switchToFrame(iframePrincipal, 40)

		WebUI.waitForElementVisible(linkOpenTask2, 40)

		WebUI.click(linkOpenTask2)

		WebUI.switchToDefaultContent()

		KeywordUtil.markPassed("Open Task link was clicked")
	}


	@Keyword
	def clickOnOpenApplication () {
		KeywordUtil.logInfo("Click on Open Application link")

		WebUI.waitForElementVisible(iframePrincipal, 40)

		WebUI.switchToFrame(iframePrincipal, 40)

		WebUI.waitForElementVisible(linkOpenApplication, 40)

		WebUI.click(linkOpenApplication)

		WebUI.switchToDefaultContent()

		KeywordUtil.markPassed("Open Application link was clicked")
	}


	@Keyword
	def clickOnNewReinstateALicense () {
		KeywordUtil.logInfo("Click on New > Reinstate a License")

		WebUI.waitForElementVisible(menuOptNew, 40)

		WebUI.mouseOver(menuOptNew)

		WebUI.waitForElementVisible(menuOptReinstateALicense, 40)

		WebUI.click(menuOptReinstateALicense)
	}


	@Keyword
	def verifyUserIsLogged (String expectedUserID) {
		KeywordUtil.logInfo("Verify user is logged in and User Id")

		WebUI.waitForElementVisible(spanUserId, 40)

		String currentUserId = WebUI.getText(spanUserId)

		if (WebUI.verifyMatch(currentUserId, expectedUserID, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("User was logged in correctly and user id was verfied correctly: " + expectedUserID)
		} else {
			KeywordUtil.markFailed("User was not logged in or user id was not the expected: Expected User Id: '" + expectedUserID +"', current User Id: '" + currentUserId + "'")
		}
	}
}

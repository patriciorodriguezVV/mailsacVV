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

public class Page_Home_Admin_ApplicationsInProgress {

	private TestObject buttonSearchMain 				= findTestObject('Page_Home_Admin_VisualVault/Home_Section/Page_Applications In Progress/span_Search')
	private TestObject inputSearchCriteria				= findTestObject('Page_Home_Admin_VisualVault/Home_Section/Page_Applications In Progress/input_Search Criteria')
	private TestObject selectSearchCriteria				= findTestObject('Page_Home_Admin_VisualVault/Home_Section/Page_Applications In Progress/a_Search By Arrow')
	private TestObject selectFirstNameOpt				= findTestObject('Page_Home_Admin_VisualVault/Home_Section/Page_Applications In Progress/li_First Name')
	private TestObject buttonSearch						= findTestObject('Page_Home_Admin_VisualVault/Home_Section/Page_Applications In Progress/input_Search Button')
	private TestObject linkReview						= findTestObject('Page_Home_Admin_VisualVault/Home_Section/Page_Applications In Progress/a_Review')




	@Keyword
	def clickOnSearchRecordButton () {
		KeywordUtil.logInfo("Click on Search button")

		WebUI.waitForElementVisible(buttonSearchMain, 40)

		WebUI.click(buttonSearchMain)

		KeywordUtil.markPassed("Search button was clicked")
	}


	@Keyword
	def enterSearchCriteria (String Criteria) {
		KeywordUtil.logInfo("Enter search parameter")

		WebUI.waitForElementVisible(inputSearchCriteria, 40)

		WebUI.sendKeys(inputSearchCriteria, Criteria)

		KeywordUtil.markPassed("Search parameter was entered: " + Criteria)
	}


	@Keyword
	def selectFirstNameForSearch () {
		KeywordUtil.logInfo("Select First Name for search criteria")

		WebUI.waitForElementVisible(selectSearchCriteria, 40)

		WebUI.click(selectSearchCriteria)

		WebUI.click(selectFirstNameOpt)

		KeywordUtil.markPassed("First Name was selected for search criteria")
	}


	@Keyword
	def clickOnSearchButton () {
		KeywordUtil.logInfo("Click on Search button")

		WebUI.waitForElementVisible(buttonSearch, 40)

		WebUI.click(buttonSearch)

		KeywordUtil.markPassed("Search button was clicked")
	}


	@Keyword
	def clickOnReviewLink () {
		KeywordUtil.logInfo("Click on Review link")

		WebUI.waitForElementVisible(linkReview, 40)

		WebUI.click(linkReview)

		KeywordUtil.markPassed("Review link was clicked")
	}
}

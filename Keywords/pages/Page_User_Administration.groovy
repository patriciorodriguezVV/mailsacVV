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

public class Page_User_Administration {


	private TestObject buttonMainSearchButton		= findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/a_Search Button')
	private TestObject inputSearchCriteria			= findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/Search Options/input_Search Criteria')
	private TestObject buttonSearchButton			= findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/Search Options/input_SearchButton')
	private TestObject buttonClear					= findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/Search Options/input_ClearButton')
	private TestObject buttonNewUser				= findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/span_New User')
	private TestObject checkboxFirstRecord			= findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User List/input_checkboxFIrstRecord')
	private TestObject checkboxSecondRecord			= findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User List/input_checkboxSecondRecord')


	@Keyword
	def clickOnSearchMainButton () {
		KeywordUtil.logInfo("Click on Search button")
		
		WebUI.waitForElementVisible(buttonMainSearchButton, 40)

		WebUI.click(buttonMainSearchButton)
		
		KeywordUtil.markPassed("Search button was clicked")
	}



	@Keyword
	def enterSearchCriteria (String searchCriteria) {
		KeywordUtil.logInfo("Complete Search Criteria: " + searchCriteria)
		
		WebUI.waitForElementVisible(inputSearchCriteria, 40)

		WebUI.sendKeys(inputSearchCriteria, searchCriteria)
		
		KeywordUtil.markPassed("Search Criteria was completed")
	}



	@Keyword
	def clickOnSearchButton () {
		KeywordUtil.logInfo("Click on Search button")
		
		WebUI.waitForElementVisible(buttonSearchButton, 40)

		WebUI.click(buttonSearchButton)
		
		KeywordUtil.markPassed("Search button was clicked")
	}


	@Keyword
	def verifyUniqueRecordOnList () {
		KeywordUtil.logInfo("Verify Unique Record on list")
		
		WebUI.waitForElementVisible(checkboxFirstRecord, 40)
		

		if (WebUI.verifyElementPresent(checkboxFirstRecord, 40)) {
			KeywordUtil.markPassed("At least one record was found")
		} else {
			KeywordUtil.markFailed("No record was found")
		}
		

		if (WebUI.verifyElementNotPresent(checkboxSecondRecord, 40)) {
			KeywordUtil.markPassed("The record found is unique")
		} else {
			KeywordUtil.markFailed("More than one record was found")
		}
	}
}

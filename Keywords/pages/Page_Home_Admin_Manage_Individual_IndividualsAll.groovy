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

public class Page_Home_Admin_Manage_Individual_IndividualsAll {

	//Import captured object variables
	private TestObject	btnSearchFilter					= findTestObject('Page_Home_Admin_VisualVault/Manage_Section/Individual/IndividualsAll/btnSearchFilters');
	private TestObject	dropdownSearchCriteria			= findTestObject('Page_Home_Admin_VisualVault/Manage_Section/Individual/IndividualsAll/dropdown_search_criteria');
	private TestObject	optionSearchCriteriaFirstName	= findTestObject('Page_Home_Admin_VisualVault/Manage_Section/Individual/IndividualsAll/option_search_criteria_firstName');
	private TestObject	dropdownSearchOperator			= findTestObject('Page_Home_Admin_VisualVault/Manage_Section/Individual/IndividualsAll/dropdown_search_operator');
	private TestObject	optionSearchOperatorContains	= findTestObject('Page_Home_Admin_VisualVault/Manage_Section/Individual/IndividualsAll/option_search_op_contains');
	private	TestObject	textboxSearch					= findTestObject('Page_Home_Admin_VisualVault/Manage_Section/Individual/IndividualsAll/textbox_search');
	private TestObject	btnSearch						= findTestObject('Page_Home_Admin_VisualVault/Manage_Section/Individual/IndividualsAll/btnSearch');
	private TestObject	checkboxIndividualRecord		= findTestObject('Page_Home_Admin_VisualVault/Manage_Section/Individual/IndividualsAll/checkbox_individual_record');

	@Keyword
	def clickOnSearchFilterBtn () {
		KeywordUtil.logInfo("Click on Search Filter button")
		
		System.sleep(5000)

		WebUI.waitForElementVisible(btnSearchFilter, 40);

		WebUI.click(btnSearchFilter);
		
		KeywordUtil.markPassed("Search Filter button clicked")
	}

	@Keyword
	def enterSearchCriteria (String searchCriteriaValue) {

		//Select criteria type
		KeywordUtil.logInfo("Select First Name for Search Criteria Type")
		
		WebUI.waitForElementVisible(dropdownSearchCriteria, 40);
		
		WebUI.click(dropdownSearchCriteria);
		
		WebUI.click(optionSearchCriteriaFirstName);
		
		KeywordUtil.markPassed("First Name for Search Criteria Type selected")

		
		//Select operator
		KeywordUtil.logInfo("Select Contains for Search Operator")
		
		WebUI.waitForElementVisible(dropdownSearchOperator, 40);
		
		WebUI.click(dropdownSearchOperator);
		
		WebUI.click(optionSearchOperatorContains);
		
		KeywordUtil.markPassed("Contains for Search Operator selected")

		
		//Input search value
		KeywordUtil.logInfo("Input search value")
		
		WebUI.waitForElementVisible(textboxSearch, 40);
		
		WebUI.sendKeys(textboxSearch, searchCriteriaValue);
		
		KeywordUtil.markPassed("Search value input: " + searchCriteriaValue)
	}

	@Keyword
	def clickOnSearchBtn () {
		KeywordUtil.logInfo("Click on Search button")
		
		WebUI.waitForElementVisible(btnSearch, 40);
		
		WebUI.click(btnSearch);
		
		KeywordUtil.markPassed("Search button clicked")
	}

	@Keyword
	def verifyIndividualRecordCreated () {
		KeywordUtil.logInfo("Verify Individual Record created")
		
		WebUI.waitForElementVisible(checkboxIndividualRecord, 40)
		
		WebUI.verifyElementPresent(checkboxIndividualRecord, 40)
		
		KeywordUtil.markPassed("Individual Record created verified")
	}
}
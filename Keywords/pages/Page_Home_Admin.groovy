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

public class Page_Home_Admin {

	private TestObject tabApplicationsInProcess			= findTestObject('Page_Home_Admin_VisualVault/Home_Section/Home_Tabs/span_Applications In Process')
	private TestObject tabApprovedApplications			= findTestObject('Page_Home_Admin_VisualVault/Home_Section/Home_Tabs/span_Approved Applications')
	private TestObject tabLicenseDetails				= findTestObject('Page_Home_Admin_VisualVault/Home_Section/Home_Tabs/span_License Details')
	private TestObject individualLink					= findTestObject('Page_Home_Admin_VisualVault/Home_Section/a_Individual Link')



	@Keyword
	def clickOnApplicationsInProcess () {
		KeywordUtil.logInfo("Click on Applications In Process tab")
		
		WebUI.waitForElementVisible(tabApplicationsInProcess, 40)

		WebUI.click(tabApplicationsInProcess)
		
		KeywordUtil.markPassed("Applications In Process tab was clicked")
	}


	@Keyword
	def clickOnApprovedApplications () {
		KeywordUtil.logInfo("Click on Approved Applications tab")
		
		WebUI.waitForElementVisible(tabApprovedApplications, 40)

		WebUI.click(tabApprovedApplications)
		
		KeywordUtil.markPassed("Approved Applications tab was clicked")
	}


	@Keyword
	def clickOnLicenseDetails () {
		KeywordUtil.logInfo("Click on License Details tab")
		
		WebUI.waitForElementVisible(tabLicenseDetails, 40)

		WebUI.click(tabLicenseDetails)
		
		KeywordUtil.markPassed("License Details tab was clicked")
	}


	@Keyword
	def clickOnIndividualLink () {
		KeywordUtil.logInfo("Click on Individual link")
		
		WebUI.waitForElementVisible(individualLink, 40)

		WebUI.click(individualLink)
		
		KeywordUtil.markPassed("Individual link was clicked")
	}
}

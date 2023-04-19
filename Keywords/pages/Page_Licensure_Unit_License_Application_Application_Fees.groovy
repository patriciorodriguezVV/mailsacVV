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

public class Page_Licensure_Unit_License_Application_Application_Fees {


	private TestObject checkboxYoungWorker					= findTestObject('Page_Licensure Unit License Application/Application Fees/input_If the applicant meets one of the following waiver options, the license fee is waived_Young Worker')
	private TestObject checkboxMilitaryFamily				= findTestObject('Page_Licensure Unit License Application/Application Fees/input_View Uploaded Documents_Military Family')
	private TestObject checkboxLowIncomeIndividual			= findTestObject('Page_Licensure Unit License Application/Application Fees/input_Young Worker_Low Income')
	private TestObject checkboxLowIncomeIndividualAssistance= findTestObject('Page_Licensure Unit License Application/Application Fees/input_Low-income Individual_Low Income Assistance')
	private TestObject checkboxLowIncomeIndividualPoverty	= findTestObject('Page_Licensure Unit License Application/Application Fees/input_Low-income Individual_Low Income Poverty')
	private TestObject buttonUploadMilitaryFeeDocuments		= findTestObject('Page_Licensure Unit License Application/Application Fees/input_btnUploadMilitaryFeeWaiver')
	private TestObject buttonViewUploadedDoc				= findTestObject('Page_Licensure Unit License Application/Application Fees/button_View Uploaded Documents')
	private TestObject buttonNext							= findTestObject('Page_Licensure Unit License Application/Convictions/button_Next')
	private TestObject buttonUploadLowIncomeDocuments		= findTestObject('Page_Licensure Unit License Application/Application Fees/input_btnUploadLowIncomeFeeWaiver')
	private TestObject buttonViewLowIncomeUploadedDoc		= findTestObject('Page_Licensure Unit License Application/Application Fees/button_Low Income View Uploaded Documents')



	/****************************************************
	 * Actions with Checkbox
	 ****************************************************/

	@Keyword
	def verifyMilitaryFamilyIsChecked () {
		KeywordUtil.logInfo("Verify Military Family checkbox is marked")

		WebUI.waitForElementVisible(checkboxMilitaryFamily, 0)

		if (WebUI.verifyElementChecked(checkboxMilitaryFamily, 0, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Military Family checkbox is marked as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Military Family is not marked")
		}
	}

	@Keyword
	def verifyMilitaryFamilyIsNotChecked () {
		KeywordUtil.logInfo("Verify Military Family checkbox is not marked")

		WebUI.waitForElementVisible(checkboxMilitaryFamily, 0)

		if (WebUI.verifyElementNotChecked(checkboxMilitaryFamily, 0, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Military Family checkbox is not marked as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Military Family is marked")
		}
	}


	@Keyword
	def verifyYoungWorkerIsChecked () {
		KeywordUtil.logInfo("Verify Young Worker checkbox is marked")

		WebUI.waitForElementVisible(checkboxYoungWorker, 0)

		if (WebUI.verifyElementChecked(checkboxYoungWorker, 0, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Young Worker checkbox is marked as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Young Worker checkbox is not marked")
		}
	}

	@Keyword
	def verifyLowIncomeIsChecked () {
		KeywordUtil.logInfo("Verify Low Income checkbox is marked")

		WebUI.waitForElementVisible(checkboxLowIncomeIndividual, 0)

		if (WebUI.verifyElementChecked(checkboxLowIncomeIndividual, 0, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Low Income checkbox is marked as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Low Income checkbox is not marked")
		}
	}

	@Keyword
	def checkMilitaryFamily () {
		KeywordUtil.logInfo("Check Military Family checkbox")

		WebUI.waitForElementVisible(checkboxMilitaryFamily, 0)

		WebUI.check(checkboxMilitaryFamily)

		KeywordUtil.markPassed("Military Family checkbox was marked")
	}

	@Keyword
	def checkLowIncomeIndividual () {
		KeywordUtil.logInfo("Check Low Income Individual checkbox")

		WebUI.waitForElementVisible(checkboxLowIncomeIndividual, 0)

		WebUI.check(checkboxLowIncomeIndividual)

		KeywordUtil.markPassed("Low Income Individual checkbox was marked")
	}

	@Keyword
	def checkLowIncomeIndividualPoverty () {
		KeywordUtil.logInfo("Check Low Income Individual Poverty checkbox")

		WebUI.waitForElementVisible(checkboxLowIncomeIndividualPoverty, 0)

		WebUI.check(checkboxLowIncomeIndividualPoverty)

		KeywordUtil.markPassed("Low Income Individual Poverty checkbox was marked")
	}



	/****************************************************
	 * Actions with buttons
	 ****************************************************/

	@Keyword
	def verifyUploadMilitaryFeeDocumentIsVisible () {
		KeywordUtil.logInfo("Verify Upload Document button is visible")


		WebUI.waitForElementVisible(buttonUploadMilitaryFeeDocuments, 0)


		if (WebUI.verifyElementVisible(buttonUploadMilitaryFeeDocuments, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Upload Document button is visible as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Upload Document button is not visible")
		}
	}

	@Keyword
	def verifyUploadLowIncomeDocumentIsVisible () {
		KeywordUtil.logInfo("Verify Upload Document button is visible")

		WebUI.waitForElementVisible(buttonUploadLowIncomeDocuments, 0)

		if (WebUI.verifyElementVisible(buttonUploadLowIncomeDocuments, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Upload Document button is visible as expected")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("Upload Document button is not visible")
		}
	}

	@Keyword
	def verifyViewMilitaryUploadedDocumentsIsVisible () {
		KeywordUtil.logInfo("Verify View Upload Documents button is visible")

		WebUI.waitForElementVisible(buttonViewUploadedDoc, 0)

		if (WebUI.verifyElementVisible(buttonViewUploadedDoc, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("View Upload Documents button is visible as expected")
		} else {
			WebUI.takeFullPageScreenshot()


			KeywordUtil.markFailed("View Upload Documents button is not visible")
		}
	}

	@Keyword
	def verifyViewLowIncomeUploadedDocumentsIsVisible () {
		KeywordUtil.logInfo("Verify View Upload Documents button is visible")

		WebUI.waitForElementVisible(buttonViewLowIncomeUploadedDoc, 0)

		if (WebUI.verifyElementVisible(buttonViewLowIncomeUploadedDoc, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("View Upload Documents button is visible as expected")
		} else {
			WebUI.takeFullPageScreenshot()


			KeywordUtil.markFailed("View Upload Documents button is not visible")
		}
	}

	@Keyword
	def ClickOnUploadMilitaryFeeDocument () {
		KeywordUtil.logInfo("Click on Upload Document button")


		WebUI.waitForElementVisible(buttonUploadMilitaryFeeDocuments, 0)

		WebUI.click(buttonUploadMilitaryFeeDocuments)

		KeywordUtil.markPassed("Upload Document button was clicked")
	}


	@Keyword
	def ClickOnUploadLowIncomeDocument () {
		KeywordUtil.logInfo("Click on Upload Document button")

		WebUI.waitForElementVisible(buttonUploadLowIncomeDocuments, 0)

		WebUI.click(buttonUploadLowIncomeDocuments)


		KeywordUtil.markPassed("Upload Document button was clicked")
	}


	@Keyword
	def ClickOnViewUploadedDocuments () {
		KeywordUtil.logInfo("Click on View Upload Documents button")

		WebUI.waitForElementVisible(buttonViewUploadedDoc, 0)

		WebUI.click(buttonViewUploadedDoc)

		KeywordUtil.markPassed("View Upload Documents button was clicked")
	}

	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button was clicked")
	}
}

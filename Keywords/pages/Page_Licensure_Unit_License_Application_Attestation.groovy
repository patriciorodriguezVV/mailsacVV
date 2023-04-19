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

public class Page_Licensure_Unit_License_Application_Attestation {


	private TestObject checkboxIamCitizen			= findTestObject('Page_Licensure Unit License Application/Attestation/input_I am a Citizen of the US')
	private TestObject fieldPrintName				= findTestObject('Page_Licensure Unit License Application/Attestation/input_Print Name')
	private TestObject checkboxSignature			= findTestObject('Page_Licensure Unit License Application/Attestation/input__Signature')
	private TestObject buttonNext					= findTestObject('Page_Licensure Unit License Application/Attestation/button_Next')
	private TestObject buttonModalDialog			= findTestObject('Modal Dialog Components/button_Next')





	@Keyword
	def checkIAmACitizen () {
		KeywordUtil.logInfo("Check 'I am a citizen of the United States.'")
		
		WebUI.waitForElementVisible(checkboxIamCitizen, 40)

		WebUI.click(checkboxIamCitizen)
		
		KeywordUtil.markPassed("'I am a citizen of the United States.' was checked")
	}


	@Keyword
	def enterPrintName (String printName) {
		KeywordUtil.logInfo("Complete Print Name field")
		
		WebUI.waitForElementVisible(fieldPrintName, 40)

		WebUI.sendKeys(fieldPrintName, printName)
		
		KeywordUtil.markPassed("Print Name was completed: " + printName)
	}


	@Keyword
	def checkSignature () {
		KeywordUtil.logInfo("Check Signature")
		
		WebUI.waitForElementVisible(checkboxSignature, 40)

		WebUI.click(checkboxSignature)
		
		KeywordUtil.markPassed("Signature was checked")
	}


	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next Button")
		
		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)
		
		KeywordUtil.markPassed("Next button was clicked")
	}

	@Keyword
	def clickOnNextButtonModalDialog () {
		KeywordUtil.logInfo("Click on Next Button from Modal Dialog")
		
		WebUI.waitForElementVisible(buttonModalDialog, 40)

		WebUI.click(buttonModalDialog)
		
		KeywordUtil.markPassed("Next button from Modal Dialog was clicked")
	}
}

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

public class Page_Licensure_Unit_License_Application_Pay {


	private TestObject buttonPayNow						= findTestObject('Page_Licensure Unit License Application/Pay/button_Pay Now')
	private TestObject buttonSubmit						= findTestObject('Page_Licensure Unit License Application/Pay/button_Submit')





	@Keyword
	def clickOnPayNowBtn () {
		KeywordUtil.logInfo("Click on Pay Now button")

		WebUI.waitForElementVisible(buttonPayNow, 40)

		WebUI.click(buttonPayNow)

		KeywordUtil.markPassed("Pay Now button was clicked")
	}


	@Keyword
	def verifyPayNowBtnIsVisible () {
		KeywordUtil.logInfo("Verify Pay Now button is visible")

		if (WebUI.verifyElementVisible(buttonPayNow, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Pay Now button is visible")
			
			return true
		} else {
			KeywordUtil.markWarning("Pay Now button is not visible")
			
			return false
		}
	}


	@Keyword
	def verifyPayNowBtnIsNotVisible () {
		KeywordUtil.logInfo("Verify Pay Now button was clicked")
		
		WebUI.waitForElementVisible(buttonPayNow, 40)

		if(!WebUI.verifyElementNotVisible(buttonPayNow, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markFailed("Failure: The button 'Pay Now' was present.")

			WebUI.takeFullPageScreenshot()
		} else {
			KeywordUtil.markPassed("Pay Now button is visible. It should not.")
		}
	}

	@Keyword
	def clickOnSubmitBtn () {
		KeywordUtil.logInfo("Click on Submit button")
		
		WebUI.waitForElementVisible(buttonSubmit, 40)

		WebUI.click(buttonSubmit)
		
		KeywordUtil.markPassed("Submit button is visible")
	}
}

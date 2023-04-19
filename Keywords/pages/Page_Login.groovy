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

public class Page_Login {


	private TestObject inputUserName							= findTestObject('Page_Login_VisualVault/input_UserName')
	private TestObject inputPassword							= findTestObject('Page_Login_VisualVault/input_Password')
	private TestObject LoginButton								= findTestObject('Page_Login_VisualVault/span_LoginButton')



	@Keyword
	def login (String username, String pass) {
		KeywordUtil.logInfo("Complete User Name and Password, and click on Login button")

		WebUI.sendKeys(inputUserName, username)

		WebUI.setEncryptedText(inputPassword, pass)

		WebUI.click(LoginButton)

		KeywordUtil.markPassed("Login process has been completed")
	}


	@Keyword
	def enterUserName (String username) {
		KeywordUtil.logInfo("Complete User Name field")

		WebUI.waitForElementVisible(inputUserName, 40)

		WebUI.sendKeys(inputUserName, username)

		KeywordUtil.markPassed("User Name was completed: " + username)
	}


	@Keyword
	def enterPassword (String pass) {
		KeywordUtil.logInfo("Complete User Name field")

		WebUI.waitForElementVisible(inputPassword, 40)

		WebUI.sendKeys(inputPassword, pass)

		KeywordUtil.markPassed("Password was completed")
	}


	@Keyword
	def clickLoginBtn() {
		KeywordUtil.logInfo("Click on Login button")

		WebUI.click(LoginButton)

		KeywordUtil.markPassed("Login button was clicked")
	}
}

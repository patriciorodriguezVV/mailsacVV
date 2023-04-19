import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import generic.generic_functions as Generic_functions
import org.openqa.selenium.WebDriver as WebDriver

// Numbers variable
String nums = '1234567890'

// Set random appeal code variable
String randomAppealCode = Generic_functions.randomString(nums, 6)

// Open Browser and go to Appeal form public link
WebUI.openBrowser(GlobalVariable.G_Appeal_Link)

// Enter incorrect appeal code
CustomKeywords.'pages.Page_Licensure_Unit_Appeals.enterAppealCode'(randomAppealCode)

// Click on Next
CustomKeywords.'pages.Page_Licensure_Unit_Appeals.clickOnNextBtn'()

// Verify if modal text contains an error message indicating denial code is invalid
String errorTextModalDialog = String.format("An error was encountered. The denial code of %s was not found in the system or is older than 50 days. Please modify your request to continue, or contact a system administrator if this problem occurs.", randomAppealCode);

String titleModalDialog = 'Start Appeal'

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleModalDialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(errorTextModalDialog)

//Close browser
WebUI.closeBrowser()
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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


// Open Browser
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)


// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_Admin_Username, GlobalVariable.G_Admin_Pass)


// Go to User Administration section
WebUI.navigateToUrl(GlobalVariable.G_UserAdministration_Link)


// Click on SearchMainButton
CustomKeywords.'pages.Page_User_Administration.clickOnSearchMainButton'()


// Enter Search Criteria
CustomKeywords.'pages.Page_User_Administration.enterSearchCriteria'(GlobalVariable.G_Applicant_Email)


// Click on Search Button
CustomKeywords.'pages.Page_User_Administration.clickOnSearchButton'()



// Verify Unique User was found
CustomKeywords.'pages.Page_User_Administration.verifyUniqueRecordOnList'()


// Close Browser
WebUI.closeBrowser()

//Testeando los commits con GitHub
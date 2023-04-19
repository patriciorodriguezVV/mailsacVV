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


// Calls Register Individual Record tc before verification process
WebUI.callTestCase(findTestCase('Test Cases/Licensure Unit User Registration/Registration Successful - US Citizen - With SSN'), [:], FailureHandling.STOP_ON_FAILURE)

// Open Browser
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_LU_Staff_UserName, GlobalVariable.G_LU_Staff_Pass)

// Go to Manage/Individual/IndividualsAll section
WebUI.navigateToUrl(GlobalVariable.G_IndividualsAll_Link)

// Click on Search Filter Btn
CustomKeywords.'pages.Page_Home_Admin_Manage_Individual_IndividualsAll.clickOnSearchFilterBtn'()

// Enter Search Criteria
CustomKeywords.'pages.Page_Home_Admin_Manage_Individual_IndividualsAll.enterSearchCriteria'(GlobalVariable.G_Applicant_FirstName)

// Click on Search Btn
CustomKeywords.'pages.Page_Home_Admin_Manage_Individual_IndividualsAll.clickOnSearchBtn'()

// Verify Individual Record was found
CustomKeywords.'pages.Page_Home_Admin_Manage_Individual_IndividualsAll.verifyIndividualRecordCreated'()

// Close Browser
WebUI.closeBrowser()
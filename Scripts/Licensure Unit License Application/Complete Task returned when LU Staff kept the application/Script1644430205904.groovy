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
import generic.common_functions as common_functions



// Verify Parents TC have not failed ---
// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Apply for a License - Physical Therapist - Reciprocity', 'Test Cases/Licensure Unit License Application/Mark License Deficient and keep the Application']
// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)

String statusExpected = 'Waiting Approval'

// Go to Login Page
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_Applicant_Email, GlobalVariable.G_ApplicantPass)

CustomKeywords.'pages.Page_Applicant_Home.clickOnOpenTask1'()

// Move to Next Window
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCompleteTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCompleteBtn'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab)



CustomKeywords.'pages.Page_Applicant_Home.clickOnOpenTask2'()

// Move to Next Window
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

// On this keyword License is completed and Status is verfied
CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCompleteTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCompleteBtn'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab)



// Close browser
WebUI.closeBrowser()

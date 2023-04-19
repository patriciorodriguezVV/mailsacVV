/******************************
 Import classes and libs needed
*******************************/

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
import generic.generic_functions as Generic_functions
import generic.common_functions as Common_functions
import pages.Page_Login as loginPage


/*********************************
 Verify Parents TC have not failed
**********************************/

// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Apply for a License - Physical Therapist - Reciprocity']

// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)


/**********************
 Configurable Variables
***********************/

int currentTab
String statusExpected = 'Returned'
String user = GlobalVariable.G_Applicant_FirstName  + ' ' + GlobalVariable.G_Applicant_LastName
String licenseType = 'Physical Therapist'


// Task names
String task1Name = 'Citizenship Documentation for '	+ user + ' and license ' + licenseType
String task2Name = 'Transcripts for '				+ user + ' and license ' + licenseType


/****************
 Steps to execute
*****************/

// Go to Login Page
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)


// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_LU_Staff_UserName, GlobalVariable.G_LU_Staff_Pass)


// Go to Applications in Progress
CustomKeywords.'pages.Page_Home_Admin.clickOnApplicationsInProcess'()


// Search Applicant by First Name
CustomKeywords.'pages.Page_Home_Admin_ApplicationsInProgress.clickOnSearchRecordButton'()

CustomKeywords.'pages.Page_Home_Admin_ApplicationsInProgress.selectFirstNameForSearch'()

CustomKeywords.'pages.Page_Home_Admin_ApplicationsInProgress.enterSearchCriteria'(GlobalVariable.G_Applicant_FirstName)

CustomKeywords.'pages.Page_Home_Admin_ApplicationsInProgress.clickOnSearchButton'()


// Click on Review Link on the License Application
CustomKeywords.'pages.Page_Home_Admin_ApplicationsInProgress.clickOnReviewLink'()


// Move to License Application tab opened
currentTab = WebUI.getWindowIndex()
WebUI.switchToWindowIndex(currentTab + 1)


// Verify the License Application Opened is the correct one
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.verifyLicenseApplicationOpened'(GlobalVariable.G_Applicant_FirstName, GlobalVariable.G_Applicant_LastName)


// Go to Checklist tab of the Form
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnChecklistTab'()


// Request More Info for Task Task "Citizenship Documentation"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task1', task1Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnRequestMoreInfoButton'()

 CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab + 1)


// Request More Info for Task "Transcripts"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task3', task2Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnRequestMoreInfoButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab + 1)


// Go to Manage Tab
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnManageTab'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application.setApplicationDeficient'()

CustomKeywords.'pages.ModalDialog.clickOnKeepApplicationBtn'()

CustomKeywords.'pages.ModalDialog.clickOnCloseButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License.verifyStatus'('Waiting Documentation, Primary Source')


// Close License Application
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Manage.clickOnCancelAndClose'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab)


// Close browser
WebUI.closeBrowser()
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
import internal.GlobalVariable

import org.apache.ivy.core.module.descriptor.License
import org.openqa.selenium.Keys as Keys
import generic.generic_functions as Generic_functions
import generic.common_functions as Common_functions
import pages.Page_Login as loginPage


/*********************************
 Verify Parents TC have not failed
**********************************/

// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Apply for a License - Physical Therapist']

// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)


/**********************
 Configurable Variables
***********************/

int currentTab
String statusExpected = 'Approved'
String user = GlobalVariable.G_Applicant_FirstName  + ' ' + GlobalVariable.G_Applicant_LastName
String licenseType = 'Physical Therapist'


// Task names
String task1Name = 'Citizenship Documentation for ' + user + ' and license ' + licenseType
String task2Name = 'NDEN Check for '                + user + ' and license ' + licenseType
String task3Name = 'Transcripts for '               + user + ' and license ' + licenseType
String task4Name = 'Minimum Education for '         + user + ' and license ' + licenseType
String task5Name = 'Exam Documentation for '        + user + ' and license ' + licenseType
String task6Name = 'Fees Paid for '                 + user + ' and license ' + licenseType
String task7Name = 'Fingerprints for '              + user + ' and license ' + licenseType
String task8Name = 'Unique Identifier for '         + user + ' and license ' + licenseType


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


// Approve Task "Citizenship Documentation"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task1', task1Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

Thread.sleep(1000)

WebUI.switchToWindowIndex(currentTab + 1)


// Approve Task "NDEN"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task2', task2Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

Thread.sleep(1000)

WebUI.switchToWindowIndex(currentTab + 1)


// Approve Task "Transcripts"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task3', task3Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

Thread.sleep(1000)

WebUI.switchToWindowIndex(currentTab + 1)


// Approve Task "Minimum Education"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task4', task4Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

Thread.sleep(1000)

WebUI.switchToWindowIndex(currentTab + 1)


// Approve Task "Exam Documentation"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task5', task5Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

Thread.sleep(1000)

WebUI.switchToWindowIndex(currentTab + 1)


// Approve Task "Fees Paid"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task6', task6Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

Thread.sleep(1000)

WebUI.switchToWindowIndex(currentTab + 1)


// Approve Task "Fingerprints"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task7', task7Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

Thread.sleep(1000)

WebUI.switchToWindowIndex(currentTab + 1)


// Approve Task "Unique Identifier"
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist.clickOnTask'('Task8', task8Name)

WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveTab'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnApproveButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.verifyStatus'(statusExpected)

CustomKeywords.'pages.Page_Licensure_Unit_Checklist_Task.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

Thread.sleep(1000)

WebUI.switchToWindowIndex(currentTab + 1)


// Close License Application
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Manage.clickOnCancelAndClose'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab)


// Close browser
WebUI.closeBrowser()
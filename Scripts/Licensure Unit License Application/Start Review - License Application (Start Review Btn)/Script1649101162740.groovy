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


// Verify Parents TC have not failed ---
// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Apply for a License - Physical Therapist', 'Test Cases/Licensure Unit License Application/Apply for a License - Physical Therapist - Reciprocity', 'Test Cases/Licensure Unit License Application/Return License Application as LU Processor', 'Test Cases/Licensure Unit License Application/Complete Task returned and resubmit License Application']
// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)



int currentTab = 0
String ExpStatusBeforeStartReview = 'Submitted'
String ExpStatus = 'Pending'
String modalDialog1Title = 'Submitted Application'
String modalDialog1Body = 'You are opening a license application that was recently submitted. Are you opening this application to start your official review of the application? If you are, select OK so that we can update the status of the application to pending. This will help the applicant know the status of the application when they review it online. If you are not opening this application to review it, select cancel.'
String modalDialog2Title = 'Start Review'
String modalDialog2Body = "Starting a Review will change the status of this application to 'Pending'. Clicking 'Ok' will confirm this action. If you do not want to continue, click 'Return to Form'."



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


// Move to Next Window
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

System.sleep(3000)

CustomKeywords.'pages.ModalDialog.verifyTitle'(modalDialog1Title)

CustomKeywords.'pages.ModalDialog.verifyBody'(modalDialog1Body)

CustomKeywords.'pages.ModalDialog.clickOnCloseButton'()


 
// Verify the License Application Opened is the correct one
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.verifyLicenseApplicationOpened'(GlobalVariable.G_Applicant_FirstName, GlobalVariable.G_Applicant_LastName)


// Go to Manage Tab of the Form
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnManageTab'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Manage.verifyStatus'(ExpStatusBeforeStartReview)

// Click on "Start Review" and complete the process
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Manage.clickOnStartReview'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(modalDialog2Title)

CustomKeywords.'pages.ModalDialog.verifyBody'(modalDialog2Body)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Manage.verifyStatus'(ExpStatus)



// Close License Application
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Manage.clickOnCancelAndClose'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab)


//Close Browser
WebUI.closeBrowser()

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
import com.kms.katalon.core.configuration.RunConfiguration



// Verify Parents TC have not failed ---
// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Apply for a License - Physical Therapist', 'Test Cases/Licensure Unit License Application/Return License Application as LU Processor']
// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)


String messageTitle = 'Application Re-Submitted'
String messageBody = "You have successfully re-submitted your license application. You can review submitted application in read-only mode by navigating through the tabs on LICENSE APPLICATION. If the Licensure Unit needs additional information, you will receive notification to add or update your information. You can now go to the home page and check the status of your application under 'My Applications In Process' by clicking on the 'My Home' tab on the left side of the portal"
String pdfMessageTitle = 'PDF Download'
String pdfMessageBody = 'A PDF document has been created that represents your complete application. Select Download PDF to download the document for your records. If you do not download the document now you can return to the attestation section of your license application at any time to download the PDF. Select OK to continue.'
String expectedStatus = 'Submitted'
String projectPath = RunConfiguration.getProjectDir()
String emtpyDoc2path = projectPath + '/Documents/Document Empty 2.txt'




// Go to Login Page
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_Applicant_Email, GlobalVariable.G_ApplicantPass)

// Open Application
CustomKeywords.'pages.Page_Applicant_Home.clickOnOpenApplication'()

// Move to Next Window
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

// Go Check list Management
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnChecklistManagementTab'()



// Complete first task returned (Citizen Documentation)
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnUploadButton'()

common_functions.uploadFilePath(emtpyDoc2path)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnNextButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()



// Complete second task returned
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnAcknowledgeButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()

CustomKeywords.'pages.ModalDialog.clickOnCloseButton'()



// Resubmit License Application
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnSubmitBtn'()

System.sleep(20000)

CustomKeywords.'pages.ModalDialog.verifyTitle'(pdfMessageTitle)

CustomKeywords.'pages.ModalDialog.verifyBody'(pdfMessageBody)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

CustomKeywords.'pages.ModalDialog.verifyTitle'(messageTitle)

CustomKeywords.'pages.ModalDialog.verifyBody'(messageBody)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab)

System.sleep(5000)

// Open Application
CustomKeywords.'pages.Page_Applicant_Home.clickOnOpenApplication'()

WebUI.switchToWindowIndex(currentTab + 1)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application.verifyStatus'(expectedStatus)

System.sleep(2000)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnCloseBtn'()

System.sleep(5000)

WebUI.switchToWindowIndex(currentTab)



// Close browser
WebUI.closeBrowser()

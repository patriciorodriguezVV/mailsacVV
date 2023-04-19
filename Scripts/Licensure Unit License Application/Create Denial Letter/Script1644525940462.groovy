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
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Apply for a License - Physical Therapist - Reciprocity']
// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)



String licenseBoard = 'PR TESTING'
String saveTitleMessage = 'Records Related'
String saveBodyMessage = 'This form has been related to relevant records, and the form has been saved.'
String sendEmailTitleMsg = 'Send Email'
String sendEmailBodyMsg = 'Do you really want to send this letter as an email?'



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
int currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

// Verify the License Application Opened is the correct one
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.verifyLicenseApplicationOpened'(GlobalVariable.G_Applicant_FirstName, GlobalVariable.G_Applicant_LastName)


CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnManageTab'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Manage.clickOnCreateLetter'()

WebUI.switchToWindowIndex(currentTab + 2)

// Select Physical Therapist from the dropdown License Type
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.selectPhysicalTherapistOnLicenseType'()

// Select Denial Notification - Initial License
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.selectDenialNotificationtOnTemplate'()

System.sleep(1000)



// Click on Marge LANCE Data and click Ok on the Modal Dialog displayed
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.clickOnMergeLanceDataBtn'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

// Verify error message is not displayed because Not all tokens could be replaced
CustomKeywords.'pages.ModalDialog.verifyTokensNotFoundMsg'()

// Verify Tokens were replaced correctly
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.verifyTokensReplacedForDenial'()



// Click on Set Dynamic Values and enter the corresponding value
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.clickOnSetDynamicValuesBtn'()

CustomKeywords.'pages.ModalDialog.enterLicenseBoard'(licenseBoard)

CustomKeywords.'pages.ModalDialog.clickOnMergeValue'()

// Verify that the Dynamic Variable was replaced correctly
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.verifyDynamicValuesReplacedForDenial'()



// Save Form
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.clickOnSaveBtn'()

// Verify Save Message is correct
CustomKeywords.'pages.ModalDialog.verifyTitle'(saveTitleMessage)

CustomKeywords.'pages.ModalDialog.verifyBody'(saveBodyMessage)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()



// Verify that buttons Preview/Print and Send Email are visible
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.verifyBtnsPrintAndEmailAreVisible'()



// Obtain PDF-Email content
String pdf = CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.getPdfContent'()

System.out.println(pdf)



// Click on Preview/Print and verify tab is opened with popup Print
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.clickOnPreviewPrintBtn'()

WebUI.switchToWindowIndex(currentTab + 4)

// Verify that element from print view is present
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.verifyPrintTabIsVisible'()

WebUI.closeWindowIndex(currentTab + 3)

WebUI.switchToWindowIndex(currentTab + 2)



// Click on Send Email button
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.clickOnSendEmailBtn'()

// Verify Send Email Message is correct
CustomKeywords.'pages.ModalDialog.verifyTitle'(sendEmailTitleMsg)

CustomKeywords.'pages.ModalDialog.verifyBody'(sendEmailBodyMsg)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

WebUI.switchToWindowIndex(currentTab + 3)

// Verify "Licensure Unit Send Communication" is opened correctly 
CustomKeywords.'pages.Page_Licensure_Unit_Send_Communication.verifyLabelForm'()

CustomKeywords.'pages.Page_Licensure_Unit_Send_Communication.verifyEmailRecipients'(GlobalVariable.G_Applicant_Email)

// Close Email tab
WebUI.closeWindowIndex(currentTab + 3)

WebUI.switchToWindowIndex(currentTab + 2)



// Close All the forms opened and Browser
CustomKeywords.'pages.Page_Licensure_Unit_Letter_Management.clickOnCancelAndContinueBtn'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

WebUI.switchToWindowIndex(currentTab + 1)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Manage.clickOnCancelAndClose'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

WebUI.switchToWindowIndex(currentTab)

// Close Browser
WebUI.closeBrowser()




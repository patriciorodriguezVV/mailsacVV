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
import generic.generic_functions as GenericFunctions


// Verify Parents TC have not failed ---
// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Issue License']
// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)



GenericFunctions genericFunctions = new GenericFunctions()

// Setting the variables needed on the test case.
String licenseType = 'Physical Therapist'
String summaryOfEvent = 'Summary Event PR Test'
String eventType = 'Facility'
String estimatedDateOfEvent = genericFunctions.getTodayDatePlusDays(5)
String effectiveDate = genericFunctions.getTodayDate()
String dateEnded = genericFunctions.getTodayDatePlusDays(15)
String desriptionOfEvent = 'Description of Event PR Test'
String docketNum = '13245'
String caseNum = '12345'
String titleMessage = 'Record Saved'
String bodyMessage = 'The record has been saved. The window will now close.'



// Go to Login Page
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_LM_Staff_UserName, GlobalVariable.G_LM_Staff_Pass)


// Go to Applications in Progress
CustomKeywords.'pages.Page_Home_Admin.clickOnLicenseDetails'()

// Search Applicant by First Name
CustomKeywords.'pages.Page_Home_Admin_LicenseDetails.clickOnMainSearchButton'()

CustomKeywords.'pages.Page_Home_Admin_LicenseDetails.selectFirstNameForSearch'()

CustomKeywords.'pages.Page_Home_Admin_LicenseDetails.enterSearchCriteria'(GlobalVariable.G_Applicant_FirstName)

CustomKeywords.'pages.Page_Home_Admin_LicenseDetails.clickOnSearchButton'()

// Click on Review Link on the License Application
CustomKeywords.'pages.Page_Home_Admin_LicenseDetails.clickOnOpenLink'()



// Move to Next Window
int currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)



// Verify License Information
CustomKeywords.'pages.Page_Licensure_Unit_License.verifyLicenseInformation'(GlobalVariable.G_Applicant_FirstName, GlobalVariable.G_Applicant_LastName, licenseType)

// Go to Manage tab
CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnDischiplineTab'()

CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnDisciplinaryButton'()

WebUI.switchToWindowIndex(currentTab + 2)



// Complete informmation of Licensure Unit Disciplinary or Licensure Event

CustomKeywords.'pages.Page_Licensure_Unit_Disciplinary_or_Licensure_Event.selectEventType'(eventType)

CustomKeywords.'pages.Page_Licensure_Unit_Disciplinary_or_Licensure_Event.completeEffectiveDate'(effectiveDate)

CustomKeywords.'pages.Page_Licensure_Unit_Disciplinary_or_Licensure_Event.completeDateEnded'(dateEnded)

CustomKeywords.'pages.Page_Licensure_Unit_Disciplinary_or_Licensure_Event.completeDescriptionOfEvent'(desriptionOfEvent)



// Go back to License Form and verify that Dischipline has not been added yet
WebUI.switchToWindowIndex(currentTab + 1)

CustomKeywords.'pages.Page_Licensure_Unit_License.verifyDisciplineIsNotPresent'()



// Go to Licensure Unit Disciplinary or Licensure Event and save it
WebUI.switchToWindowIndex(currentTab + 2)

CustomKeywords.'pages.Page_Licensure_Unit_Disciplinary_or_Licensure_Event.clickOnSaveAndContinueBtn'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleMessage)

CustomKeywords.'pages.ModalDialog.verifyBody'(bodyMessage)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()



// Go back to License Form and verify that Dischipline has not been added yet
WebUI.switchToWindowIndex(currentTab + 1)

CustomKeywords.'pages.Page_Licensure_Unit_License.verifyDisciplineIsPresent'()



// Close License Form and browser

CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnCancelAndContinueButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(3000)

WebUI.closeBrowser()


 

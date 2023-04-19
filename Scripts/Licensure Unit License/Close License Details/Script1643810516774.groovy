import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.logging.Handler
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
import ws.GetToken as GetToken
import generic.generic_functions as GenericFunctions
import ws.GetLicenseDetailsStatus as GetLicenseDetailsStatus
import com.kms.katalon.core.testobject.ResponseObject


GlobalVariable.G_Applicant_Email = 'pruebas.onetree+Applicanthldxj@gmail.com'
GlobalVariable.G_Applicant_FirstName = 'PRyrurv'
GlobalVariable.G_Applicant_LastName = 'Automationoiiod'

int currentTab
String licenseType = 'Physical Therapist'


// Go to Login Page
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_Admin_Username, GlobalVariable.G_Admin_Pass)


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
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

// I need to wait until this element Close Button is clickable, so Tab Title is updated correctly
System.sleep(2000)


// Verify License Information
CustomKeywords.'pages.Page_Licensure_Unit_License.verifyLicenseInformation'(GlobalVariable.G_Applicant_FirstName, GlobalVariable.G_Applicant_LastName, licenseType)


// Save tab title
String tabTitleExpected = WebUI.getWindowTitle(FailureHandling.OPTIONAL)

System.out.println('\nCurrent Tab:' + tabTitleExpected + '\n')



// Click on Close form
CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.verifyTitle'('Cancel and Close')

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

// Get current tab title. If tab was closed, it should be null
String tabTitle = WebUI.getWindowTitle(FailureHandling.OPTIONAL)

System.out.println('\nCurrent Tab:' + tabTitle + '\n')

// If the tab was closed as expected, the tab title should not match
WebUI.verifyNotMatch(tabTitle, tabTitleExpected, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()





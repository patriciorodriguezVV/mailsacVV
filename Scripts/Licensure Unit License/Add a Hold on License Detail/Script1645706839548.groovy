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


GlobalVariable.G_Applicant_Email = 'pruebas.onetree+Applicanthldxj@gmail.com'
GlobalVariable.G_Applicant_FirstName = 'PRyrurv'
GlobalVariable.G_Applicant_LastName = 'Automationoiiod'

// Set variables
String licenseType = 'Physical Therapist'
String licenseStatus = 'On Hold'


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
CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnManageTab'()

CustomKeywords.'pages.Page_Licensure_Unit_License.selectHoldReason'()

CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnPlaceOnHoldBtn'()

CustomKeywords.'pages.Page_Licensure_Unit_License.verifyStatus'(licenseStatus)


// Close License Form and Open it again to verify message On Hold is displayed
CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnCancelAndContinueButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

WebUI.switchToWindowIndex(currentTab)

System.sleep(2000)

WebUI.closeBrowser()
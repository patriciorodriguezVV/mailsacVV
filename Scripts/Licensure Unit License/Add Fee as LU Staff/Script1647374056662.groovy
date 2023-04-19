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



// Verify Parents TC have not failed ---
// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Issue License']
// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)




GetToken getTokenReq = new GetToken()
int currentTab
String feeAmount = 50
String allowPayments = 'No'
String licenseType = 'Physical Therapist'
String titleModalDialog = 'Record Saved'
String bodyModalDialog = "The record has been saved."
String status = 'Unpaid'
String feeDescription = 'Certs, Dups, Inactive'
String totalPaid = '$0.00'
String totalDue = '$50.00'
String feeId



// Go to Login Page
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_LU_Staff_UserName, GlobalVariable.G_LU_Staff_Pass)


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



// Verify License Information
CustomKeywords.'pages.Page_Licensure_Unit_License.verifyLicenseInformation'(GlobalVariable.G_Applicant_FirstName, GlobalVariable.G_Applicant_LastName, licenseType)

// Get License Id form the form
String licenseId = CustomKeywords.'pages.Page_Licensure_Unit_License.obtainLicenseId'()

System.out.println('\nLicense Id: ' + licenseId + '\n')

// Go to Manage tab
CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnManageTab'()

// Click on Add Fee button
CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnAddFee'()

WebUI.switchToWindowIndex(currentTab + 2)



// Complete basic information on the page
CustomKeywords.'pages.Page_Licensure_Unit_Fee.selectPhysicalTherapistOnLicenseName'()

CustomKeywords.'pages.Page_Licensure_Unit_Fee.selectLapFeeOnFeeType'()

CustomKeywords.'pages.Page_Licensure_Unit_Fee.completeFeeAmount'(feeAmount)

CustomKeywords.'pages.Page_Licensure_Unit_Fee.selectAllowPayments'(allowPayments)



// Click on Save button and verify Repeating Raw Control
CustomKeywords.'pages.Page_Licensure_Unit_Fee.clickOnSave'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleModalDialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(bodyModalDialog)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.Page_Licensure_Unit_Fee.verifyRepeatingRawControlInfo'(totalDue, totalPaid, feeDescription, status)



// Get Fee Id
feeId = CustomKeywords.'pages.Page_Licensure_Unit_Fee.getRecordId'()



// Close the Licensure Unit Fee Form
CustomKeywords.'pages.Page_Licensure_Unit_Fee.clickOnCancelAndContinue'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab + 1)



// Close Licensure Unit License Form
CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnCancelAndContinueButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab)

WebUI.closeBrowser()



// Verify Fee is displayed on the Applicant Shopping Cart	---



// Go to Login Page
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_Applicant_Email, GlobalVariable.G_ApplicantPass)

System.sleep(10000)

CustomKeywords.'pages.Page_Applicant_Home.clickOnViewYourFinances'()

// Move to Next Window
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

// Click on Pay Outstading Fees link
CustomKeywords.'pages.Page_Applicant_MyFinances.clickOnPayOutstandingFees'()

// Move to Next Window
WebUI.switchToWindowIndex(currentTab + 2)

System.sleep(10000)


// Click on Refresh button to make sure Fee is displayed on the RRC
CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.clickOnRefreshbutton'()

// Verify Information of Fee displayed on RRC
CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.verifyOpt1OnRRC'(feeDescription, totalDue, totalDue, feeId)

// Close the Licensure Unit Fee Form
CustomKeywords.'pages.Page_Licensure_Unit_Fee.clickOnCancelAndContinue'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab + 1)



// Close browser
WebUI.closeBrowser()



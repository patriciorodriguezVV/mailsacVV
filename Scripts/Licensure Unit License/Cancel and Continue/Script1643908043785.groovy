import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.logging.Handler
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.keyword.builtin.VerifyMatchKeyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import ws.GetToken as GetToken
import ws.GetLicenseDetails as GetLicenseDetails
import generic.generic_functions as GenericFunctions
import com.kms.katalon.core.testobject.ResponseObject


GlobalVariable.G_Applicant_Email = 'pruebas.onetree+Applicanthldxj@gmail.com'
GlobalVariable.G_Applicant_FirstName = 'PRyrurv'
GlobalVariable.G_Applicant_LastName = 'Automationoiiod'

GetToken getTokenReq = new GetToken()
int currentTab
GenericFunctions genericFunctions = new GenericFunctions()
String today
String issueDate
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

// Get current Issue Date
String currentIssueDate = CustomKeywords.'pages.Page_Licensure_Unit_License.obtainIssueDate'()


// Get today date less 5 days
int dayLess = -5

issueDate = genericFunctions.getTodayDatePlusDays(dayLess)


// Enter new date on Issue Date
CustomKeywords.'pages.Page_Licensure_Unit_License.completeIssueDate'(issueDate)




// Close the License Details tab
CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnCancelAndContinueButton'()

CustomKeywords.'pages.ModalDialog.verifyTitle'('Cancel and Close')

CustomKeywords.'pages.ModalDialog.verifyBody'('Are you sure you would like to close this form? Any unsaved changes will be lost.')

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab)



// Get token
ResponseObject getTokenResp = getTokenReq.getToken1()

CustomKeywords.'api_Connection.TokenResp.getToken'(getTokenResp)

if(getTokenReq.getStatusCode(getTokenResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getTokenResp))
}


// Verify that issue date was not saved
GetLicenseDetails getLicenseDetailsReq = new GetLicenseDetails()

ResponseObject getLicenseDetailsResp = getLicenseDetailsReq.getLicenseDetailsByApplicantFirstName(GlobalVariable.G_Applicant_FirstName)

if(getLicenseDetailsReq.getStatusCode(getLicenseDetailsResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getLicenseDetailsResp))
}

String iDateAftClose = CustomKeywords.'api_Connection.LicenseDetailsResp.getIssueDate'(getLicenseDetailsResp)



// Verify that the issue date was not modified 
WebUI.verifyMatch(currentIssueDate, iDateAftClose, false, FailureHandling.CONTINUE_ON_FAILURE)


WebUI.closeBrowser()





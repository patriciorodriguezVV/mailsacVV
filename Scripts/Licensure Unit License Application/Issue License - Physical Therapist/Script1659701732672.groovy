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
import com.kms.katalon.core.testobject.ResponseObject
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import ws.GetLicenseLookup as GetLicenseLookup
import ws.GetLicenseDetails as GetLicenseDetails
import ws.GetLicenseDetailsStatus as GetLicenseDetailsStatus
import ws.GetToken as GetToken
import com.kms.katalon.core.util.KeywordUtil





// Verify Parents TC have not failed ---
// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Approve License Application']
// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)



int currentTab = 0
String licenseName = 'Physical+Therapist'
GetToken getTokenReq = new GetToken()
String statusReason = 'License Issued'




// Go to Login Page
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_LU_Staff_UserName, GlobalVariable.G_LU_Staff_Pass)


// Go to Applications Approved
CustomKeywords.'pages.Page_Home_Admin.clickOnApprovedApplications'()



// Search Applicant by First Name
CustomKeywords.'pages.Page_Home_Admin_ApprovedApplications.clickOnSearchRecordButton'()

CustomKeywords.'pages.Page_Home_Admin_ApprovedApplications.selectFirstNameForSearch'()

CustomKeywords.'pages.Page_Home_Admin_ApprovedApplications.enterSearchCriteria'(GlobalVariable.G_Applicant_FirstName)

CustomKeywords.'pages.Page_Home_Admin_ApprovedApplications.clickOnSearchButton'()



// Click on Review Link on the License Application
CustomKeywords.'pages.Page_Home_Admin_ApprovedApplications.clickOnOpenLink'()


// Move to Next Window
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)



// Verify the License Application Opened is the correct one
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.verifyLicenseApplicationOpened'(GlobalVariable.G_Applicant_FirstName, GlobalVariable.G_Applicant_LastName)


// Go to Manage Tab of the Form
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnManageTab'()


// Click on "Issue License" and complete the process
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.IssueLicense'()



// Verify License Details Status was created correctly
ResponseObject getTokenResp = getTokenReq.getToken1()

CustomKeywords.'api_Connection.TokenResp.getToken'(getTokenResp)

if(getTokenReq.getStatusCode(getTokenResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getTokenResp))
}



// Get Object for License Detail
GetLicenseDetails getLicenseDetailsReq = new GetLicenseDetails()

ResponseObject getLicenseDetailsResp = getLicenseDetailsReq.getLicenseDetailsByApplicantFirstName(GlobalVariable.G_Applicant_FirstName)

if(getLicenseDetailsReq.getStatusCode(getLicenseDetailsResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getLicenseDetailsResp))
}



// Get issue date from License Detail form
String issueDate = CustomKeywords.'api_Connection.LicenseDetailsResp.getIssueDate'(getLicenseDetailsResp)



// Get License Lookup Information
GetLicenseLookup getLicenseLookupReq = new GetLicenseLookup()

ResponseObject getLicenseLookupResp = getLicenseLookupReq.getLicenseLookupByLicenseName(licenseName)

if(getLicenseDetailsReq.getStatusCode(getLicenseLookupResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getLicenseLookupResp))
}

System.out.println(getLicenseLookupReq.getResponseText(getLicenseLookupResp))

// Calculate expiration date based on the issue date of the License Details and License Lookup information
String expirationDate = CustomKeywords.'api_Connection.LicenseLookupResp.calculateExpirationDate'(getLicenseLookupResp, issueDate)



// Verify Information of the License Detail created
CustomKeywords.'api_Connection.LicenseDetailsResp.verifyIssueDate'(getLicenseDetailsResp)

CustomKeywords.'api_Connection.LicenseDetailsResp.verifyEffectiveDate'(getLicenseDetailsResp)

CustomKeywords.'api_Connection.LicenseDetailsResp.verifyExpirationDate'(getLicenseDetailsResp, expirationDate)

// Get License ID from License Details Resp
String licenseId = CustomKeywords.'api_Connection.LicenseDetailsResp.getLicenseId'(getLicenseDetailsResp)



// Look for License Detail Status by License Id
GetLicenseDetailsStatus getLicenseDetailsStatusReq = new GetLicenseDetailsStatus()

ResponseObject getLicenseDetailsStatusResp = getLicenseDetailsStatusReq.getLicenseDetailsStatusByLicenseId(licenseId)

// Verify License Details Status information
CustomKeywords.'api_Connection.LicenseDetailsStatusResp.verifyOriginalEffectivetDate'(getLicenseDetailsStatusResp, issueDate)

CustomKeywords.'api_Connection.LicenseDetailsStatusResp.verifyOriginalExpirationDate'(getLicenseDetailsStatusResp, expirationDate)

CustomKeywords.'api_Connection.LicenseDetailsStatusResp.verifyOriginalStatusReason'(getLicenseDetailsStatusResp, statusReason)

//Close Browser
WebUI.closeBrowser()

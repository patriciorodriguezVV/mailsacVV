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
import com.sun.net.httpserver.Authenticator.Failure
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import ws.GetLicenseDetailsStatus as GetLicenseDetailsStatus
import ws.GetToken as GetToken
import ws.GetLicenseLookup as GetLicenseLookup
import ws.GetLicenseDetails as GetLicenseDetails

String licenseExpirationType
String dateExpires
String simpleExpirationDate
String licenseExpirationDate



/*
GlobalVariable.G_Applicant_FirstName = 'PRyrurv'

// Get License Lookup Details for a specific License Type
Object responseLicenseLookup = CustomKeywords.'api_Connection.LicenseLookupResp.getLicenseLookupDetails'()

// Get License Lookup Details for a specific License Type
Object responseLicenseDetails = CustomKeywords.'api_Connection.LicenseDetailsResp.getLicenseDetails'()



// Get Issue Date from License
String issueDate = CustomKeywords.'api_Connection.LicenseDetailsResp.getIssueDate'(responseLicenseDetails)

// Calculate License Expiration Date
String expectedExpirationDate = CustomKeywords.'api_Connection.LicenseLookupResp.calculateExpirationDate'(responseLicenseLookup, issueDate)








//Process the date received from the form
licenseExpirationDate = CustomKeywords.'api_Connection.LicenseDetailsResp.processLicenseExpirationDate'(responseLicenseDetails)

System.out.println('\n\nLicense Expiration Date: ' + licenseExpirationDate)

WebUI.verifyMatch(expectedExpirationDate, licenseExpirationDate, true, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'api_Connection.LicenseDetailsResp.verifyIssueDate'(responseLicenseDetails)

CustomKeywords.'api_Connection.LicenseDetailsResp.verifyEffectiveDate'(responseLicenseDetails)
*/


/*
GetToken getTokenReq = new GetToken()

ResponseObject getTokenresp = getTokenReq.getToken1()

if(GetToken.getStatusCode(getTokenresp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getTokenresp))
}

System.out.println(GetToken.getResponseText(getTokenresp))

// Assign token to Global Variable
GlobalVariable.G_Token = WS.getElementPropertyValue(getTokenresp, 'access_token')

System.out.println('Token: "'+ GlobalVariable.G_Token + '"')




GetLicenseDetailsStatus getLicenseDetailsStatusReq = new GetLicenseDetailsStatus()

String licenseId = 'PT-0000025'

ResponseObject getLicenseDetailsStatuspResp = getLicenseDetailsStatusReq.getLicenseDetailsStatusByLicenseId(licenseId)

if(getLicenseDetailsStatusReq.getStatusCode(getLicenseDetailsStatuspResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getLicenseDetailsStatuspResp))
}

System.out.println(getLicenseDetailsStatusReq.getResponseText(getLicenseDetailsStatuspResp))

String startDate = '01/27/2022'

CustomKeywords.'api_Connection.LicenseDetailsStatusResp.verifyEffectivetDate'(getLicenseDetailsStatuspResp, startDate)

*/

// Verify License Details Status was created correctly

// Verify License Details Status was created correctly

GetToken getTokenReq = new GetToken()



GlobalVariable.G_Applicant_FirstName = 'PRkmauh'
String licenseName = 'Physical+Therapist'


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




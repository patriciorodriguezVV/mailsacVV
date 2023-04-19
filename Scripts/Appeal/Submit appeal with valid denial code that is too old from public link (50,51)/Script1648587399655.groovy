import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import generic.generic_functions as GenericFunctions

import ws.GetToken as GetToken

import ws.GetDenialEventRecord as GetDenialEventRecord
import ws.PostDenialEventRecord as PostDenialEventRecord

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver

// Verify Parents TC have not failed ---
// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit License Application/Deny License Application']
// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)

String modalDialgoTitle = 'Appeals'

// Verify Denial Event Record Status was created correctly
GetToken getTokenReq = new GetToken()

ResponseObject getTokenResp = getTokenReq.getToken1()

CustomKeywords.'api_Connection.TokenResp.getToken'(getTokenResp)

// TC fail control
if(getTokenReq.getStatusCode(getTokenResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getTokenResp))
}

// Get Object for Denial Event Record that matches Appeal Denial Code saved as variable
GetDenialEventRecord getDenialEventRecordReq = new GetDenialEventRecord()

ResponseObject getDenialEventRecordRes = getDenialEventRecordReq.getDenialEventRecordByDenialCode(GlobalVariable.G_Appeal_Code)

// TC fail control
if(getDenialEventRecordReq.getStatusCode(getDenialEventRecordRes) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getDenialEventRecordRes))
}

// Get Revision ID from Denial Event Record Res
GlobalVariable.G_DenialEvent_RevisionId = CustomKeywords.'api_Connection.DenialEventRecordRes.getDenialEventRecordRevisionId'(getDenialEventRecordRes)

// Get Danial Date from Denial Event Record Res
GlobalVariable.G_DenialEvent_DenialDate = CustomKeywords.'api_Connection.DenialEventRecordRes.getDenialEventRecordDenialDate'(getDenialEventRecordRes)

/****************************************************
 * 51 days past appeal window border case
 ****************************************************/

// Modifies Denial Date 51 days into past
String denialDateMinus51 = GenericFunctions.getCustomDateMinusCustomDays(GlobalVariable.G_DenialEvent_DenialDate, 51)

// Post new Denial Event date of Denial for License Application Record
PostDenialEventRecord postDenialEventRecordReq1 = new PostDenialEventRecord()

ResponseObject postDenialEventRecordRes1 = postDenialEventRecordReq1.postNewDenialDate(denialDateMinus51)

// TC fail control
if(postDenialEventRecordReq1.getStatusCode(postDenialEventRecordRes1) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(postDenialEventRecordRes1))
}

// Open Browser and go to Appeal form public link
WebUI.openBrowser(GlobalVariable.G_Appeal_Link)

// Enter incorrect appeal code
CustomKeywords.'pages.Page_Licensure_Unit_Appeals.enterAppealCode'(GlobalVariable.G_Appeal_Code)

// Click on Next
CustomKeywords.'pages.Page_Licensure_Unit_Appeals.clickOnNextBtn'()

// Verify if modal text contains an error message indicating denial code is invalid
String errorTextModalDialog = String.format("An error was encountered. The denial code of %s was not found in the system or is older than 50 days. Please modify your request to continue, or contact a system administrator if this problem occurs.", GlobalVariable.G_Appeal_Code);

String titleModalDialog = 'Start Appeal'

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleModalDialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(errorTextModalDialog)

//Close browser
WebUI.closeBrowser()

/****************************************************
 * 50 days past appeal window border case
 ****************************************************/

// Modifies Denial Date 50 days into past
String denialDateMinus50 = GenericFunctions.getCustomDateMinusCustomDays(GlobalVariable.G_DenialEvent_DenialDate, 50)

// Post new Denial Event date of Denial for License Application Record
PostDenialEventRecord postDenialEventRecordReq2 = new PostDenialEventRecord()

ResponseObject postDenialEventRecordRes2 = postDenialEventRecordReq2.postNewDenialDate(denialDateMinus50)

// TC fail control
if(postDenialEventRecordReq2.getStatusCode(postDenialEventRecordRes2) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(postDenialEventRecordRes2))
}

// Open Browser and go to Appeal form public link
WebUI.openBrowser(GlobalVariable.G_Appeal_Link)

// Enter incorrect appeal code
CustomKeywords.'pages.Page_Licensure_Unit_Appeals.enterAppealCode'(GlobalVariable.G_Appeal_Code)

// Click on Next
CustomKeywords.'pages.Page_Licensure_Unit_Appeals.clickOnNextBtn'()

//Verify Modal Dialog Title
CustomKeywords.'pages.ModalDialog.verifyTitle'(modalDialgoTitle)

// Verify valid denial code entered and form shows up poping up a modal
CustomKeywords.'pages.ModalDialog.clickOnCloseButton'()

//Close browser
WebUI.closeBrowser()
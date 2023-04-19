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
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper
import ws.GetToken as GetToken
import ws.GetIndividualRecord as GetIndividualRecord

// Verify Individual Record Details Status was created correctly


GetToken getTokenReq = new GetToken()

ResponseObject getTokenResp = getTokenReq.getToken1()

CustomKeywords.'api_Connection.TokenResp.getToken'(getTokenResp)

if(getTokenReq.getStatusCode(getTokenResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getTokenResp))
}

// Get Object for Individual Record Detail
GetIndividualRecord getIndividualRecordReq = new GetIndividualRecord()

ResponseObject getIndividualRecordResp = getIndividualRecordReq.getIndividualRecordByApplicantFirstName(GlobalVariable.G_Applicant_FirstName)

if(getIndividualRecordReq.getStatusCode(getIndividualRecordResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ GetToken.getStatusCode(getIndividualRecordResp))
}

// Get Record ID from Individual Record Details Resp
String applicantEmail = CustomKeywords.'api_Connection.IndividualRecordResp.getApplicantEmail'(getIndividualRecordResp)

CustomKeywords.'api_Connection.IndividualRecordResp.verifyUniqueIndividualRecord'(getIndividualRecordResp)

// Validates that global email variable matches API returned applicant email
WebUI.verifyMatch(applicantEmail, GlobalVariable.G_Applicant_Email, false, FailureHandling.CONTINUE_ON_FAILURE)

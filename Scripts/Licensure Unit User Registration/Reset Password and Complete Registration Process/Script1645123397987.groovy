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
import ws.Mailsac as Mailsac
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil

import gmail_Connection.getEmailContent as getEmailContent



// Verify Parent TC has not failed
String[] parentsTC = ['Test Cases/Licensure Unit User Registration/Registration Successful - US Citizen - With SSN']

CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)


// Get Object for License Detail
Mailsac getMessagesReq = new Mailsac()



ResponseObject getMessagesListResp = getMessagesReq.getListMessagesByEmail(GlobalVariable.G_Applicant_Email)

if(getMessagesReq.getStatusCode(getMessagesListResp) != 200) {
	KeywordUtil.markFailed("Status code is not 200 as expected. It is "	+ getMessagesReq.getStatusCode(getMessagesListResp))
}


// Get link to complete registration from Email received by the Applicant
String link = CustomKeywords.'api_Connection.MailsacResp.getLinkVerification'(getMessagesListResp)

// Open browswer and navigate to Rest Password link and complete the registration
WebUI.openBrowser(link)

CustomKeywords.'pages.Page_Reset_Password_Complete_Registration.verifyUserId'(GlobalVariable.G_Applicant_Email)

CustomKeywords.'pages.Page_Reset_Password_Complete_Registration.completePasswords'()

CustomKeywords.'pages.Page_Reset_Password_Complete_Registration.clickOnResetPasswordbtn'()

// Verify user was logged correctly
CustomKeywords.'pages.Page_Applicant_Home.verifyUserIsLogged'(GlobalVariable.G_Applicant_Email)


// Close browser
WebUI.closeBrowser()
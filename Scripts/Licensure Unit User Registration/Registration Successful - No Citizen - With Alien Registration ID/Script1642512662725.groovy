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
import java.util.Date as Date
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import generic.generic_functions as Generic_functions


String chars = 'abcdefghijklmnopqrstuvwxyz'
String nums = '1234567890'
String DOB = Generic_functions.randomPastDate(18250, 10000)


// Set Random Variables
String randomFirstName = Generic_functions.randomString(chars, 5)
String randomLastName = Generic_functions.randomString(chars, 5)
String randomAlienRegistrationNum = Generic_functions.randomString(nums, 9)
GlobalVariable.G_Applicant_FirstName = ('PR' + randomFirstName)
GlobalVariable.G_Applicant_LastName = ('AutomationNoCitizen' + randomLastName)
GlobalVariable.G_Applicant_Email = (('applicantNoCitizen' + randomFirstName) + GlobalVariable.MailsacDomain)


// Open Browser
WebUI.openBrowser(GlobalVariable.G_Registration_Form)



// Enter Individual Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeFirstName'(GlobalVariable.G_Applicant_FirstName)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeLastName'(GlobalVariable.G_Applicant_LastName)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeDOB'(DOB)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completePlaceOfBirth'(GlobalVariable.G_Applicant_PlaceOfBirthCanada)



// Enter Mailing Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectCountryUruguay'()

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeAddressLine'(GlobalVariable.G_Applicant_AddressLine)


// Select Yes on dropdown "Is the Physical address the same?"
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectSameAddress'('Yes')



// Select No on US Citizen option
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectUSCitizen'('No')



// Select No on Do You Have SSN option
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectDoYouHaveSSN'('No')



// Enter Identification Information - Alien Registration Number 
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeAlienRegistrationNum'(randomAlienRegistrationNum)



// Enter PhoneNumber Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completePrimaryPhoneNumber'(GlobalVariable.G_Applicant_PhoneNumber)



// Enter Email Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeEmailAddress'(GlobalVariable.G_Applicant_Email)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeRetypeEmailAddress'(GlobalVariable.G_Applicant_Email)



// Click on Submit and complete Registration
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.clickOnSubmitBtn'()

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.verifyRegistrationCompletedSuccessfully'()



// Close Browser
WebUI.closeBrowser()


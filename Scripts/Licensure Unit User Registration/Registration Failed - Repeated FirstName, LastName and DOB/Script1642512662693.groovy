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
String nums = '123456780'


// Set Random Variables
String placeOfBirth = 'Miami'
String zipCode = '33513'
String dob = '08/08/1992'
String addressLine1 = '3 CR 542D'
String phoneNumber = '2222222222'
String firstName1 = 'Kathrine'
String lastName1 = 'Smith'
String firstName2 = 'Kathrine'
String lastName2 = 'Smith'
String firstName3 = 'Kathrine'
String lastName3 = 'Smith'
String firstName4 = 'Kathrine'
String lastName4 = 'Smith'
String aka = 'Kathy, Kathrine'
String randomSSN = Generic_functions.randomString(nums, 9)
GlobalVariable.G_Applicant_Email = (('applicant_' + randomSSN) + GlobalVariable.MailsacDomain)


// Open Browser
WebUI.openBrowser(GlobalVariable.G_Registration_Form)


// Enter Individual Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeFirstName'(firstName1)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeLastName'(lastName1)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeDOB'(dob)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completePlaceOfBirth'(placeOfBirth)



// Enter Mailing Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectCountryEEUU'()

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeZipCode'(zipCode)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeAddressLine'(addressLine1)



// Enter Identification Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectUSCitizen'('Yes')

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeSSN'(randomSSN)



// Enter PhoneNumber Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completePrimaryPhoneNumber'(phoneNumber)



// Enter Email Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeEmailAddress'(GlobalVariable.G_Applicant_Email)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeRetypeEmailAddress'(GlobalVariable.G_Applicant_Email)


// Click on Submit and complete Registration
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.clickOnSubmitBtn'()

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.verifyDuplicatedErrorMessage'()



// Clear FirstName, LastName and DOB
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.clearFirstNameField'()

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.clearLastNameField'()

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.clearDOBField'()



// Close Browser
WebUI.closeBrowser()

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



// Set modal variables
String titleMessage = 'Existing Account Found'
String bodyMessageEmailDuplicated = 'An existing User Account was found with the same information on this User Registration form. Click Ok to reset your password.'


// Set Existing Registered User Variables
String firstName = 'RRopdda'
String lastName = 'Automationkvqgh'
String dob = '09/21/1985'
String placeOfBirth = 'Alaska'
String zipCode = '33513'
String addressLine1 = 'PO BOX 4'
String existingSSN = '214-15-4174'
String phoneNumber = '2222222222'
String existingEmail = 'pruebas.onetree+Applicantopdda@gmail.com'


// Open Browser
WebUI.openBrowser(GlobalVariable.G_Registration_Form)



// Enter Individual Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeFirstName'(firstName)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeLastName'(lastName)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeDOB'(dob)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completePlaceOfBirth'(placeOfBirth)



// Enter Mailing Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectCountryEEUU'()

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeZipCode'(zipCode)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeAddressLine'(addressLine1)



// Select Yes on dropdown "Is the Physical address the same?"
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectSameAddress'('Yes')



// Enter Identification Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectUSCitizen'('Yes')

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeSSN'(existingSSN)



// Enter PhoneNumber Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completePrimaryPhoneNumber'(phoneNumber)



// Enter existing Email Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeEmailAddress'(existingEmail)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeRetypeEmailAddress'(existingEmail)



// Click on Submit and complete Registration
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.clickOnSubmitBtn'()



// Verify Error Message because user duplicated is displayed - In this case the duplacted error is cause because the Email
CustomKeywords.'pages.ModalDialog.verifyBody'(bodyMessageEmailDuplicated)

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleMessage)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

// Verify redirection to resetting password page
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.verifyResetPasswordURL'()

// Close Browser
WebUI.closeBrowser()
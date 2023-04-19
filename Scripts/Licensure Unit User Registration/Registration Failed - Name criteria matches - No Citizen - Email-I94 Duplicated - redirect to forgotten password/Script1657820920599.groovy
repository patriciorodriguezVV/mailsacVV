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


// Set Existing Registered User Variables
String firstName = 'Freddie'
String lastName = 'AutomationNoCitizen'
String aka = 'Freddie, AutomationNoCitizen'
String dob = '04/08/1992'
String i94 = '07121222222'
String placeOfBirth = 'Montevideo'
String addressLine = 'PO BOX 4'
String phoneNumber = '2222222222'
String email = 'federico.cuelho+AIMPL1951@visualvault.com'


// Set modal variables
String titleModalDialog = 'Existing Account Found'
String errorTextModalDialog = 'An existing User Account was found with the same information on this User Registration form. Click Ok to reset your password.'


// Open Browser
WebUI.openBrowser(GlobalVariable.G_Registration_Form)


// Enter Individual Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeFirstName'(firstName)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeLastName'(lastName)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeAKA'(aka)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeDOB'(dob)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completePlaceOfBirth'(placeOfBirth)



// Enter Mailing Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectCountryUruguay'()

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeAddressLine'(addressLine)


// Select Yes on dropdown "Is the Physical address the same?"
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectSameAddress'('Yes')


// Enter Identification Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectUSCitizen'('No')


// Select No on Do You Have SSN option
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectDoYouHaveSSN'('No')


// Enter I-94 Number
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeI94'(i94)

// Enter PhoneNumber Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completePrimaryPhoneNumber'(phoneNumber)


// Enter Email Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeEmailAddress'(email)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeRetypeEmailAddress'(email)


// Click on Submit and verify existing user found message modal shows
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.clickOnSubmitBtn'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleModalDialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(errorTextModalDialog)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()


// Verify redirection to resetting password page
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.verifyResetPasswordURL'()


// Close Browser
WebUI.closeBrowser()

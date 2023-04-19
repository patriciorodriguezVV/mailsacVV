/*
Script Name:    Registration Failed - User cease and desist - US Citizen - Sounds like first name - Duplicated Last Name - contact DHH
 
Purpose:        The purpose of this script is to attempt to register a user using the a nick name for the first name and same last name
                of the user registered within the precondition. When attempting to submit the registration the user should get an error 
                message informing that the registration can’t be completed and needs to contact DHHS.

Revision Notes:
                07/14/2022 - Federico Cuelho: Initial creation of the test case.
                07/21/2022 - Federico Cuelho: Add initial annotation and modify modal info, tc name and variables used.								
*/


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


// Set existing registered user variables
String firstName = 'Kathrine'
String lastName = 'AutomationImplNineteenSixtySeven'
String dob = '04/19/1981'
String zipCode = '33513'
String addressLine = 'PO BOX 4'
String ssn = '071422222'
String email = 'federico.cuelho+AIMPL1967@visualvault.com'


// Set modal variables
String titleModalDialog = 'Unable To Process Registration'
String errorTextModalDialog = 'An error was encountered. Unable to match with a current record. Please contact LU Staff to complete registration. Please try again or contact a system administrator if this problem continues.'


// Open Browser
WebUI.openBrowser(GlobalVariable.G_Registration_Form)


// Enter Individual Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeFirstName'(firstName)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeLastName'(lastName)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeDOB'(dob)


// Enter Mailing Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectCountryEEUU'()

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeZipCode'(zipCode)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeAddressLine'(addressLine)


// Select Yes on dropdown "Is the Physical address the same?"
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectSameAddress'('Yes')


// Enter Identification Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.selectUSCitizen'('Yes')

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeSSN'(ssn)


// Enter Email Address Information
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeEmailAddress'(email)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completeRetypeEmailAddress'(email)


// Click on Submit and verify existing user found message modal shows
CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.clickOnSubmitBtn'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleModalDialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(errorTextModalDialog)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()


// Close Browser
WebUI.closeBrowser()

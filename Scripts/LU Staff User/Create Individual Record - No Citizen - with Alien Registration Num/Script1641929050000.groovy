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
String randomFirstName = Generic_functions.randomString(chars, 5)
String randomLastName = Generic_functions.randomString(chars, 5)
int currentTab = 0



// Set Random Variables
String placeOfBirth = 'Toronto'
String zipCode = 'M1R 0E9'
String addressLine1 = 'Address Line 1234'
String phoneNumber = '2222222222'
GlobalVariable.G_Applicant_DOB = Generic_functions.randomPastDate(18250, 10000)
GlobalVariable.G_Applicant_AlienRegistrationNum = Generic_functions.randomString(nums, 9)
GlobalVariable.G_Applicant_FirstName = ('PR' + randomFirstName)
GlobalVariable.G_Applicant_LastName = ('AutomationNoCitizen' + randomLastName)
GlobalVariable.G_Applicant_Email = (('applicantNoCitizen' + randomFirstName) + GlobalVariable.MailsacDomain)



// Open Browser
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)



// Login with LU Staff user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_LU_Staff_UserName, GlobalVariable.G_LU_Staff_Pass)



// Click on Individual Link
CustomKeywords.'pages.Page_Home_Admin.clickOnIndividualLink'()



// Move to Next Window
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)



// Enter Individual Information
CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.enterFirstName'(GlobalVariable.G_Applicant_FirstName)

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.enterLastName'(GlobalVariable.G_Applicant_LastName)

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.enterDateOfBirth'(GlobalVariable.G_Applicant_DOB)

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.enterPlaceOfBirth'(GlobalVariable.G_Applicant_PlaceOfBirth)

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.selectCountryUruguay'()

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.enterAddressLine1'(GlobalVariable.G_Applicant_AddressLine)

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.selectSameAddress'('Yes')

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.selectUSCitizen'('No')

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.selectDoYouHaveSSN'('No')

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.enterAlienRegisterNumber'(GlobalVariable.G_Applicant_AlienRegistrationNum)

CustomKeywords.'pages.Page_Licensure_Unit_User_Registration.completePrimaryPhoneNumber'(GlobalVariable.G_Applicant_PhoneNumber)

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.enterEmailAddress'(GlobalVariable.G_Applicant_Email)

CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.enterRetypeEmailAddress'(GlobalVariable.G_Applicant_Email)



// Click on Save and Confirm button
CustomKeywords.'pages.Page_Licensure_Unit_Individual_Record.clickOnSaveAndConfirm'()



// Close Broser
WebUI.closeBrowser()


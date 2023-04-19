/*
 Test Case Name: Cosmetologist - Reinstatement - Practice Prior to License Yes (Applicant)
 Purpose: Verify that an Applicant can submit License Application Cosmetologist - Reinstatement. Confirm that fields are required on PRACTICE PRIOR TO LICENSE OR AFTER EXPIRATION, when the question "Did the applicant practice this profession in Nebraska without a license since [Current Date]" is answered YES.
 Steps:
	1- Open Browser.
	2- Login as Applicant.
	3- Click on New > Reinstate a License.
	4- Select Cosmetologist.
	5- Click on Next.
	6- Click on 'Start a Reinstatement Application'.
	7- Acknowledge.
	8- Complete Demographics information.
	9- Click next on Application Fees information.
	10- Click next on US Citizenship-Lawful information.
	11- Complete Other License information.
	12- Complete Conviction section.
	13- Answer Yes to 'Has Practiced Without License'. (Practice Prior to License)
	14- Click on Next without completing the fields.
	15- Verify Error message asking to complete required fields.
	16- Complete required fields and click on Next.
	17- Complete Continuing Competency Hours.
	18- Verify checklist tasks complete.
	19- Complete Attestation information.
	20- Complete Pay information.
	21- Submit License Application.
	22- Verify License Application submitted and documentation created.
	23- Close browser.
 Revision Notes:
 07/20/2022: Patricio Rodriguez - https://visualvault.atlassian.net/browse/IMPL-1975
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
import generic.common_functions as common_functions
import com.kms.katalon.core.configuration.RunConfiguration


/****************************************************
 * Verify Parents TC have not faile
 ****************************************************/

// Set TCs dependency
String[] parentsTC = ['Test Cases/Licensure Unit User Registration/Reset Password and Complete Registration Process']
// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)




/****************************************************
 * Variables
 ****************************************************/

int currentTab
String aka = 'PR'
String placeOfBirth = 'Alaska'
String schoolName = 'PR Test'
String titleMessageRecord = 'Record Saved'
String printName = 'PR Automation Test'
String projectPath = RunConfiguration.getProjectDir()
String emtpyDocpath = projectPath + '/Documents/Document Empty.txt'
String emtpyDocpath2 = projectPath + '/Documents/Document Empty 2.txt'
String emtpyDocpath3 = projectPath + '/Documents/Document Empty 3.txt'
String numOfDays = '30'
String nameOfBusiness = 'BusinessName AT'
String city = 'Omaha'
String workPhone = '3333333333'
String taskDescriptionMilitaryFamily = 'You have requested a military family fee waiver for your initial license for the license Cosmetologist. You must be an active duty service member in the armed services of the United States, a military spouse, honorably discharged veteran of the armed services of the United States, spouse of such honorably discharged veteran, and un-remarried surviving spouses of deceased service members of the armed services of the United States. To be eligible for this waiver, you must submit a copy of your ID card, discharge paperwork, or similar document that shows you are a military family member as described above.'
String pdfTitleModalDialog = 'PDF Download'
String pdfBodyModalDialog = 'A PDF document has been created that represents your complete application. Select Download PDF to download the document for your records. If you do not download the document now you can return to the attestation section of your license application at any time to download the PDF. Select OK to continue.'
String submittedTitleModalDialog = 'Application Submitted'
String submittedBodyModalDialog = "You have successfully submitted your reinstatement application. You may see your reinstatement application in read-only mode by navigating through the tabs. If additional information is needed, you will receive a notification to add or update your information. You may check the status of your reinstatement on your home page under 'My applications in Process' by clicking on the 'My Home' tab in your portal."
String titleStartReinstatement = 'License Reinstatement'
String bodyStartReinstatement = 'The system has found that your Cosmetologist license is not active, but can be considered for reinstatement. To proceed, click "Start a Reinstatement Application". If this is not the application you wanted, click on "Select a different license type".\nStart a Reinstatement Application.\nSelect a different license type.\nIf you believe this information is incorrect, please contact Nebraska Licensure at DHHS.LanceSupport@nebraska.gov for further assistance.'
String payMethod = 'Credit Card'
String errorMessagePracticePriorToLicense = 'Please examine the list of fields with errors that have occurred. The description by each field outlines the error that was encountered. Navigate to the field, make the appropriate correction, and then try again.'
String errorMessageFieldsDetails = 'Prior Practice Number of Days: A whole number must be entered for Prior Practice Number of Days.\nPrior Practice Name: Please complete the Prior Practice Name field.\nPrior Practice City: Please complete the Prior Practice City field.\nPrior Practice Work Number: When a phone number is entered, it must be 10 digits, all numbers, and formatted (xxx) xxx-xxxx. The local prefix cannot start with a 0 or 1.'




/****************************************************
 * Step execution
 ****************************************************/

// Open Browser
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)



// Common_functions.login(GlobalVariable.G_Applicant_Email, GlobalVariable.G_ApplicantPass)
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_Applicant_Email, GlobalVariable.G_ApplicantPass)



// Click on New > Reinstate a License
System.sleep(10000)

CustomKeywords.'pages.Page_Applicant_Home.clickOnNewReinstateALicense'()
//CustomKeywords.'pages.Page_Applicant_Home.clickOnOpenApplication'()

// Move to the next Window
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)



// Select Cosmetologist on License Type
CustomKeywords.'pages.Page_Applicant_Renew_Or_Reinstate.selectLicenseCosmetologist'()

CustomKeywords.'pages.Page_License_Information.clickOnNextButton'()



// Verify Modal Dialog content and Click on the link "Start a Reinstatement Application" ---
CustomKeywords.'pages.ModalDialog.verifyBody'(bodyStartReinstatement)

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleStartReinstatement)

CustomKeywords.'pages.ModalDialog.clickOnLinkStartAReinstatementApplication'()



// Acknowledge ---
System.sleep(10000)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnAcknowledgeBtn'()



// Complete Demographics information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.enterAKA'(aka)
	
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.verifyPlaceOfBirth'(placeOfBirth)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.clickOnNextButton'()



// Verify Application Fees information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.clickOnNextButton'()



// Complete Other License information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.selectOutofStateLicense'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.selectDeniedRenewal'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.selectDisciplineSinceLicensed'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.clickOnNextButton'()



// Complete Convictions information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.selectIsOnProbation'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.selectHasBeenConvicted'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.clickOnNextButton'()



// Verify fields are required on Practice Prior to License information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.selectHasPracticedWithoutLicense'('Yes')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.clickOnNextButton'()

System.sleep(GlobalVariable.G_shot_time_milliseconds)

CustomKeywords.'pages.ModalDialog.verifyBodyValidationMessage'(errorMessagePracticePriorToLicense)

CustomKeywords.'pages.ModalDialog.verifyBodyValidationDetails'(errorMessageFieldsDetails)

CustomKeywords.'pages.ModalDialog.clickOnCancelButton'()



// Complete information on Practice Prior to License information
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.completeNumberOfDays'(numOfDays)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.completeNameOfBusiness'(nameOfBusiness)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.completeCity'(city)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.completeWorkPhone'(workPhone)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.clickOnNextButton'()



// Complete Continuing Competency Hours information
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Continuing_Competency_Hours.selectContinuingCompetencyRequirementMet'('Yes')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.clickOnNextButton'()



//Accept Checklist Management Modal Dialog (No task need to be completed)
CustomKeywords.'pages.ModalDialog.clickOnCloseButton'()



// Complete Attestation Information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.checkIAmACitizen'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.enterPrintName'(printName)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.checkSignature'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.clickOnNextButton'()

System.sleep(5000)



// Pay Fees---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Pay.clickOnPayNowBtn'()

System.sleep(10000)

WebUI.switchToWindowIndex(currentTab + 2)

System.sleep(5000)

CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.selectPaymentType'(payMethod)

System.sleep(2000)

CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.clickOnPayOnline'()

CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.completeCreditCardInfo'(GlobalVariable.G_CreditCardNum, GlobalVariable.G_CreditCardExpMonth, GlobalVariable.G_CreditCardExpYear, GlobalVariable.G_CreditCardSecCode)

CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.clickOnSubmitButton'()

WebUI.acceptAlert(FailureHandling.OPTIONAL)

System.sleep(10000)

WebUI.switchToWindowIndex(currentTab + 1)

CustomKeywords.'pages.ModalDialog.verifyTitle'('Fees Paid')

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()




//Submit License Application and verify messages.
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Pay.clickOnSubmitBtn'()

System.sleep(15000)

CustomKeywords.'pages.ModalDialog.verifyTitle'(pdfTitleModalDialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(pdfBodyModalDialog)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(submittedTitleModalDialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(submittedBodyModalDialog)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)



// Close Browser
WebUI.closeBrowser()


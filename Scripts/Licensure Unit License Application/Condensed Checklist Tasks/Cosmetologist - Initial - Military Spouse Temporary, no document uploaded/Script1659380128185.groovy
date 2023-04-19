/*
 Test Case Name: Cosmetologist - Initial - Military Spouse Temporary, no document uploaded
 Purpose: Verify that the user is istopped from moving forward by the checklist asking to upload military spouse documentation and that after uploading it the user is no longer stopped
 Steps:
	 1-Open Browser.
	 2-Login as Applicant.
	 3-Click on Apply for a License Link.
	 4-Move to License Application form tab.
	 5-Select Cosmetology on Professional License.
	 6-Select Cosmetologist on Professional License Type.
	 7-Answer both questions with 'Yes'and do not upload Military family document.
	 8-Acknowledge.
	 9-Complete Demographics information.
	 10-Verify Military Family is Checked
	 11-Click next on Application Fees information.
	 12-Click next on US Citizenship-Lawful information.
	 13-Click next on Education information.
	 14-Complete Other License information.
	 15-Complete Conviction section.
	 16-Complete Practice Prior to License information.
	 17-Complete Checklist Management tasks.
	 18-Complete Education information.
	 19-Verify checklist tasks complete.
	 20-Complete Attestation information.
	 21-Complete Pay information.
	 22-Submit License Application.
	 23-Verify License Application submitted and documentation created.
	 24-Close browser.
 Revision Notes:
 08/01/2022: Ivan Arno - https://visualvault.atlassian.net/browse/IMPL-2028
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
String placeOfBirth = 'Alaska'
String schoolName = 'PR Test'
String titleMessageRecord = 'Record Saved'
String printName = 'PR Automation Test'
String projectPath = RunConfiguration.getProjectDir()
String emtpyDocpath = projectPath + '/Documents/Document Empty.txt'
String emtpyDocpath2 = projectPath + '/Documents/Document Empty 2.txt'
String emtpyDocpath3 = projectPath + '/Documents/Document Empty 3.txt'
String taskDescriptionMilitaryFamily = 'You have requested a military family fee waiver for your initial license for the license Cosmetologist. You must be an active duty service member in the armed services of the United States, a military spouse, honorably discharged veteran of the armed services of the United States, spouse of such honorably discharged veteran, and un-remarried surviving spouses of deceased service members of the armed services of the United States. To be eligible for this waiver, you must submit a copy of your ID card, discharge paperwork, or similar document that shows you are a military family member as described above.'
String pdfTitleModalDialog = 'PDF Download'
String pdfBodyModalDialog = 'A PDF document has been created that represents your complete application. Select Download PDF to download the document for your records. If you do not download the document now you can return to the attestation section of your license application at any time to download the PDF. Select OK to continue.'
String submittedTitleModalDialog = 'Application Submitted'
String submittedBodyModalDialog = "You have successfully submitted your license application. You can review submitted application in read-only mode by navigating through the tabs on LICENSE APPLICATION. If the Licensure Unit needs additional information, you will receive notification to add or update your information. You can now go to the home page and check the status of your application under 'My Applications In Process' by clicking on the 'My Home' tab on the left side of the portal"




/****************************************************
 * Step execution
 ****************************************************/

// Open Browser
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)



// Common_functions.login(GlobalVariable.G_Applicant_Email, GlobalVariable.G_ApplicantPass)
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_Applicant_Email, GlobalVariable.G_ApplicantPass)



// Click on Apply for a License Link
System.sleep(10000)

CustomKeywords.'pages.Page_Applicant_Home.clickOnApplyForALicense'()



// Move to the next Window
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)



// Select Cosmetology on Professional License
CustomKeywords.'pages.Page_License_Information.selectCosmetologyProfessionalLicense'()



// Select Cosmetologist on Professional License Type
CustomKeywords.'pages.Page_License_Information.selectCosmetologistProfessionalLicenseType'()

CustomKeywords.'pages.Page_License_Information.clickOnNextButton'()


// Answer previous questions ---
CustomKeywords.'pages.Page_Questions_Previous_License_Application.answerYesNoQuestion'('Yes')

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnNextButtonm'()

CustomKeywords.'pages.Page_Questions_Previous_License_Application.answerYesNoQuestion'('Yes')

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnNextButtonm'()

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnConfirmAnswers'()



// Acknowledge ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnAcknowledgeBtn'()



// Complete Demographics information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.verifyPlaceOfBirth'(placeOfBirth)
	
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.selectSpouseMemberUSAF'('Yes')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.selectTemporaryLicense'('Yes')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.verifyViewUploadedDocumentsIsVisible'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.verifyUploadDocumentIsVisible'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.clickOnNextButton'()



// Verify Application Fees information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.verifyMilitaryFamilyIsChecked'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.verifyUploadDocumentIsVisible'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.verifyViewUploadedDocumentsIsVisible'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.clickOnNextButton'()



// Complete US Citizenship-Lawful information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_US_Citizenshi_Lawful_Presence.clickOnNextButton'()



// Complete Employment information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Employment_History.selectEmploymentConsideration'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Employment_History.clickOnNextButton'()



// Complete Examination information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Examination.clickOnNextButton'()



// Complete Education information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Education.clickOnNextButton'()



// Complete Other License information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.selectHasBeenDeniedRight'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.selectHasBeenDeniedIssuance'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.selectDoesApplicantHold'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.clickOnNextButton'()



// Complete Convictions information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.selectIsOnProbation'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.selectHasBeenConvicted'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.clickOnNextButton'()



// Complete Practice Prior to License information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.selectHasPracticedWithoutLicense'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.clickOnNextButton'()



//Checklist Management---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.verifyTaskDescription'(taskDescriptionMilitaryFamily)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnUploadButton'()

common_functions.uploadFilePath(emtpyDocpath)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnNextButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnUploadButton'()

common_functions.uploadFilePath(emtpyDocpath2)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnNextButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnUploadButton'()

common_functions.uploadFilePath(emtpyDocpath3)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnNextButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()



// Complete School Information

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOpenRelatedFormButton'()

WebUI.switchToWindowIndex(currentTab + 2)
	
Thread.sleep(5000)

CustomKeywords.'pages.Page_Licensure_Unit_Education_History.enterSchoolName'(schoolName)

CustomKeywords.'pages.Page_Licensure_Unit_Education_History.selectEducationTypeDiploma'()

CustomKeywords.'pages.Page_Licensure_Unit_Education_History.clickOnSaveAndContinue'()

CustomKeywords.'pages.Page_Licensure_Unit_Education_History.verifyRecordSavedCorrectly'(titleMessageRecord)

WebUI.switchToWindowIndex(currentTab + 1)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnNextButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()

CustomKeywords.'pages.ModalDialog.clickOnCloseButton'()



// Complete Attestation Information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.checkIAmACitizen'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.enterPrintName'(printName)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.checkSignature'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.clickOnNextButton'()

System.sleep(5000)



// Verify Pay Information and Submit Form---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Pay.verifyPayNowBtnIsNotVisible'()

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

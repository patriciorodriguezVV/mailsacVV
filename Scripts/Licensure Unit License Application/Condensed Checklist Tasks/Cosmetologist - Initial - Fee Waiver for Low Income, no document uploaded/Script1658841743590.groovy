/*
 Test Case Name: Cosmetologist - Initial - Fee Waiver for Low Income, no document uploaded
 Purpose: Verify that the user is prompted to upload a low income waiver documentation by the checklist
 Steps:
	 1-Open Browser.
	 2-Login as Applicant.
	 3-Click on Apply for a License Link.
	 4-Move to License Application form tab.
	 5-Select Cosmetology on Professional License.
	 6-Select Cosmetologist on Professional License Type.
	 7-Answer questions.
	 8-Acknowledge.
	 9-Complete Demographics information.
	 10-Select Low income as Fee Waiver, and dont upload a document
	 11-Click next on Application Fees information.
	 12-Click next on US Citizenship-Lawful information.
	 13-Click next on Education information.
	 14-Complete Other License information.
	 15-CompleteConviction section.
	 16-Complete Practice Prior to License information.
	 17-Complete Checklist Management tasks.
	 18-Complete Education information.
	 19-Confirm Checklist item asking to upload Low income Fee waiver document.
	 20-Verify checklist tasks complete.
	 21-Complete Attestation information.
	 22-Complete Pay information.
	 23-Submit License Application.
	 25-Verify License Application submitted and documentation created.
	 26-Close browser.
 Revision Notes:
 07/28/2022: Ivan Arno - https://visualvault.atlassian.net/browse/IMPL-2021
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
String taskDescriptionLowIncome = 'You have requested a fee waiver as a low-income individual and checked that your adjusted gross income is below 130% of the Federal Income Poverty Guideline. Upload a copy of your most recent tax return as proof of income.'
String pdfTitleModalDialog = 'PDF Download'
String pdfBodyModalDialog = 'A PDF document has been created that represents your complete application. Select Download PDF to download the document for your records. If you do not download the document now you can return to the attestation section of your license application at any time to download the PDF. Select OK to continue.'
String submittedTitleModalDialog = 'Application Submitted'



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

CustomKeywords.'pages.Page_Questions_Previous_License_Application.answerYesNoQuestion'('No')

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnNextButtonm'()

CustomKeywords.'pages.Page_Questions_Previous_License_Application.answerYesNoQuestion'('Yes')

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnNextButtonm'()

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnConfirmAnswers'()



// Acknowledge ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnAcknowledgeBtn'()



// Complete Demographics information ---
//CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.enterAKA'(aka)
	
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.verifyPlaceOfBirth'(placeOfBirth)
	
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.selectSpouseMemberUSAF'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.clickOnNextButton'()



// Verify Application Fees information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.checkLowIncomeIndividual'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.checkLowIncomeIndividualPoverty'()

System.sleep(3000)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.verifyUploadLowIncomeDocumentIsVisible'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.verifyViewLowIncomeUploadedDocumentsIsVisible'()

//CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.ClickOnUploadLowIncomeDocument'()

//common_functions.uploadFilePath(emtpyDocpath)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.clickOnNextButton'()



// Complete US Citizenship-Lawful information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_US_Citizenshi_Lawful_Presence.clickOnNextButton'()



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
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnUploadButton'()

common_functions.uploadFilePath(emtpyDocpath)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnNextButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnAcknowledgeButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnUploadButton'()

common_functions.uploadFilePath(emtpyDocpath2)

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


//Low Income Upload document requested by Checklist

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.verifyTaskDescription'(taskDescriptionLowIncome)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnUploadButton'()

common_functions.uploadFilePath(emtpyDocpath3)

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

CustomKeywords.'pages.ModalDialog.verifyBody'(GlobalVariable.G_Successful_Message_License_Application_Submitted)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)



// Close Browser
WebUI.closeBrowser()


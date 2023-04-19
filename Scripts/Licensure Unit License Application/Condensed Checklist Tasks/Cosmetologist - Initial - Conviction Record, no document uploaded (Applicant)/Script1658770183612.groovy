/*
Script Name:   Cosmetologist - Initial - Conv Record, no document uploaded
               
Purpose:       The purpose of this script is to attempt to verify that there is a checklist item asking for conviction information when applying for a license.
               
Steps:         1. Open Browser.
               2. Login as Applicant.
               3. Click on Apply for a License Link.
               4. Move to License Application form tab.
               5. Select Cosmetology on Professional License.
               6. Select Cosmetologist on Professional License Type.
               7. Answer questions.
               8. Acknowledge check.
               9. Complete Demographics information.
               10. Click next on Application Fees information.
               11. Click next on US Citizenship-Lawful information.
               12. Click next on Education information.
               13. Complete Other License information.
               14. Answer Conviction section questions without adding or uploading info.
               15. Complete Practice Prior to License information.
               16. Complete Checklist Management tasks.
               17. Complete Education information.
               18. Confirm Checklist item asking for Conviction information.
               19. Complete Conviction information.
               20. Upload Conviction documentation and verify checklist tasks complete.
               21. Complete Attestation information.
               22. Complete Pay information.
               23. Submit License Application.
               24. Verify License Application submitted and documentation created.
               25.Close browser.
               
Revision Notes:
               07/25/2022 - Federico Cuelho: Initial creation of the test case. - https://visualvault.atlassian.net/browse/IMPL-2039
*/


/****************************************************
		Import classes, libs and objects needed
****************************************************/

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
			Verify Parents TC have not failed
****************************************************/

// Set TCs dependency ---
String[] parentsTC = ['Test Cases/Licensure Unit User Registration/Reset Password and Complete Registration Process']

// Verify any TC dependency has failed
CustomKeywords.'tc_listener.tcl.checkErrors'(parentsTC)


/****************************************************
					Variables
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
String offenseDescription = 'Bar fight'
String docMonth = '12'
String docDay = '25'
String docYear = '2021'
String finalOutcome = 'Communitary service for 10 days'
String convictionExplanation = 'This is the full fight explanation.'
String pdfTitleModalDialog = 'PDF Download'
String pdfBodyModalDialog = 'A PDF document has been created that represents your complete application. Select Download PDF to download the document for your records. If you do not download the document now you can return to the attestation section of your license application at any time to download the PDF. Select OK to continue.'
String submittedTitleModalDialog = 'Application Submitted'
String submittedBodyModalDialog = "You have successfully submitted your license application. You can review submitted application in read-only mode by navigating through the tabs on LICENSE APPLICATION. If the Licensure Unit needs additional information, you will receive notification to add or update your information. You can now go to the home page and check the status of your application under 'My Applications In Process' by clicking on the 'My Home' tab on the left side of the portal"

// Set modals variables
String titleModal1Dialog = 'Checklist Management'
String errorTextModal1Dialog = "Task incomplete, to complete this task:\nThe response to the question 'Has the applicant EVER been convicted of a misdemeanor or felony?' is yes, but no conviction records were entered. Click the back button to return to the Conviction section of your application and enter the details in the table."
String errorTextModal2Dialog = "There are still 1 tasks that still have not been completed. You will now be directed to those remaining tasks."
String successTextModalDialog = 'All checklist tasks have been addressed. You are being redirected to the Attestation section. Select the Review Application button to see your full application if you want to review your answers or change what you have entered. When you have finished your review and attestation, click on Next. Clicking Next will create a PDF of your application that you can download for your records.'


/****************************************************
					Step execution
****************************************************/

// Open browser ---
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)


// Login as Applicant
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_Applicant_Email, GlobalVariable.G_ApplicantPass)


// Click on Apply for a License link ---
System.sleep(10000)

CustomKeywords.'pages.Page_Applicant_Home.clickOnApplyForALicense'()


// Move to the License Application tab ---
currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)


// Select Cosmetology on Professional License ---
CustomKeywords.'pages.Page_License_Information.selectCosmetologyProfessionalLicense'()


// Select Cosmetologist on Professional License Type ---
CustomKeywords.'pages.Page_License_Information.selectCosmetologistProfessionalLicenseType'()

CustomKeywords.'pages.Page_License_Information.clickOnNextButton'()


// Answer questions ---
CustomKeywords.'pages.Page_Questions_Previous_License_Application.answerYesNoQuestion'('Yes')

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnNextButtonm'()

CustomKeywords.'pages.Page_Questions_Previous_License_Application.answerYesNoQuestion'('No')

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnNextButtonm'()

CustomKeywords.'pages.Page_Questions_Previous_License_Application.answerYesNoQuestion'('Yes')

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnNextButtonm'()

CustomKeywords.'pages.Page_Questions_Previous_License_Application.clickOnConfirmAnswers'()


// Acknowledge check ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application.clickOnAcknowledgeBtn'()


// Complete Demographics information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.enterAKA'(aka)
	
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.verifyPlaceOfBirth'(placeOfBirth)
	
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.selectSpouseMemberUSAF'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Demographics.clickOnNextButton'()


// Skip Application Fees information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Application_Fees.clickOnNextButton'()


// Skip US Citizenship-Lawful information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_US_Citizenshi_Lawful_Presence.clickOnNextButton'()


// Skip Education information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Education.clickOnNextButton'()


// Complete Other License information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.selectHasBeenDeniedRight'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.selectHasBeenDeniedIssuance'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.selectDoesApplicantHold'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Other_License.clickOnNextButton'()


// Answer Conviction section questions without adding or uploading info ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.selectIsOnProbation'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.selectHasBeenConvicted'('Yes')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.clickOnNextButton'()


// Complete Practice Prior to License information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.selectHasPracticedWithoutLicense'('No')

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.clickOnNextButton'()


// Complete Checklist Management tasks ---
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


// Complete Education information ---
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


// Confirm Checklist item asking for Conviction information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnNextButton'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleModal1Dialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(errorTextModal1Dialog)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleModal1Dialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(errorTextModal2Dialog)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnBackButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnBackButton'()


// Complete Conviction information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.clickOnAddNewRow'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.completeOffenseDescription'(offenseDescription)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.selectJurisdictionNebraska'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.completeDoC'(docMonth, docDay, docYear)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.completeFinalOutcome'(finalOutcome)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.clickOnSaveConvictionItemButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.completeConvictionExplanation'(convictionExplanation)


// Upload Conviction documentation and verify checklist tasks complete ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.clickOnUploadExplainConvictionsButton'()

common_functions.uploadFilePath(emtpyDocpath3)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Convictions.clickOnNextButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Practice_Prior_To_License.clickOnNextButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnNextButton'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Checklist_Management.clickOnOkDialogButton'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(titleModal1Dialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(successTextModalDialog)

CustomKeywords.'pages.ModalDialog.clickOnOkbutton'()


// Complete Attestation information ---
CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.checkIAmACitizen'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.enterPrintName'(printName)

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.checkSignature'()

CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Attestation.clickOnNextButton'()

System.sleep(5000)


// Complete Pay information ---
if (CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Pay.verifyPayNowBtnIsVisible'()) {
	
    CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Pay.clickOnPayNowBtn'()

	System.sleep(10000)
	
	WebUI.switchToWindowIndex(currentTab + 2)
	
	System.sleep(5000)

    CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.selectPaymentType'('Credit Card')
	
	System.sleep(2000)

    CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.clickOnPayOnline'()

    CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.completeCreditCardInfo'(GlobalVariable.G_CreditCardNum, GlobalVariable.G_CreditCardExpMonth, GlobalVariable.G_CreditCardExpYear, GlobalVariable.G_CreditCardSecCode)

    CustomKeywords.'pages.Page_Licensure_Unit_Shopping_Cart.clickOnSubmitButton'()
	
	WebUI.acceptAlert(FailureHandling.OPTIONAL)
	
	System.sleep(10000)

    WebUI.switchToWindowIndex(currentTab + 1)

    CustomKeywords.'pages.ModalDialog.verifyTitle'('Fees Paid')

    CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()
}


// Submit License Application ---
if (WebUI.verifyElementVisible(findTestObject('Page_Licensure Unit License Application/Pay/button_Submit'),	FailureHandling.OPTIONAL)) {
	
		WebUI.verifyElementText(findTestObject('Page_Licensure Unit License Application/Pay/kendo-Dropdown-Status'), 'New', FailureHandling.OPTIONAL)
	
		CustomKeywords.'pages.Page_Licensure_Unit_License_Application_Pay.clickOnSubmitBtn'()
	}

// Verify License Application submitted and documentation created ---	
System.sleep(15000)

CustomKeywords.'pages.ModalDialog.verifyTitle'(pdfTitleModalDialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(pdfBodyModalDialog)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

CustomKeywords.'pages.ModalDialog.verifyTitle'(submittedTitleModalDialog)

CustomKeywords.'pages.ModalDialog.verifyBody'(submittedBodyModalDialog)

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)


// Close browser ---
WebUI.closeBrowser()
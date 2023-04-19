package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.support.FindBy

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.thoughtworks.selenium.webdriven.commands.Click
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class Page_Licensure_Unit_License_Application_Other_License {

	private TestObject dropdownCurrentlyPracticing			= findTestObject('Page_Licensure Unit License Application/Other Licenses/Is the applicant currently practicing/dropdown_Currently Practicing')
	private TestObject selectCurrentlyPracticingNoOpt		= findTestObject('Page_Licensure Unit License Application/Other Licenses/Is the applicant currently practicing/li_No')
	private TestObject selectCurrentlyPracticingYesOpt		= findTestObject('Page_Licensure Unit License Application/Other Licenses/Is the applicant currently practicing/li_Yes')
	private TestObject dropdownEverPracticed				= findTestObject('Page_Licensure Unit License Application/Other Licenses/Has the applicant ever practiced/dropdown_Ever Practiced')
	private TestObject selectEverPracticedNoOpt				= findTestObject('Page_Licensure Unit License Application/Other Licenses/Has the applicant ever practiced/li_No')
	private TestObject selectEverPracticedYesOpt			= findTestObject('Page_Licensure Unit License Application/Other Licenses/Has the applicant ever practiced/li_Yes')
	private TestObject dropdownHasBeenDeniedRight			= findTestObject('Page_Licensure Unit License Application/Other Licenses/span_Select Has been denied the right-arrow')
	private TestObject selectHasBeenDeniedRightNoOpt		= findTestObject('Page_Licensure Unit License Application/Other Licenses/li_Has been denied the right- No')
	private TestObject selectHasBeenDeniedRightYesOpt		= findTestObject('Page_Licensure Unit License Application/Other Licenses/li_Has been denied the right- Yes')
	private TestObject dropdownHasBeenDeniedIssuance		= findTestObject('Page_Licensure Unit License Application/Other Licenses/span_Select Has been denied issuance-arrow')
	private TestObject selectHasBeenDeniedIssuanceNoOpt		= findTestObject('Page_Licensure Unit License Application/Other Licenses/li_Has been denied issuance - No')
	private TestObject selectHasBeenDeniedIssuanceYesOpt	= findTestObject('Page_Licensure Unit License Application/Other Licenses/li_Has been denied issuance - Yes')
	private TestObject dropdownDoesApplicantHold			= findTestObject('Page_Licensure Unit License Application/Other Licenses/span_Select Does applicant hold-arrow')
	private TestObject selectDoesApplicantHoldNoOpt			= findTestObject('Page_Licensure Unit License Application/Other Licenses/li_Does applicant hold - No')
	private TestObject selectDoesApplicantHoldYesOpt		= findTestObject('Page_Licensure Unit License Application/Other Licenses/li_Does applicant hold - Yes')
	private TestObject buttonNext							= findTestObject('Page_Licensure Unit License Application/Other Licenses/button_Next')
	private TestObject dropdownOutOfStateLicense			= findTestObject('Page_Licensure Unit License Application/Other Licenses/Out of State License dropdown/span_drop-down-Out of State License')
	private TestObject selectOutOfStateLicenseNoOpt			= findTestObject('Page_Licensure Unit License Application/Other Licenses/Out of State License dropdown/li_No')
	private TestObject selectOutOfStateLicenseYesOpt		= findTestObject('Page_Licensure Unit License Application/Other Licenses/Out of State License dropdown/li_Yes')
	private TestObject dropdownDeniedRenewal				= findTestObject('Page_Licensure Unit License Application/Other Licenses/Denied Renewal dropdown/span_dropdown-Denied Renewal')
	private TestObject selectDeniedRenewalNoOpt				= findTestObject('Page_Licensure Unit License Application/Other Licenses/Denied Renewal dropdown/li_No')
	private TestObject selectDeniedRenewalYesOpt			= findTestObject('Page_Licensure Unit License Application/Other Licenses/Denied Renewal dropdown/li_Yes')
	private TestObject dropdownDisciplineSinceLicensed		= findTestObject('Page_Licensure Unit License Application/Other Licenses/Discipline Since Licensed dropdown/span_dropdown-Discipline Since Licensed')
	private TestObject selectDisciplineSinceLicensedNoOpt	= findTestObject('Page_Licensure Unit License Application/Other Licenses/Discipline Since Licensed dropdown/li_No')
	private TestObject selectDisciplineSinceLicensedYesOpt	= findTestObject('Page_Licensure Unit License Application/Other Licenses/Discipline Since Licensed dropdown/li_Yes')




	@Keyword
	def selectIsCurrentlyuPracticing (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Is the applicant currently practicing as a(n) Physical Therapist in another Jurisdiction? '")

		WebUI.waitForElementVisible(dropdownCurrentlyPracticing, 40)

		WebUI.click(dropdownCurrentlyPracticing)

		switch (answer) {
			case "Yes":
				WebUI.click(selectCurrentlyPracticingYesOpt)
				break;

			case "No":
				WebUI.click(selectCurrentlyPracticingNoOpt)
				break;

			default:
				break;
		}

		KeywordUtil.markPassed("An answer was selecte for 'Is the applicant currently practicing as a(n) Physical Therapist in another Jurisdiction?': " + answer)
	}


	@Keyword
	def selectHasEverPracticed (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Has the applicant ever practiced as a(n) Physical Therapist?'")

		WebUI.waitForElementVisible(dropdownEverPracticed, 40)

		WebUI.click(dropdownEverPracticed)

		switch (answer) {
			case "Yes":
				WebUI.click(selectEverPracticedYesOpt)
				break;

			case "No":
				WebUI.click(selectEverPracticedNoOpt)
				break;

			default:
				break;
		}

		KeywordUtil.markPassed("An answer was selecte for 'Has the applicant ever practiced as a(n) Physical Therapist?': " + answer)
	}


	@Keyword
	def selectHasBeenDeniedRight (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Has the applicant ever been denied the right to take a license examination in any State?'")

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(dropdownHasBeenDeniedRight, 40)

			WebUI.click(dropdownHasBeenDeniedRight)

			WebUI.click(selectHasBeenDeniedRightYesOpt)
		} else {
			WebUI.waitForElementVisible(dropdownHasBeenDeniedRight, 40)

			WebUI.click(dropdownHasBeenDeniedRight)

			WebUI.click(selectHasBeenDeniedRightNoOpt)
		}

		KeywordUtil.markPassed("An answer was selecte for 'Has the applicant ever been denied the right to take a license examination in any State?': " + answer)
	}


	@Keyword
	def selectHasBeenDeniedIssuance (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Has the applicant ever been denied the issuance or refused the renewal of a license in any state?'")

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(dropdownHasBeenDeniedIssuance, 40)

			WebUI.click(dropdownHasBeenDeniedIssuance)

			WebUI.click(selectHasBeenDeniedIssuanceYesOpt)
		} else {
			WebUI.waitForElementVisible(dropdownHasBeenDeniedIssuance, 40)

			WebUI.click(dropdownHasBeenDeniedIssuance)

			WebUI.click(selectHasBeenDeniedIssuanceNoOpt)
		}

		KeywordUtil.markPassed("An answer was selecte for 'Has the applicant ever been denied the issuance or refused the renewal of a license in any state?': " + answer)
	}


	@Keyword
	def selectDoesApplicantHold (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Does the applicant hold or has held licenses to provide any health-related services, health services, professional services or environmental services in another state(s)?'")

		if (answer == 'Yes') {
			WebUI.waitForElementVisible(dropdownDoesApplicantHold, 40)

			WebUI.click(dropdownDoesApplicantHold)

			WebUI.click(selectDoesApplicantHoldYesOpt)
		} else {
			WebUI.waitForElementVisible(dropdownDoesApplicantHold, 40)

			WebUI.click(dropdownDoesApplicantHold)

			WebUI.click(selectDoesApplicantHoldNoOpt)
		}

		KeywordUtil.markPassed("An answer was selecte for 'Does the applicant hold or has held licenses to provide any health-related services, health services, professional services or environmental services in another state(s)?': " + answer)
	}


	@Keyword
	def clickOnNextButton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonNext, 40)

		WebUI.click(buttonNext)

		KeywordUtil.markPassed("Next button was clicked")
	}


	@Keyword
	def selectOutofStateLicense (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Did the applicant obtain a license in another state to provide health-related services, health services, professional services, or environmental services?': " + answer)

		WebUI.waitForElementVisible(dropdownOutOfStateLicense, 40)

		WebUI.click(dropdownOutOfStateLicense)

		switch (answer) {
			case "Yes":
				WebUI.click(selectOutOfStateLicenseYesOpt)
				break;

			case "No":
				WebUI.click(selectOutOfStateLicenseNoOpt)
				break;

			default:
				break;
		}

		KeywordUtil.markPassed("An answer was selecte for 'Did the applicant obtain a license in another state to provide health-related services, health services, professional services, or environmental services?': " + answer)
	}


	@Keyword
	def selectDeniedRenewal (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Has the applicant experienced a denial or been refused a renewal for any health-related service, health service, professional service or environmental service license they hold in another state?': " + answer)

		WebUI.waitForElementVisible(dropdownDeniedRenewal, 40)

		WebUI.click(dropdownDeniedRenewal)

		switch (answer) {
			case "Yes":
				WebUI.click(selectDeniedRenewalYesOpt)
				break;

			case "No":
				WebUI.click(selectDeniedRenewalNoOpt)
				break;

			default:
				break;
		}

		KeywordUtil.markPassed("An answer was selecte for 'Has the applicant experienced a denial or been refused a renewal for any health-related service, health service, professional service or environmental service license they hold in another state?': " + answer)
	}


	@Keyword
	def selectDisciplineSinceLicensed (String answer) {
		KeywordUtil.logInfo("Select an answer for 'Has the applicant had discipline applied to any health-related service, health service, professional service or environmental service license they hold in another state?': " + answer)

		WebUI.waitForElementVisible(dropdownDeniedRenewal, 40)

		WebUI.click(dropdownDisciplineSinceLicensed)

		switch (answer) {
			case "Yes":
				WebUI.click(selectDisciplineSinceLicensedYesOpt)
				break;

			case "No":
				WebUI.click(selectDisciplineSinceLicensedNoOpt)
				break;

			default:
				break;
		}

		KeywordUtil.markPassed("An answer was selecte for 'Has the applicant had discipline applied to any health-related service, health service, professional service or environmental service license they hold in another state?': " + answer)
	}
}

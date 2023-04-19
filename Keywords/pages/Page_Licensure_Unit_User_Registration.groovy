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
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class Page_Licensure_Unit_User_Registration {

	private TestObject inputFirstName 				= findTestObject('Page_Licensure Unit User Registration/input_First Name')
	private TestObject inputLastName 				= findTestObject('Page_Licensure Unit User Registration/input_Last Name')
	private TestObject inputAKA 					= findTestObject('Page_Licensure Unit User Registration/input_AKA')
	private TestObject inputDOB 					= findTestObject('Page_Licensure Unit User Registration/input_Date of Birth')
	private TestObject inputPlaceOfBirth 			= findTestObject('Page_Licensure Unit User Registration/input_Place of Birth')
	private TestObject selectCountry 				= findTestObject('Page_Licensure Unit User Registration/Select Country/span_Select Country-arrow')
	private TestObject selectCountry_USOpt 			= findTestObject('Page_Licensure Unit User Registration/Select Country/li_United States')
	private TestObject selectCountry_UruguayOpt		= findTestObject('Page_Licensure Unit User Registration/Select Country/span_Uruguay')
	private TestObject selectCountry_CanadaOpt		= findTestObject('Page_Licensure Unit User Registration/Select Country/li_Canada')
	private TestObject selectUSCitizen 				= findTestObject('Page_Licensure Unit User Registration/Select Are you a US Citizen/span_Select US Citizen-arrow')
	private TestObject selectUSCitizen_YesOpt 		= findTestObject('Page_Licensure Unit User Registration/Select Are you a US Citizen/li_Yes')
	private TestObject selectUSCitizen_NoOpt 		= findTestObject('Page_Licensure Unit User Registration/Select Are you a US Citizen/li_No')
	private TestObject inputZipCode					= findTestObject('Page_Licensure Unit User Registration/input_Zip Code')
	private TestObject inputAddressLine1			= findTestObject('Page_Licensure Unit User Registration/input_Address Line 1')
	private TestObject inputSSN						= findTestObject('Page_Licensure Unit User Registration/input_SSN')
	private TestObject selectDoYouHaveSSN			= findTestObject('Page_Licensure Unit User Registration/Select Do You have SSN/span_Select Do You Have SSN')
	private TestObject selectDoYouHaveSSN_YesOpt	= findTestObject('Page_Licensure Unit User Registration/Select Do You have SSN/span_YesOpt_DoYouHaveSSN')
	private TestObject selectDoYouHaveSSN_NoOpt		= findTestObject('Page_Licensure Unit User Registration/Select Do You have SSN/span_NoOpt_DoYouHaveSSN')
	private TestObject inputI94						= findTestObject('Page_Licensure Unit User Registration/input_I-94')
	private TestObject inputAlienRegistrationNum	= findTestObject('Page_Licensure Unit User Registration/input_Alien Registration Number')
	private TestObject selectPhoneNumber			= findTestObject('Page_Licensure Unit User Registration/Select Primary Phone Number/span_Select Phone Number Type-arrow')
	private TestObject selectPhoneNumberHome		= findTestObject('Page_Licensure Unit User Registration/Select Primary Phone Number/span_Home')
	private TestObject inputPhoneNumber				= findTestObject('Page_Licensure Unit User Registration/input_Primary Phone Number')
	private TestObject inputEmailAddress			= findTestObject('Page_Licensure Unit User Registration/input_Email Address')
	private TestObject inputRetypeEmailAddress		= findTestObject('Page_Licensure Unit User Registration/input_Retype Email Address')
	private TestObject buttonSubmit					= findTestObject('Page_Licensure Unit User Registration/button_Submit')
	private TestObject msgSubmittedSuccessful		= findTestObject('Page_Licensure Unit User Registration/User has been created - Message/div_Message Registration Completed Successfully')
	private TestObject buttonDialogOk				= findTestObject('Page_Licensure Unit User Registration/User has been created - Message/button_Okay_UserCreated')
	private TestObject msgRegistrationCompleted		= findTestObject('Page_Licensure Unit User Registration/h1_Message Your registration is complete')
	private TestObject selectSameAddress			= findTestObject('Page_Licensure Unit User Registration/Select Same Addresss/span_Select Item_k-icon k-i-arrow-s')
	private TestObject selectSameAddressYes			= findTestObject('Page_Licensure Unit User Registration/Select Same Addresss/li_Yes')
	private TestObject selectSameAddressNo			= findTestObject('Page_Licensure Unit User Registration/Select Same Addresss/li_No')




	@Keyword
	def completeFirstName (String FirstName) {
		KeywordUtil.logInfo("Complete First Name")

		WebUI.waitForElementVisible(inputFirstName, 40)

		WebUI.sendKeys(inputFirstName, FirstName)

		KeywordUtil.markPassed("First Name completed: " + FirstName)
	}


	@Keyword
	def completeLastName (String LastName) {
		KeywordUtil.logInfo("Complete Last Name")

		WebUI.waitForElementVisible(inputLastName, 40)

		WebUI.sendKeys(inputLastName, LastName)

		KeywordUtil.markPassed("Last Name completed: " + LastName)
	}


	@Keyword
	def completeDOB (String DOB) {
		KeywordUtil.logInfo("Complete DOB")

		WebUI.waitForElementVisible(inputDOB, 40)

		WebUI.sendKeys(inputDOB, DOB)

		KeywordUtil.markPassed("DOB was completed: " + DOB)
	}


	@Keyword
	def completeAKA (String AKA) {
		WebUI.waitForElementVisible(inputAKA, 40)

		WebUI.sendKeys(inputAKA, AKA)
	}


	@Keyword
	def completePlaceOfBirth (String PlaceOfBirth) {
		KeywordUtil.logInfo("Complete Place Of Birth")

		WebUI.waitForElementVisible(inputPlaceOfBirth, 40)

		WebUI.sendKeys(inputPlaceOfBirth, PlaceOfBirth)

		KeywordUtil.markPassed("Place Of Birth was completed: " + PlaceOfBirth)
	}


	@Keyword
	def selectCountryEEUU () {
		KeywordUtil.logInfo("Select Country - EEUU")

		WebUI.waitForElementVisible(selectCountry, 40)

		WebUI.click(selectCountry)

		WebUI.click(selectCountry_USOpt)

		KeywordUtil.markPassed("Country was selected: EEUU")
	}


	@Keyword
	def selectCountryUruguay () {
		KeywordUtil.logInfo("Select Country - Uruguay")

		WebUI.waitForElementVisible(selectCountry, 40)

		WebUI.click(selectCountry)

		WebUI.click(selectCountry_UruguayOpt)

		KeywordUtil.markPassed("Country was selected: Uruguay")
	}


	@Keyword
	def selectCountryCanada () {
		KeywordUtil.logInfo("Select Country - Canada")

		WebUI.waitForElementVisible(selectCountry, 40)

		WebUI.click(selectCountry)

		WebUI.click(selectCountry_CanadaOpt)

		KeywordUtil.markPassed("Country was selected: Canada")
	}


	@Keyword
	def selectSameAddress (String sameAddress) {
		KeywordUtil.logInfo("Select " + sameAddress + " for question 'Is the Physical address the same?'")

		WebUI.waitForElementVisible(selectSameAddress, 40)

		WebUI.click(selectSameAddress)

		if (sameAddress == 'Yes') {
			WebUI.click(selectSameAddressYes)
		} else {
			WebUI.click(selectSameAddressNo)
		}

		KeywordUtil.markPassed("Drop-down 'Is the Physical address the same?' was selected: " + sameAddress)
	}


	@Keyword
	def selectUSCitizen (String USCitizen) {
		KeywordUtil.logInfo("Select " + USCitizen + " for question 'Are you a US Citizen?'")

		WebUI.waitForElementVisible(selectUSCitizen, 40)

		WebUI.click(selectUSCitizen)

		if (USCitizen == 'Yes') {
			WebUI.click(selectUSCitizen_YesOpt)
		} else {
			WebUI.click(selectUSCitizen_NoOpt)
		}

		KeywordUtil.markPassed("Drop-down 'Are you a US Citizen?' was selected: " + USCitizen)
	}


	@Keyword
	def selectDoYouHaveSSN (String HaveSSN) {
		KeywordUtil.logInfo("Select " + HaveSSN + " for question 'Do you have a social security number?'")

		WebUI.waitForElementVisible(selectDoYouHaveSSN, 40)

		WebUI.click(selectDoYouHaveSSN)

		if (HaveSSN == 'Yes') {
			WebUI.click(selectDoYouHaveSSN_YesOpt)
		} else {
			WebUI.click(selectDoYouHaveSSN_NoOpt)
		}

		KeywordUtil.markPassed("Drop-down 'Do you have a social security number?' was selected: " + HaveSSN)
	}


	@Keyword
	def completeZipCode (String ZipCode) {
		KeywordUtil.logInfo("Complete Zip Code")

		WebUI.waitForElementVisible(inputZipCode, 40)

		WebUI.sendKeys(inputZipCode, ZipCode)

		KeywordUtil.markPassed("'Zip Code' was completed: " + ZipCode)
	}


	@Keyword
	def completeAddressLine (String AddressLine) {
		KeywordUtil.logInfo("Complete 'ddress Line'")

		WebUI.waitForElementVisible(inputAddressLine1, 40)

		WebUI.sendKeys(inputAddressLine1, AddressLine)

		KeywordUtil.markPassed("'Address Line' was completed: " + AddressLine)
	}


	@Keyword
	def completeSSN (String SSN) {
		KeywordUtil.logInfo("Complete 'Social Security Number'")

		WebUI.waitForElementVisible(inputSSN, 40)

		WebUI.sendKeys(inputSSN, SSN)

		KeywordUtil.markPassed("'Social Security Number' was completed: " + SSN)
	}


	@Keyword
	def completeI94 (String I94) {
		KeywordUtil.logInfo("Complete 'I-94 #'")

		WebUI.waitForElementVisible(inputI94, 40)

		WebUI.sendKeys(inputI94, I94)

		KeywordUtil.markPassed("'I-94 #' was completed: " + I94)
	}


	@Keyword
	def completeAlienRegistrationNum (String AlienRegistrationNum) {
		KeywordUtil.logInfo("Complete 'Alien Registration Number'")

		WebUI.waitForElementVisible(inputAlienRegistrationNum, 40)

		WebUI.sendKeys(inputAlienRegistrationNum, AlienRegistrationNum)

		KeywordUtil.markPassed("'Alien Registration Number' was completed: " + AlienRegistrationNum)
	}


	@Keyword
	def completePrimaryPhoneNumber (String PhoneNumber) {
		KeywordUtil.logInfo("Complete 'Primary Phone Number'")

		WebUI.waitForElementVisible(selectPhoneNumber, 40)

		WebUI.click(selectPhoneNumber)

		WebUI.click(selectPhoneNumberHome)

		WebUI.sendKeys(inputPhoneNumber, PhoneNumber)

		KeywordUtil.markPassed("'Primary Phone Number' was completed: Home - " + PhoneNumber)
	}


	@Keyword
	def completeEmailAddress (String EmailAddress) {
		KeywordUtil.logInfo("Complete 'E-Mail Address'")

		WebUI.waitForElementVisible(inputEmailAddress, 40)

		WebUI.sendKeys(inputEmailAddress, EmailAddress)

		KeywordUtil.markPassed("'E-Mail Address' was completed: " + EmailAddress)
	}


	@Keyword
	def completeRetypeEmailAddress (String EmailAddress) {
		KeywordUtil.logInfo("Complete 'Re-Type E-Mail Address'")

		WebUI.waitForElementVisible(inputRetypeEmailAddress, 40)

		WebUI.sendKeys(inputRetypeEmailAddress, EmailAddress)

		KeywordUtil.markPassed("'Re-Type E-Mail Address' was completed: " + EmailAddress)
	}


	@Keyword
	def clickOnSubmitBtn () {
		KeywordUtil.logInfo("Click on Submit button")

		WebUI.waitForElementVisible(buttonSubmit, 40)

		WebUI.click(buttonSubmit)

		KeywordUtil.markPassed("Submit button was clicked")
	}

	@Keyword
	def verifyRegistrationCompletedSuccessfully () {
		KeywordUtil.logInfo("Verify successful message is displayed")

		WebUI.waitForElementVisible(msgSubmittedSuccessful, 40)

		WebUI.verifyElementText(msgSubmittedSuccessful, 'The user account has been created, and the user has been notified of their login information via email. The record has been saved.', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(buttonDialogOk)

		WebUI.waitForElementVisible(msgRegistrationCompleted, 5)

		if(WebUI.verifyElementText(msgRegistrationCompleted, 'Your registration is complete', FailureHandling.OPTIONAL))	{
			KeywordUtil.markPassed("The successful message was verified correctly: 'The user account has been created, and the user has been notified of their login information via email. The record has been saved.'")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The successful message was not the expected or couldn't be verified")
		}
	}


	@Keyword
	def verifyRegistrationExistingUserCompletedSuccessfully () {
		KeywordUtil.logInfo("Verify successful message is displayed")

		WebUI.waitForElementVisible(msgSubmittedSuccessful, 40)

		if (WebUI.verifyElementText(msgSubmittedSuccessful, 'An existing User record has been found matching the information you have entered. An account has been created for that User Registration record and login credentials have been sent by email.', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The successful message was verified correctly: 'An existing User record has been found matching the information you have entered. An account has been created for that User Registration record and login credentials have been sent by email.'")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The successful message was not the expected or couldn't be verified")
		}

		WebUI.click(buttonDialogOk)
	}


	@Keyword
	def verifyDuplicatedErrorMessage () {
		KeywordUtil.logInfo("Verify error message is displayed for duplicated user")

		WebUI.waitForElementVisible(msgSubmittedSuccessful, 40)

		if (WebUI.verifyElementText(msgSubmittedSuccessful, 'An error was encountered. A record for you already exists in the system based upon one of the key identifying criteria. Please go to https://vv5qa.visualvault.com/ to sign in or use the forgot username/password link. If you need further assistance, please e-mail DHHS.LanceSupport@nebraska.gov.', FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("The error message was verified correctly: 'An error was encountered. A record for you already exists in the system based upon one of the key identifying criteria. Please go to https://vv5qa.visualvault.com/ to sign in or use the forgot username/password link. If you need further assistance, please e-mail DHHS.LanceSupport@nebraska.gov.'")
		} else {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("The error message was not the expected or couldn't be verified")
		}

		WebUI.click(buttonDialogOk)

		WebUI.waitForElementVisible(msgRegistrationCompleted, 5)
	}


	@Keyword
	def verifyResetPasswordURL () {
		String currentUrl = WebUI.getUrl()

		if (currentUrl != 'https://vv5qa.visualvault.com/loginassistance') {
			WebUI.takeFullPageScreenshot()

			KeywordUtil.markFailed("\nThe test case can not be completed. Reset password webpage did not load")
		}
	}


	@Keyword
	def clearFirstNameField () {
		KeywordUtil.logInfo("Clear First Name field")

		WebUI.clearText(inputFirstName)

		KeywordUtil.markPassed("First Name field was cleared")
	}


	@Keyword
	def clearLastNameField () {
		KeywordUtil.logInfo("Clear Last Name field")

		WebUI.clearText(inputLastName)

		KeywordUtil.markPassed("Last Name field was cleared")
	}


	@Keyword
	def clearDOBField () {
		KeywordUtil.logInfo("Clear DOB field")

		WebUI.clearText(inputDOB)

		KeywordUtil.markPassed("DOB field was cleared")
	}


	@Keyword
	def clearSSNField () {
		KeywordUtil.logInfo("Clear SSN field")

		WebUI.clearText(inputSSN)

		KeywordUtil.markPassed("SSN field was cleared")
	}


	@Keyword
	def clearI94Field () {
		KeywordUtil.logInfo("Clear I94# field")

		WebUI.clearText(inputI94)

		KeywordUtil.markPassed("I94# field was cleared")
	}


	@Keyword
	def clearAlienRegistrationNumField () {
		KeywordUtil.logInfo("Clear Alien Registration Number field")

		WebUI.clearText(inputAlienRegistrationNum)

		KeywordUtil.markPassed("Alien Registration Number field was cleared")
	}


	@Keyword
	def clearEmailField () {
		KeywordUtil.logInfo("Clear Email field")

		WebUI.clearText(inputEmailAddress)

		KeywordUtil.markPassed("Email field was cleared")
	}


	@Keyword
	def clearRetypeEmailField () {
		KeywordUtil.logInfo("Clear Retype Email field")

		WebUI.clearText(inputRetypeEmailAddress)

		KeywordUtil.markPassed("Retype Email field was cleared")
	}
}

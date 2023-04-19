package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

import internal.GlobalVariable

public class Page_Licensure_Unit_Individual_Record {


	private TestObject inputFirstName 				= findTestObject('Page_Licensure Unit Individual Record/input_First Name')
	private TestObject inputLastName 				= findTestObject('Page_Licensure Unit Individual Record/input_Last Name')
	private TestObject inputDOB		 				= findTestObject('Page_Licensure Unit Individual Record/input_Date of Birth')
	private TestObject inputPlaceOfBirth			= findTestObject('Page_Licensure Unit Individual Record/input_Place of Birth_Place of Birth')
	private TestObject selectCountry				= findTestObject('Page_Licensure Unit Individual Record/span_Select Country-arrow')
	private TestObject selectCountryUSOpt			= findTestObject('Page_Licensure Unit Individual Record/li_United States')
	private TestObject selectCountryCanadaOpt		= findTestObject('Page_Licensure Unit Individual Record/li_Canada')
	private TestObject selectCountryUruguayOpt		= findTestObject('Page_Licensure Unit Individual Record/li_Uruguay')
	private TestObject inputZipCode	 				= findTestObject('Page_Licensure Unit Individual Record/input_Zip Code')
	private TestObject inputAddressLine1			= findTestObject('Page_Licensure Unit Individual Record/input_Address Line 1')
	private TestObject selectUSCitizen				= findTestObject('Page_Licensure Unit Individual Record/span_Select US Citizen-arrow')
	private TestObject selectUSCitizenYes			= findTestObject('Page_Licensure Unit Individual Record/li_USCitizen_Yes')
	private TestObject selectUSCitizenNo			= findTestObject('Page_Licensure Unit Individual Record/li_USCitizen_No')
	private TestObject inputSSN						= findTestObject('Page_Licensure Unit Individual Record/input_SSN')
	private TestObject inputAlianRegNum				= findTestObject('Page_Licensure Unit Individual Record/input_Alien Registration Number')
	private TestObject inputI94						= findTestObject('Page_Licensure Unit Individual Record/input_I-94')
	private TestObject checkboxNumberOutside1		= findTestObject('Page_Licensure Unit Individual Record/checkbox_Number Outside United States')
	private TestObject selectDoYouHaveSSN			= findTestObject('Page_Licensure Unit Individual Record/span_Select DoYouHaveSSN-arrow')
	private TestObject selectDoYouHaveSSNYes		= findTestObject('Page_Licensure Unit Individual Record/li_USCitizen_Yes')
	private TestObject selectDoYouHaveSSNNo			= findTestObject('Page_Licensure Unit Individual Record/li_USCitizen_No')
	private TestObject checkboxNumOutsideUS1		= findTestObject('Page_Licensure Unit Individual Record/checkbox_Number Outside United States')
	private TestObject selectPrimaryPhoneType		= findTestObject('Page_Licensure Unit Individual Record/span_Select Primary Phone Type-arrow')
	private TestObject selectPrimaryPhoneTypeHome	= findTestObject('Page_Licensure Unit Individual Record/li_Home')
	private TestObject selectPrimaryPhoneTypeMobile	= findTestObject('Page_Licensure Unit Individual Record/li_Mobile')
	private TestObject selectPrimaryPhoneTypeWork	= findTestObject('Page_Licensure Unit Individual Record/li_Work')
	private TestObject selectPrimaryPhoneTypeOther	= findTestObject('Page_Licensure Unit Individual Record/li_Other')
	private TestObject inptuPrimaryPhoneNumber		= findTestObject('Page_Licensure Unit Individual Record/input_Primary Phone Number')
	private TestObject inptuEmailAddress			= findTestObject('Page_Licensure Unit Individual Record/input_E-Mail Address')
	private TestObject inptuRetypeEmailAddress		= findTestObject('Page_Licensure Unit Individual Record/input_Retype Email Address')
	private TestObject buttonSaveAndConfirm			= findTestObject('Page_Licensure Unit Individual Record/button_Save and Confirm')
	private TestObject h5ModalDialogTitle			= findTestObject('Page_Licensure Unit Individual Record/Modal Dialog/h5_Record Created')
	private TestObject buttonModalDialogOk			= findTestObject('Modal Dialog Components/button_Okay')
	private TestObject selectSameAddress			= findTestObject('Page_Licensure Unit Individual Record/Select Same Addresss/span_Select Item_k-icon k-i-arrow-s')
	private TestObject selectSameAddressYes			= findTestObject('Page_Licensure Unit Individual Record/Select Same Addresss/li_Yes')
	private TestObject selectSameAddressNo			= findTestObject('Page_Licensure Unit Individual Record/Select Same Addresss/li_No')




	@Keyword
	def enterFirstName (String FirstName) {
		WebUI.waitForElementVisible(inputFirstName, 40)

		WebUI.sendKeys(inputFirstName, FirstName)
	}


	@Keyword
	def enterLastName (String LastName) {
		WebUI.waitForElementVisible(inputLastName, 40)

		WebUI.sendKeys(inputLastName, LastName)
	}


	@Keyword
	def enterDateOfBirth (String DOB) {
		WebUI.waitForElementVisible(inputDOB, 40)

		WebUI.sendKeys(inputDOB, DOB)
	}


	@Keyword
	def enterPlaceOfBirth (String PlaceOfBirth) {
		WebUI.waitForElementVisible(inputPlaceOfBirth, 40)

		WebUI.sendKeys(inputPlaceOfBirth, PlaceOfBirth)
	}


	@Keyword
	def selectCountryUS () {
		WebUI.waitForElementVisible(selectCountry, 40)

		WebUI.click(selectCountry)

		WebUI.click(selectCountryUSOpt)
	}


	@Keyword
	def selectCountryCanada () {
		WebUI.waitForElementVisible(selectCountry, 40)

		WebUI.click(selectCountry)

		WebUI.click(selectCountryCanadaOpt)
	}


	@Keyword
	def selectCountryUruguay () {
		WebUI.waitForElementVisible(selectCountry, 40)

		WebUI.click(selectCountry)

		WebUI.click(selectCountryUruguayOpt)
	}


	@Keyword
	def enterZipCode (String ZipCode) {
		WebUI.waitForElementVisible(inputZipCode, 40)

		WebUI.sendKeys(inputZipCode, ZipCode)
	}


	@Keyword
	def enterAddressLine1 (String AddressLine) {
		WebUI.waitForElementVisible(inputAddressLine1, 40)

		WebUI.sendKeys(inputAddressLine1, AddressLine)
	}


	@Keyword
	def selectSameAddress (String sameAddress) {
		WebUI.waitForElementVisible(selectSameAddress, 40)

		if (sameAddress == 'Yes') {
			WebUI.click(selectSameAddress)

			WebUI.click(selectSameAddressYes)
		} else {
			WebUI.click(selectSameAddress)

			WebUI.click(selectSameAddressNo)
		}
	}


	@Keyword
	def selectUSCitizen (String USCitizen) {
		WebUI.waitForElementVisible(selectUSCitizen, 0)

		if (USCitizen == 'Yes') {
			WebUI.click(selectUSCitizen)

			WebUI.click(selectUSCitizenYes)
		} else {
			WebUI.click(selectUSCitizen)

			WebUI.click(selectUSCitizenNo)
		}
	}


	@Keyword
	def enterSSN (String SSN) {
		WebUI.waitForElementVisible(inputSSN, 40)

		WebUI.sendKeys(inputSSN, SSN)
	}


	@Keyword
	def selectDoYouHaveSSN (String SSN) {
		WebUI.waitForElementVisible(selectDoYouHaveSSN, 40)

		if (SSN == 'Yes') {
			WebUI.click(selectDoYouHaveSSN)

			WebUI.click(selectDoYouHaveSSNYes)
		} else {
			WebUI.click(selectDoYouHaveSSN)

			WebUI.click(selectDoYouHaveSSNNo)
		}
	}


	@Keyword
	def enterAlienRegisterNumber (String AlienRegNum) {
		WebUI.waitForElementVisible(inputAlianRegNum, 40)

		WebUI.sendKeys(inputAlianRegNum, AlienRegNum)
	}


	@Keyword
	def enterI94 (String I94) {
		WebUI.waitForElementVisible(inputI94, 40)

		WebUI.sendKeys(inputI94, I94)
	}


	@Keyword
	def completePhoneNumber (String PhoneNumber) {
		WebUI.waitForElementVisible(inptuPrimaryPhoneNumber, 40)

		WebUI.click(selectPrimaryPhoneType)

		WebUI.click(selectPrimaryPhoneTypeHome)

		WebUI.sendKeys(inptuPrimaryPhoneNumber, PhoneNumber)
	}


	@Keyword
	def enterEmailAddress (String EmailAddress) {
		WebUI.waitForElementVisible(inptuEmailAddress, 40)

		WebUI.sendKeys(inptuEmailAddress, EmailAddress)
	}


	@Keyword
	def enterRetypeEmailAddress (String EmailAddress) {
		WebUI.waitForElementVisible(inptuRetypeEmailAddress, 40)

		WebUI.sendKeys(inptuRetypeEmailAddress, EmailAddress)
	}


	@Keyword
	def clickOnSaveAndConfirm () {
		WebUI.waitForElementVisible(buttonSaveAndConfirm, 40)

		WebUI.click(buttonSaveAndConfirm)

		WebUI.waitForElementVisible(h5ModalDialogTitle, 40)

		WebUI.verifyElementText(h5ModalDialogTitle, 'Record Created')

		WebUI.click(buttonModalDialogOk)
	}
}

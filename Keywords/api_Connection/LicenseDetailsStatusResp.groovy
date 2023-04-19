package api_Connection

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
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import internal.GlobalVariable

public class LicenseDetailsStatusResp {

	private TestObject requesGetLicenseLookup						= findTestObject('RequestApiInformation/GetLicenseLookupDetailsByProvisionalLicenseName')
	Date today
	String licenseExpirationType


	/*
	 public LicenseLookupResp (String licenseExpirationTypeResp, String dateExpiresResp) {
	 licenseExpirationType = licenseExpirationTypeResp
	 dateExpires = dateExpiresResp
	 }
	 */

	@Keyword
	def verifyOriginalEffectivetDate (Object responseDetailsStatus, String startDate) {

		// Get Effective Date from the License Details Status form
		String effectiveDate = WS.getElementPropertyValue(responseDetailsStatus, 'data[0]["effective Date"]')

		System.out.println('\n\nFull Effective Date: ' + effectiveDate)

		// Split full date in day, month and year
		String[] effectiveDateSplit = effectiveDate.split('-|T')

		String year = effectiveDateSplit[0]
		String month = effectiveDateSplit[1]
		String day = effectiveDateSplit[2]

		// Generate expiration date with correct format
		String simpleEffectiveDate = month + '/' + day + '/' + year

		System.out.println('\nLicense Expiration Date: ' + simpleEffectiveDate + '\n')

		WebUI.verifyMatch(simpleEffectiveDate, startDate, true, FailureHandling.CONTINUE_ON_FAILURE)
	}


	@Keyword
	def verifyOriginalExpirationDate (Object responseDetailsStatus, String endDate) {

		// Get License Expiration Type and Date Expires from the form
		String expirationDate = WS.getElementPropertyValue(responseDetailsStatus, 'data[0]["expiration Date"]')

		System.out.println('\n\nFull Effective Date: ' + expirationDate)

		// Split full date in day, month and year
		String[] expirationDateSplit = expirationDate.split('-|T')

		String year = expirationDateSplit[0]
		String month = expirationDateSplit[1]
		String day = expirationDateSplit[2]

		// Generate expiration date with correct format
		String simpleExpirationDate = month + '/' + day + '/' + year

		System.out.println('\nLicense Expiration Date: ' + simpleExpirationDate + '\n')

		WebUI.verifyMatch(simpleExpirationDate, endDate, true, FailureHandling.CONTINUE_ON_FAILURE)
	}


	@Keyword
	def verifyOriginalStatusReason (Object responseDetailsStatus, String expectedStatusReason) {

		// Get License Expiration Type and Date Expires from the form
		String licenseStatusReason = WS.getElementPropertyValue(responseDetailsStatus, 'data[0]["reason Status was Assigned"]')

		System.out.println('\nLicense Status: ' + licenseStatusReason + '\n')

		WebUI.verifyMatch(licenseStatusReason, expectedStatusReason, true, FailureHandling.CONTINUE_ON_FAILURE)
	}


	@Keyword
	def verifyEffectivetDate (Object responseDetailsStatus, String startDate) {

		// Get Effective Date from the License Details Status form
		String effectiveDate = WS.getElementPropertyValue(responseDetailsStatus, 'data[1]["effective Date"]')

		System.out.println('\nFull Effective Date: ' + effectiveDate + '\n')

		// Split full date in day, month and year
		String[] effectiveDateSplit = effectiveDate.split('-|T')

		String year = effectiveDateSplit[0]
		String month = effectiveDateSplit[1]
		String day = effectiveDateSplit[2]

		// Generate expiration date with correct format
		String simpleEffectiveDate = month + '/' + day + '/' + year

		System.out.println('\nLicense Expiration Date: ' + simpleEffectiveDate + '\n')

		WebUI.verifyMatch(simpleEffectiveDate, startDate, true, FailureHandling.CONTINUE_ON_FAILURE)
	}


	@Keyword
	def verifyExpirationDate (Object responseDetailsStatus, String endDate) {

		// Get License Expiration Type and Date Expires from the form
		String expirationDate = WS.getElementPropertyValue(responseDetailsStatus, 'data[1]["expiration Date"]')

		System.out.println('\nFull Expiration Date: ' + expirationDate + '\n')

		// Split full date in day, month and year
		String[] expirationDateSplit = expirationDate.split('-|T')

		String year = expirationDateSplit[0]
		String month = expirationDateSplit[1]
		String day = expirationDateSplit[2]

		// Generate expiration date with correct format
		String simpleExpirationDate = month + '/' + day + '/' + year

		System.out.println('\nLicense Expiration Date: ' + simpleExpirationDate + '\n')

		WebUI.verifyMatch(simpleExpirationDate, endDate, true, FailureHandling.CONTINUE_ON_FAILURE)
	}


	@Keyword
	def verifyStatus (Object responseDetailsStatus, String expectedStatus) {

		// Get License Expiration Type and Date Expires from the form
		String licenseStatus = WS.getElementPropertyValue(responseDetailsStatus, 'data[1]["license Status"]')

		System.out.println('\nLicense Status: ' + licenseStatus + '\n')

		WebUI.verifyMatch(licenseStatus, expectedStatus, true, FailureHandling.CONTINUE_ON_FAILURE)
	}
}

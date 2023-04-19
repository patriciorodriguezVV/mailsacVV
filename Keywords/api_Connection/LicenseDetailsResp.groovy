//package api_Connection
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
import com.kms.katalon.core.testobject.ResponseObject

public class LicenseDetailsResp {

	private TestObject requesGetLicenseDetails						= findTestObject('RequestApiInformation/GetLicenseDetails')

	//Not used
	/*
	 @Keyword
	 def getLicenseDetails () {
	 // Get License Lookup Details for a specific License Type
	 Object responseLicenseDetails = WS.sendRequest(requesGetLicenseDetails)
	 // Verify Request was completed correctly
	 WS.verifyResponseStatusCode(responseLicenseDetails, 200)
	 return responseLicenseDetails
	 }
	 */


	@Keyword
	def verifyExpirationDate (Object responseLicenseDetails, String expectedExpirationDate) {

		// Assign the expirationDate from the License Details to the variables
		String fullLicenseExpirationDate = WS.getElementPropertyValue(responseLicenseDetails, 'data[0]["expiration Date"]')

		System.out.println('\n\nFull License Expiration Date: ' + fullLicenseExpirationDate)

		// Split full date in day, month and year
		String[] expirationDateSplit = fullLicenseExpirationDate.split('-|T')

		String year = expirationDateSplit[0]
		String month = expirationDateSplit[1]
		String day = expirationDateSplit[2]

		// Generate expiration date with correct format
		String licenseExpirationDate = month + '/' + day + '/' + year

		System.out.println('\n\nLicense Expiration Date: ' + licenseExpirationDate)

		// Verify issue date is same as today date
		WebUI.verifyMatch(licenseExpirationDate, expectedExpirationDate, true, FailureHandling.CONTINUE_ON_FAILURE)
	}


	@Keyword
	def verifyIssueDate (Object responseLicenseDetails) {

		// Assign the expirationDate from the License Details to the variables
		String fullIssueDate = WS.getElementPropertyValue(responseLicenseDetails, 'data[0]["issue Date"]')

		System.out.println('\n\nFull Issue Date: ' + fullIssueDate)

		// Split full date in day, month and year
		String[] expirationDateSplit = fullIssueDate.split('-|T')

		String year = expirationDateSplit[0]
		String month = expirationDateSplit[1]
		String day = expirationDateSplit[2]

		// Generate expiration date with correct format
		String issueDate = month + '/' + day + '/' + year

		System.out.println('\n\nIssue Date: ' + issueDate)


		// Get today's date
		Date today = Calendar.getInstance().getTime()

		// Create a date "formatter" (the date format we want)
		SimpleDateFormat formatter = new SimpleDateFormat('MM/dd/YYYY')

		// Create a new String using the date format we want
		String simpleTodayDate = formatter.format(today)

		System.out.println('\n\nToday Date: ' + simpleTodayDate)


		// Verify issue date is same as today date
		WebUI.verifyMatch(issueDate, simpleTodayDate, true, FailureHandling.CONTINUE_ON_FAILURE)
	}


	@Keyword
	def verifyEffectiveDate (Object responseLicenseDetails) {

		// Assign the expirationDate from the License Details to the variables
		String fullEffectiveDate = WS.getElementPropertyValue(responseLicenseDetails, 'data[0]["effective Date"]')

		System.out.println('\n\nFull Effective Date: ' + fullEffectiveDate)

		// Split full date in day, month and year
		String[] expirationDateSplit = fullEffectiveDate.split('-|T')

		String year = expirationDateSplit[0]
		String month = expirationDateSplit[1]
		String day = expirationDateSplit[2]

		// Generate expiration date with correct format
		String effectiveDate = month + '/' + day + '/' + year

		System.out.println('\nEffective Date: ' + effectiveDate + '\n')


		// Get today's date
		Date today = Calendar.getInstance().getTime()

		// Create a date "formatter" (the date format we want)
		SimpleDateFormat formatter = new SimpleDateFormat('MM/dd/YYYY')

		// Create a new String using the date format we want
		String simpleTodayDate = formatter.format(today)

		System.out.println('\nToday Date: ' + simpleTodayDate + '\n')


		// Verify issue date is same as today date
		WebUI.verifyMatch(effectiveDate, simpleTodayDate, true, FailureHandling.CONTINUE_ON_FAILURE)
	}


	@Keyword
	def getIssueDate (ResponseObject responseLicenseDetails) {

		// Assign the expirationDate from the License Details to the variables
		String fullIssueDate = WS.getElementPropertyValue(responseLicenseDetails, 'data[0]["issue Date"]')

		System.out.println('\n\nFull Issue Date: ' + fullIssueDate)

		// Split full date in day, month and year
		String[] expirationDateSplit = fullIssueDate.split('-|T')

		String year = expirationDateSplit[0]
		String month = expirationDateSplit[1]
		String day = expirationDateSplit[2]

		// Generate expiration date with correct format
		String issueDate = month + '/' + day + '/' + year

		System.out.println('\nIssue Date: ' + issueDate+ '\n')


		// Verify issue date is same as today date
		return issueDate
	}


	@Keyword
	def getLicenseId (Object responseLicenseDetails) {

		// Assign the License Id from the License Details to the variables
		String licenseId = WS.getElementPropertyValue(responseLicenseDetails, 'data[0]["license ID"]')

		System.out.println('\nLicenseId: ' + licenseId + '\n')

		// Return License Id
		return licenseId
	}
}

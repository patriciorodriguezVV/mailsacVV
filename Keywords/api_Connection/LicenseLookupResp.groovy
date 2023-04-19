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

public class LicenseLookupResp {

	private TestObject requesGetLicenseLookup						= findTestObject('RequestApiInformation/GetLicenseLookupDetailsByProvisionalLicenseName')
	Date today
	String licenseExpirationType
	String dateExpires
	String simpleTodayDate
	String [] todayDate
	String expirationDate
	SimpleDateFormat formatter
	int expiredYear
	int currentYear

	/*
	 public LicenseLookupResp (String licenseExpirationTypeResp, String dateExpiresResp) {
	 licenseExpirationType = licenseExpirationTypeResp
	 dateExpires = dateExpiresResp
	 }
	 */


	@Keyword
	def getLicenseLookupDetails () {
		// Get License Lookup Details for a specific License Type
		ResponseObject responseLicenseLookup = WS.sendRequest(requesGetLicenseLookup)

		// Verify Request was completed correctly
		WS.verifyResponseStatusCode(responseLicenseLookup, 200)

		return responseLicenseLookup
	}


	@Keyword
	def calculateExpirationDate (ResponseObject responseLincenseLookup, String issueDate) {

		// Get License Expiration Type and Date Expires from the form
		String licenseExpirationType = WS.getElementPropertyValue(responseLincenseLookup, 'data[0]["license Expiration Type"]')

		String licenseDateExpires = WS.getElementPropertyValue(responseLincenseLookup, 'data[0]["date Expires"]')

		System.out.println('\nLicense Expiration Type: ' + licenseExpirationType + '\nLicense Expires: ' + licenseDateExpires + '\n')

		// Split date
		todayDate = issueDate.split('/')

		// Set Year
		currentYear = Integer.parseInt(todayDate[2])



		//verify if current year is odd or even
		if (currentYear % 2 == 0){
			if (licenseExpirationType == 'Expires in Odd Years') {
				// If current year is Even and it Expires in Odd Years, plus 1 year
				expiredYear = currentYear + 1
			} else {
				// If current year is Even and it Expires in Even Years, plus 0 year
				expiredYear = currentYear + 0
			}
		}else{
			if (licenseExpirationType == 'Expires in Odd Years') {
				// If current year is Odd and it Expires in Odd Years, plus 0 year
				expiredYear = currentYear + 0
			} else {
				expiredYear = currentYear + 1
				// If current year is Odd and it Expires in Even Years, plus 1 year
			}
		}

		expirationDate = licenseDateExpires + '/' + expiredYear

		System.out.println(expirationDate)

		return expirationDate
	}


}

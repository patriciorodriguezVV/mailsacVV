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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.JsonSlurper as JsonSlurper

import internal.GlobalVariable

public class IndividualRecordResp {

	@Keyword
	def getApplicantEmail (Object individualRecordResp) {

		// Assign the License Id from the License Details to the variables
		String applicantEmail = WS.getElementPropertyValue(individualRecordResp, 'data[0]["email Address"]')

		// Return record id
		return applicantEmail
	}
	
	@Keyword
	def verifyUniqueIndividualRecord (Object individualRecordResp) {

		String currentSize = WS.getElementsCount(individualRecordResp, 'data')
		
		String expectedSize = '1'
		
		WebUI.verifyMatch(currentSize, expectedSize, false, FailureHandling.CONTINUE_ON_FAILURE)
	}
}
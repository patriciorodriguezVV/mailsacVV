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

import internal.GlobalVariable
import groovy.json.JsonSlurper

public class DenialEventRecordRes {

	@Keyword
	def getDenialEventRecordData (ResponseObject denialEventRecordRes) {

		// Assign the data from the Denial Event Record to the variables
		String denialEventRecordObj = denialEventRecordRes.getResponseBodyContent()

		// Return Denial Event Record data
		return denialEventRecordObj
	}

	@Keyword
	def getDenialEventRecordRevisionId (ResponseObject denialEventRecordRes) {

		// Assign the Revision ID from the Denial Event Record to the variables
		String revisionIdObj = WS.getElementPropertyValue(denialEventRecordRes, 'data[0]["revisionId"]')

		// Return Denial Event Record Revision ID
		return revisionIdObj
	}

	@Keyword
	def getDenialEventRecordDenialDate (ResponseObject denialEventRecordRes) {

		// Assign the Denial Date from the Denial Event Record to the variables
		String denialDateObj = WS.getElementPropertyValue(denialEventRecordRes, 'data[0]["date of Denial"]')

		// Return Denial Event Record Date of Denial
		return denialDateObj
	}
}
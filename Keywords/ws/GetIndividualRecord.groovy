package ws

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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


import internal.GlobalVariable

public class GetIndividualRecord {

	// Endpoint variables
	String baseUrl = GlobalVariable.G_BaseUrl
	String individualRecordDetailsID = "0dcac7d7-219b-ec11-a9d8-a898949011e1"

	// Request variables
	String requestMethod = "GET"
	String authHeader = "Bearer " + GlobalVariable.G_Token

	TestObjectProperty header1 = new TestObjectProperty("Authorization", ConditionType.EQUALS, authHeader)
	TestObjectProperty header2 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
	TestObjectProperty header3 = new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json")
	ArrayList defaultHeaders = Arrays.asList(header1, header2, header3)

	/**
	 * GET requests
	 * @return
	 */
	public ResponseObject getIndividualRecord() {
		RequestObject ro = new RestRequestObjectBuilder()
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod(requestMethod)
				.build()

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	public ResponseObject getIndividualRecordByApplicantFirstName(String firstName) {
		String endpoint = baseUrl + "/formtemplates/" + individualRecordDetailsID + "/forms?q=[First+Name]+eq+'" + firstName + "'&expand=true"

		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(endpoint)
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod(requestMethod)
				.build()

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}

	public static int getStatusCode(ResponseObject resp) {
		return resp.getStatusCode()
	}
	public static String getResponseText(ResponseObject resp) {
		return resp.getResponseText()
	}
	public static long getResponseBodySize(ResponseObject resp) {
		return resp.getResponseBodySize()
	}
	public static long getResponseHeaderSize(ResponseObject resp) {
		return resp.getResponseHeaderSize()
	}
	public static long getWaitingTime(ResponseObject resp) {
		return resp.getWaitingTime()
	}
}
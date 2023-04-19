package ws

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable


public class GetLicenseDetails {
	// Endpoint variables
	String baseUrl = GlobalVariable.G_BaseUrl
	String licenseDetailsID = "04c45495-559a-ec11-a9d8-a898949011e1"
	String applicantFirstName = ""

	// Request variables
	String endpoint = baseUrl + "/formtemplates/" + licenseDetailsID + "/forms?q=[First+Name]+eq+'" + applicantFirstName + "'&expand=true"
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
	public ResponseObject getLicenseDetails() {
		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(endpoint)
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod(requestMethod)
				.build()

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	public ResponseObject getLicenseDetailsByApplicantFirstName(String firstName) {
		String endpoint1 = baseUrl + "/formtemplates/" + licenseDetailsID + "/forms?q=[First+Name]+eq+'" + firstName + "'&expand=true"

		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(endpoint1)
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
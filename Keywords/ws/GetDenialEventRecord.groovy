package ws

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable


public class GetDenialEventRecord {
	// Endpoint variables
	String baseUrl = GlobalVariable.G_BaseUrl
	String denialEventRecordID = "2cf4d0f6-b28a-ec11-a9d7-a8692667873e"

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
	public ResponseObject getDenialEventRecord() {
		RequestObject ro = new RestRequestObjectBuilder()
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod(requestMethod)
				.build()

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	public ResponseObject getDenialEventRecordByDenialCode(String denialCode) {
		String endpoint = baseUrl + "/formtemplates/" + denialEventRecordID + "/forms?q=[denial+Code]+eq+'" + denialCode + "'&expand=true"

		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(endpoint)
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod(requestMethod)
				.build()

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}

	// Handling methods
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
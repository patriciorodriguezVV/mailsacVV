package ws

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

import com.kms.katalon.core.testobject.UrlEncodedBodyParameter


public class GetToken {

	// Request variables
	String endpoint = GlobalVariable.G_EndpointAccessToken
	String requestMethod = "POST"
	//String authHeader = "Basic MDNhYjViM2MtYWJlZS00MTg4LWE5ZjItYmNmOTNkMjQ2N2FhOmg0STJSS1VYQnFBY05GVHFMN1ZEc3JQTk1VbVVLTVF5SklEWG05dlhXMW89"

	//TestObjectProperty header1 = new TestObjectProperty("Authorization", ConditionType.EQUALS, authHeader)
	TestObjectProperty header1 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded")
	ArrayList defaultHeaders = Arrays.asList(header1)

	//Esto no lo pude hacer andar
	UrlEncodedBodyParameter body1 = new UrlEncodedBodyParameter("grant_type", "password")
	UrlEncodedBodyParameter body2 = new UrlEncodedBodyParameter("username", "03ab5b3c-abee-4188-a9f2-bcf93d2467aa")
	UrlEncodedBodyParameter body3 = new UrlEncodedBodyParameter("password", "h4I2RKUXBqAcNFTqL7VDsrPNMUmUKMQyJIDXm9vXW1o=")
	UrlEncodedBodyParameter body4 = new UrlEncodedBodyParameter("client_id", "03ab5b3c-abee-4188-a9f2-bcf93d2467aa")
	UrlEncodedBodyParameter body5 = new UrlEncodedBodyParameter("client_secret", "h4I2RKUXBqAcNFTqL7VDsrPNMUmUKMQyJIDXm9vXW1o=")
	ArrayList defaultBody = Arrays.asList(body1, body2, body3, body4, body5)


	/**
	 * POST requests
	 * @return
	 */
	public ResponseObject getToken1() {
		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(endpoint)
				.withHttpHeaders(defaultHeaders)
				.withUrlEncodedBodyContent(defaultBody)
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
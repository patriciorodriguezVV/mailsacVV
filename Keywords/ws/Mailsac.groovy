package ws

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable


public class Mailsac {
	// Endpoint variables
	String baseUrl = GlobalVariable.MailsacBaseUrl

	// Request variables
	String requestMethodGET = "GET"
	String requestMethodDELETE = "DELETE"
	String authHeader = GlobalVariable.MailsacKey

	TestObjectProperty header1 = new TestObjectProperty("Mailsac-Key", ConditionType.EQUALS, authHeader)
	ArrayList defaultHeaders = Arrays.asList(header1)

	/**
	 * GET requests
	 * @return
	 */

	public ResponseObject getListMessagesByEmail(String email) {
		String endpoint = baseUrl + "/api/addresses/" + email + "/messages"

		print '\n' + endpoint + '\n'

		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(endpoint)
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod(requestMethodGET)
				.build()

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	public ResponseObject gettMessagesById(String email, messageId) {
		String endpoint = baseUrl + "/api/addresses/" + email + "/messages/" + messageId

		print endpoint

		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(endpoint)
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod(requestMethodGET)
				.build()

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}


	/**
	 * DELETE requests
	 * @return
	 */

	public ResponseObject DeleteMessagesByEmail(String email) {
		String endpoint = baseUrl + "/api/addresses/" + email + "/messages"

		print endpoint

		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(endpoint)
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod(requestMethodDELETE)
				.build()

		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}

	public ResponseObject DeleteMessagesById(String email, id) {
		String endpoint = baseUrl + "/api/addresses/" + email + "/messages/" + id

		print endpoint

		RequestObject ro = new RestRequestObjectBuilder()
				.withRestUrl(endpoint)
				.withHttpHeaders(defaultHeaders)
				.withRestRequestMethod(requestMethodDELETE)
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
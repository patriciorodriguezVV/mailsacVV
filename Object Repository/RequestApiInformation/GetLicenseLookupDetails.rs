<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetLicenseLookupDetails</name>
   <tag></tag>
   <elementGuidId>ee1295a2-37b8-44bb-8dfb-eb209bae1e4e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer 38JweiykBC-7X6AOhElADw_FZXPc6RVePHpSajhHM5cIIhrUnuQEjSdj5kfyJ_wAj4tCBTbqUXeKpKBgXyscAs7-4g6Nt4sOfKUade0bQqs4WTtb33_nSSK3mv4iwpndBF1mmKJ_uOJrp13l-u0_7SMVtwVmOnOlOqgtF94e5CexGqJNKe4FYo1d4H3xSlm_r062jSdWzf8sl6t89g875snyCkBKQxEy_SLL7-xKyuMSKbpiDxRGQa6ibSdK6sUJLyiiqVrWDs7PiqAl_hhS5qAX5-3wRW5hmq0ElI-uKlzKdxiNjc2qu6sq16KZ4Y1sHhbz4zuowv0sR3RJxOOLGMjAlYMOXPhTT8h3mKQ4wHzb6ZBl</value>
   </httpHeaderProperties>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${baseUrl}/formtemplates/${formId}/forms</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'https://vv5qa.visualvault.com/api/v1/NEDHHS/LIS'</defaultValue>
      <description></description>
      <id>aed7893f-1e43-4fd2-a074-7225c960023a</id>
      <masked>false</masked>
      <name>baseUrl</name>
   </variables>
   <variables>
      <defaultValue>'c84de965-197a-ec11-a9d6-e507991dbdb7'</defaultValue>
      <description></description>
      <id>a56ffc08-0641-4e2e-9ad5-9141c8b2dfd9</id>
      <masked>false</masked>
      <name>formId</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>

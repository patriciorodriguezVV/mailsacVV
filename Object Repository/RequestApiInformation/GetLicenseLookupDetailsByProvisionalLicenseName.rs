<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetLicenseLookupDetailsByProvisionalLicenseName</name>
   <tag></tag>
   <elementGuidId>6ef8c4a6-3913-4262-b22b-648469cb1fe7</elementGuidId>
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
      <value>Bearer T_pjm8DjIVvOMec9tFzD5BcVhwdTkskt_NC8qDqV_nCIN9NeYNMWbqXI9HZH-zjHa6qKuBqyZ0FOtMAnQY9Al7x1INox3usVdymL4VvBLPWu_QYbBYWcqLfTgZ_A2A-0-ejuPnEhfTX9TUJtrWBCcZbp7-GQ8-Bgd8kA5Wew0apGG9cGL515s0DJDuGyFZSBofwHrQfN_FwXlC1HSTdH882QogTOiE1wAw0-Or0QEZIV3hQNJm56nCBNpr0BKIbhSrl2QeliCGmY-CgSnSWutKostvsT9UE8WvZDOUwkW-6quVrI0aJq6wnj2rQsR-f9XWFqsJwVk01LcKSIPSDzCxL_VaQxJ90FyKLBediqR_pFk3NW</value>
   </httpHeaderProperties>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${baseUrl}/formtemplates/${formId}/forms?q=[Provisional License Name] eq 'EO 21-18 Prov Physical Therapist'&amp;expand=true</restUrl>
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

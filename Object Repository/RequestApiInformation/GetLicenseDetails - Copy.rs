<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetLicenseDetails - Copy</name>
   <tag></tag>
   <elementGuidId>d2d50229-d0ab-45ac-a444-1eed93a407a5</elementGuidId>
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
      <value>Bearer _DiGarTG_QNqytB14mmh8Ae-ipcNz4r77vIfkw2qpddzk9SylGMd5fUpg6_rwqrPu0Ieldi2W19IiWpQsfwjY9HGbWgd-IxPy01RHGTLU1xQ6e3SkReSIgG9wKp_42r11VJ5Q5ytDkoUdqmK77erzCvzXNzdhmSnnPiQZMG5Pv3Yf9nbe2-ZPFnvh-ItlVZP1xrZJIKR272H_KQhTSMw1x2khXnwHxCaq6uxf1XHW2olasKRZZFAvVOJVLXlm1aOruyGqU7Hvqs7epH6Arnb-FCHlzNv5UC0chD-cnlQ_wvH_Bzn0kcZr7ADcle_OnVRxBe5Af-1-pCDpR3DgvjfZXuiC0SJcqGrsRes-_fZBuogBoTk</value>
   </httpHeaderProperties>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${baseUrl}/formtemplates/${formId}/forms?q=[status] eq 'Active'&amp;expand=true</restUrl>
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
      <defaultValue>'2553239d-2c7d-ec11-a9d6-e507991dbdb7'</defaultValue>
      <description></description>
      <id>a56ffc08-0641-4e2e-9ad5-9141c8b2dfd9</id>
      <masked>false</masked>
      <name>formId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.G_Applicant_FirstName</defaultValue>
      <description></description>
      <id>6d69f191-ba12-4075-9ee7-61140520a44e</id>
      <masked>false</masked>
      <name>applicantFirstName</name>
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

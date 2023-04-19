package pages


/******************************
 Import classes and libs needed
 *******************************/

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.support.FindBy
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.thoughtworks.selenium.webdriven.commands.Click
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable


public class Page_Licensure_Unit_License_Application_Checklist {


	/************************
	 Configure objects needed
	 *************************/

	private TestObject buttonApplicationApprove		= findTestObject('Page_Licensure Unit License Application/Checklist/button_Application Approve')
	private TestObject linkTask1					= findTestObject('Page_Licensure Unit License Application/Checklist/Open Links for Checklist Tasks/a_Open Task1')
	private TestObject linkTask2					= findTestObject('Page_Licensure Unit License Application/Checklist/Open Links for Checklist Tasks/a_Open Task2')
	private TestObject linkTask3					= findTestObject('Page_Licensure Unit License Application/Checklist/Open Links for Checklist Tasks/a_Open Task3')
	private TestObject linkTask4					= findTestObject('Page_Licensure Unit License Application/Checklist/Open Links for Checklist Tasks/a_Open Task4')
	private TestObject linkTask5					= findTestObject('Page_Licensure Unit License Application/Checklist/Open Links for Checklist Tasks/a_Open Task5')
	private TestObject linkTask6					= findTestObject('Page_Licensure Unit License Application/Checklist/Open Links for Checklist Tasks/a_Open Task6')
	private TestObject linkTask7					= findTestObject('Page_Licensure Unit License Application/Checklist/Open Links for Checklist Tasks/a_Open Task7')
	private TestObject linkTask8					= findTestObject('Page_Licensure Unit License Application/Checklist/Open Links for Checklist Tasks/a_Open Task8')


	/*********************
	 Configurable Keywords
	 **********************/

	@Keyword
	def clickOnTask (String taskNum, String taskName) {

		switch (taskNum) {

			case 'Task1':
				KeywordUtil.logInfo('Click on Open button for task: ' + taskName)

				WebUI.waitForElementVisible(linkTask1, 40)

				WebUI.click(linkTask1)

				KeywordUtil.markPassed("Open button was clicked for: " + taskName)
				break

			case 'Task2':
				KeywordUtil.logInfo("Click on Open button for task: " + taskName)

				WebUI.waitForElementVisible(linkTask2, 40)

				WebUI.click(linkTask2)

				KeywordUtil.markPassed("Open button was clicked for: " + taskName)
				break

			case 'Task3':
				KeywordUtil.logInfo("Click on Open button for task: " + taskName)

				WebUI.waitForElementVisible(linkTask3, 40)

				WebUI.click(linkTask3)

				KeywordUtil.markPassed("Open button was clicked for: " + taskName)
				break

			case 'Task4':
				KeywordUtil.logInfo("Click on Open button for task: " + taskName)

				WebUI.waitForElementVisible(linkTask4, 40)

				WebUI.click(linkTask4)

				KeywordUtil.markPassed("Open button was clicked for: " + taskName)
				break

			case 'Task5':
				KeywordUtil.logInfo("Click on Open button for task: " + taskName)

				WebUI.waitForElementVisible(linkTask5, 40)

				WebUI.click(linkTask5)

				KeywordUtil.markPassed("Open button was clicked for: " + taskName)
				break

			case 'Task6':
				KeywordUtil.logInfo("Click on Open button for task: " + taskName)

				WebUI.waitForElementVisible(linkTask6, 40)

				WebUI.click(linkTask6)

				KeywordUtil.markPassed("Open button was clicked for: " + taskName)
				break

			case 'Task7':
				KeywordUtil.logInfo("Click on Open button for task: " + taskName)

				WebUI.waitForElementVisible(linkTask7, 40)

				WebUI.click(linkTask7)

				KeywordUtil.markPassed("Open button was clicked for: " + taskName)
				break

			case 'Task8':
				KeywordUtil.logInfo("Click on Open button for task: " + taskName)

				WebUI.waitForElementVisible(linkTask8, 40)

				WebUI.click(linkTask8)

				KeywordUtil.markPassed("Open button was clicked for: " + taskName)
				break
		}
	}

	@Keyword
	def clickOnApplicationApprove () {
		KeywordUtil.logInfo("Click on Application Approve button")

		WebUI.waitForElementVisible(buttonApplicationApprove, 40)

		WebUI.click(buttonApplicationApprove)

		KeywordUtil.markPassed("Application Approve button was clicked")
	}
}

package pages

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

public class Page_Licensure_Unit_Disciplinary_or_Licensure_Event {


	private TestObject inputSummaryOfEvent						= findTestObject('Licensure Unit Disciplinary or Licensure Event/Event Details/input_Summary of Event')
	private TestObject dropdownEventType						= findTestObject('Licensure Unit Disciplinary or Licensure Event/Event Details/Dropdown Event Type/span_Event Type-arrow')
	private TestObject dropdownEventTypeFacilityOpt				= findTestObject('Licensure Unit Disciplinary or Licensure Event/Event Details/Dropdown Event Type/li_Facility')
	private TestObject dropdownEventTypeOrganizationOpt			= findTestObject('Licensure Unit Disciplinary or Licensure Event/Event Details/Dropdown Event Type/li_Organization')
	private TestObject dropdownEventTypeProfessionalOpt			= findTestObject('Licensure Unit Disciplinary or Licensure Event/Event Details/Dropdown Event Type/li_Professional')
	private TestObject inputEstimatedDateOfEvent				= findTestObject('Licensure Unit Disciplinary or Licensure Event/Tab Details/input_Estimated Date of Event')
	private TestObject inputEffectiveDate						= findTestObject('Licensure Unit Disciplinary or Licensure Event/Tab Details/input_Effective Date')
	private TestObject inputDateEnded							= findTestObject('Licensure Unit Disciplinary or Licensure Event/Tab Details/input_Date Ended')
	private TestObject testareaDescriptionOfEvent				= findTestObject('Licensure Unit Disciplinary or Licensure Event/Tab Details/textarea_Description of Event')
	private TestObject inputDocketNum							= findTestObject('Licensure Unit Disciplinary or Licensure Event/Tab Details/input_Docket Number')
	private TestObject inputCaseNum								= findTestObject('Licensure Unit Disciplinary or Licensure Event/Tab Details/input_Case Number')
	private TestObject buttonSave								= findTestObject('Licensure Unit Disciplinary or Licensure Event/Tab Details/button_Save')
	private TestObject buttonSaveAndContinue					= findTestObject('Licensure Unit Disciplinary or Licensure Event/Tab Details/button_Save and Continue')
	private TestObject buttonCancelAndContinue					= findTestObject('Licensure Unit Disciplinary or Licensure Event/Tab Details/button_Cancel and Continue')





	@Keyword
	def completeSummaryOfEvent (String summaryOfEvent) {
		KeywordUtil.logInfo("Complete Summary of Event information: " + summaryOfEvent)
		
		WebUI.waitForElementVisible(inputSummaryOfEvent, 40)

		WebUI.sendKeys(inputSummaryOfEvent, summaryOfEvent)
		
		KeywordUtil.markPassed("Summary of Event information was completed: " + summaryOfEvent)
	}


	@Keyword
	def selectEventType (String eventType) {
		KeywordUtil.logInfo("Select Event Type: " + eventType)
		
		WebUI.waitForElementVisible(dropdownEventType, 40)

		WebUI.click(dropdownEventType)

		switch (eventType) {
			case "Facility":
				WebUI.click(dropdownEventTypeFacilityOpt);
				break;

			case "Organization":
				WebUI.click(dropdownEventTypeOrganizationOpt);
				break;

			case "Professional":
				WebUI.click(dropdownEventTypeProfessionalOpt);
				break;

			default:
				break;
		}
		KeywordUtil.markPassed("Event Type was selected correctly: " + eventType)
	}


	@Keyword
	def completeEstimatedDateOfEvent (String estimatedDateofEvent) {
		KeywordUtil.logInfo("Complete estimated Date of Event: " + estimatedDateofEvent)
		
		WebUI.waitForElementVisible(inputEstimatedDateOfEvent, 40)

		WebUI.sendKeys(inputEstimatedDateOfEvent, estimatedDateofEvent)
		
		KeywordUtil.markPassed("Estimated Date of Event was completed: " + estimatedDateofEvent)
	}


	@Keyword
	def completeEffectiveDate (String effectiveDate) {
		KeywordUtil.logInfo("Complete effective Date: " + effectiveDate)
		
		WebUI.waitForElementVisible(inputEffectiveDate, 40)

		WebUI.sendKeys(inputEffectiveDate, effectiveDate)
		
		KeywordUtil.markPassed("Effective Date was completed: " + effectiveDate)
	}

	@Keyword
	def completeDateEnded (String dateEnded) {
		KeywordUtil.logInfo("Complete date ended: " + dateEnded)
		
		WebUI.sendKeys(inputDateEnded, dateEnded)
		
		KeywordUtil.markPassed("Date ended was completed: " + dateEnded)
	}


	@Keyword
	def completeDescriptionOfEvent (String description) {
		KeywordUtil.logInfo("Complete Description of Event: " + description)
		
		WebUI.sendKeys(testareaDescriptionOfEvent, description)
		
		KeywordUtil.markPassed("Description of Event completed: " + description)
	}


	@Keyword
	def completeDocketNum (String docketNum) {
		KeywordUtil.logInfo("Complete Docket Number: " + docketNum)
		
		WebUI.sendKeys(inputDocketNum, docketNum)
		
		KeywordUtil.markPassed("Docket Number completed: " + docketNum)
	}

	@Keyword
	def completeCaseNum (String caseNum) {
		KeywordUtil.logInfo("Complete Case Number: " + caseNum)
		
		WebUI.sendKeys(inputCaseNum, caseNum)
		
		KeywordUtil.markPassed("Case Number completed: " + caseNum)
	}


	@Keyword
	def clickOnSaveBtn () {
		KeywordUtil.logInfo("Click on Save Button")
		
		WebUI.click(buttonSave)
		
		KeywordUtil.markPassed("Save Button was clicked")
	}


	@Keyword
	def clickOnSaveAndContinueBtn () {
		KeywordUtil.logInfo("Click on Save and Continue Button")
		
		WebUI.click(buttonSaveAndContinue)
		
		KeywordUtil.markPassed("Save and Continue Button was clicked")
	}


	@Keyword
	def clickOnCancelAndContinueBtn () {
		KeywordUtil.logInfo("Click on Cancel and Continue Button")
		
		WebUI.click(buttonCancelAndContinue)
		
		KeywordUtil.markPassed("Cancel and Continue Button was clicked")
	}
}

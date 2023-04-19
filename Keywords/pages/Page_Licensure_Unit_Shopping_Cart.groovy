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
import com.kms.katalon.core.webui.constants.CoreWebuiMessageConstants
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.thoughtworks.selenium.webdriven.commands.Click
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class Page_Licensure_Unit_Shopping_Cart {


	private TestObject buttonRefresh						= findTestObject('Page_Licensure Unit Shopping Cart/Repeating Raw Control/button_Refresh')
	private TestObject opt1FeeDescription					= findTestObject('Page_Licensure Unit Shopping Cart/Repeating Raw Control/div_Fee Description Opt1')
	private TestObject opt1FeeAmount						= findTestObject('Page_Licensure Unit Shopping Cart/Repeating Raw Control/td_Fee Amount Opt1')
	private TestObject opt1TotalToPay						= findTestObject('Page_Licensure Unit Shopping Cart/Repeating Raw Control/td_Total to Pay Opt1')
	private TestObject opt1FeeId							= findTestObject('Page_Licensure Unit Shopping Cart/Repeating Raw Control/div_Fee Id Opt1')
	private TestObject buttonCancelAndClose					= findTestObject('Page_Licensure Unit Shopping Cart/button_Cancel and Close')
	private TestObject dropdownPaymentType					= findTestObject('Page_Licensure Unit Shopping Cart/span_Select Payment Type')
	private TestObject optionPaymentTypeCreditCard			= findTestObject('Page_Licensure Unit Shopping Cart/li_Credit Card')
	private TestObject buttonPayOnline						= findTestObject('Page_Licensure Unit Shopping Cart/button_Pay Online')
	private TestObject inputCardFirstName					= findTestObject('Page_Licensure Unit Shopping Cart/input_Cardholder Name_FIRSTNAME')
	private TestObject inputCardLastName					= findTestObject('Page_Licensure Unit Shopping Cart/input_Cardholder Name_LASTNAME')
	private TestObject inputCardNumber						= findTestObject('Page_Licensure Unit Shopping Cart/input_Card Number_ACCT')
	private TestObject inputCardExpMonth					= findTestObject('Page_Licensure Unit Shopping Cart/input__EXPMONTH')
	private TestObject inputCardExpYear						= findTestObject('Page_Licensure Unit Shopping Cart/input__EXPYEAR')
	private TestObject inputCardSecurityCode				= findTestObject('Page_Licensure Unit Shopping Cart/input_Security Code_CSC')
	private TestObject buttonSubmit							= findTestObject('Page_Licensure Unit Shopping Cart/button_Submit')







	@Keyword
	def clickOnRefreshbutton () {
		KeywordUtil.logInfo("Click on Next button")

		WebUI.waitForElementVisible(buttonRefresh, 40)

		WebUI.click(buttonRefresh)

		KeywordUtil.markPassed("Next button was clicked")
	}


	@Keyword
	def verifyOpt1OnRRC (String feeDescription, String feeAmount, String totalToPay, String feeID) {
		KeywordUtil.logInfo("Verify Fee information")

		WebUI.waitForElementVisible(opt1FeeDescription, 40)

		String currentFeeDescription = WebUI.getText(opt1FeeDescription)

		String currentFeeAmount = WebUI.getText(opt1FeeAmount)

		String currentTotalToPay = WebUI.getText(opt1TotalToPay)

		String currentFeeId = WebUI.getText(opt1FeeId)

		if (WebUI.verifyMatch(currentFeeDescription, feeDescription, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Fee Description was verfied correctly: " + feeDescription)
		} else {
			KeywordUtil.markFailed("Fee Description didn't match or couldn't be verified: Expected: " + feeDescription + " - Current: " + currentFeeDescription)
		}


		if (WebUI.verifyMatch(currentFeeAmount, feeAmount, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Fee Amount was verfied correctly: " + feeAmount)
		} else {
			KeywordUtil.markFailed("Fee Amount didn't match or couldn't be verified: Expected: " + feeAmount + " - Current: " + currentFeeAmount)
		}


		if (WebUI.verifyMatch(currentTotalToPay, totalToPay, false, FailureHandling.OPTIONAL)) {
			KeywordUtil.markPassed("Total To Pay was verfied correctly: " + totalToPay)
		} else {
			KeywordUtil.markFailed("Total To Pay didn't match or couldn't be verified: Expected: " + totalToPay + " - Current: " + currentTotalToPay)
		}


		if (WebUI.verifyMatch(currentFeeId, feeID, false, FailureHandling.CONTINUE_ON_FAILURE)) {
			KeywordUtil.markPassed("Fee Id was verfied correctly: " + feeID)
		} else {
			KeywordUtil.markFailed("Fee Id didn't match or couldn't be verified: Expected: " + feeID + " - Current: " + currentFeeId)
		}
	}


	@Keyword
	def clickOnCancelAndClose () {
		KeywordUtil.logInfo("Click on Cancel and Close button")

		WebUI.waitForElementClickable(buttonCancelAndClose, 40)

		WebUI.click(buttonCancelAndClose)

		KeywordUtil.markPassed("Cancel and Close button was clicked")
	}


	@Keyword
	def clickOnPayOnline () {
		KeywordUtil.logInfo("Click on Pay Online button")

		WebUI.waitForElementClickable(buttonPayOnline, 40)

		WebUI.click(buttonPayOnline)

		KeywordUtil.markPassed("Pay Online button was clicked")
	}


	@Keyword
	def clickOnSubmitButton () {
		KeywordUtil.logInfo("Click on Submit button")

		WebUI.waitForElementClickable(buttonSubmit, 40)

		WebUI.click(buttonSubmit)

		KeywordUtil.markPassed("Submit button was clicked")
	}


	@Keyword
	def selectPaymentType (String paymentType) {
		KeywordUtil.logInfo("Select Payment Type")

		WebUI.waitForElementClickable(dropdownPaymentType, 40)

		WebUI.waitForElementVisible(dropdownPaymentType, 40)

		WebUI.click(dropdownPaymentType)


		switch (paymentType) {
			case "Credit Card":
				WebUI.click(optionPaymentTypeCreditCard);
				break;

			default:
				break;
		}

		KeywordUtil.markPassed("Payment Type was selected: " + paymentType)
	}

	@Keyword
	def completeCreditCardInfo (String cardNumber, String cardExpMonth, String cardExpYear, String secCode) {
		KeywordUtil.logInfo("Select Payment Type")

		WebUI.sendKeys(inputCardNumber, cardNumber)

		KeywordUtil.markPassed("Card Number was completed: " + cardNumber)

		WebUI.sendKeys(inputCardExpMonth, cardExpMonth)

		KeywordUtil.markPassed("Card Expiration Month was completed: " + cardExpMonth)

		WebUI.sendKeys(inputCardExpYear, cardExpYear)

		KeywordUtil.markPassed("Card Expiration Year was completed: " + cardExpYear)

		WebUI.sendKeys(inputCardSecurityCode, secCode)

		KeywordUtil.markPassed("Security Code was completed: " + secCode)
	}
}

package generic

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.time.Duration

import internal.GlobalVariable


public class generic_functions {

	public static String randomPastDate(int maxNum, int minNum) {
		//-------------RANDOM DATE------------------
		// get today's date
		Date today = Calendar.getInstance().getTime()

		// set number of days random
		int randomInt = new Random().nextInt(maxNum + 1) + minNum

		// rest the number of days from today
		today = today.minus(randomInt)

		// create a date "formatter" (the date format we want)
		SimpleDateFormat formatter = new SimpleDateFormat('MM/dd/YYYY')

		// create a new String using the date format we want
		String DOB = formatter.format(today)
		return DOB
	}

	public static String randomFutureDate(int daysAfter) {
		//-------------RANDOM DATE------------------
		// get today's date
		Date today = Calendar.getInstance().getTime()

		// set number of days random
		int randomInt = new Random().nextInt((daysAfter - 1) + 1) + 1

		// add the random days from today
		today= today.plus(randomInt)

		// create a date "formatter" (the date format we want)
		SimpleDateFormat formatter = new SimpleDateFormat('MM/dd/YYYY')

		// create a new String using the date format we want
		String DOB = formatter.format(today)
		return DOB
	}


	public static String getTodayDate() {
		// get today's date
		Date today = Calendar.getInstance().getTime()

		// create a date "formatter" (the date format we want)
		SimpleDateFormat formatter = new SimpleDateFormat('MM/dd/YYYY')

		// create a new String using the date format we want
		String todayDate = formatter.format(today)
		return todayDate
	}

	public static String getTodayDatePlusDays(int daysAfter) {
		// get today's date
		Date today = Calendar.getInstance().getTime()

		// add the random days from today
		today= today.plus(daysAfter)

		// create a date "formatter" (the date format we want)
		SimpleDateFormat formatter = new SimpleDateFormat('MM/dd/YYYY')

		// create a new String using the date format we want
		String todayDate = formatter.format(today)
		return todayDate
	}

	public static String getCustomDatePlusCustomDays(String date, int daysFuture) {
		// Parse Instant Date as String to Instant Date format
		Instant instantDate = new SimpleDateFormat("yyyy-MM-dd'T'HH':'mm':'ss'Z'")
				.parse(date)
				.toInstant()

		// Adds custom amount of days to given instant date
		Instant nowPlusCustomDays = instantDate
				.plus(daysFuture, ChronoUnit.DAYS);

		// Create a new String using the new instant date
		String customDatePlusCustomDays = nowPlusCustomDays

		return customDatePlusCustomDays
	}

	public static String getCustomDateMinusCustomDays(String date, int daysPast) {
		// Parse Instant Date as String to Instant Date format
		Instant instantDate = new SimpleDateFormat("yyyy-MM-dd'T'HH':'mm':'ss'Z'")
				.parse(date)
				.toInstant()

		// Adds custom amount of days to given instant date
		Instant nowMinusCustomDays = instantDate
				.minus(Duration.ofDays(daysPast));

		// Create a new String using the new instant date
		String customDateMinusCustomDays = nowMinusCustomDays

		return customDateMinusCustomDays
	}


	public static String randomString(String chars, int length) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			sb.append(chars.charAt(rand.nextInt(chars.length())));
		}
		return sb.toString();
	}
}

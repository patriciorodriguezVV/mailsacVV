import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.Date as Date
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import generic.generic_functions as Generic_functions
import generic.common_functions as Common_functions



//GlobalVariable.G_Applicant_Email = 'patricio.rodriguez+Applicantpptnw@onetree.com'



WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

Common_functions.login(GlobalVariable.G_Admin_Username, GlobalVariable.G_Admin_Pass)

WebUI.navigateToUrl(GlobalVariable.G_UserAdministration_Link)

WebUI.click(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/a_Search Button'))


WebUI.sendKeys(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/Search Options/input_Search Criteria'), 
    GlobalVariable.G_Applicant_Email)

WebUI.click(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/Search Options/input_SearchButton'))

WebUI.verifyElementText(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User List/a_UserId_Result'), 
    GlobalVariable.G_Applicant_Email)

WebUI.click(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User List/a_UserId_Result'))

int currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.verifyElementText(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User Details/span_User Email'), 
    'User Information for: ' + GlobalVariable.G_Applicant_Email)

WebUI.click(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User Details/span_Change Password'))

WebUI.setEncryptedText(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User Details/Change Password/input_New Password'), GlobalVariable.G_ApplicantPass)

WebUI.setEncryptedText(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User Details/Change Password/input_Confirm Password'), GlobalVariable.G_ApplicantPass)

WebUI.click(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User Details/Change Password/input_Save Button'))

WebUI.click(findTestObject('Page_Home_Admin_VisualVault/Page_VisualVault_Control Panel/Page_VisualVault_Control Panel_AdminTools/User Administration/User Details/a_Close Button'))

WebUI.switchToWindowIndex(currentTab)

WebUI.closeBrowser()


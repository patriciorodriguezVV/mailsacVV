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
import ws.GetToken as GetToken
import generic.generic_functions as GenericFunctions
import ws.GetLicenseDetailsStatus as GetLicenseDetailsStatus
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import java.util.Calendar as Calendar
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration



GlobalVariable.G_Applicant_Email = 'pruebas.onetree+Applicanteihin@gmail.com'
GlobalVariable.G_Applicant_FirstName = 'PReihin'
GlobalVariable.G_Applicant_LastName = 'Automationeznne'



// Set TC variables
String projectPath = RunConfiguration.getProjectDir()
String expectedImgDir = projectPath + '/ScreenShots/Expected Screenshots/WalletCardScreenView_TestCloud.png'


// Go to Login Page
WebUI.openBrowser(GlobalVariable.G_Nebraska_Link)

// Login with Applicant user
CustomKeywords.'pages.Page_Login.login'(GlobalVariable.G_Applicant_Email, GlobalVariable.G_ApplicantPass)

// Click on View and Print License 
CustomKeywords.'pages.Page_Applicant_Home.clickOnViewAndPrintLicense'()

System.sleep(1000)

// Move to Next Window
int currentTab = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(currentTab + 1)

// Click on Print Wallet Card button
CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnPrintWalletCardButton'()

WebUI.switchToWindowIndex(currentTab + 2)

System.sleep(25000)

WebUI.waitForPageLoad(30)

// Take screenshot and save Path of img
WebUI.takeFullPageScreenshot()

String currentImgDir = CustomKeywords.'generic.screenshots.getFullPageScreenshot'()

// Compare ScreenShots. First Screenshot is a Correct Example. The second Screenshot is the one taken on the test case
CustomKeywords.'compareImages.compareImages.compareImagesTest'(expectedImgDir, currentImgDir)

// Close all the Tabs and Browser
WebUI.closeWindowIndex(currentTab + 2)

WebUI.switchToWindowIndex(currentTab + 1)

CustomKeywords.'pages.Page_Licensure_Unit_License.clickOnCloseButton'()

CustomKeywords.'pages.ModalDialog.clickOnOkaybutton'()

System.sleep(2000)

WebUI.switchToWindowIndex(currentTab)

WebUI.closeBrowser()


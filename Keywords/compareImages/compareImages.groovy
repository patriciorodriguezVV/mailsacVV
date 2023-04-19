package compareImages;

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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import javax.imageio.ImageIO

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.configuration.RunConfiguration

import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
import ru.yandex.qatools.ashot.comparison.ImageDiff
import ru.yandex.qatools.ashot.comparison.ImageDiffer

import java.awt.Image
import java.awt.Toolkit

import java.awt.image.PixelGrabber

import org.openqa.selenium.By;
import com.kms.katalon.core.logging.KeywordLogger

public class compareImages {

	@Keyword
	def compareImagesTest (String expectedImage, String currentImage) {

		Image image1 = Toolkit.getDefaultToolkit().getImage(expectedImage);

		Image image2 = Toolkit.getDefaultToolkit().getImage(currentImage);

		PixelGrabber grab1 = new PixelGrabber (image1 , 0 ,0,-1,-1,false);

		PixelGrabber grab2 = new PixelGrabber (image2 , 0 ,0,-1,-1,false);

		int [] data1 =  null ;

		if(grab1.grabPixels()) {
			int width = grab1.getWidth();

			int height = grab1.getHeight();

			data1 = new int[width*height];

			data1 = (int[]) grab1.getPixels();
		}


		int [] data2 =  null ;

		if(grab2.grabPixels()){
			int width = grab2.getWidth();

			int height = grab2.getHeight();

			data2 = new int[width*height];

			data2 = (int[]) grab2.getPixels();
		}


		KeywordLogger logger = new KeywordLogger()

		if (java.util.Arrays.equals(data1,data2)==true){
			logger.logPassed('aynı')
		} else {
			BufferedImage expectedImage3 = ImageIO.read(new File(expectedImage))

			BufferedImage expectedImage4 = ImageIO.read(new File(currentImage))

			ImageDiffer imgDiff = new ImageDiffer()

			ImageDiff diff = imgDiff.makeDiff(expectedImage4, expectedImage3)

			BufferedImage diffImage = diff.getDiffImage()

			Path f = Paths.get(System.getProperty("user.dir"))
					.resolve('Screenshots')
					.resolve(currentImage + '_Differences.png')
			ImageIO.write(diff.getMarkedImage(),"PNG", f.toFile())

			System.out.println('\n diffImage path= ' + f + '\n')

			KeywordUtil.markFailed("Obtained screenshot is not equal to the expected screenshot")

			logger.logFailed('farklı')
		}
	}
}
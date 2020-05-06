package ezcontent.qa.base;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import ezcontent.qa.pages.ArticleMapPage;
import ezcontent.qa.pages.LoginPage;
import ezcontent.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ezcontent.qa.util.Wait;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static ezcontent.qa.util.TestUtil.timeStamp;
import static ezcontent.qa.util.TestUtil.timeStampByDate;

public class TestBase {

	public static LoginPage loginpage;
	public static ArticleMapPage articlemapPage;
	public static WebDriver driver;
	public static Properties prop;

	public static ExtentReports extent;
	public static ExtentTest logger;


	

	static String currentDir = System.getProperty("user.dir");
	String configFilePath = currentDir+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator
			+"ezcontent"+File.separator+"qa"+File.separator+"config"+File.separator+"config.properties";

	static String chromeDriverPath = currentDir+File.separator+"driver"+File.separator+"chromedriver.exe" ;
	static String fireFoxDriverPath = currentDir+File.separator+"driver"+File.separator+"geckodriver.exe" ;
	

	public TestBase() {

//		System.out.println("in const of parent ");


		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(configFilePath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void browserLaunch() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {


			WebDriverManager.chromedriver().setup();

			
			driver = new ChromeDriver();



			//ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.addArguments("headless");
			//driver = new ChromeDriver(chromeOptions);

		} else if (browserName.equals("FF")) {
		
			driver = new FirefoxDriver();
			
		} else if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver",chromeDriverPath);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("devurl"));
	}

	public static void browserQuit() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}


	@BeforeClass
	public void setup() throws IOException {
		System.out.println("in test one ");

		browserLaunch();
		loginpage = new LoginPage();
		articlemapPage = new ArticleMapPage();


		ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/learn_automation2"+timeStampByDate()+".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}


	@AfterClass
	public void closeBrowser() {
		browserQuit();
		extent.flush();
	}


	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		System.out.println(result.getName());
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp= TestUtil.captureScreenshot();

			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}/*else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//String temp= TestUtil.captureScreenshot();
			logger.info(result.getName() + result.getStatus());
			logger.pass(result.getThrowable().getMessage());
		}else if(result.getStatus()==ITestResult.SKIP)
		{
			//String temp= TestUtil.captureScreenshot();
			logger.info(result.getName() + result.getStatus());
			logger.skip(result.getThrowable().getMessage());
		}*/



	}
}

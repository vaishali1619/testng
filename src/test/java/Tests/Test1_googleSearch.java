package Tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.googleSearchPage;

public class Test1_googleSearch{

	static WebDriver driver = null; 
	static ExtentReports extent ;
	static ExtentSparkReporter htmlReport;
	static ExtentTest test1 ;

	@BeforeTest
	public void setupDriver() {
		extent= new ExtentReports();
		htmlReport= new ExtentSparkReporter("extentReport.html");
		extent.attachReporter(htmlReport);

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/src/test/resources/BrowserDriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public static void googleSearch(){
		test1 = extent.createTest("google search");
		test1.log(Status.INFO, "Start");
		driver.get("http://www.google.com");
		test1.addScreenCaptureFromBase64String("capture");
		googleSearchPage obj_googleSearchPage = new googleSearchPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		obj_googleSearchPage.setsearchTextBox("search");
		test1.pass("entertext");
	}	
	@AfterTest
	public void teardown() {
		extent.flush();
		driver.close();
	}
}

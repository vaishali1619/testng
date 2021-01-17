package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {

    public static void main(String[] args) throws ClassNotFoundException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter htmlReport = new ExtentSparkReporter("extentReport.html");
        extent.attachReporter(htmlReport);

        ExtentTest test1 = extent.createTest("google search");
        test1.log(Status.INFO, "Start");
        test1.pass("entertext");
        test1.addScreenCaptureFromBase64String("capture");
    }
}

package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {

	JavaUtility jUtil = new JavaUtility();
	String dateTimeStamp = jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
	ExtentReports reports;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test method started");
		
		Reporter.log(methodName+" Test method started");
		
		//Logging every test methods in the Extent Report
		test = reports.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test method successfully executed");
		
		Reporter.log(methodName+" Test method successfully executed");
		
		//Logging the status as PASS for test method passed
		test.log(Status.PASS, methodName+" Test method successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test method failed");
		
		Reporter.log(methodName+" Test method failed");
		
		//Logging the status as FAIL for test method failed
		test.log(Status.FAIL, methodName+" Test method failed");
		
		//Logging the INFO for test method failed about its Throwable message
		test.log(Status.INFO, result.getThrowable());
		
		//Taking webpage screenshot
		String screenshotName = methodName+"-"+dateTimeStamp;
		SeleniumUtility sUtil = new SeleniumUtility();
		try {
			String path = sUtil.getWebpageScreenshot(BaseClass.sDriver, screenshotName);
			//Attaching screenshot to the report for the failed test method
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Test method skipped");
		
		Reporter.log(methodName+" Test method skipped");
		
		//Logging the status as SKIP for test method skipped
		test.log(Status.SKIP, methodName+" Test method skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
		
		//Configuration of Extent Reports
		ExtentSparkReporter reporter = new ExtentSparkReporter
				(".\\Extent Reports\\report-"+dateTimeStamp+".html");
		reporter.config().setDocumentTitle("QA Report");
		reporter.config().setReportName("VTiger Report");
		reporter.config().setTheme(Theme.STANDARD);
		
		//Generate an empty report and add system info
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Base URL", "http://localhost:8888");
		reports.setSystemInfo("Base OS", "Windows");
		reports.setSystemInfo("Base browser", "Chrome");
		reports.setSystemInfo("Test Engineer", "Rajat");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution finished");
		//Flushing the generated report
		reports.flush();
	}
	
}

//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;

//package Selenium.WebDriver.BasicTest;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.base.TestBase;
//
//public class twitterPage extends TestBase {
//	@FindBy(xpath="//a[text()='Twitter']")
//	WebElement twitterPageTitleName;
//	
//	public twitterPage() {
//		PageFactory.initElements(driver, this);
//	}
//	
//	public boolean validateFacebookPageTitle() {
//		
//	return twitterPageTitleName.isDisplayed();
//	}
//}

//		try {
//		extentTest.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getName());
//		extentTest.log(LogStatus.FAIL,"TEST CASE FAILED IS "+result.getThrowable());
//		
//		String screenshotPath=new Screenshot().takeScreenShotForExtentReport(result.getName());
//		extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
//		
//		extent.endTest(extentTest);
//	}catch(Exception e) {
//		e.printStackTrace();
//	}

//public String takeScreenShotForExtentReport(String testMethodName) {
//		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String screenShotDestination=System.getProperty("user.dir")+"/ScreenshotExtent/"+testMethodName+"_"+dateName+".jpg";
//		File finalDestination=new File(screenShotDestination);
//		try {
//			FileUtils.copyFile(screenShotFile, finalDestination);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return screenShotDestination;

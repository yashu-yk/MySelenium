package Selenium.WebDriver.BasicTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
		
		//dyanamic wait
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // when some sites take longer to load
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS ) ;
		
		
		driver.get("http://google.com");
		//take screenshot and store as file format
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the screenshot to desired location using copyto method
		FileUtils.copyFile(src, new File("C://Users//Yashu Kumar//Desktop//google.png"));
	}

}

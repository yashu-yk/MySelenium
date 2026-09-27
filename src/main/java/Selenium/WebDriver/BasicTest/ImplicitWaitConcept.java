package Selenium.WebDriver.BasicTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("http://ebay.com");
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
		
		//dyanamic wait
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // when some sites take longer to load
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS ) ;
	}

}

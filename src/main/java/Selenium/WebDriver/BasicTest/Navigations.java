package Selenium.WebDriver.BasicTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
// how to simulate back and forword button
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
		
		//dyanamic wait
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // when some sites take longer to load
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS ) ;
		
		
		driver.get("http://google.com"); //launches url
		driver.navigate().to("http://ebay.com");// launches external url
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		
	}

}

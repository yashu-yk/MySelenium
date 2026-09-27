package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
        System.setProperty("webdriver.chrome.driver","C://Users//Yashu Kumar//Downloads//eclipse-java-2022-06-R-win32-x86_64//eclipse//chromedriver.exe");
		
     //   System.setProperty("webdriver.firefox.marionette","C://Users//Yashu Kumar//Downloads//eclipse-java-2022-06-R-win32-x86_64//eclipse//geckodriver.exe");
		
// webdrivers 
    //    WebDriver driver=new FirefoxDriver();
		WebDriver driver=new ChromeDriver();
        driver.get("http://www.amazon.in");

		
//Locators
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"); //by id
	//	driver.findElement(By.name("field-keywords")).sendKeys("iphone"); //by name
	//	driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone"); //by css selector
   //   driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone"); //by xpath
	//	driver.findElement(By.className("field-keywords")).sendKeys("iphone"); //by class name
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println(driver.getTitle());
		String exp_title="Google";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title)==true) {
			System.out.println("test is passed");
		}
		
		else {
			System.out.println("test is not passed");
			
		}
		System.out.println("ok");
	//	driver.close();
	}

}

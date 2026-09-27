package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	 System.setProperty("webdriver.chrome.driver","C://Users//Yashu Kumar//Downloads//eclipse-java-2022-06-R-win32-x86_64//eclipse//chromedriver.exe");
	//	 System.setProperty("webdriver.firefox.marionette","C://Users//Yashu Kumar//Downloads//eclipse-java-2022-06-R-win32-x86_64//eclipse//geckodriver.exe");
//		 WebDriver driver=new FirefoxDriver();
		 WebDriver driver=new ChromeDriver();
	     driver.get("http://www.amazon.in");
	     
	   //  Select select=new Select(driverr.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")));
	     Select select=new Select(driver.findElement(By.cssSelector("#searchDropdownBox")));
	    // select.selectByValue("search-alias=stripbooks-intl-ship");
	     select.selectByVisibleText("Books");
	     driver.findElement(By.id("nav-search-submit-button")).click(); 
	}

}

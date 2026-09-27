package Selenium.WebDriver.BasicTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BootstrapDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // when some sites take longer to load
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS ) ;
	     driver.get("https://www.jquery-az.com/4-demos-bootstrap-labels-forms-floating/");
	     Actions action=new Actions(driver);
	     action.moveToElement(driver.findElement(By.linkText("Programming"))).build().perform();
	     
	     List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'menu-top')]//ul//li[contains(@id,'7090')]//child::ul//li//a"));
	     System.out.println(list.size());
	     
	     for(int i=0;i<list.size();i++) {
	    	 System.out.println(list.get(i).getText());
	    	 if(list.get(i).getText().contains("Python")) {
	    		 list.get(i).click();
	    	  }
	      }
	 }
}

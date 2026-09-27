package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderjS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
	    driver.get("https://www.spicejet.com/");
	     
//	    Thread.sleep(3000);
//	    Alert alert=driver.switchTo().alert();
//	    alert.dismiss();
//	    Thread.sleep(6000);
	    WebElement dateElement=driver.findElement(By.xpath("//div[contains(@data-testid,'November-2022')]/child::div//child::div//div[contains(@data-testid,'calendar-day-15')]"));
	    
	   
	    
	    ////div[contains(@data-testid,'November-2022')]/child::div//child::div//div[contains(@data-testid,'calendar-day-15')]
	    
//	    String beforeXpath="//div[contains(@data-testid,";
//	    String midXpath=")]/\"+ \"child::div/\"\r\n"
//	    		+ "	    		+ \"child::div//div[contains(@data-testid,";
//	    String afterXpath=")]\"));";
//	    
//	    String day="7"; String month="December"; String year="2022";
//	    
//	    String path=//div[contains(@data-testid,'"+month+"-"+year+"')]/\"+ \"child::div/\"\r\n"
//	    		+ "	    		+ \"child::div//div[contains(@data-testid,
	   
	    String dateVal="Wed, 7 Sep 2022";
	     
	    selectDateByJs(driver,dateElement);
	    System.out.println("Date has changed");
	}

	public static void selectDateByJs(WebDriver driver ,WebElement element) {
		
		  JavascriptExecutor js = (JavascriptExecutor)driver;

		  
		  js.executeScript("arguments[0].click();", element); 
	}
}

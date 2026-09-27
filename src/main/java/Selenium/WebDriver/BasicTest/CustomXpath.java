package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
		
		driver.get("http://ebay.com");
		
		//by customise xpath
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Books");
		driver.findElement(By.xpath("//input[contains(@id,'gh-ac')]")).sendKeys("Books");
		driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();
		
		//for links custom xpath
		driver.findElement(By.xpath("//a[contains(text(),'My eBay')]")).click();		
	}
}

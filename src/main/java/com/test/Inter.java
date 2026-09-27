package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Inter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		driver.get("https://www.flipkart.com/");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("books");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//a[@title='Login' and @class='_1TOQfO']"))).build().perform();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[@title='My Profile']")).click();
//		Thread.sleep(3000);
		
		 driver.get("https://www.automationtestinginsider.com/2019/12/bootstrap-dropdown-example_12.html");
	     
	     List<WebElement> list=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
	     System.out.println(list.size());
	     
	     for(int i=0;i<list.size();i++) {
	     	 System.out.println(list.get(i).getText());
	     	 if(list.get(i).getText().contains("HOME")) {
	     		 list.get(i).click();
	     		 Thread.sleep(3000);
	    	  }
	      }
	     System.out.println(list.size());
	     
		driver.quit();
	}

}

package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondSession {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
//		 	WebDriver driver=new ChromeDriver();
		    WebDriverManager.chromedriver().setup();
	        WebDriver driver=new ChromeDriver();
		 	driver.manage().window().maximize(); //to maximize window
			driver.manage().deleteAllCookies();
	        driver.get("http://automationpractice.com/index.php");
	        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	        driver.findElement(By.id("email_create")).sendKeys("email08@gmail.com");
	        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
//	        Thread.sleep(15000);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_gender1\"]")));
	        
//	        driver.findElement(By.cssSelector("id_gender1")).click();
//	        driver.findElement(By.cssSelector("customer_firstname")).sendKeys("fname");
//	        driver.findElement(By.cssSelector("customer_lastname")).sendKeys("lname");
	        
	        driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
	        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("fname");
	        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("lname");
	        
	        driver.findElement(By.id("passwd")).sendKeys("password");
	        
	        Select selectd=new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
	        selectd.selectByValue("1");
	        
	        Select selectm=new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
	        selectm.selectByVisibleText("January ");
	        
	        Select selecty=new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
	        selecty.selectByValue("2000");
	        
	      driver.findElement(By.xpath("//*[@id=\"address1\"] ")).sendKeys("address");
	      driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("city");
	      Select selects=new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
	      selects.selectByVisibleText("Alabama");
	        
	      driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("24700");
	      driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("1234567890");
	      
	      driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
	}

}

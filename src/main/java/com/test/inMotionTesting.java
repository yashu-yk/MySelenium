package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class inMotionTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.inmotionhosting.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#whyUsDropdown"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a//span[contains(text(),\"About Us\")]")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}

package com.test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {

	 @Test
	public void register() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://practice.expandtesting.com/upload");
	  driver.findElement(By.id("fileInput")).sendKeys("C:\\Users\\chsri\\Downloads\\969c3e063533c472ea23d5f677bb7cf7.jpg");
	  driver.findElement(By.id("fileSubmit")).click();
	  driver.quit();
	 }
}

package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	static WebDriver driver;
	
	@BeforeMethod
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		
	}
	
	@Test
	public void check() {
		System.out.println(driver.getTitle());
		
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
}

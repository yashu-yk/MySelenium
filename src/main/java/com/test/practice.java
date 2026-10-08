package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

	  // how to use select
//		 WebElement element= driver.findElement(By.id("cars"));
//		 Select select = new Select(element);
//		 select.selectByValue("Audi");
//		 List<String> options = new ArrayList<>();
//		 for(WebElement option : select.getOptions()){
//			 options.add(option.getText());
//		 }

		 // how to use actions class
		 WebElement products = driver.findElement(By.xpath("Electronic"));
		 Actions action = new Actions(driver);
		 action.moveToElement(products).perform();

		 WebElement laptop = driver.findElement((By.xpath("laptops")));
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(laptop));

		 action.moveToElement(laptop).click().perform();

		 // another way of implementing above code
		 action.moveToElement(products).click().moveToElement(laptop).click().perform();
	 }
}



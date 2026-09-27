package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcepts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
	     driver.get("https://www.myntra.com/");
	     Actions action=new Actions(driver);
	     action.moveToElement(driver.findElement(By.linkText("WOMEN"))).build().perform();
	     Thread.sleep(3000); // static wait
	     driver.findElement(By.linkText("Sunglasses & Frames")).click(); 
	}

}

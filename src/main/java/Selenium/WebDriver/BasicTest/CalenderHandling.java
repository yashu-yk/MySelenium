package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalenderHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
	     driver.get("https://ui.cogmento.com/home");
	     driver.findElement(By.xpath("//input[@name='email']")).sendKeys("yashukumar98@gmail.com");
	     driver.findElement(By.name("password")).sendKeys("Yashu@123");
	     driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();////*[@id="ui"]/div/div/form/div/div[3]
//	     driver.findElement(By.xpath("//class[contains(text(),'Login')]")).click();
	     Thread.sleep(3000);
	     
	     Actions action=new Actions(driver);
	     action.moveToElement(driver.findElement(By.linkText("Contacts"))).build().perform(); ////*[@id="main-nav"]/div[3]/a
	     
	     Thread.sleep(3000); // static wait
	     
	     driver.findElement(By.linkText("Contacts")).click(); 
	}

}

package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions option=new ChromeOptions();
		option.addArguments("window-size=1400,800");
		option.addArguments("headless");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
	     driver.get("https://ui.cogmento.com/home");
	     System.out.println("login page title=="+driver.getTitle());
	     driver.findElement(By.xpath("//input[@name='email']")).sendKeys("yashukumar98@gmail.com");
	     driver.findElement(By.name("password")).sendKeys("Yashu@123");
	     driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
	     System.out.println("home page title=="+driver.getTitle());
	}

}

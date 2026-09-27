package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopupAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//	 System.setProperty("webdriver.firefox.marionette","C://Users//Yashu Kumar//Downloads//eclipse-java-2022-06-R-win32-x86_64//eclipse//geckodriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		 driver.findElement(By.name("proceed")).click(); //
		
		 Thread.sleep(2000); // to pause the script
		 
		 Alert alert=driver.switchTo().alert(); //switch to popup window
		 System.out.println(alert.getText());
		 alert.accept(); //click on ok button of popup
		// alert.dismiss();// to click on cancel button
	}

}

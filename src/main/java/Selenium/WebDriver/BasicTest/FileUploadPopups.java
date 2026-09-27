package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadPopups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Types of popups
		//1 alerts --javascript popups--Alerts API(accept,dismiss).
		//2 Fileuploadpopup --browse button--(type=file, sendkeys(path)).
		//3 Browser Window popup --Advertisement popup--(Window handler API)
		
		
	
		// System.setProperty("webdriver.chrome.driver","C://Users//Yashu Kumar//Downloads//eclipse-java-2022-06-R-win32-x86_64//eclipse//chromedriver.exe");
//		 System.setProperty("webdriver.firefox.marionette","C://Users//Yashu Kumar//Downloads//eclipse-java-2022-06-R-win32-x86_64//eclipse//geckodriver.exe");
//		 WebDriver driver=new FirefoxDriver();
		 WebDriver driver=new ChromeDriver();
	     driver.get("https://html.com/input-type-file/");
	     
	     // works only when type equals to file is available in browse/attach file/upload file
	     driver.findElement(By.id("fileupload")).sendKeys("C://Users//Yashu Kumar//Desktop//waste.txt");
	}

}

package Selenium.WebDriver.BasicTest;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://deliver.courseavenue.com/PopupTest.aspx");
		driver.findElement(By.id("ctl00_ContentMain_popupTest")).click();
		Set <String> handler=driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		String parentWindowId=it.next();
		
		String childWindowId=it.next();
		driver.switchTo().window(childWindowId);
		System.out.println("Child window popup title"+ driver.getTitle() );
		
		driver.close(); //used to close specific browser
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window popup title"+ driver.getTitle() );
		driver.quit(); //used to close all browser
	}

}

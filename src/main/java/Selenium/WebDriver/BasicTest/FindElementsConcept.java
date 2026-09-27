package Selenium.WebDriver.BasicTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // when some sites take longer to load
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS ) ;
		driver.get("http://facebook.com");
		
		// 1.get the total count of links on page
		// 2. get the text of each link on the page
		
		//all the link are represented by <a> tags
		List <WebElement> list=driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		System.out.println(list.get(0));
		
		for(int i=0;i<list.size();i++) {
			String linkText=list.get(i).getText();
			System.out.println(linkText);
		}

	}
 
}

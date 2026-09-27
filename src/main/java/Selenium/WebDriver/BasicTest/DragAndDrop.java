package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
		driver.get("http://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0);// switch to frame if its present
		
	    Actions action=new Actions(driver);
	    action.clickAndHold(driver.findElement(By.xpath("//*[@id=\"draggable\"]")))
	    .moveToElement(driver.findElement(By.xpath("//*[@id=\"droppable\"]")))
	    .release().build().perform();
	}

}

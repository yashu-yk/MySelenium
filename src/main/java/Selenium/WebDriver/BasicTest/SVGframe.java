package Selenium.WebDriver.BasicTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGframe {

	public static void main() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies();
	    driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
	    
	    driver.switchTo().frame("svg_result");
	    while(true) {
	    List<WebElement> list=driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and @id='g2']//"
	    		+ "*[local-name()='path' and contains(@id,'face')]"));
	    
	    for(WebElement ele: list) {
	    	String text=null;
	    	text=ele.getAttribute("d");
	    	System.out.println(text);
	    }
	    }
	}
}

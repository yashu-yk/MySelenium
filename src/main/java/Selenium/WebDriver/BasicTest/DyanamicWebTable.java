package Selenium.WebDriver.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DyanamicWebTable {

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
	     ////*[@id="main-content"]/div/div[2]/div/table/tbody/tr[1]/td[2]/a
	     
	     Thread.sleep(3000);
	     action.moveToElement(driver.findElement(By.xpath("//*[@id=\"top-header-menu\"]/div[2]/span[1]"))).build().perform();
	//     Thread.sleep(10000);
	     
	     // Method 1 using forloop
	     
//	     String BeforeXpath="//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[";
//	     String AfterXpath="]/td[2]/a";
//	     
//	     for(int i=1;i<=3;i++) {
//	    	 String name=driver.findElement(By.xpath(BeforeXpath +i+ AfterXpath)).getText();
//	    	 System.out.println(name);
//	    	 if(name.contains("omega shenron")) { // i=3
//	    		 Thread.sleep(5000);
//	    	     driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[" + i + "]/td[1]/div/input")).click();   
//	    	  //  //*[@id="main-content"]/div/div[2]/div/table/tbody/tr[3]/td[1]/div/input
//	    	 }
//	     }
	     
	     
	     // Method 2 usng customise xpath
		
	     // //a[contains(text(),'omega shenron')]/parent::td//preceding-sibling::td//input[@name='id']
	 //    driver.findElement(By.xpath("//a[contains(text(),'omega shenron')]/parent::td//preceding-sibling::td//input[@name='id']")).click();
//	     WebElement element=driver.findElement(By.xpath("//a[contains(text(),'omega shenron')]/parent::td//preceding-sibling::td//input[@name='id']"));
	    
	     WebElement element=driver.findElement(By.xpath("//a[contains(text(),'y11 z11')]/parent::td//preceding-sibling::td//child::div//input[contains(@name,'id')]"));
	     
	     JavascriptExecutor js = (JavascriptExecutor)driver;
	     js.executeScript("arguments[0].click();", element);

	     
	}

}

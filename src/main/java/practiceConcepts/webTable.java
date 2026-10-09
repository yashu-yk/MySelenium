package practiceConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class webTable {

	static WebDriver driver;
	static WebDriverWait wait;
	
			static{
						 driver = new ChromeDriver();
						 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
						 driver.manage().window().maximize();
						 driver.get("https://testautomationpractice.blogspot.com/#");
	 }
		
			// iterating static web table tr[1] first row...td[1] first column... tr[td[2]]
			
			
			public void staticWebTable() {
				
			WebElement table = driver.findElement(By.name("BookTable"));
			
			List<WebElement> tableRow = table.findElements(By.tagName("tr"));
			
			for(WebElement row: tableRow) {
				
				List<WebElement> columns = row.findElements(By.xpath("./th | ./td"));
				
				for(WebElement column: columns ) {
					System.out.print(column.getText() +"	 			");
				}
				System.out.println();
			}
			
}	
			
		
			// webtable with pagination...
			public void pageTable() {
				int count =1; 
				String laptop = "Laptop";
				while(true && count<5) {
					
				List<WebElement> rows= driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/tr"));
				// select product "Laptop"
				
				boolean found = false;
				for(WebElement row:rows) {
					if(row.getText().contains(laptop)) {
						row.findElement(By.xpath("//table[@id=\"productTable\"]/tbody/"
								+ "tr[td[2]=\"Laptop\"]/td[4]/input")).click();
						found = true;
						break;
					}
				}
				
				if(found) {
					break;
				}
				 count= count+1;
				 String str ="//a[text()=" + count+"]";
				 driver.findElement(By.xpath(str));
			}
			
			}	
			
			//@Test
			//form filling
			public void formAlert() throws InterruptedException {
				driver.findElement(By.id("alertBtn")).click();
				Alert alert = driver.switchTo().alert();
				Thread.sleep(3000);
				alert.accept();
				
				driver.findElement(By.id("confirmBtn")).click();
				Alert alert2 = driver.switchTo().alert();
				Thread.sleep(3000);
				alert2.accept();
				
				driver.findElement(By.id("promptBtn")).click();
				Alert alert3 = driver.switchTo().alert();
				alert3.sendKeys("be alert");
				Thread.sleep(3000);
				alert3.accept();
				Thread.sleep(3000);
			}
			
			@Test
			//using action class for mouse
			public void mouseHover() throws InterruptedException {
				WebElement element =driver.findElement(By.className("dropbtn"));
				Actions action = new Actions(driver);
				action.moveToElement(element).perform();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[text()=\"Mobiles\"]")).click();
				
				
				 WebElement ele = driver.findElement(By.xpath("//button[text()=\"Copy Text\"]"));
				 Actions a = new Actions(driver);
				 a.moveToElement(ele).doubleClick().perform();
				 Thread.sleep(3000);
				}
			
			
			
			
			
			
			
}
package practiceConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Practice {

	static WebDriver driver;
	static WebDriverWait wait;
	
			static{
						 driver = new ChromeDriver();
						 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
						 driver.manage().window().maximize();
						 driver.get("https://testautomationpractice.blogspot.com/#");
	 }
			
			public void waitForElementToBeClickable(WebElement element) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(element));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			public void waitForElementToBeVisible(WebElement element) {
				try {
					wait.until(ExpectedConditions.visibilityOf(element));
				} catch (Exception e) {
					System.out.println("Element is not visible:" + e.getMessage());
				}
			}

			
		  @Test
		// to fill form
		public void fillForm() throws InterruptedException {
			driver.findElement(By.id("name")).sendKeys("Omega");
			driver.findElement(By.id("email")).sendKeys("Omega@gmail.com");
			driver.findElement(By.id("phone")).sendKeys("123456789");
			driver.findElement(By.id("textarea")).sendKeys("Wanderer");
			driver.findElement(By.id("male")).click();
			driver.findElement(By.id("sunday")).click();
			
			// now to select country from a select dropdown
			WebElement ele = driver.findElement(By.id("country"));
			Select select = new Select(ele);
			select.selectByValue("india");
			
			new Select(driver.findElement(By.id("colors"))).selectByValue("white");
			new Select(driver.findElement(By.id("animals"))).selectByValue("zebra");
			
			String date = "5/12/2020";
			String[] strDate = date.split("/");
			String day = strDate[0];
			String month = strDate[1];
			String year = strDate[2];
			
			//simple html date to fill
			driver.findElement(By.id("datepicker")).sendKeys(date);
			//driver.findElement(By.xpath("//p[text()=\"Date Picker 1 (mm/dd/yyyy): \"]")).click();
			
			// selecting date through select class of selenium
			driver.findElement(By.id("txtDate")).click();
			
			//selecting year
			WebElement elementYear=driver.findElement(By.className("ui-datepicker-year"));
			Select selectYear = new Select(elementYear);
			selectYear.selectByValue(year);
			
			//selecting month
			WebElement elementMonth=driver.findElement(By.className("ui-datepicker-month"));
			Select selectMonth = new Select(elementMonth);
			int Month = Integer.parseInt(month) - 1;
			if(Month==0 || Month>0) {
			selectMonth.selectByValue(Month+"");
			}
			//selecting day
			String dayElementXpath= "//a[normalize-space()="+day+"]";
			driver.findElement(By.xpath(dayElementXpath)).click();
			
			// another date to enter where type="date"
			 driver.findElement(By.id("start-date")).sendKeys("10-01-2026");
			 driver.findElement(By.id("end-date")).sendKeys("12-01-2026");
			
			 //upload single file
			 driver.findElement(By.id("singleFileInput")).sendKeys("C:\\Users\\chsri\\OneDrive\\Desktop\\upload.txt");
			
			//upload multiple files
			driver.findElement(By.id("multipleFilesInput")).sendKeys(
				    "C:\\Users\\chsri\\OneDrive\\Desktop\\upload.txt" +
				    	    System.lineSeparator() +
				    	    "C:\\Users\\chsri\\OneDrive\\Desktop\\upload2.txt");
			Thread.sleep(4000);
		}
			
			
			
}
package NewTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Leave {



    @Test
    public void setup() throws IOException {

        //load properties files
        Properties prop = new Properties();
        String configPath = System.getProperty("user.dir") + "//src/main/java/com/test/config.properties";
        try (
                FileInputStream fileInput = new FileInputStream(configPath)) {
            prop.load(fileInput);
        }
        // --------------------------------------------------
        // 2. Read browser from properties file
        // --------------------------------------------------

        String browser = prop.getProperty("browser");

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else {
            throw new IllegalArgumentException(
                    "Invalid browser specified: " + browser
            );
        }


        // --------------------------------------------------
        // 3. Create explicit wait
        // --------------------------------------------------

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));


        // --------------------------------------------------
        // 4. Open application
        // --------------------------------------------------

        try {
            // open application

            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");

            driver.manage().window().maximize();
            driver.get(url);
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//input[@name='username']")));
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//span[text()=\"Leave\"]")));
            driver.findElement(By.xpath("//span[text()=\"Leave\"]")).click();

            //to apply leave
//            wait.until(ExpectedConditions.
//                    visibilityOfElementLocated(
//                            By.xpath("//a[text()=\"Apply\"]")));
//            driver.findElement(By.xpath("//a[text()=\"Apply\"]")).click();
//
//
//            wait.until(ExpectedConditions.
//                    visibilityOfElementLocated(
//                            By.xpath("//label[text()=\"Leave Type\"]/parent::div/following-sibling::div//i")));
//            driver.findElement(By.xpath("//label[text()=\"Leave Type\"]/parent::div/following-sibling::div//i")).click();
//
//
//            wait.until(ExpectedConditions.
//                    visibilityOfElementLocated(
//                            By.xpath("//div[@role='listbox']//div[normalize-space()=\"CAN - Vacation\"]")));
//            driver.findElement(By.xpath("//div[@role='listbox']//div[normalize-space()=\"CAN - Vacation\"]")).click();
//           // Thread.sleep(4000);
//
//            wait.until(ExpectedConditions.
//                    visibilityOfElementLocated(
//                            By.xpath("//label[text()=\"From Date\"]/parent::div/following-sibling::div//input")));
//            driver.findElement(By.xpath("//label[text()=\"From Date\"]/parent::div/following-sibling::div//input")).sendKeys("2026-17-12");
//
////            wait.until(ExpectedConditions.
////                    visibilityOfElementLocated(
////                            By.xpath("//div[text()=\"Half Day - Morning\"]/parent::div/div//i")));
////            driver.findElement(By.xpath("//div[text()=\"Half Day - Morning\"]/parent::div/div//i")).click();
////
////            wait.until(ExpectedConditions.
////                    visibilityOfElementLocated(
////                            By.xpath("//div[@role='listbox']//div[normalize-space()=\"Half Day - Morning\"]")));
////            driver.findElement(By.xpath("//div[@role='listbox']//div[normalize-space()=\"Half Day - Morning\"]")).click();
//
//            wait.until(ExpectedConditions.
//                    visibilityOfElementLocated(
//                            By.xpath("//textarea[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]")));
//            driver.findElement(By.xpath("//textarea[@class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]")).sendKeys("Taking Half day leave on 26-01-10");
//
//            wait.until(ExpectedConditions.
//                    visibilityOfElementLocated(
//                            By.xpath("//p[text()=\" * Required\"]/following-sibling::button")));
//            Thread.sleep(4000);
//            driver.findElement(By.xpath("//p[text()=\" * Required\"]/following-sibling::button")).click();


            // to check my leave
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//a[text()=\"My Leave\"]")));
            driver.findElement(By.xpath("//a[text()=\"My Leave\"]")).click();

            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//label[text()=\"From Date\"]/parent::div/following-sibling::div//input")));
            driver.findElement(By.xpath("//label[text()=\"From Date\"]/parent::div/following-sibling::div//input")).click();
            driver.findElement(By.xpath("//label[text()=\"From Date\"]/parent::div/following-sibling::div//input")).clear();
            driver.findElement(By.xpath("//label[text()=\"From Date\"]/parent::div/following-sibling::div//input")).sendKeys("2026-10-11");

            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//label[text()=\"To Date\"]/parent::div/following-sibling::div//input")));
            driver.findElement(By.xpath("//label[text()=\"To Date\"]/parent::div/following-sibling::div//input")).click();
            driver.findElement(By.xpath("//label[text()=\"To Date\"]/parent::div/following-sibling::div//input")).clear();
            driver.findElement(By.xpath("//label[text()=\"To Date\"]/parent::div/following-sibling::div//input")).sendKeys("2026-12-11");
            Thread.sleep(3000);
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//label[text()=\"Leave Type\"]/parent::div/following-sibling::div//i")));
            driver.findElement(By.xpath("//label[text()=\"Leave Type\"]/parent::div/following-sibling::div//i")).click();

            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//div[@role='listbox']//div[normalize-space()=\"US - Vacation\"]")));
           // Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@role='listbox']//div[normalize-space()=\"US - Vacation\"]")).click();

            // clear all the preselected leave types
            driver.findElement(By.xpath("//span[text()=\"Cancelled \"]/i")).click();
            driver.findElement(By.xpath("//span[text()=\"Pending Approval \"]/i")).click();
            driver.findElement(By.xpath("//span[text()=\"Scheduled \"]/i")).click();
            //Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()=\"Taken \"]/i")).click();
            driver.findElement(By.xpath("//span[text()=\"Rejected \"]/i")).click();

            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//label[text()=\"Show Leave with Status\"]/parent::div/following-sibling::div//i")));
            driver.findElement(By.xpath("//label[text()=\"Show Leave with Status\"]/parent::div/following-sibling::div//i")).click();
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//div[@role='listbox']//div[normalize-space()=\"Pending Approval\"]")));
            driver.findElement(By.xpath("//div[@role='listbox']//div[normalize-space()=\"Pending Approval\"]")).click();
               Thread.sleep(4000);
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//p[text()=\" * Required\"]/following-sibling::button")));
            driver.findElement(By.xpath("//p[text()=\" * Required\"]/following-sibling::button")).click();
            //Thread.sleep(2000);
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//div[text()=\"Pending Approval (1.00)\"]")));
            driver.findElement(By.xpath("//div[text()=\"Pending Approval (1.00)\"]")).isDisplayed();
            Thread.sleep(4000);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {

            // --------------------------------------------------
            // 23. Close browser
            // --------------------------------------------------

            driver.quit();
        }
    }
}


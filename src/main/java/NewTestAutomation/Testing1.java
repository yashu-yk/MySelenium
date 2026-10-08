package NewTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Testing1 {

    @Test
    public void setup() throws IOException {

        //load properties files
        Properties prop = new Properties();
        String configPath = System.getProperty("user.dir") + "//src/main/java/com/test/config.properties";
        try (FileInputStream fileInput = new FileInputStream(configPath)) {
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
            String username= prop.getProperty("username");
            String password= prop.getProperty("password");

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
                            By.xpath("//span[text()=\"Admin\"]")));
            driver.findElement(By.xpath("//span[text()=\"Admin\"]")).click();

            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//label[text()=\"Username\"]/following::input[contains(@class,'oxd-input oxd-input--active')]")));
            driver.findElement(By.xpath("//label[text()=\"Username\"]/following::input[contains(@class,'oxd-input oxd-input--active')]")).sendKeys("Admin");
            driver.findElement(By.xpath("//label[text()=\"User Role\"]/following::i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'][1]")).click();
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//div[@role='listbox']//div[normalize-space()='Admin']")));
            driver.findElement(By.xpath("//div[@role='listbox']//div[normalize-space()='Admin']")).click();
            driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("John Tester");
            driver.findElement(By.xpath("//label[text()=\"Status\"]/following::div[1]//i")).click();
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(
                            By.xpath("//div[@role='listbox']//div[normalize-space()='Enabled']")));

            driver.findElement(By.xpath("//div[@role='listbox']//div[normalize-space()='Enabled']")).click();
            Thread.sleep(3000);
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
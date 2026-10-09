package NewTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UsingActionsClass {

    @Test
    public void USA() throws InterruptedException {

//        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();

        options.setBinary(
                "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
        );


        ChromeDriver driver = new ChromeDriver(options);
        // Enable CDP Network
        driver.executeCdpCommand(
                "Network.enable",
                new HashMap<>()
        );

        // URLs to block
        Map<String, Object> params = new HashMap<>();

        params.put("urls", Arrays.asList(
                "*://*.googlesyndication.com/*",
                "*://*.doubleclick.net/*",
                "*://*.googleadservices.com/*",
                "*://*.googletagservices.com/*",
                "*://*.adservice.google.com/*"
        ));

        driver.executeCdpCommand(
                "Network.setBlockedURLs",
                params
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/");

        WebElement element= driver.findElement(By.xpath("//a[text()=\"Drag and Drop\"]/parent::h3/parent::div/following-sibling::div//a[text()=\"Try it out\"]"));
        // Scroll target to center
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                element
        );
       //String parentWindow= driver.getWindowHandle();
        System.out.println("Before click");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Drag and Drop\"]/parent::h3/parent::div/following-sibling::div//a[text()=\"Try it out\"]")));
        driver.findElement(By.xpath("//a[text()=\"Drag and Drop\"]/parent::h3/parent::div/following-sibling::div//a[text()=\"Try it out\"]")).click();
        System.out.println("After click");
       // String childWindow= driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("column-a")));
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement destination = driver.findElement(By.id("column-b"));

        Actions action = new Actions(driver);

        action.dragAndDrop(source,destination).perform();

      //  Thread.sleep(4000);

        driver.quit();
        //driver.switchTo().window(parentWindow);
        //System.out.println(driver.getTitle());

    }
}

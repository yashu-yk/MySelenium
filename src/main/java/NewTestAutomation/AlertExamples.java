package NewTestAutomation;

import org.openqa.selenium.*;
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

public class AlertExamples {

    @Test
    public void USA() throws InterruptedException {

        // to use brave for preventing ads
        ChromeOptions options = new ChromeOptions();
        options.setBinary(
                "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
        );
        ChromeDriver driver = new ChromeDriver(options);

        // to prevent itercepting ads
        adBlocker(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/");

        WebElement element= driver.findElement(By.xpath("//a[text()=\"Notification Message\"]/parent::h3/parent::div/following-sibling::div//a[text()=\"Try it out\"]"));

        // will scroll till the element is not visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (true) {

            Boolean visible = (Boolean) js.executeScript(
                    "var r = arguments[0].getBoundingClientRect();" +
                            "return r.top >= 0 && " +
                            "       r.bottom <= window.innerHeight;",
                    element
            );

            if (visible) {
                break;
            }

            js.executeScript("window.scrollBy(0, 500);");
        }

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        // to prevent itercepting ads
        adBlocker(driver);

        wait.until(
                ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        alert.dismiss();
        Thread.sleep(4000);

    }
    void adBlocker(ChromeDriver driver){
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
        //axinposts ey5814078741n    EY5814078741N
    }
}
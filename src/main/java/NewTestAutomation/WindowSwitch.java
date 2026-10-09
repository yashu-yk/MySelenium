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

public class WindowSwitch {

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

        WebElement element= driver.findElement(By.xpath("//a[text()=\"Drag and Drop\"]/parent::h3/parent::div/following-sibling::div//a[text()=\"Try it out\"]"));

        // Scroll target to center
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                element
        );

        //Storing Parent window handle
        String parentWindow= driver.getWindowHandle();

        //link of element to be clicked to open new tab
        String urlTryOut = element.getAttribute("href");

        //open new tab on click
        ((JavascriptExecutor) driver).executeScript(
                "window.open(arguments[0], '_blank');",
                urlTryOut
        );

        // to prevent itercepting ads
        adBlocker(driver);

        // wait for second window
        wait.until(d-> d.getWindowHandles().size() == 2);

        // Switch to child tab
        for(String window: driver.getWindowHandles()){
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }

        System.out.println("Child tab title: " + driver.getTitle());

        // perform drag and drop down in new tab

        wait.until(ExpectedConditions.elementToBeClickable(By.id("column-a")));
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement destination = driver.findElement(By.id("column-b"));

        Actions action = new Actions(driver);

        action.dragAndDrop(source,destination).perform();

          Thread.sleep(4000);

          // closing child window
            driver.close();

            // switching to parent window
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        // closing browser
        driver.quit();


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
    }
}

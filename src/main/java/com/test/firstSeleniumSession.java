package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class firstSeleniumSession {

    @Test

    public void testing()

    {
        //System.setProperty("webdriver.gecko.driver", "C://Users//Yashu Kumar//Downloads//eclipse-java-2022-06-R-win32-x86_64//eclipse//geckodriver.exe");

    //  WebDriverManager.firefoxdriver().setup();
       WebDriverManager.chromedriver().setup();
        //    WebDriverManager.edgedriver().setup();
    //  WebDriver driver=new FirefoxDriver();
        WebDriver driver=new ChromeDriver();
     //   WebDriver driver=new EdgeDriver();

        driver.manage().window().maximize(); //to maximize window
        driver.manage().deleteAllCookies();

//        driver.get("http://www.google.com");
//        String title= driver.getTitle();
//        System.out.print(title);

        driver.get("http://www.amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.quit();
    }


}

package com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class SecondSeleniumSession {

    @Test
    public void register() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = null;
        String url;
        String day = null;
        String month = null;
        String year = null;

        Properties prop = new Properties();
        FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")  +  "\\src\\main\\java\\com\\test\\config.properties");

        try {
            prop.load(fileInput);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String browser = prop.getProperty("browser");
            if (browser.equals("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equals("FF")) {
                driver = new FirefoxDriver();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            String Date = prop.getProperty("Date");
            String date[] = Date.split("/");
            day = date[0];
            month = date[1];
            year = date[2];
        }catch (Exception e){
        e.printStackTrace();
        }

        try {
            url = prop.getProperty("url");
            driver.get(url);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            driver.findElement(By.id("email_create")).sendKeys(prop.getProperty("Email"));
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_gender1\"]")));
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys(prop.getProperty("First_Name"));
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys(prop.getProperty("Last_Name"));
        }catch (Exception e){
            e.printStackTrace();
        }

            try {
                driver.findElement(By.id("passwd")).sendKeys(prop.getProperty("Password"));
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                Select selectd = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
                selectd.selectByValue(day);
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                Select selectm = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
                selectm.selectByVisibleText(month + " ");
            }catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Select selecty = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
                selecty.selectByValue(year);
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                driver.findElement(By.xpath("//*[@id=\"address1\"] ")).sendKeys(prop.getProperty("Address"));
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(prop.getProperty("City"));
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                Select selects = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
                selects.selectByVisibleText(prop.getProperty("State"));
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys(prop.getProperty("PostCode"));
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys(prop.getProperty("Phone_Mobile"));
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
            }catch (Exception e){
                e.printStackTrace();
            }

    }
}

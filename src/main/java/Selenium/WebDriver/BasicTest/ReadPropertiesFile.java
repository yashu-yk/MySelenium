package Selenium.WebDriver.BasicTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver=null;
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\Yashu Kumar\\eclipse-workspace\\MySelenium\\src\\main\\java\\Selenium\\WebDriver\\BasicTest\\config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("name"));
		
		String url=prop.getProperty("url");
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("FF")) {
			driver=new FirefoxDriver();
		}
		
		driver.get(url);
		driver.quit();
		// /html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/a
	///html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/a
	// /html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a
}

}

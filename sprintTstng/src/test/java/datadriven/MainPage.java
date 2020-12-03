package datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainPage {
	WebDriver driver;
	
	public MainPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public void login() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://freecrm.co.in/index.html");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();

		Thread.sleep(1500);
		driver.findElement(By.xpath("(//input)[1]")).sendKeys("rokkamdhatri@gmail.com");
		driver.findElement(By.xpath("(//input)[2]")).sendKeys("Dhatri@23");
	    driver.findElement(By.xpath("//div[text()='Login']")).click();
	    Thread.sleep(1500);
	}
	
}

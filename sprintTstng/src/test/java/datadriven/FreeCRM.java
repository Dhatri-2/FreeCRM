package datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FreeCRM {
	
	
	WebDriver driver;
	MainPage mp;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","./driverC/chromedriver.exe");
	driver=new ChromeDriver();
	}
	
	@Test (dataProvider="user")
	public void loginFun(String email,String password) throws Exception
	{
	System.out.println("Validating data");
	System.out.println(email);
	System.out.println(password);

	driver.manage().window().maximize();
	driver.get("https://freecrm.co.in/index.html");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//span[text()='Log In']")).click();

	Thread.sleep(1500);
	driver.findElement(By.xpath("(//input)[1]")).sendKeys(email);
	Thread.sleep(1500);
	driver.findElement(By.xpath("(//input)[2]")).sendKeys(password);
	Thread.sleep(1500);
    driver.findElement(By.xpath("//div[text()='Login']")).click();
    Thread.sleep(1500);
	}
	
	@Test (dataProvider="userN")
	public void contactFail(String fname,String lname) throws Exception
	{
	System.out.println("Validating data1");
	System.out.println(fname);
	System.out.println(lname);
	
	driver.manage().window().maximize();
	driver.get("https://freecrm.co.in/index.html");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//span[text()='Log In']")).click();

	Thread.sleep(1500);
	driver.findElement(By.xpath("(//input)[1]")).sendKeys("rokkamdhatri@gmail.com");
	driver.findElement(By.xpath("(//input)[2]")).sendKeys("Dhatri@23");
    driver.findElement(By.xpath("//div[text()='Login']")).click();
    
	
    Thread.sleep(1500);
    driver.findElement(By.xpath("//*[@id='main-nav']/a[3]/span")).click();
    Thread.sleep(1500);
    driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a/button")).click();
    
   
    
    Thread.sleep(1500);
    WebElement Cname=driver.findElement(By.xpath("//input[@name='first_name']"));
    WebElement Clname= driver.findElement(By.xpath("//input[@name='last_name']"));
    Thread.sleep(1500);
    
    if(fname.equals("null"))
    {
    	 Cname.sendKeys("");
    }
    else {
    	Cname.sendKeys(fname);
    }
   
    if(lname.equals("null"))
    {
    	Clname.sendKeys("");
    }
    else
    {
    	Clname.sendKeys(lname);
    }
    driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
	   Thread.sleep(3000);
   
	}
	
	@Test (priority=1)
	public void deals() throws InterruptedException
	{
		mp=new MainPage(driver);
		mp.login();
		Thread.sleep(1500);
		driver.findElement(By.linkText("Deals")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a[3]/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/input")).sendKeys("Dealtt");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/button[2]")).click();
		Thread.sleep(1500);
	}
	
	@Test (priority=2)
	public void dealsFail() throws InterruptedException
	{
		mp=new MainPage(driver);
		mp.login();
		Thread.sleep(1500);
		driver.findElement(By.linkText("Deals")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a[3]/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/button[2]")).click();
		Thread.sleep(1500);
	}
	
	@Test (priority=3)
	public void tasks() throws InterruptedException
	{
		mp=new MainPage(driver);
		mp.login();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='main-nav']/a[6]/span")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/input")).sendKeys("TASK");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/button[2]")).click();
		Thread.sleep(1500);
	}
	@Test (priority=4)
	public void tasksFail() throws InterruptedException
	{
		mp=new MainPage(driver);
		mp.login();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='main-nav']/a[6]/span")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/button[2]")).click();
		Thread.sleep(1500);
	}
	
	@Test (priority=5)
	public void company() throws InterruptedException
	{
		mp=new MainPage(driver);
		mp.login();
		Thread.sleep(1500);
		driver.findElement(By.linkText("Companies")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/div/input")).sendKeys("Company1");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/button[2]")).click();
		Thread.sleep(1500);
	}
	
	@Test (priority=6)
	public void companyFail() throws InterruptedException
	{
		mp=new MainPage(driver);
		mp.login();
		Thread.sleep(1500);
		driver.findElement(By.linkText("Companies")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/button[2]")).click();
		Thread.sleep(1500);
	}
	
	@Test(priority=7)
	public void contact() throws InterruptedException
	{
		
		
		mp=new MainPage(driver);
		mp.login();
		Thread.sleep(1500);
	    driver.findElement(By.xpath("//*[@id='main-nav']/a[3]/span")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a/button")).click();
	    
	   
	    
	    Thread.sleep(1500);
	    WebElement Fname=driver.findElement(By.xpath("//input[@name='first_name']"));
	    WebElement Lname= driver.findElement(By.xpath("//input[@name='last_name']"));
	    Fname.sendKeys("Dhatrii");
	    Thread.sleep(1500);
	    Lname.sendKeys("Rokkamm");
	    Thread.sleep(1500);
	    driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/button[2]")).click();
	    Thread.sleep(1500);
	}
	
	@Test (priority=8)
	public void loginFail() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://freecrm.co.in/index.html");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();

		Thread.sleep(1500);
	    driver.findElement(By.xpath("//div[text()='Login']")).click();
	    Thread.sleep(1500);
	}
	
	@DataProvider(name="user")
	public String[][] data() throws Exception
	{
	String[][] arrobj = getDataFromXLSX("login.xlsx");
	return arrobj;
	}
	
	private String[][] getDataFromXLSX(String filename) throws IOException {
		String[][] array=null;
		FileInputStream fs = new FileInputStream(filename);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sh =wb.getSheetAt(0);
		XSSFRow rows;
		XSSFCell cell;

		int rowCount = sh.getLastRowNum();
		int columnCount = sh.getRow(0).getLastCellNum();
		array=new String[rowCount][columnCount];
		for(int i=1;i<rowCount+1;i++)
		{
		for(int j=0;j<columnCount;j++)
		{
		rows=sh.getRow(i);
		cell=rows.getCell(j);
		array[i-1][j]=cell.getStringCellValue();
		}
		}

		return array;
		}
	@DataProvider(name="userN")
	public String[][] data1() throws Exception
	{
	String[][] arrobj1 = getDataFromXLSXA("home.xlsx");
	return arrobj1;
	}
	
	
	
	private String[][] getDataFromXLSXA(String filename) throws IOException {
		String[][] arrayy=null;
		FileInputStream fss = new FileInputStream(filename);
		XSSFWorkbook wbb=new XSSFWorkbook(fss);
		XSSFSheet shh =wbb.getSheetAt(0);
		XSSFRow rowss;
		XSSFCell celll;

		int rowCount1 = shh.getLastRowNum();
		int columnCount1 = shh.getRow(0).getLastCellNum();
		arrayy=new String[rowCount1][columnCount1];
		for(int c=1;c<rowCount1+1;c++)
		{
		for(int d=0;d<columnCount1;d++)
		{
		rowss=shh.getRow(c);
		celll=rowss.getCell(d);
		arrayy[c-1][d]=celll.getStringCellValue();
		}
		}

		return arrayy;
		}
		@AfterMethod
		public void teardown()
		{
			driver.close();
		}
	}


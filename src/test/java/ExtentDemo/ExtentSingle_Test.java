package ExtentDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentSingle_Test {
    
	 ExtentSparkReporter htmlReport;
	 ExtentReports extent;
	 ExtentTest test;
	 
	
     WebDriver driver;
	
	@BeforeSuite
	public void openbrowser() {
		
		System.out.println("openbrowser");
		System.setProperty("webdriver.chrome.driver", "H:\\Software Testing Course\\Automation Manual Testing\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	@BeforeTest
	public void url() throws InterruptedException {
		
		htmlReport = new ExtentSparkReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		
		test = extent.createTest("first test","discription");
		
		
		System.out.println("enter url");
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(3000);
	}
	@BeforeClass
	public void maximize() {
		
		System.out.println("maximize browser");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getcookies() {
		
	}
	
	@Test
	public void businesslogic_1() throws InterruptedException {
		
		System.out.println("Test one Completed");
		
		test.info("user is on home page");
		
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"])[2]"))).perform();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[contains(text(),'User Login')])[2]")).click();
		test.info("click on login button");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//input[@id=\"sign_user_email\"]")).sendKeys("sonawanesushil5700@gmail.com");
        test.info("entered email id");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//input[@id=\"sign_user_password\"]")).sendKeys("Sushil@123");
        test.info("entred passowrd");
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("(//button[contains(text(),\"Log in\")])[1]")).click();
        test.info("clicked on login button");
        Thread.sleep(3000);
        
        WebElement x = driver.findElement(By.xpath("//button[@class=\"close open_parent\"]"));
        boolean True = x.isDisplayed();
        
        if(True) {
        	
        	  x.click();
        	  Thread.sleep(3000);
        	
        	 driver.findElement(By.xpath("//input[@id=\"sign_user_email\"]")).clear();
             Thread.sleep(3000);
             
             driver.findElement(By.xpath("//input[@id=\"sign_user_password\"]")).clear();
             test.info("cleard both user name and passowrd");
             Thread.sleep(3000);
             
             driver.findElement(By.xpath("//input[@id=\"sign_user_email\"]")).sendKeys("sonawanesushil57@gmail.com");
             test.info("entered email id");
             Thread.sleep(3000);
             
             driver.findElement(By.xpath("//input[@id=\"sign_user_password\"]")).sendKeys("Sushil@123");
             test.info("entred passowrd");
        	 Thread.sleep(3000);
        	 
        	 driver.findElement(By.xpath("(//button[contains(text(),\"Log in\")])[1]")).click();
             test.info("clicked on login button");
             Thread.sleep(3000);
             
             
             
        }else {
        	
        }
        
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);
		
        act.click(driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"])[4]"))).perform();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("(//a[contains(text(),\"Log Out\")])[2]")).click();
        test.info("user logged out");
        test.info("test pass");
		
	}
	@AfterMethod
	public void takescreenshot() {
		
	}
	@AfterClass
	public void dlcookies() {
		
	}
	@AfterTest
	public void dbconnectionclosd() {
		
		extent.flush();
		
	}
	@AfterSuite
	public void closebrowser() {
		
		System.out.println("closebrowser");
		driver.close();
	}

}

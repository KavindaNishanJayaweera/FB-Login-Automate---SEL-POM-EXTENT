package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.HomePage;
import Pages.LoginPage;

public class LoginTest {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver = null;
	LoginPage ologinpage;
	HomePage ohomepage;
	SoftAssert sa;
	boolean navigateBack = false;
	
	// SETUPING EXTENT REPORTS
	@BeforeSuite
	public void setEnv() {
		
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	//SETUPING TESTING ENVIROMENT
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kavinda Jayaweera\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		sa = new SoftAssert();
		
		//First test case for Page loading succefully
		ExtentTest test = extent.createTest("Facebook home page loading", "Sample");
		
		//Checking URL loaded or not succefully
		try {
            driver.get("https://www.facebook.com/");
            ologinpage = new LoginPage(driver);
            test.pass("Facebook login page loaded");
        } 
		
		catch (Exception e) {
            test.fail("Failed to navigate to Facebook: " + e.getMessage());
        }
		
	}
	
	// TEST CASE 01 : FACEBOOK LOGIN WITH INVALID EMAIL
	@Test(priority = 1)
	public void loginWrongEmail() {
		ExtentTest test1 = extent.createTest("Facebook login with invalid email", "Sample");
		ologinpage.clearTextFields();
		ologinpage.addUserName("peasdfcsf0@yalhethum.com");
		ologinpage.addPassword("qwertQWERT");
		ologinpage.clickLogin();
		test1.pass("Cant login with Invalid Email");
	}
	
	// TEST CASE: FACEBOOK LOGIN WITH WRONG PASSWORD
	@Test(priority = 2)
	public void loginWrongPassword() {
		ExtentTest test2 = extent.createTest("Facebook login with Wrong Password", "Sample");
		ologinpage.clearTextFields();
		ologinpage.addUserName("pearly640@yalhethum.com");
		ologinpage.addPassword("123456789");
		ologinpage.clickLogin();
		test2.pass("Cant login with Wrong Password");
	}
	
	// TEST CASE: FACEBOOK LOGIN WITH WRONG CREDENTIALS
	@Test(priority = 3)
	public void loginWrongCredentiols() {
		ExtentTest test3 = extent.createTest("Facebook login with Wrong Credentiols", "Sample");
		ologinpage.clearTextFields();
		ologinpage.addUserName("pesdss0@yalhethum.com");
		ologinpage.addPassword("123456789");
		ologinpage.clickLogin();
		test3.pass("Cant login with Invalid Email and Password");
	}
	
	// TEST CASE: FACEBOOK LOGIN WITH NULL VALUES
	@Test(priority = 4)
	public void loginNullValues() {
		ExtentTest test4 = extent.createTest("Facebook login with null values", "Sample");
		ologinpage.clearTextFields();
		ologinpage.addUserName("");
		ologinpage.addPassword("");
		ologinpage.clickLogin();
		test4.pass("Cant login with null values");
		
	}
	
	// TEST CASE: CLICK FORGOTTEN PASSWORD
	@Test(priority = 5)
	public void clickForgattenPassword() {
		ExtentTest test5 = extent.createTest("Facebook login clcik another button", "Sample");
		ologinpage.clearTextFields();
		ologinpage.addUserName("pearly640@yalhethun.com");
		ologinpage.addPassword("qwertQWERT");
		ologinpage.clickForgottenPassword();
		test5.pass("Cant login and naviagte to Facebook login poge");
	}
	
	// TEST CASE: FACEBOOK LOGIN WITH VALID CREDENTIALS
	@Test(priority = 6)
	public void loginValidCredentiols() {
		
		//In here need to load Facebook URL again
		//Because previoyes test case written for click forgottten butyon
	
	    driver.get("https://www.facebook.com/");
	    
		ExtentTest test6 = extent.createTest("Facebook login with valid Credentiols", "Sample");
		ologinpage.clearTextFields();
		ologinpage.addUserName("pearly640@yalhethun.com");
		ologinpage.addPassword("qwertQWERT");
		ologinpage.clickLogin();
		test6.pass("Can login with valid Email and Password");
		
		
		//Access the Home page 
		ohomepage = new HomePage(driver);
		
		//Checking the User name for succesfully login or not
		sa.assertEquals(driver.findElement(By.xpath("//div[@class='xg87l8a x1iymm2a']/span")).getText(),"Welcome to Facebook, Pearly");
		
		//Logout
		ohomepage.clickSettings();
		ohomepage.clickLogOut();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		sa.assertAll();
		extent.flush();
	}
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver = null;
	
	// GETTING PATH TO WEB ELEMENTS AVAILABLE IN FACEBOOK LOGIN PAGE
	By txtUserName = By.id("email");
	By txtPassword = By.name("pass");
	By loginBtn = By.name("login");
	By forgettenpaswordLink = By.xpath("//div[3]/a");
	//div[@class='_6ltj']/a

	
	// DEFINING CONSTRUCTOR TO CAPTURE DRIVER URL
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	// CLEAR TEXT FIELDS BEFORE RUNNING EACH TEST CASE
	 public void clearTextFields() {
	        driver.findElement(txtUserName).clear();
	        driver.findElement(txtPassword).clear();
	}
	 
	public void addUserName(String username) {
		driver.findElement(txtUserName).sendKeys(username);
	}
	
	public void addPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public void clickForgottenPassword() {
		driver.findElement(forgettenpaswordLink).click();
	}
	
	
}

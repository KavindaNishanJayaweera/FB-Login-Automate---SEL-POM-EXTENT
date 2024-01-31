package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver = null;
	
	//GETTING PATH TO WEB ELEMENTS AVAILABLE IN FACEBOOK HOME PAGE AFTER SUCCEFULLY LOGGED IN
	By txtLoggedName = By.xpath("//div[@class='xg87l8a x1iymm2a']/span");
	By btnSettings = By.xpath("//div[@class='x1rg5ohu x1n2onr6 x3ajldb x1ja2u2z']");
	By btnLogout = By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[5]/div/div[1]/div[2]/div/div/div/div/span");
			
	// DEFINING CONSTRUCTOR TO CAPTURE DRIVER URL
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSettings() {
		driver.findElement(btnSettings).click();
	}
	
	public void clickLogOut() {
		driver.findElement(btnLogout).click();
	}
	

}

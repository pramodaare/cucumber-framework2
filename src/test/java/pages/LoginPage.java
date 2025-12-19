package pages;

import factory.DriverFactory;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class LoginPage {

    By username = By.name("username");
    By password = By.name("password");;
    By loginBtn = By.xpath("//button[@type='submit']");

    public void openLoginPage() {
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void login(String user, String pass) {
        DriverFactory.getDriver().findElement(username).sendKeys(user);
        DriverFactory.getDriver().findElement(password).sendKeys(pass);
        DriverFactory.getDriver().findElement(loginBtn).click();          
    }
    
    public void adminModule() {
    	//String msg="Upgrade";
    	if(DriverFactory.getDriver().findElement(By.xpath("//button[normalize-space()='Upgrade']")).isDisplayed())
    	{
    		System.out.println("admin logged in successfully");
    	}
    }
    
    public void errmsg(String expectedMessage) {
    	
    	WebElement errorMsg = DriverFactory.getDriver().findElement(
                By.xpath("//p[contains(@class,'oxd-alert-content-text') or contains(@class,'oxd-input-field-error-message')]")
            );

            String actualMessage = errorMsg.getText();
            Assert.assertEquals(expectedMessage, actualMessage);
            
        }
    
    
    
}

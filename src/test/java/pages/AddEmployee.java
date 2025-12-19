package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import factory.DriverFactory;

public class AddEmployee {

	By firstName = By.name("firstName");
	By middleName = By.name("middleName");
	By lastName = By.name("lastName");
	By empId = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By save= By.xpath("//button[normalize-space()='Save']");
	

	By dob         = By.xpath("(//input[@class='oxd-input oxd-input--active' and @placeholder='yyyy-dd-mm'])[2]");
	By maleRadio   = By.xpath("//label[text()='Male']");
	By femaleRadio = By.xpath("//label[text()='Female']");
	By nationalityDD   = By.xpath("(//div[@clear='false'][normalize-space()='-- Select --'])[1]");
	By maritalStatusDD = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]");    By personalSaveBtn =By.xpath("(//button[@type='submit'])[1]");
    
	By bloodGroupDD = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]");
	By customSaveBtn = By.xpath("(//button[@type='submit'])[2]");

	WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
	
	public void enterEmployeeDetails(String fName, String mName, String lName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
		DriverFactory.getDriver().findElement(middleName).sendKeys(mName);
		DriverFactory.getDriver().findElement(lastName).sendKeys(lName);
		//DriverFactory.getDriver().findElement(empId).clear();
		//DriverFactory.getDriver().findElement(empId).sendKeys(id);

	}

	/*public void enterName(String fName, String mName, String lName) {
		DriverFactory.getDriver().findElement(firstName).clear();
		DriverFactory.getDriver().findElement(firstName).sendKeys(fName);

		DriverFactory.getDriver().findElement(middleName).clear();
		DriverFactory.getDriver().findElement(middleName).sendKeys(mName);

		DriverFactory.getDriver().findElement(lastName).clear();
		DriverFactory.getDriver().findElement(lastName).sendKeys(lName);
	}*/
	
	public void selectNationality(String nationality) {
		selectDropdown(nationalityDD, nationality);
	}

	public void selectMaritalStatus(String status) {
		
		//Select selmar=new Select(DriverFactory.getDriver().findElement(maritalStatusDD));
		//selmar.selectByVisibleText("Single");
		//DriverFactory.getDriver().findElement(maritalStatusDD).sendKeys("Single");
		selectDropdown(maritalStatusDD, status);
	}
	
	public void selectDOB(String date) {
		WebElement dobField = wait.until(ExpectedConditions.elementToBeClickable(dob));
	    dobField.clear();
	    dobField.sendKeys(date);
	}

	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			DriverFactory.getDriver().findElement(maleRadio).click();
		} else {
			DriverFactory.getDriver().findElement(femaleRadio).click();
		}
	}

	public void savePersonalDetails() {
		DriverFactory.getDriver().findElement(personalSaveBtn).click();
	}

	public void selectBloodGroup(String bloodGroup) {
		wait.until(ExpectedConditions.elementToBeClickable(bloodGroupDD)).click();
		//DriverFactory.getDriver().findElement(By.xpath("//span[text()='" + bloodGroup + "']")).click();
	}

	public void saveCustomFields() {
		DriverFactory.getDriver().findElement(customSaveBtn).click();
	}

	
	public void selectDropdown(By locator, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		DriverFactory.getDriver().findElement(By.xpath("//span[text()='" + value + "']")).click();
	}


}

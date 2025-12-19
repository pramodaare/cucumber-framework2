package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployee;
import pages.LoginPage;

public class EmployeeSteps {
	
	AddEmployee emp=new AddEmployee();
	
	@When("user clicks on PIM module")
    public void user_clicks_pim() {
        DriverFactory.getDriver().findElement(By.xpath("//span[text()='PIM']")).click();
    }

    @When("user clicks on Add Employee")
    public void user_clicks_add_employee() {
    	DriverFactory.getDriver().findElement(By.xpath("//a[text()='Add Employee']")).click();
    }

    @When("user enters employee details")
    public void user_enters_employee_details() {
    	emp.enterEmployeeDetails("Aare", "aa1", "Kumar");
    }

    @When("user clicks on Save button")
    public void user_clicks_save() {
    	DriverFactory.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user should be navigated to Employee List page")
    public void user_navigated_employee_list() {
    	DriverFactory.getDriver().findElement(By.xpath("//h6[text()='Personal Details']"));
    }

    @When("user clicks on Personal Details")
    public void user_clicks_personal_details() {
        // Already on Personal Details after save
        System.out.println("Navigated to Personal Details page");
    }
    
    
    
    @When("user add remaining missing details")
    public void user_add_remaining_missing_details() throws InterruptedException {
    	Thread.sleep(20000);
    	//emp.enterName("Pramod", "Kumar", "Aare");
    	emp.selectNationality("Indian");
    	Thread.sleep(20000);
    	//emp.selectMaritalStatus();
    	emp.selectMaritalStatus("Single");
    	Thread.sleep(20000);
    	emp.selectDOB("2001-29-10");
    	Thread.sleep(20000);
    	emp.selectGender("Male");
    	Thread.sleep(20000);
    	emp.savePersonalDetails();
    }
  
    @Then("personal details should be saved successfully")
    public void personal_details_saved_be_saved_successfully() {
    	DriverFactory.getDriver().findElement(By.xpath("//p[text()='Successfully Updated']"));
        //DriverFactory.getDriver().quit();
    }
    
    @When("user enter remaining details in Custom fields")
    public void user_enter_remaining_details_in_Custom_fields() {
    	emp.selectBloodGroup("O+");
    	emp.saveCustomFields();
    }
     
    @Then("Custom fields should be saved successfully")
    public void Custom_fields_should_be_saved_successfully() {
    	DriverFactory.getDriver().findElement(By.xpath("//p[text()='Successfully Updated']"));
        //DriverFactory.getDriver().quit();
    }

    

}

    
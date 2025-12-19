package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {

    LoginPage login = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        login.openLoginPage();
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        login.login("Admin", "admin123");
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        login.adminModule();
    }
    
    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
    	 login.login("username", "password");
    }
    
    @Then("error message should be displayed as {string}")
    public void error_message_should_be_displayed(String expectedMessage) {
    	login.errmsg("Invalid credentials");
        
    }
    
}


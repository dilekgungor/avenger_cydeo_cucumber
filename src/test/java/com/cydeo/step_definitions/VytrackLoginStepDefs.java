package com.cydeo.step_definitions;

import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VytrackLoginStepDefs {
    VytrackLoginPage loginPage=new VytrackLoginPage();
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("envytrack"));
    }
    @When("User enters the valid username")
    public void user_enters_the_valid_username() {
        loginPage.userInput.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
    }
    @When("User enters the valid password")
    public void user_enters_the_valid_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));
    }
    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.loginButton.click();
    }
    @Then("User should be able to see {string} as title")
    public void user_should_be_able_to_see_dashboard_as_title(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
       Assert.assertEquals(expectedTitle, actualTitle);

    }

}

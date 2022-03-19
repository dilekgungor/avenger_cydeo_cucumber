package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.junit.Assert;

import java.util.Optional;

public class CalculatorStepDefs {

    Integer actualResult;
    @Given("Calculator app is opened")
    public void calculator_app_is_opened() {
        System.out.println("Calulator is opened");
    }

    @When("User add {int} with {int}")
    public void user_add_with(Integer int1, Integer int2) {
        actualResult=int1+int2;
    }

    @Then("User should see {int} as expected")
    public void user_should_see_as_expected(Integer expectedResult) {
        Assert.assertEquals(expectedResult, actualResult);
    }


}

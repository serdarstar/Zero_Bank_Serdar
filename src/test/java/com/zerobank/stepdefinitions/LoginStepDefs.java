package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.SignInPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {
    public WebDriver driver=Driver.get();

    @Given("the user sign in succesfully")
    public void theUserSignInSuccesfully() {
        String url=ConfigurationReader.get("url");
        driver.get(url);
        SignInPage signInPage=new SignInPage();
        signInPage.signInButton.click();
    }

    @When("the user sends login info")
    public void theUserSendsLoginInfo() {
        LoginPage loginPage=new LoginPage();
        loginPage.loginButton.sendKeys("username");
        loginPage.passwordButton.sendKeys(ConfigurationReader.get("password"));
    }

    @Then("the user logs in succesfully")
    public void theUserLogsInSuccesfully() {

            LoginPage loginPage=new LoginPage();
            if(loginPage.loginButton.getAttribute("value").equals("username")&&loginPage.passwordButton.getAttribute("value").equals("password")){
                loginPage.signInButton.click();
            }else if (!loginPage.loginButton.getAttribute("value").equals("username")&&loginPage.passwordButton.getAttribute("value").equals("password"))
                {
                loginPage.signInButton.click();
                Assert.assertTrue(loginPage.alertMessage.isDisplayed());
            }
    }



}

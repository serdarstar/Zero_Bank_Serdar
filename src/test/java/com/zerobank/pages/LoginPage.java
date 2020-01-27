package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){ PageFactory.initElements(Driver.get(), this);
    }
    @FindBy (id = "user_login")
    public WebElement loginButton;

    @FindBy(id = "user_password")
    public WebElement passwordButton;

    @FindBy(name = "submit")
    public WebElement signInButton;

    @FindBy (xpath = "//div[@class='alert alert-error']")
    public WebElement alertMessage;



}

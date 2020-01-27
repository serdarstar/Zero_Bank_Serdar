package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage extends BasePage{
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//h2[@class='board-header']")
    public WebElement accountTypes;

    @FindBy(xpath = "//li[@id='account_activity_tab']")
    public WebElement accountActivityTab;

    @FindBy(linkText = "Savings")
    public WebElement savingsLink;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerageLink;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCardLink;

    @FindBy(linkText = "Loan")
    public WebElement loanLink;


}

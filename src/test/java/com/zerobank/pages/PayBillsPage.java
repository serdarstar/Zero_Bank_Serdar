package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBillsPage {
    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//input[@name='amount']")
    public WebElement amountBox;

    @FindBy(id = "sp_date")
    public WebElement dateBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy (id = "alert_content")
    public WebElement paymentAlert;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayee;

    @FindBy(id = "np_new_payee_name")
    public WebElement newPayeeBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement newPayeeAddressBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement newPayeeAccountBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement newPayeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement addNewPayeeButton;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement alertMessage;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;


}

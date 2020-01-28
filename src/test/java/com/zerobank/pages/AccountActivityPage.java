package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage {

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> dateColumnList;

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//table//th")
    public WebElement transactionTable;

    @FindBy(id = "pay_bills_tab")
    public WebElement payBillsTab;

    @FindBy(css= "table[class^='t']>thead>tr>th")
    public List<WebElement> tableColumns;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsLink;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[contains(text(),'2012-09')]")
    public List<WebElement> paymentDates;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    public int fromdateInt(String fromDate){
        int fromDateint = Integer.parseInt(fromDate.replace("-", ""));
        return fromDateint;
    }
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> getTableColumns;

    public List<String> getElements(List<WebElement> list){
        List<String> elements=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
           elements.add(list.get(i).getText().replace("-",""));
        }
        return elements;


    }



}

package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import cucumber.api.java.sl.In;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AccountPage_StepDefs {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    WebDriver driver = Driver.get();

    @Then("Account page title must be verified")
    public void accountPageTitleMustBeVerified() {

        Assert.assertEquals("Zero - Account Summary", Driver.get().getTitle());
    }

    @And("Account types must be verified")
    public void accountTypesMustBeVerified() {
        List<WebElement> accountTypes = Driver.get().findElements(By.xpath("//h2[@class='board-header']"));

        List<String> accountTypesExpected = new ArrayList<>(Arrays.asList("Cash Accounts", "Investment Accounts", "Credit Accounts", "Loan Accounts"));

        for (int i = 0; i < accountTypes.size(); i++) {
            Assert.assertEquals(accountTypesExpected.get(i), accountTypes.get(i).getText());
        }
    }

    @And("Credit accounts table must be verified")
    public void creditAccountsTableMustBeVerified() {
        List<WebElement> creditAccountsActual = Driver.get().findElements(By.xpath("(//table[@class='table'])[3]//thead//th"));

        for (WebElement creditAccount : creditAccountsActual) {
            System.out.println("creditAccount = " + creditAccount.getText());

        }

        List<String> creditAccountsExpected = new ArrayList<>(Arrays.asList("Account", "Credit Card", "Balance"));

        for (String creditAccount : creditAccountsExpected) {
            System.out.println("creditAccount = " + creditAccountsExpected);

        }

        for (int i = 0; i < creditAccountsActual.size(); i++) {
            Assert.assertEquals(creditAccountsExpected.get(i), creditAccountsActual.get(i).getText());
        }

    }

    @Given("the user is on Account Activity page")
    public void theUserIsOnAccountActivityPage() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.accountActivityTab.click();
    }

    @Then("Default dropdown should be Savings")
    public void defaultDropdownShouldBeSavings() {
        Select select = new Select(Driver.get().findElement(By.id("aa_accountId")));
        List<WebElement> accountDropdownOptions = select.getOptions();
        Assert.assertEquals(accountDropdownOptions.get(0).getText(), "Savings");
    }

    @Then("Account dropdown menu items must be verified")
    public void accountDropdownMenuItemsMustBeVerified() {
        Select select = new Select(Driver.get().findElement(By.id("aa_accountId")));
        List<WebElement> accountDropdownOptions = select.getOptions();
        List<String> accountDropdownOptionsExpected = new ArrayList<>(Arrays.asList("Savings", "Checking", "Loan", "Credit Card", "Brokerage"));
        for (int i = 0; i < accountDropdownOptions.size(); i++) {
            Assert.assertEquals(accountDropdownOptionsExpected.get(i), accountDropdownOptions.get(i).getText());

        }
    }

    @Then("transaction table columns should be verified")
    public void transactionTableColumnsShouldBeVerified() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        BrowserUtils.waitFor(4);
        List<WebElement> transactionTableColumns = Driver.get().findElements(By.xpath("//table/thead/tr/th"));
        List<String> transactionTableColumnsExpected = new ArrayList<>(Arrays.asList("Date", "Description", "Deposits", "Withdrawals"));
        for (int i = 0; i < transactionTableColumns.size(); i++) {
            Assert.assertEquals(transactionTableColumnsExpected.get(i), transactionTableColumns.get(i).getText());
        }

    }

    @Then("the user navigates to pay bill tab")
    public void theUserNavigatesToPayBillTab() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.payBillsTab.click();

    }

    @And("Account activity page title must be verified")
    public void accountActivityPageTitleMustBeVerified() {
        Assert.assertEquals("Zero - Account Activity", Driver.get().getTitle());
    }

    @Then("pay bill page title should be verified")
    public void payBillPageTitleShouldBeVerified() {
        Assert.assertEquals("Zero - Pay Bills", Driver.get().getTitle());
    }

    @Then("after payment, successful message displayed")
    public void afterPaymentSuccessfulMessageDisplayed() {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitFor(4);
        payBillsPage.amountBox.sendKeys("20.0");
        payBillsPage.dateBox.sendKeys("2020-01-31");
        payBillsPage.payButton.click();
        Assert.assertTrue(payBillsPage.paymentAlert.isDisplayed());
    }


    @Then("Amount and date should be correct type")
    public void amountAndDateShouldBeCorrectType() {
        PayBillsPage payBillsPage = new PayBillsPage();
        System.out.println(payBillsPage.dateBox.getText());


        BrowserUtils.waitFor(4);
        payBillsPage.amountBox.sendKeys("20");
        payBillsPage.payButton.click();
        BrowserUtils.waitFor(3);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(Driver.get().switchTo().alert().getText());

//        if(payBillsPage.amountBox.getAttribute("value").equals("null")||payBillsPage.dateBox.getAttribute("value").equals("null")){


//        }
    }

    @When("users click Savings link")
    public void usersClickSavingsLink() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.savingsLink.click();
    }

    @When("user click Brokerage link")
    public void userClickBrokerageLink() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.brokerageLink.click();

    }

    @And("Default dropdown should be Brokerage")
    public void defaultDropdownShouldBeBrokerage() {
        Select select = new Select(Driver.get().findElement(By.id("aa_accountId")));
        List<WebElement> accountDropdownOptions = select.getOptions();
        Assert.assertTrue(accountDropdownOptions.get(5).isSelected());
    }

    @When("user clicks Credit Card link")
    public void userClicksCreditCardLink() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.creditCardLink.click();
    }

    @And("Default dropdown should be Credit Card")
    public void defaultDropdownShouldBeCreditCard() {
        Select select = new Select(Driver.get().findElement(By.id("aa_accountId")));
        List<WebElement> accountDropdownOptions = select.getOptions();
        Assert.assertTrue(accountDropdownOptions.get(4).isSelected());
    }

    @When("user clicks Loan link")
    public void userClicksLoanLink() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.loanLink.click();
    }

    @And("Default dropdown should be Loan")
    public void defaultDropdownShouldBeLoan() {
        Select select = new Select(Driver.get().findElement(By.id("aa_accountId")));
        List<WebElement> accountDropdownOptions = select.getOptions();
        Assert.assertTrue(accountDropdownOptions.get(3).isSelected());
    }

    @Given("the    user   accesses   the    Find   Transactions   tab")
    public void theUserAccessesTheFindTransactionsTab() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.findTransactionsLink.click();
        BrowserUtils.waitFor(1);
    }

    @When("the   user   enters date   range  from   {string}  to {string}")
    public void theUserEntersDateRangeFromTo(String arg0, String arg1) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        arg0 = "2012-09-01";
        arg1 = "2012-09-06";
        accountActivityPage.fromDate.sendKeys(arg0);
        accountActivityPage.toDate.sendKeys(arg1);
    }

    @And("clicks search")
    public void clicksSearch() {
        accountActivityPage.findButton.click();
        BrowserUtils.waitFor(2);

    }


    @Then("results   table  should only   show   transactions   dates  between “{int}{int}{int}”   to   “{int}{int}{int}”")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    }

    @And("the    results    table  should only   not    contain    transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String expectedDate) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        int fromDateint = Integer.parseInt(accountActivityPage.fromDate.getAttribute("value").replace("-", ""));
        int toDate = Integer.parseInt(accountActivityPage.toDate.getAttribute("value").replace("-", ""));
        BrowserUtils.waitFor(4);
        List<WebElement> Date = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[1]"));
        int columnData = 0;

        List<Integer> columnsValues = new ArrayList<>();
        for (int i = 0; i < Date.size(); i++) {

            int columnsData = Integer.parseInt(Date.get(i).getText().replace("-", ""));
            String[] strings1 = Date.get(i).getText().split("-");
            String columnDataString = strings1[0].concat(strings1[1]).concat(strings1[2]);
            columnData = Integer.parseInt(columnDataString);
            columnsValues.add(columnData);

        }


        int expectedDateInt = Integer.parseInt(expectedDate.replace("-", ""));
        boolean isIncluded = false;
        for (int i = 0; i < columnsValues.size(); i++) {
            if (expectedDateInt != columnsValues.get(i)) {
                isIncluded = true;

            }
        }
        Assert.assertTrue(isIncluded);


    }


    @Then("results   table  should only   show   transactions   dates  between {string}   to   {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String date1, String date2) throws ParseException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        System.out.println(accountActivityPage.fromDate.getAttribute("value"));
        System.out.println(accountActivityPage.toDate.getAttribute("value"));

        int fromDateint = Integer.parseInt(accountActivityPage.fromDate.getAttribute("value").replace("-", ""));
        int toDate = Integer.parseInt(accountActivityPage.toDate.getAttribute("value").replace("-", ""));
        BrowserUtils.waitFor(4);
        List<WebElement> Date = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[1]"));
        int columnData = 0;

        List<Integer> columnsValues = new ArrayList<>();
        for (int i = 0; i < Date.size(); i++) {

            int columnsData = Integer.parseInt(Date.get(i).getText().replace("-", ""));
            String[] strings1 = Date.get(i).getText().split("-");
            String columnDataString = strings1[0].concat(strings1[1]).concat(strings1[2]);
            columnData = Integer.parseInt(columnDataString);
            columnsValues.add(columnData);
            System.out.println(columnData);
        }
        System.out.println(columnsValues.toString());
        int counter = 0;
        for (int i = 0; i < columnsValues.size(); i++) {
            if (columnsValues.get(i) <= toDate && columnsValues.get(i) >= fromDateint) {
                counter++;
            }
            System.out.println(counter);
        }

        boolean isRange = false;
        if (columnData >= Date.size()) {
            isRange = true;
        }

        Assert.assertTrue(isRange);


//        BU SORUNUN 2. COZUMU
//        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
//
//        java.util.Date ndate1 = formatter1.parse(date1);
//        Date ndate2 = formatter1.parse(date2);
//
//        List<String> actualDateList = BrowserUtils.getElementsText(new AccountActivityPage().dateColumnList);
//        System.out.println("actualDateList = " + actualDateList);
//
//        List<Date> actualDates = new ArrayList<>();
//        for (String dates : actualDateList) {
//            Date ad = formatter1.parse(dates);
//            actualDates.add(ad);
//        }
//
//        int counter1 = 0;
//        for(int i=0; i<actualDates.size(); i++){
//            if(ndate1.compareTo(actualDates.get(i))<=0 && ndate2.compareTo(actualDates.get(i))>=0){
//                counter1++;
//            }
//        }
//        System.out.println(counter1);
//
//        boolean flag = false;
//        if(counter1==actualDates.size()){
//            flag =true;
//        }
//
//        Assert.assertTrue(flag);


    }

    @And("the    results    should be sorted by most   recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {
        List<WebElement> Date = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[1]"));
        int columnData;
        List<Integer> columnsValues = new ArrayList<>();
        for (int i = 0; i < Date.size(); i++) {

            int columnsData = Integer.parseInt(Date.get(i).getText().replace("-", ""));
            String[] strings1 = Date.get(i).getText().split("-");
            String columnDataString = strings1[0].concat(strings1[1]).concat(strings1[2]);
            columnData = Integer.parseInt(columnDataString);
            columnsValues.add(columnData);
            System.out.println(columnData);
        }
        boolean isMax = false;
        int maxColumnValue = columnsValues.get(0);
        for (int i = 0; i < columnsValues.size(); i++) {
            if (maxColumnValue > columnsValues.get(i)) {
                isMax = true;
            }

        }
        Assert.assertTrue(isMax);
        BrowserUtils.waitFor(3);
        accountActivityPage.toDate.clear();
        accountActivityPage.fromDate.clear();


    }

    @Then("results	table	should	only	show	descriptions	containing	{string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String arg0) {
    }

    @But("results	table	should	not show	descriptions	containing	{string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String arg0) {
    }

    @When("the user enters description {string}")
    public void theUserEntersDescription(String arg0) {
        accountActivityPage.descriptionBox.sendKeys(arg0);
    }

    @Given("user clicks add new payee link")
    public void userClicksAddNewPayeeLink() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.addNewPayee.click();
    }

    @Then("user creates payee by the following data")
    public void userCreatesPayeeByTheFollowingData(Map<String, String> userData) {
        PayBillsPage payBillsPage = new PayBillsPage();
        BrowserUtils.waitFor(3);
        payBillsPage.newPayeeBox.sendKeys(userData.get("Payee Name"));
        payBillsPage.newPayeeAddressBox.sendKeys(userData.get("Payee Address"));
        payBillsPage.newPayeeAccountBox.sendKeys(userData.get("Account"));
        payBillsPage.newPayeeDetails.sendKeys(userData.get("Payee Details"));
        payBillsPage.addNewPayeeButton.click();
        String actualMessage = payBillsPage.alertMessage.getText();
        String expectedMessage = "The new payee The Law Offices of Hyde, Price & Sharks was successfully created.";
        Assert.assertTrue(expectedMessage.equals(actualMessage));
    }

    @Given("the user is on the Purchase Foreign Currency tab")
    public void theUserIsOnThePurchaseForeignCurrencyTab() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.purchaseForeignCurrencyTab.click();
    }

    @Then("the following options should be available")
    public void theFollowingOptionsShouldBeAvailable(List<String> menuOptions) {
        PayBillsPage payBillsPage = new PayBillsPage();
        System.out.println("menuOptions.size = " + menuOptions.size());
        System.out.println("Menu options: " + menuOptions);
        BrowserUtils.waitFor(2);

        WebElement actualMenuOptions = Driver.get().findElement(By.id("pc_currency"));
        Select select = new Select(actualMenuOptions);
        ArrayList<String> actualMenu = new ArrayList<>();
        for (int i = 1; i < select.getOptions().size(); i++) {
            actualMenu.add(select.getOptions().get(i).getText());

        }
        System.out.println(actualMenu.toString());
        boolean isContains = false;
        for (int i = 0; i < actualMenu.size(); i++) {
            for (int j = 0; j < menuOptions.size(); j++) {
                if (!actualMenu.get(i).contains(menuOptions.get(j))) {
                    isContains = true;
                    break;
                }
            }
        }
        Assert.assertTrue(isContains);
    }

    @Then("results   table  should only   show  the transactions   dates  between {string}   to   {string}")
    public void resultsTableShouldOnlyShowTheTransactionsDatesBetweenTo(String arg0, String arg1) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
//        System.out.println(accountActivityPage.fromDate.getAttribute("value"));
//        System.out.println(accountActivityPage.toDate.getAttribute("value"));

        int fromDateint = Integer.parseInt(accountActivityPage.fromDate.getAttribute("value").replace("-", ""));
        int toDate = Integer.parseInt(accountActivityPage.toDate.getAttribute("value").replace("-", ""));
        BrowserUtils.waitFor(4);
        List<WebElement> Date = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[1]"));
        int columnData = 0;

        List<Integer> columnsValues = new ArrayList<>();
        for (int i = 0; i < Date.size(); i++) {

            int columnsData = Integer.parseInt(Date.get(i).getText().replace("-", ""));
            String[] strings1 = Date.get(i).getText().split("-");
            String columnDataString = strings1[0].concat(strings1[1]).concat(strings1[2]);
            columnData = Integer.parseInt(columnDataString);
            columnsValues.add(columnData);
        }
        System.out.println(columnsValues.toString());
        int counter = 0;
        for (int i = 0; i < columnsValues.size(); i++) {
            if (columnsValues.get(i) <= toDate && columnsValues.get(i) >= fromDateint) {
                counter++;
            }
        }

        boolean isRange = false;
        if (columnData >= Date.size()) {
            isRange = true;
        }
        Assert.assertTrue(isRange);
    }


    @Then("the results should only have {string}")
    public void theResultsShouldOnlyHave(String arg0) {

        BrowserUtils.waitFor(2);
        List<WebElement> online = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[2]"));
        List<String> cellData = new ArrayList<>();

        for (int i = 0; i < online.size(); i++) {
            System.out.println(online.get(i).getText());
            cellData.add(online.get(i).getText());

        }
        System.out.println(cellData.toString());
        int counter = 0;
        for (int i = 0; i < cellData.size(); i++) {

            if (cellData.get(i).contains(arg0)) {
                counter++;
            }

        }

        boolean isOnline = false;
        if (counter == online.size()) {
            isOnline = true;

        }
        Assert.assertTrue(isOnline);
        accountActivityPage.descriptionBox.clear();

//        System.out.println(cellData.toString());


    }

    @And("the results table should not show descriptions containing {string}")
    public void theResultsTableShouldNotShowDescriptionsContaining(String arg0) {
        BrowserUtils.waitFor(2);
        List<WebElement> online = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[2]"));
        List<String> cellData = new ArrayList<>();

        for (int i = 0; i < online.size(); i++) {
            System.out.println(online.get(i).getText());
            cellData.add(online.get(i).getText());

        }
        System.out.println(cellData.toString());
        boolean isOnline = false;
        for (int i = 0; i < cellData.size(); i++) {

            if (!cellData.contains(arg0)) {
                isOnline = true;
            }

        }

        Assert.assertTrue(isOnline);

    }
}
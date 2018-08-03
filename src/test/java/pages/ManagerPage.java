package pages;

import drivermanager.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ManagerPage extends BasePage{

    private static ManagerPage instance;
    private ManagerPage(){}
    public static ManagerPage getInstance(){
        instance = new ManagerPage();
        return instance;
    }


    @FindBy(css = ".menusubnav > li:nth-child(2) > a:nth-child(1)")
    WebElement newCustomer;

    @FindBy(css = ".menusubnav > li:nth-child(5) > a:nth-child(1)")
    WebElement newAccount;

    @FindBy(css = ".menusubnav > li:nth-child(8) > a:nth-child(1)")
    WebElement deposit;

    private String pageTitle = "Guru99 Bank Manager HomePage";

    public void isLoggedIn(){
        Assert.assertEquals(Driver.getInstance().getTitle(),pageTitle);
        System.out.println("Login Successfully!");
    }

    public void navigateToNewCustomerPage() throws InterruptedException {
        Thread.sleep(1000);
        newCustomer.click();
    }

    public void navigateToNewAccountPage() throws InterruptedException {
        Thread.sleep(1000);
        newAccount.click();
    }

    public void navigateToDepositPage() throws InterruptedException {
        Thread.sleep(1000);
        deposit.click();
    }


}

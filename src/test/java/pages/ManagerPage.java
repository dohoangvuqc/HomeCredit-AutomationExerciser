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


    @FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
    WebElement newCustomer;

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[5]/a")
    WebElement newAccount;

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[8]/a")
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

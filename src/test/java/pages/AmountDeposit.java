package pages;

import drivermanager.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AmountDeposit extends BasePage {

    private static AmountDeposit instance;
    private AmountDeposit(){}
    public static AmountDeposit getInstance(){
        instance = new AmountDeposit();
        return instance;
    }

    private String pageTitle = "Guru99 Bank Amount Deposit Page";

    @FindBy(xpath = "//*[@id=\"deposit\"]/tbody/tr[23]/td[2]")
    WebElement currentBalance;

    public void isDeposited() throws InterruptedException {
        Assert.assertEquals(pageTitle,Driver.getInstance().getTitle());
        Assert.assertEquals(currentBalance.getText(),"30000");
        System.out.println("Deposited 20k cash Successfully!");
        System.out.println("Current Balance is: " + currentBalance.getText());
        Thread.sleep(1500);
    }

}

package pages;

import config.Configuration;
import drivermanager.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NewAccountPage extends BasePage {

    private static NewAccountPage instance;

    private NewAccountPage(){}

    public static NewAccountPage getInstance(){
        instance = new NewAccountPage();
        return instance;
    }

    private String pageTitle = "Guru99 bank add new account";

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")
    WebElement customerIdField;

    @FindBy(name = "selaccount")
    WebElement accountType;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
    WebElement initalDepositField;

    @FindBy(name = "button2")
    WebElement submitBtn;

    @FindBy(name = "reset")
    WebElement resetBtn;



    public void isLoaded(){
        Assert.assertEquals(Driver.getInstance().getTitle(),pageTitle);
        System.out.println("Page Loaded Correctly!");
    }


    public NewAccountPage readAndEnterCustomerID() throws IOException, InterruptedException {

        BufferedReader br = null;
        FileReader fr = null;

        fr = new FileReader(Configuration.getCustomerFilePath());
        br = new BufferedReader(fr);

        customerIdField.sendKeys(br.readLine());

        br.close();
        fr.close();

        Thread.sleep(1000);

        return instance;
    }

    public NewAccountPage selectAccountType(){
        Select select = new Select(accountType);
        select.selectByValue("Current");

        return instance;
    }

    public NewAccountPage initialDeposit(String deposit){
        initalDepositField.sendKeys(deposit);
        return instance;
    }

    public void submitAddNewAccount() throws InterruptedException {
        submitBtn.click();
        Thread.sleep(1500);
    }


}

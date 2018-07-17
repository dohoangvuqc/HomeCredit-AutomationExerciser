package pages;

import config.Configuration;
import drivermanager.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DepositPage extends BasePage {
    private static DepositPage instance;
    private DepositPage(){}
    public static DepositPage getInstance(){
        instance = new DepositPage();
        return instance;
    }
    private String pageTitle = "Guru99 Bank Amount Deposit Page";

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")
    WebElement accountNoField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input")
    WebElement amountField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
    WebElement descriptionField;

    @FindBy(name = "AccSubmit")
    WebElement submitBtn;

    @FindBy(name = "/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input[2]")
    WebElement resetBtn;

    public void isLoaded(){
        Assert.assertEquals(pageTitle,Driver.getInstance().getTitle());
        System.out.println("Page Loaded Correctly!");
    }

    public DepositPage readAndEnterAccountID() throws IOException, InterruptedException {

        BufferedReader br = null;
        FileReader fr = null;

        fr = new FileReader(Configuration.getAccountFilePath());
        br = new BufferedReader(fr);

        accountNoField.sendKeys(br.readLine());

        br.close();
        fr.close();

        Thread.sleep(1000);

        return instance;

    }

    public DepositPage enterAmount(String amount){
        amountField.sendKeys(amount);
        return instance;
    }

    public DepositPage enterDescription(String description){
        descriptionField.sendKeys(description);
        return instance;
    }

    public void submitDeposit() throws InterruptedException {
        submitBtn.click();
        Thread.sleep(1500);
    }

}

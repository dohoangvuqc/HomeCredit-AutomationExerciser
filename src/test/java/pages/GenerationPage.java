package pages;

import config.Configuration;
import drivermanager.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerationPage extends BasePage{

    private static GenerationPage instance;

    private GenerationPage(){}

    public static GenerationPage getInstance(){
        instance = new GenerationPage();
        return instance;
    }

    private String pageTitle = "Gtpl Bank Customer Registration Page";

    @FindBy(xpath = "//*[@id=\"account\"]/tbody/tr[4]/td[2]")
    WebElement accountIdCell;

    @FindBy(xpath = "//*[@id=\"account\"]/tbody/tr[10]/td[2]")
    WebElement currentAmountCell;

    public void isGenerated(){
        Assert.assertEquals(pageTitle, Driver.getInstance().getTitle());
        System.out.println("Account Generated Successfully!");
        ((JavascriptExecutor)Driver.getInstance()).executeScript("arguments[0].style.border='3px solid red'",accountIdCell);
    }

    public void writeData() throws IOException, InterruptedException {
        BufferedWriter bw;
        FileWriter fw;
        String accountID = accountIdCell.getText();
        fw = new FileWriter(Configuration.getAccountFilePath());
        bw = new BufferedWriter(fw);
        bw.write(accountID);
        bw.close();
        fw.close();
        System.out.println("AccountID is: " + accountID);
        System.out.println("Current Ammount is: " + currentAmountCell.getText());
        Thread.sleep(3000);
    }
}

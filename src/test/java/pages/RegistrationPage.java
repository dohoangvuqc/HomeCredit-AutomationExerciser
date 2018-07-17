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

public class RegistrationPage extends BasePage {
    private static RegistrationPage instance;
    private RegistrationPage(){}
    public static RegistrationPage getInstance(){
        instance = new RegistrationPage();
        return instance;
    }

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
    WebElement customerIdCell;

    @FindBy(xpath = "//*[@id=\"account\"]/tbody/tr[4]/td[2]")
    WebElement accountIdCell;



    private String pageTitle = "Guru99 Bank Customer Registration Page";

    public void isRegistered(){
        Assert.assertEquals(Driver.getInstance().getTitle(),pageTitle);
        System.out.println("Customer Registered Successfully!");
        ((JavascriptExecutor)Driver.getInstance()).executeScript("arguments[0].style.border='3px solid red'",customerIdCell);
    }

    public void writeData() throws IOException, InterruptedException {
        BufferedWriter bw;
        FileWriter fw;
        String customerID = customerIdCell.getText();
        fw = new FileWriter(Configuration.getCustomerFilePath());
        bw = new BufferedWriter(fw);
        bw.write(customerID);
        bw.close();
        fw.close();
        System.out.println("CustomerID is: " + customerID);
        Thread.sleep(3000);
    }
}

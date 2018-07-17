package pages;

import drivermanager.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class NewCustomerPage extends BasePage{
    private static NewCustomerPage instance;
    private NewCustomerPage(){}
    public static NewCustomerPage getInstance(){
        instance = new NewCustomerPage();
        return instance;
    }

    private String pageTitle = "Guru99 Bank New Customer Entry Page";

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
    WebElement nameField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
    WebElement male;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
    WebElement female;

    @FindBy(id = "dob")
    WebElement dateBox;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
    WebElement addressField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
    WebElement cityField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
    WebElement stateField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")
    WebElement pinField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input")
    WebElement mobileNumberField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input")
    WebElement emailField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input")
    WebElement passwordField;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
    WebElement submitBtn;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[2]")
    WebElement resetBtn;

    public void isLoaded(){
        Assert.assertEquals(Driver.getInstance().getTitle(),pageTitle);
        System.out.println("Page Loaded Correctly!");
    }

    public NewCustomerPage enterName(String name){
        nameField.sendKeys(name);
        return instance;
    }

    public NewCustomerPage selectGender() throws InterruptedException {
        Thread.sleep(2000);
        if(male.isSelected()){
            female.click();
        }
        return instance;
    }

    public NewCustomerPage enterDOB(String dob){
        dateBox.sendKeys(dob);
        return instance;
    }

    public NewCustomerPage enterAdderss(String address){
        addressField.sendKeys(address);
        return instance;
    }

    public NewCustomerPage enterCity(String city){
        cityField.sendKeys(city);
        return instance;
    }

    public NewCustomerPage enterState(String state){
        stateField.sendKeys(state);
        return instance;
    }

    public NewCustomerPage enterPin(String pin){
        pinField.sendKeys(pin);
        return instance;
    }

    public NewCustomerPage enterMobileNumber(String mobileNumber){
        mobileNumberField.sendKeys(mobileNumber);
        return instance;
    }

    public NewCustomerPage enterEmail(String email){
        emailField.sendKeys(email);
        return instance;
    }

    public NewCustomerPage enterPassword(String password){
        passwordField.sendKeys(password);
        return instance;
    }

    public void submit() throws InterruptedException {
        Thread.sleep(1500);
        submitBtn.click();
    }

}

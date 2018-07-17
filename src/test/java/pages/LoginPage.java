package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private static LoginPage instance;

    private LoginPage(){}

    public static LoginPage getInstance(){
        instance = new LoginPage();
        return instance;
    }

    @FindBy(xpath = "/html/body/form/table/tbody/tr[1]/td[2]/input")
    WebElement userIdField;

    @FindBy(xpath = "/html/body/form/table/tbody/tr[2]/td[2]/input")
    WebElement passwordField;

    @FindBy(name = "btnLogin")
    WebElement loginBtn;

    @FindBy(name = "btnReset")
    WebElement resetBtn;


    public void isLoaded(){
        Assert.assertTrue(loginBtn.isDisplayed());
        System.out.println("Page Loaded Correctly!");
    }


    public LoginPage enterUserID(String userID){
        userIdField.sendKeys(userID);
        return instance;
    }

    public LoginPage enterPassword(String password){
        passwordField.sendKeys(password);
        return instance;
    }

    public void submitLogin(){
        loginBtn.click();
    }

}

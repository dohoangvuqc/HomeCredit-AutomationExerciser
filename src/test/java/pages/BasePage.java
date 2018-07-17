package pages;

import drivermanager.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected static WebDriver driver;

    BasePage(){
        driver = Driver.getInstance();
        PageFactory.initElements(driver, this);
    }
}

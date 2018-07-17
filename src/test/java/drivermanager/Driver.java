package drivermanager;

import config.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static ThreadLocal<WebDriver>webDriverThreadLocal = new ThreadLocal<WebDriver>();

    public static void initialize(String browserName){

        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            InternetExplorerDriverManager.getInstance().setup();
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeDriverManager.getInstance().setup();
            driver = new EdgeDriver();
        }

        webDriverThreadLocal.set(driver);

        Assert.assertNotNull(driver);
        driver.manage().timeouts().implicitlyWait(Configuration.getTimeout(),TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getInstance(){
        return webDriverThreadLocal.get();
    }
}

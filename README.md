# HomeCredit-AutomationExerciser

## Summary
A Test Automation Framework using Page Factory Design Pattern and TestNG Framework to verify three functions of Demo Banking System.

1. Verify that a new customer can be created.
2. Verify creating new account based on the customer just created above.
3. Verify deposit function work fine with the account just created.

## Installation and Requiremens

1. IntelliJ IDEA and JDK 1.8 or above
2. Google Chrome 66.0 or higher
3. Install Maven on Windows

## Usage

When you're on Folder Location of this Repository, you can run the TestNG.xml file from CMD by using following command:

```
mvn clean test -DsuiteXmlFile=TestNG.xml
```

## Description

Configuration Class consits of link, data file path and timeout etc.
```
package config;
public class Configuration {
    private static final String baseUrl = "http://demo.guru99.com/v4/";
    private static final String customerFilePath = "D:\\CustomerID.txt";
    private static final String accountFilePath = "D:\\AccountID.txt";
    private static final int timeout = 10;
    ...
```

Class Driver using ThreadLocal and allow that using paramemter to run Parallel Testing Cross Browsers if needed
```
package drivermanager;
public class Driver {
    private static ThreadLocal<WebDriver>webDriverThreadLocal = new ThreadLocal<WebDriver>();
    public static void initialize(String browserName){
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            ChromeDriverManager.getInstance().setup();
            ...
```

Creating Constructor of BasePage class and using PageFactory.initElements method 
```
package pages;
public class BasePage { ...
 BasePage(){
        driver = Driver.getInstance();
        PageFactory.initElements(driver, this);
    } ...
 ```
 
 Page Object Classes will extend BasePage and using annotation @FindBy to store the web element location in PageFactory pattern
  ```
package pages;
public class LoginPage extends BasePage {
@FindBy(name = "btnLogin")
WebElement loginBtn;
public void submitLogin(){
        loginBtn.click(); }
    ...
 ```   
 
 In the Test Class, we use TestNG to build the test scenario and test suites by using @BeforeMethod, @AfterMethod, @Test
 ```
package tests;
@Parameters("browserName")
@BeforeMethod
    public void setUp(String browserName) throws InterruptedException {
        Driver.initialize(browserName);
        Driver.getInstance().get(Configuration.getBaseUrl());
        LoginPage.getInstance().isLoaded();
        ...
 @AfterMethod
    public void tearDown(){
        if(Driver.getInstance()!= null){
            Driver.getInstance().quit();
        }
    }
  @Test(dataProvider = "CustomerData")
    public void createNewCustomer(String name, String DOB...){  
    ...
    NewCustomerPage.getInstance().enterName(name)              //test-data to be passed
                        .enterDOB(DOB)
                        .enterAdderss(address)
                        .enterCity(city)
                        .enterState(state)
                        .enterPin(pin)
                        .enterMobileNumber(mobileNumber)
                        .enterEmail(email)
                        .enterPassword(password)
                        .submit();    
    RegistrationPage.getInstance().isRegistered();            
    RegistrationPage.getInstance().writeData(); 
 ```
@BeforeClass is defined as a method to check and delete existing data files .txt
 ```
 @BeforeClass
    public void deleteExistingFiles(){
        File customerFile = new File(Configuration.getCustomerFilePath());     //Check to delete existing data files
        File accountFile = new File(Configuration.getAccountFilePath());
        if(customerFile.exists()){
            System.out.println("Existing Customer File");
            customerFile.delete();
            System.out.println("Deleted Customer File");
        } else System.out.println("Clean");
        ...
 ```
 Inside the TestNG.xml file 
 ```
 <suite name="Bankink System Functions Suite" parallel="none">
    <test name="Chrome Test">
        <parameter name="browserName" value="chrome"/>
        <classes>
            <class name="tests.DemoBankingFunctionsTest"/>
        </classes>
    </test>
</suite>
```
 

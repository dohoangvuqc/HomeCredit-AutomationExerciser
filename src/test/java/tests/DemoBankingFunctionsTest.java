package tests;

import config.Configuration;
import drivermanager.Driver;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.testng.annotations.*;
import pages.*;

import java.io.File;
import java.io.IOException;

public class DemoBankingFunctionsTest {

    @BeforeClass
    public void deleteExistingFiles(){
        File customerFile = new File(Configuration.getCustomerFilePath());     //Check to delete existing data files
        File accountFile = new File(Configuration.getAccountFilePath());
        if(customerFile.exists()){
            System.out.println("Existing Customer File");
            customerFile.delete();
            System.out.println("Deleted Customer File");
        } else System.out.println("Clean");
        if(accountFile.exists()){
            System.out.println("Existing Account File");
            accountFile.delete();
            System.out.println("Deleted Account File");
        } else System.out.println("Clean");
    }

    @Parameters("browserName")
    @BeforeMethod
    public void setUp(String browserName) throws InterruptedException {
        Driver.initialize(browserName);
        Driver.getInstance().get(Configuration.getBaseUrl());
        LoginPage.getInstance().isLoaded();
        LoginPage.getInstance().enterUserID("mngr143133").enterPassword("gUpytYt").submitLogin();
        Thread.sleep(1000);
        ManagerPage.getInstance().isLoggedIn();
    }

    @AfterMethod
    public void tearDown(){
        if(Driver.getInstance()!= null){
            Driver.getInstance().quit();
        }
    }

    @Test(dataProvider = "CustomerData")
    public void createNewCustomer(String name, String DOB, String address, String city, String state, String pin, String mobileNumber, String email, String password) throws InterruptedException, IOException {

        ManagerPage.getInstance().navigateToNewCustomerPage();     //navigate to New Customer Page

        Thread.sleep(1500);                                   //wait for loading page

        NewCustomerPage.getInstance().isLoaded();                  //validate the loaded page correct or not

        NewCustomerPage.getInstance().enterName(name)              //test-data to be passed
                        .enterDOB(DOB)
                        .enterAdderss(address)
                        .enterCity(city)
                        .enterState(state)
                        .enterPin(pin)
                        .enterMobileNumber(mobileNumber)
                        .enterEmail(email)
                        .enterPassword(password)
                        .submit();                                  //submit

        Thread.sleep(1000);                                   //wait for loading page

        RegistrationPage.getInstance().isRegistered();             //verify New Customer Creating Function of bank system

        RegistrationPage.getInstance().writeData();                //write data of customerID into text file

    }

    @DataProvider(name = "CustomerData")
    public static Object[][] getData (){

        Fairy fairy = Fairy.create();             //create Fairy object

        Person person = fairy.person();           //create person object

        return new Object[][] {
                {person.getFirstName()+"HC","09251985","52 Madden St","Phoenix","Arizona","123456","10236954",person.getEmail(),person.getPassword()}
        };
    }

    @Test(priority = 1)
    public void createNewAccount() throws InterruptedException, IOException {

        ManagerPage.getInstance().navigateToNewAccountPage();     //navigate to New Account Page

        Thread.sleep(1000);                                  //wait for loading page

        NewAccountPage.getInstance().isLoaded();                  //validate the loaded page correct or not

        NewAccountPage.getInstance().readAndEnterCustomerID()     //read customerID from text file and pass into field
                                    .selectAccountType()          //select account type - Current
                                    .initialDeposit("10000")      //enter amount of deposit
                                    .submitAddNewAccount();       //submit

        Thread.sleep(1000);                                  //wait for loading page

        GenerationPage.getInstance().isGenerated();               //verify New Account Creating Function of bank system

        GenerationPage.getInstance().writeData();                 //write AccountID data into text file
    }

    @Test(priority = 2)
    public void depositFunction() throws InterruptedException, IOException {

        ManagerPage.getInstance().navigateToDepositPage();      //navigate to Deposit Page

        Thread.sleep(1000);                                   //wait for loading page

        DepositPage.getInstance().isLoaded();                      //validate the loaded page correct or not

        DepositPage.getInstance().readAndEnterAccountID()          //read accountID from text file and pass into field
                                 .enterAmount("20000")
                                 .enterDescription("added 20k")
                                 .submitDeposit();                 //submit

        Thread.sleep(1000);                                   //wait for loading page

        AmountDeposit.getInstance().isDeposited();                 //verify deposit function of bank system
    }


}

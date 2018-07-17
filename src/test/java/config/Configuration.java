package config;

public class Configuration {

    private static final String baseUrl = "http://demo.guru99.com/v4/";

    private static final String customerFilePath = "D:\\CustomerID.txt";

    private static final String accountFilePath = "D:\\AccountID.txt";

    private static final int timeout = 10;

    public static String getBaseUrl(){
        return baseUrl;
    }


    public static int getTimeout(){
        return timeout;
    }


    public static String getCustomerFilePath(){
        return customerFilePath;
    }

    public static String getAccountFilePath(){
        return accountFilePath;
    }
}

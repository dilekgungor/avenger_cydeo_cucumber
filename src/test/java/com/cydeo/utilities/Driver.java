package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
    Creating a private constructor, so we are closing  access
    to the object of this class from outside the class
     */

    private Driver(){}
    /*

   We make Web Driver private , because we want to close access from outside the class
     We make static because we will use it in static method

     */
    private  static WebDriver driver;
    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public  static WebDriver getDriver(){
        if(driver==null){
            /*
            we read our browser type from Configuration.properties
            This way, we can control which browser is opened from outside our code,
            from configuration.properties
             */
            String browserType = ConfigurationReader.getProperty("browser");
           /*
           Depending on the browser type that will return from configuration.properties file
           switch statement will determine the case, and open the matching browser
            */
            switch (browserType){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driver;
    }

    //driver.quit
    //driver.close
    //try to create logic
    /*
    this method will make sure our driver value is always null after using quit() method
     */
    public  static void closeDriver(){
        if(driver !=null){
            driver.quit();//this line will terminate the existing session. value will not even be null
            driver = null;
        }
        //session id for driver= driver==> driver_122333434dshf34455(example)
        // driver.get();
        // driver.findElement();
        //  driver.quit()==>  session id will be terminated
        //
    }

}

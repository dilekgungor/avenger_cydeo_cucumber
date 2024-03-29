package com.cydeo.utilities;

import org.junit.Assert;

import java.util.Set;

public class BrowserUtils {
    /*
   This method will accept int (in seconds) and execute Thread.sleep
   for given duration
    */
    public static void sleep(int second) {

        second *= 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
        }
    }
/*This method excepts 3 argument
arg1= webdriver
arg2= expectedInUrl:for verify if url contains givenString
                      if condition matches,will break loop
  arg3=expectedInTitle:to be compared against actual title

 */

    public static void switchWindowAndVerify( String expectedInUrl, String expectedInTitle ) {

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " +Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //5. Assert:Title contains “expectedInTitle";

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
    /*
         This method accepts a String  "expectedTitle" and Assert if it is true
     */
    public static void verifyTitle(String expectedTitle) {

       Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }



}

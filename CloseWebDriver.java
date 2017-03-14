package com.InitCleanup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

/**
 * Created by shache on 01/03/2016.
 */
public class CloseWebDriver {

    public CloseWebDriver(){}

    public void CloseWebDriver(WebDriver driver){
        try{
            driver.close();
            driver.quit();
        }catch (UnreachableBrowserException Excep){
            Excep.printStackTrace();
            System.out.println("not close : Browser Failure");
        }
    }
}

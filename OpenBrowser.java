package com.InitCleanup;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;

import java.net.URL;

/**
 * Created by shache on 01/03/2016.
 */
public class OpenBrowser {



    public WebDriver OpenBrowser(String masterBrowser, String masterIp){
        WebDriver driver = null;
        if (masterBrowser == "safari"){

        try {
            DesiredCapabilities capability = DesiredCapabilities.safari();
            capability.setPlatform(Platform.MAC);
            capability.setVersion("");

            driver = new RemoteWebDriver(new URL("http://10.86.9.47:4444/wd/hub"), capability);
            //Maximize browser page (100%)
            driver.manage().window().maximize();


        } catch (MalformedURLException e){
            System.err.println("Error Open remote WebDriver :  ");
            e.printStackTrace();

        }
        return driver;


        //WebDriver driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.get("http://visithybrid-release.qa.keo.net/");

    }else if (masterBrowser == "chrome"){

            try {
                //System.setProperty("webdriver.chrome.driver","WebDriver/chromedriver.exe");
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setPlatform(Platform.WINDOWS);
                capability.setVersion("");

                driver = new RemoteWebDriver(new URL("http://"+masterIp+":4444/wd/hub"), capability);
                //Maximize browser page (100%)
                driver.manage().window().maximize();


            } catch (MalformedURLException e){
                System.err.println("Error Open remote WebDriver :  ");
                e.printStackTrace();

            }
        }else if (masterBrowser == "firefox"){

            try {
                //System.setProperty("webdriver.chrome.driver","WebDriver/chromedriver.exe");
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                capability.setPlatform(Platform.WINDOWS);
                capability.setVersion("");

                driver = new RemoteWebDriver(new URL("http://"+masterIp+":4444/wd/hub"), capability);
                //Maximize browser page (100%)
                driver.manage().window().maximize();


            } catch (MalformedURLException e){
                System.err.println("Error Open remote WebDriver :  ");
                e.printStackTrace();

            }
        }else if (masterBrowser == "ie"){

            try {
                //System.setProperty("webdriver.chrome.driver","WebDriver/chromedriver.exe");
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setPlatform(Platform.WINDOWS);
                capability.setVersion("");

                driver = new RemoteWebDriver(new URL("http://"+masterIp+":4444/wd/hub"), capability);
                //Maximize browser page (100%)
                driver.manage().window().maximize();


            } catch (MalformedURLException e){
                System.err.println("Error Open remote WebDriver :  ");
                e.printStackTrace();

            }
        }else if (masterBrowser == "edge"){

            try {
                //System.setProperty("webdriver.edge.driver","WebDriver/chromedriver.exe");
                DesiredCapabilities capability = DesiredCapabilities.edge();
                capability.setBrowserName(DesiredCapabilities.edge().getBrowserName());
                capability.setPlatform(Platform.WIN8);
                capability.setVersion("");

                driver = new RemoteWebDriver(new URL("http://"+masterIp+":4444/wd/hub"), capability);
                //Maximize browser page (100%)
                driver.manage().window().maximize();


            } catch (MalformedURLException e){
                System.err.println("Error Open remote WebDriver :  ");
                e.printStackTrace();

            }
        }
        return driver;
    }
}

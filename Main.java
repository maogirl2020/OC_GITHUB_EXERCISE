package com.company;
import com.HCPAdditionalDocument.OpenMLACT;
import com.InitCleanup.CloseWebDriver;
import com.InitCleanup.HCPOpenBrowser;
import com.InitCleanup.OpenBrowser;
import com.LogoutFunction.LogoutMaster;;
import org.openqa.selenium.*;
import com.tools.*;
import com.loginFunctions.*;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws Exception{

	    // write your code here

        //Appel et initialisation des  différentes classes

        MasterLogin masterLogin = new MasterLogin();
        SessionKey sessionKey = new SessionKey();
        HCPLogin hcpLogin = new HCPLogin();
        OpenMLACT openMlAct = new OpenMLACT();
        LogoutMaster logout = new LogoutMaster();
        CloseWebDriver closeBrowser = new CloseWebDriver();
        OpenBrowser MasterBrowser = new OpenBrowser();
        HCPOpenBrowser HCPBrowser = new HCPOpenBrowser();


        //Définition du chemin du fichier XML
        String DataPath = "TestData/TestData.xml";

        ///Initialisation des variables depuis le fichier XML
        String URL;
        String masterUsername;
        String masterPassword;
        String sessionKey1;
        String masterName;
        String mentions;
        String masterIP;
        String hcpIP;
        String masterBrowser;
        String hcpBrowser;

        //Récupération des valeurs du fichier XML mises dans une variable de type String
        GetDataFromFile getDataFromXml = new GetDataFromFile();
        URL = getDataFromXml.GetDataFromFile(DataPath,0,"PlatformURL");
        masterUsername = getDataFromXml.GetDataFromFile(DataPath,0,"MasterUsername");
        masterPassword = getDataFromXml.GetDataFromFile(DataPath,0,"MasterPassword");
        masterName = getDataFromXml.GetDataFromFile(DataPath,0,"MasterCompleteName");
        masterIP = getDataFromXml.GetDataFromFile(DataPath,0,"masterIp");
        hcpIP = getDataFromXml.GetDataFromFile(DataPath,0,"hcpIp");
        mentions = getDataFromXml.GetDataFromFile(DataPath,0,"MLACT1");
        masterBrowser = getDataFromXml.GetDataFromFile(DataPath,0,"MasterBrowser").toLowerCase();
        hcpBrowser = getDataFromXml.GetDataFromFile(DataPath,0,"HCPBrowser").toLowerCase();

        //Open Master Browser

        WebDriver driver = MasterBrowser.OpenBrowser(masterBrowser, masterIP);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(URL);



        //Maximize browser page (100%)
        driver.manage().window().maximize();


        //Nouvelle page de login : Connexion d'un Master

        masterLogin.MasterLogin(driver,masterUsername, masterPassword);

        //Retrive Session Key
        sessionKey1 = sessionKey.SessionKey(driver);


        //Master logs out from application
        logout.LogoutMaster(driver);

        //Close Browser and quit
        closeBrowser.CloseWebDriver(driver);


    }


}

package tests;

import Actions.MobileActions;
import com.shaft.tools.io.JSONFileManager;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    JSONFileManager value =new JSONFileManager("src/test/resources/TestDataFiles/Data.json");
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    InformationPage informationPage;
    MobileActions mobileActions;
    PurchasingPage purchasingPage;
    FinalPage finalPage;

    @BeforeClass
    public void setupDevice() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataFiles\\Android.SauceLabs.Mobile.Sample.app.2.2.0.apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName",value.getTestData("Os"));
        caps.setCapability("appium:deviceName",value.getTestData("Name"));
        caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:appWaitActivity",value.getTestData("Wait"));
        caps.setCapability("appium:platformVersion",value.getTestData("Version"));
        caps.setCapability("appium:automationName",value.getTestData("Automator"));
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage=new CartPage(driver);
        informationPage=new InformationPage(driver);
        mobileActions= new MobileActions(driver);
        purchasingPage= new PurchasingPage(driver);
        finalPage=new FinalPage(driver);
    }

    @Test
    /**
     * this a method to set the credentials of successfull login
     * by enering valid username and valid password
     * Assertion of successfulo login by redirected into productpage
     * @param username   the right username you want to login with
     * @param password  the right password you want to login with
     */
    public void loginSuccessfully() {

        loginPage.loginProcess(value.getTestData("Username"), value.getTestData("Password"));
        Assert.assertEquals(productPage.getPageTitle(),"PRODUCTS");
    }


    @Test
    /**
     * this a method to set the credentials of unsuccessfull login
     *by entering invalid username
     * @param username   the wrong username you want to login with
     * @param password  the right password you want to login with
     */
    public void loginUnsuccessfully() {
        loginPage.loginProcess(value.getTestData("Wrongusername"),value.getTestData("Password"));
       Assert.assertEquals(loginPage.validateErrorMessage(),
               "");

    }





}



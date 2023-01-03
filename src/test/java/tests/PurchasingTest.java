package tests;

import Actions.MobileActions;
import com.shaft.tools.io.JSONFileManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class PurchasingTest {
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
        loginPage.loginProcess(value.getTestData("Username"), value.getTestData("Password"));

        productPage = new ProductPage(driver);
        cartPage=new CartPage(driver);
        informationPage=new InformationPage(driver);
        mobileActions= new MobileActions(driver);
        purchasingPage= new PurchasingPage(driver);
        finalPage=new FinalPage(driver);
    }
    @Test
    /**
     * this a method to validate a whole purchasing process by adding a product
     * and assert on price and success process

     * @param product a product adding to the acrt
     * @Param productprice to make sure of the same price in the cart
     * @Param purchasestatus to make sure the whole process is done successfully
     */
    public void validatePurchasingProcess(){
        SoftAssert softAssert = new SoftAssert();
        String Price1= productPage.getProductPrice();
        productPage.pickFirstProduct();
        productPage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        informationPage.setCredentials(value.getTestData("Firstname"), value.getTestData("Lastname")
                ,value.getTestData("Code"));

        softAssert.assertEquals(Price1,purchasingPage.getFinalPrice());
        MobileActions.scrollDownToSpecificText("FINISH");
        purchasingPage.clickOnFinish();
        softAssert.assertEquals(finalPage.getPurchaseStatus(),"THANK YOU FOR YOU ORDER");

        softAssert.assertAll();


    }
}

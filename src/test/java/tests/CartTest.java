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

public class CartTest {
    WebDriver driver;
    JSONFileManager value =new JSONFileManager("src/test/resources/TestDataFiles/Data.json");
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;


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

    }


    @Test
    /**
     * this a method to validate cartStatus by adding 2 product and removing one item
     * and see the diffrence in cart index after remove
     * @param cartindex showing how many items in th card
     */
    public void validateCartPageAfterRemove(){
        productPage.pickFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        productPage.pickSecondProduct();
        productPage.clickOnCartButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartPage.getCartIndex());
        cartPage.removeProduct();
        softAssert.assertTrue(cartPage.getCartIndex2());
        softAssert.assertAll();

    }
}

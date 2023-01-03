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

public class AddProductTest {
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
     * this a method to validate add to cart by adding 2 product,
     * comparing the title and price in homepage and cart page
     * @param Titleofproduct  in the product and cart page
     * @param priceofproduct in the product and cart page
     */
    public void validateAddToCartProcess() {

        SoftAssert softAssert = new SoftAssert();
        String Title1= productPage.getProductTitle();
        String Price1= productPage.getProductPrice();
        productPage.pickFirstProduct();
        productPage.clickOnCartButton();
        softAssert.assertEquals(Title1, cartPage.getProductTitle());
        softAssert.assertEquals(Price1, cartPage.getProductPrice());
        softAssert.assertAll();

    }
}

package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasingPage {
    WebDriver driver;

    public PurchasingPage(WebDriver driver) {
        this.driver = driver;
    }
    private By FinsihButton=new AppiumBy.ByAccessibilityId("test-FINISH");
    private By FinalPrice = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");


    public String getFinalPrice(){
        return driver.findElement(FinalPrice).getText();

    }
    public void clickOnFinish(){

        driver.findElement(FinsihButton).click();
    }
}

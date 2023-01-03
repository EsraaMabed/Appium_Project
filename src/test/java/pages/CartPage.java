package pages;

import io.appium.java_client.AppiumBy;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    }

    private By ProductName=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By ProductPrice=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By RemoveButton=new AppiumBy.ByAccessibilityId("test-REMOVE");
    private By CartIndex=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");
    private By CheckoutButton =new AppiumBy.ByAccessibilityId("test-CHECKOUT");
public String getProductTitle(){
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(ProductName));

    return driver.findElement(ProductName).getText();

}
public String getProductPrice(){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    return driver.findElement(ProductPrice).getText();

}
public Boolean getCartIndex(){
    wait.until(ExpectedConditions.visibilityOfElementLocated(CartIndex));
    System.out.println(driver.findElement(CartIndex).getAttribute("text"));
    return driver.findElement(CartIndex).getAttribute("text").equals("2");

}
public Boolean getCartIndex2(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartIndex));

        return driver.findElement(CartIndex).getAttribute("text").equals("1");
    }
public void removeProduct(){
    driver.findElement(RemoveButton).click();
}
public String getCartIndexAfterRemove(){
    return driver.findElement(CartIndex).getText();
}
public InformationPage clickOnCheckoutButton(){
    driver.findElement(CheckoutButton).click();
    return new InformationPage(driver);
}
}








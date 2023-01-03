package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By UsernamePlaceholder = new AppiumBy.ByAccessibilityId("test-Username");
    private By PasswordPlaceholder = new AppiumBy.ByAccessibilityId("test-Password");
    private By LoginButton = new AppiumBy.ByAccessibilityId("test-LOGIN");
    private By ErrorMessage=new AppiumBy.ByAccessibilityId("test-Error message");

    public void loginProcess (String username,String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(UsernamePlaceholder).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(PasswordPlaceholder).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(LoginButton).click();
    }

    public String validateErrorMessage(){

        return driver.findElement(ErrorMessage).getText();
    }
}

package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class InformationPage {
    WebDriver driver;

    public InformationPage(WebDriver driver) {
        this.driver = driver;
    }
    private By FirstName=new AppiumBy.ByAccessibilityId("test-First Name");
    private By LastName=new AppiumBy.ByAccessibilityId("test-Last Name");
    private By PostalCode=new AppiumBy.ByAccessibilityId("test-Zip/Postal Code");

    private By ContinueButton=new AppiumBy.ByAccessibilityId("test-CONTINUE");
public void setCredentials(String firstname,String lastname,String code){

    driver.findElement(FirstName).sendKeys(firstname);

    driver.findElement(LastName).sendKeys(lastname);

    driver.findElement(PostalCode).sendKeys(code);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.findElement(ContinueButton).click();
}




}

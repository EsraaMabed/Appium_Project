package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalPage {
    WebDriver driver;

    public FinalPage(WebDriver driver) {
        this.driver = driver;
    }

    private By CompletionImg=By.xpath("\t\n" +
            "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");
    public String getPurchaseStatus(){
        return driver.findElement(CompletionImg).getText();
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private By PageTitle=By.xpath("//android.widget.TextView[@text='PRODUCTS']");
private By Addtocart_Button=By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    private By Addtocart_Button2=By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]");
    private By TitleOfProduct= By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
    private By PriceOfProduct=By.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
private By CartButton=By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView\n");

     public String getPageTitle(){
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         return driver.findElement(PageTitle).getText();

     }
    public void pickFirstProduct() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(Addtocart_Button).click();
    }
    public void pickSecondProduct(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(Addtocart_Button2).click();
    }
    public String getProductTitle(){

        return driver.findElement(TitleOfProduct).getText();
    }
    public String getProductPrice(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver.findElement(PriceOfProduct).getText();
    }


    public CartPage clickOnCartButton()
    {
        driver.findElement(CartButton).click();

        return new CartPage(driver);
    }

    }




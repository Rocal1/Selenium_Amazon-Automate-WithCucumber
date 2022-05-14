package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartBtn;

    public void clickAddToCart(){
        clickOnElement(addToCartBtn);
    }

    public Boolean isAddToCartDisplayed(){
        getWait().until(ExpectedConditions.visibilityOf(addToCartBtn));
        return addToCartBtn.isDisplayed();
    }

    public Boolean isAddToCartEnabled(){
        return addToCartBtn.isEnabled();
    }
}

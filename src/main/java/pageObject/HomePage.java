package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.Integer.parseInt;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchInput;

    @FindBy(className = "nav-search-submit")
    private WebElement searchBtn;

    @FindBy(id = "nav-cart-count")
    private WebElement cartItems;

    public void searchForItem(String item){
        getWait().until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(item);
    }

    public void clickOnSearchBtn(){
        clickOnElement(searchBtn);
    }

    public int getCartItemsCount(){
        waitUntilCountChanges(cartItems);
        return parseInt(cartItems.getText());
    }

    public void waitUntilCountChanges(WebElement element) {
        getWait().until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                int elementCount = parseInt(element.getText());
                if (elementCount > 0)
                    return true;
                else
                    return false;
            }
        });
    }

}

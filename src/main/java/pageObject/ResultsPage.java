package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultsPage extends BasePage {

    @FindBy(css = ".a-last")
    private WebElement nextPageButton;

    @FindAll(@FindBy(css = ".a-spacing-medium img"))
    private List<WebElement> resultsImages;


    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public void goToNextPage(){
        scrollToElement(nextPageButton);
        clickOnElement(nextPageButton);
    }

    public void selectResult(int index){
        getWait().until(ExpectedConditions.visibilityOfAllElements(resultsImages));
        clickOnElement(resultsImages.get(index-1));
    }

}

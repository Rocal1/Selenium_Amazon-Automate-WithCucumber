package stepDefinitions;

import driver.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.ProductPage;
import pageObject.ResultsPage;


public class StepDefinition {
    public WebDriver myDriver;
    private HomePage homePage;
    private ResultsPage resultsPage;
    private ProductPage productPage;

    @Given("The user navigates to Amazon.com")
    public void goToHomePage(){
        myDriver = MyDriver.getDriver();
        myDriver.get("https://amazon.com");
        myDriver.manage().window().maximize();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String product){
        homePage = new HomePage(myDriver);
        //This method signature receives the name of the product that we want to search.
        homePage.searchForItem(product);
        homePage.clickOnSearchBtn();
    }

    @And("navigates to the second page")
    public void goToSecondPage(){
        resultsPage = new ResultsPage(myDriver);
        resultsPage.goToNextPage();
    }

    @And("selects the third item")
    public void selectThirdItem(){
        //This method signature receives the position of the item that we want to select.
        resultsPage.selectResult(3);
    }

    @And("the user adds the item to the cart")
    public void addItemToCart(){
        productPage = new ProductPage(myDriver);
        Assert.assertTrue("Add to cart button isn't displayed",productPage.isAddToCartDisplayed());
        Assert.assertTrue("Add to cart button isn't clickable",productPage.isAddToCartEnabled());
        productPage.clickAddToCart();
    }

    @Then("the item is added to the cart")
    public void validateAdditionToCart(){
        Assert.assertEquals(1, homePage.getCartItemsCount());
    }
}

package stepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import com.google.common.collect.Ordering;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class HomePageSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
    HomePage homepage = new HomePage(DriverManager.getDriver().driver);

    @And("I click on menu button")
    public void clickOnMenuButton(){ homepage.clickOnMenuButton(); }

    @And("I click on logout button")
    public void clickOnLogoutButton(){ homepage.clickOnLogoutButton(); }

    @Then("The url should be the login page url")
    public void checkUrl(){
        Assert.assertEquals("https://www.saucedemo.com/", DriverManager.getDriver().driver.getCurrentUrl());
    }
    @When("I add the backpack to cart")
    public void addBackpackToCart(){ homepage.clickOnAddSauceLabsBackPackToCartButton(); }

    @Then("Cart number should increase")
    public void checkCartNumber(){ Assert.assertEquals("1",homepage.getCartIconText());}

    @When("I select the {string} filter")
    public void selectFilter(String filter){ homepage.selectProductFilter(filter);}

    @Then("Products should be ordered Low to High Pricewise")
    public void checkFilterPriceLowToHigh(){
        List<Double> prices = homepage.getAllItemPrices();
        boolean pricesAreSorted = Ordering.natural().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);
    }

}

import Pages.*;
import Utilities.DriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class CheckoutTests extends BaseTest {

    @Test
    public void verifySegundoParcial(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        HomePage homepage= new HomePage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnAddBikelight();
        String bpPrice = homepage.getBackpackPrice();
        String blPrice = homepage.getBikelightPrice();
        homepage.clickOnCart();
        CartPage cart = new CartPage(DriverManager.getDriver().driver);
        Assert.assertTrue(cart.blNameDisplayed());
        Assert.assertTrue(cart.bpNameDisplayed());
        Assert.assertEquals(bpPrice,cart.getBpPrice());
        Assert.assertEquals(blPrice,cart.getBlPrice());
        Assert.assertEquals("2",cart.getIconNumber());
        cart.bpRemoveClick();
        cart.blRemoveClick();
        Assert.assertTrue(cart.listEmpty());
        Assert.assertEquals("",cart.getIconNumber());
    }


}

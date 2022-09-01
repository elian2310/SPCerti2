package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackPackAddToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveToCartButton;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    WebElement menuButton;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")
    WebElement facebookButton;

    @FindBy(id = "about_sidebar_link")
    WebElement aboutButton;

    @FindBy(xpath = "//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a")
    WebElement twitterButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikelightButton;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    WebElement backpackPrice;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[2]/div")
    WebElement bikelightPrice;

    @FindBy(className = "product_sort_container")
    WebElement productFilterDropDown;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPricesLabel;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProductFilter(String element){
        Select selectObject = new Select(productFilterDropDown);
        selectObject.selectByVisibleText(element);

    }

    public List<Double> getAllItemPrices(){
        List<Double> prices = new ArrayList<>();

        for (WebElement itemPrice: itemPricesLabel) {
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            sb.deleteCharAt(0);
            prices.add(Double.parseDouble(sb.toString()));
        }
        return prices;
    }


    public boolean appLogoIsDisplayed() {
        boolean appLogoIsDisplayed = appLogo.isDisplayed();
        return appLogoIsDisplayed;
    }

    public String getCartIconText(){
        String cartText = cartIcon.getText();
        return cartText;
    }

    public void clickOnAddSauceLabsBackPackToCartButton(){
        sauceLabsBackPackAddToCartButton.click();
    }

    public void clickOnRemoveSauceLabsBackPackToCartButton(){
        sauceLabsBackPackRemoveToCartButton.click();
    }

    public void clickOnMenuButton() { menuButton.click(); }

    public void clickOnLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public void clickOnAboutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(aboutButton));
        aboutButton.click();
    }

    public void clickOnTwitterButton(){ twitterButton.click(); }
    public void clickOnFacebookButton() { facebookButton.click(); }

    public void clickOnCart() { cartIcon.click(); }

    public void clickOnAddBikelight(){ bikelightButton.click(); }

    public String getBackpackPrice(){
        String res = backpackPrice.getText();
        return res;
    }

    public String getBikelightPrice(){
        String res = bikelightPrice.getText();
        return res;
    }

}

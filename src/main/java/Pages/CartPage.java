package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]")
    WebElement backpackCuantity;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    WebElement backpackName;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    WebElement backpackPrice;

    @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    WebElement bikelightName;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
    WebElement bikelightPrice;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement cartIcon;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement backpackRemove;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement bikelightRemove;

    @FindBy(className = "cart_item")
    List<WebElement> cartList;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckoutButton(){ checkoutButton.click(); }
    public boolean backpackCuantityIsTB(){
        boolean res = backpackCuantity.isEnabled();
        return res;
    }
    public boolean bpNameDisplayed(){
        boolean res = backpackName.isDisplayed();
        return res;
    }
    public boolean blNameDisplayed(){
        boolean res = bikelightName.isDisplayed();
        return res;
    }
    public String getBpPrice(){
        String res = backpackPrice.getText();
        return res;
    }
    public String getBlPrice(){
        String res = bikelightPrice.getText();
        return res;
    }
    public String getIconNumber(){
        String res = cartIcon.getText();
        return res;
    }
    public boolean listEmpty(){
        boolean res = cartList.isEmpty();
        return res;
    }
    public void bpRemoveClick(){ backpackRemove.click(); }
    public void blRemoveClick(){ bikelightRemove.click(); }
}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFinishPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    WebElement thanksText;

    public CheckoutFinishPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayedThanksText(){
        boolean res = thanksText.isDisplayed();
        return res;
    }
}

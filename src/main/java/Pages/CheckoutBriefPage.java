package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutBriefPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    WebElement firstItemPrice;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
    WebElement secondItemPrice;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]")
    WebElement totalItemPrice;

    @FindBy(id = "finish")
    WebElement finishButton;

    public CheckoutBriefPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstItemPrice(){
        String res = firstItemPrice.getText();
        return res;
    }
    public String getSecondItemPrice(){
        String res = secondItemPrice.getText();
        return res;
    }

    public String getTotalPrice(){
        String res = totalItemPrice.getText();
        return res;
    }

    public void clickOnFinishButton(){ finishButton.click(); }
}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage {
    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")
    WebElement infoError;

    public CheckoutInfoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameField(String firstName) { firstNameField.sendKeys(firstName); }
    public void setLastNameField(String lastName) { lastNameField.sendKeys(lastName); }
    public void setPostalCode(String postalCode) { postalCodeField.sendKeys(postalCode); }
    public void clickOnContinue() { continueButton.click(); }
    public String getInfoError(){
        String res = infoError.getText();
        return res;
    }
}

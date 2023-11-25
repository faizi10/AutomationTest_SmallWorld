package pageObjects;

import fundamentals.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    Waiting waiting;

    public LoginPage(WebDriver driver) {
        super(driver);
        waiting = new Waiting(driver);
    }

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public void enterUserName(String userName) {
        waiting.clear(userNameField);
        waiting.sendKeys(userNameField, userName);
    }

    public void enterPassword(String userPassword) {
        waiting.clear(passwordField);
        waiting.sendKeys(passwordField, userPassword);
    }

    public void clickLoginButton() {
        waiting.click(submitButton);
    }

    public void visitLoginPage() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
}

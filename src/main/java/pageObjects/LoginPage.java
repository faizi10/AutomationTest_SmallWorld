package pageObjects;

import fundamentals.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    Waiting waiting;

    public LoginPage(WebDriver driver) {
        super(driver);
        waiting = new Waiting(driver);
    }

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement unsuccessfulLoginMessage;

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
        driver.get("https://www.saucedemo.com/");
    }

    public void clickOkAlertDialogue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public String getUnsuccessfulLoginMessage() {
        return waiting.getText(unsuccessfulLoginMessage);
    }

}

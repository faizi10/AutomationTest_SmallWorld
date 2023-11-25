package pageObjects;

import fundamentals.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulLoginPage extends BasePage {

    Waiting waiting;
    public SuccessfulLoginPage(WebDriver driver) {
        super(driver);
        waiting = new Waiting(driver);
    }

    @FindBy(css = ".post-title")
    private WebElement successfulLoginTitle;

    public String getSuccessTitleText() {
        return waiting.getText(successfulLoginTitle);
    }
}

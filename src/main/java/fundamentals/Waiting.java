package fundamentals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class Waiting extends BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final int timeout;

    public Waiting(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.timeout = 20;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(WebElement element) {
        waitForElementVisibility(element);
        element.clear();
    }

    public void sendKeys(WebElement element, String value) {
        waitForElementVisibility(element);
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        waitForElementVisibility(element);
        element.click();
    }

    public String getText(WebElement element) {
        waitForElementVisibility(element);
        return element.getText();
    }
}

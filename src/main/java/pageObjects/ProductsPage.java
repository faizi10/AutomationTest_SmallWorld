package pageObjects;

import fundamentals.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    Waiting waiting;
    public ProductsPage(WebDriver driver) {
        super(driver);
        waiting = new Waiting(driver);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement productsPageTitle;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement clickHamburgerIcon;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement clickLogoutButton;

    @FindBy(css = ".login_logo")
    private WebElement loginPageTitle;

    public String getProductsPageTitle(){
        return waiting.getText(productsPageTitle);
    }

    public void clickHamburgerIcon() {
        waiting.click(clickHamburgerIcon);
    }

    public void clickLogoutButton() {
        waiting.click(clickLogoutButton);
    }

    public String getLoginPageTitle(){
        return waiting.getText(loginPageTitle);
    }
}

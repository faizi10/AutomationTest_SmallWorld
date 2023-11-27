package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.time.Duration;

public class  LogoutSteps extends TestBase {
    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        softAssert.assertEquals(productsPage.getProductsPageTitle(), "Products");
    }

    @When("I click on the hamburger icon")
    public void iClickOnTheHamburgerIcon() {
        productsPage.clickHamburgerIcon();
    }

    @And("I click on the logout button")
    public void iClickOnTheLogoutButton() {
        productsPage.clickLogoutButton();
    }

    @Then("I should be logged out successfully")
    public void iShouldBeLoggedOutSuccessfully() {
        softAssert.assertEquals(productsPage.getLoginPageTitle(), "Swag Labs");
    }
}

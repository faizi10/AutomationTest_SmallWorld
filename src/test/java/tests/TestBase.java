package tests;

import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageObjects.LoginPage;
import pageObjects.SuccessfulLoginPage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestBase extends AbstractTestNGCucumberTests {
    private WebDriver driver;
    protected static SoftAssert softAssert;
    protected static LoginPage loginPage;
    protected static SuccessfulLoginPage successfulLoginPage;
    public void setupChromeDriver() {
        driver = WebDriverManager.firefoxdriver().create();
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void beforeScenario(Scenario scenario) {
        createSoftAssertionObject();
        pageInitializer();
        System.out.println("We are executing scenario name: " + scenario.getName());
    }

    public void afterScenario(Scenario scenario) {
        System.out.println("/------------------------------------------------------------------------------------------------------/");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String rootDirectoryPath = System.getProperty("user.dir");
            String screenShotDirectory = rootDirectoryPath + "/screenshots/" + LocalDate.now().toString() + "/";
            File screenshotFolder = new File(screenShotDirectory);
            screenshotFolder.mkdirs();
            String screenShotFilePath = screenshotFolder + "/" + LocalTime.now().toString().replaceAll(":", "") + " " + scenario.getName() + ".jpg";
            File targetFile = new File(screenshotFolder + "/" + LocalTime.now().toString().replaceAll(":", "") + " " + scenario.getName() + ".jpg");
            try {
                FileUtils.copyFile(screenshot, targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Path screenShotContent = Paths.get(screenShotFilePath);
            try (InputStream is = Files.newInputStream(screenShotContent)) {
                Allure.addAttachment("Failure ", is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("/------------------------------------------------------------------------------------------------------/");
        AssertAndDestroySoftAssetObject();
    }

    private void pageInitializer() {
        if (driver!=null) {
            loginPage = new LoginPage(driver);
            successfulLoginPage = new SuccessfulLoginPage(driver);
        }
    }

    // creates new softAssert object
    private static void createSoftAssertionObject() {
        if (softAssert == null) {
            softAssert = new SoftAssert();
        }
    }

    // assert all the softAsserts and set the softAssert to null
    private static void AssertAndDestroySoftAssetObject() {
        if (softAssert != null) {
            softAssert.assertAll();
            softAssert = null;
        } else {
            System.out.println("Soft Assert is Already Null");
        }
    }

}

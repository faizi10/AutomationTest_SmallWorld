package runners;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = {"src/test/resources/features/Login.feature"},
        glue = {"steps"},
        plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})
public class TestRunner extends TestBase {
}

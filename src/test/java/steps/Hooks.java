package steps;

import io.cucumber.java.*;
import tests.TestBase;

public class Hooks extends TestBase {

    @BeforeAll
    public static void start() {
    }

    @Before
    public void before(Scenario scenario) {
        setupChromeDriver();
        beforeScenario(scenario);
    }

    @After
    public void after(Scenario scenario) {
        afterScenario(scenario);
        quitDriver();
    }

    @AfterAll
    public static void end() {
    }
}

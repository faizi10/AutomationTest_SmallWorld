package steps;

import io.cucumber.java.*;
import tests.TestBase;

public class Hooks extends TestBase {

    @BeforeAll
    public static void start() {
        setupFirefoxDriver();
    }

    @Before
    public void before(Scenario scenario) {
        beforeScenario(scenario);
    }

    @After
    public void after(Scenario scenario) {
        afterScenario(scenario);
    }

    @AfterAll
    public static void end() {
        quitDriver();
    }
}

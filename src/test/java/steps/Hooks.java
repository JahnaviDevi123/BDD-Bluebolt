package steps;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import QA_testrailManager.testrailManager;
import generic.baseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import runners.TestRunner;

public class Hooks {

    public static WebDriver driver;
    private static testrailManager testRailManager = new testrailManager();

    @BeforeAll
    public static void setUp() throws Exception {
        driver = baseClass.beforeTest();
    }

    private String getTestCaseIdFromScenario(Scenario scenario) {
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.startsWith("@testCaseId")) {
                return tag.replace("@testCaseId=", "").trim();
            }
        }
        return "default_case_id";
    }

   @After(order = 1)
    public void addScreenshot(Scenario scenario) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        System.out.println("screenshot successfully added");
    }
   

    @After(order = 2)
    public void addResultsToTestRail(Scenario scenario) throws IOException {
        int status = scenario.isFailed() ? testRailManager.TEST_RAIL_FAIL_STATUS : testRailManager.TEST_RAIL_PASS_STATUS;
        String errorMessage = scenario.isFailed() ? "Test failed: " + scenario.getName() : "Test passed";

        int testCaseId = Integer.parseInt(getTestCaseIdFromScenario(scenario));
        int resultId = testRailManager.addResultsForTestCase(testCaseId, status, errorMessage);

        // Store the TestCase ID and Result ID in the test runner's map
        TestRunner.testResultMap.put(testCaseId, resultId);

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

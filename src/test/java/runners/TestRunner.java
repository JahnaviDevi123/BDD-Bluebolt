package runners;

import java.util.HashMap;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.restAssured;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/openCart.feature",
    glue = "steps",
    		plugin= {"pretty", "html:reports/myreport.html", 
					  "rerun:target/rerun.txt",
					  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true
)
public class TestRunner {

	 // Static map to hold TestCase IDs and Result IDs
    public static Map<Integer, Integer> testResultMap = new HashMap<>();
    
    @AfterClass
    public static void attachReportToTestRail() {
    	
        System.out.println("Starting to attach reports to TestRail...");
      

        // Assume you have a way to get the latest report
        String latestReport = getLatestReport();
       
        // Attach reports based on the stored TestCase IDs and Result IDs
        for (Map.Entry<Integer, Integer> entry : testResultMap.entrySet()) {
            int testCaseId = entry.getKey();
            int resultId = entry.getValue();
            restAssured.reports(resultId, latestReport);
            System.out.println("Attached report for TestCase ID: " + testCaseId + " with Result ID: " + resultId);
        }
       
        System.out.println("Report attachment process completed.");
    }

    // Method to get the latest generated report (similar to Hooks)
    public static String getLatestReport() {
        // Your logic to find the latest report
        return "C:\\Users\\2303926\\eclipse-workspace\\Bluebolt_cucumber\\reports\\myreport.html"; 
    }
}



	
	

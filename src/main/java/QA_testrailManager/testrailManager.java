package QA_testrailManager;

import java.util.HashMap;
import java.util.Map;
import com.gurock.testrail.APIClient;

public class testrailManager {

    public static String TEST_RUN_ID = "1";
    public static String TEST_RAIL_USERNAME = "2303926@cognizant.com";
    public static String TEST_RAIL_PASSWORD = "Testrail@2024";
    public static String TEST_RAIL_ENGINE_URL = "https://jahnavidevi.testrail.io/";

    public static int TEST_RAIL_PASS_STATUS = 1;
    public static int TEST_RAIL_FAIL_STATUS = 5;

    public static int addResultsForTestCase(int testCaseId, int status, String error) {
        String testRunID = TEST_RUN_ID;
        APIClient client = new APIClient(TEST_RAIL_ENGINE_URL);
        client.setUser(TEST_RAIL_USERNAME);
        client.setPassword(TEST_RAIL_PASSWORD);

        Map<String, Object> map = new HashMap<>();
        map.put("status_id", status);
        map.put("comment", "This test is executed via automation code. " + error);

        try {
            Object responseObject = client.sendPost("add_result_for_case/" + testRunID + "/" + testCaseId, map);
            if (responseObject instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> responseMap = (Map<String, Object>) responseObject;
                return ((Number) responseMap.get("id")).intValue();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
   
}

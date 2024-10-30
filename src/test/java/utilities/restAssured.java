package utilities;

import java.io.File;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class restAssured {
 
	public static void reports(int id, String fileName) {
	        // Check if the file exists
	        File file = new File(fileName);
	        if (!file.exists()) {
	            System.err.println("File not found: " + fileName);
	            return;
	        }

	        RequestSpecification request = RestAssured.given()
	            .pathParam("resultId", id)
	            .auth().preemptive().basic("2303926@cognizant.com", "Testrail@2024")
	            .header("Content-Type", "multipart/form-data")
	            .multiPart("attachment", file);

	        Response response = request.post("https://jahnavidevi.testrail.io/index.php?/api/v2/add_attachment_to_result/{resultId}");
	       
	        // Log the response details
	        System.out.println("Response Status Code: " + response.getStatusCode());
	        System.out.println("Response Body: " + response.getBody().asString());

	        if (response.getStatusCode() != 200) {
	            System.err.println("Failed to upload attachment: " + response.getStatusLine());
	        }
	    }
}
	   
	



package generic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class baseClass {

    public static WebDriver driver;

    public static WebDriver beforeTest() throws Exception {
        String browserName = "chrome";
        System.out.println("Launching browser: " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Please pass the right browser name: " + browserName);
        }

        driver.get("https://www.pepperfry.com");
        driver.manage().window().maximize();
        return driver;
    }


   
	/*public static void screenShot(int testCaseId) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
	    File trg = new File(System.getProperty("user.dir")+"\\screenshots\\"+testCaseId+".png");
	    FileUtils.copyFile(src, trg);
}*/
 
	

}
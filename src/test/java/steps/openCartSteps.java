package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.locators;
import generic.baseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class openCartSteps {
	
	WebDriver driver=baseClass.driver;
	
	locators lo=new locators(driver);

    @Given("I navigate to the website pepperfry")
    public void i_navigate_to_the_website_pepperfry() {
        System.out.println("Successfully navigated to the page");
    }

    @Then("validate the title of the page")
    public void validate_the_title_of_the_page() throws InterruptedException {
    	
    	Thread.sleep(4000);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
    	Assert.assertTrue(actualTitle.contains("Pepperfry"),"Title doesn't match");	
    }

    @When("I click on the Furniture category")
    public void i_click_on_the_furniture_category() throws InterruptedException {
    	lo.FurnitureClick();
    	System.out.println("Successfully click on furniture");
    }

    @Then("I click on the Cart button")
    public void i_click_on_the_cart_button() throws InterruptedException {
    lo.cartClick();
    System.out.println("cart is empty");
    } 
}
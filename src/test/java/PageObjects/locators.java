package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class locators extends BasePage {

	public locators(WebDriver driver)
	{
		super(driver);
	
	}
	
	//Locators
	
	@FindBy(xpath="//a[text()=' Furniture ']")
	WebElement Furniture;
	
	
	@FindBy(xpath="//div[@class='hd-cart-wrap hd-icon-cta']")
	WebElement cart;

	
	
	
	public void FurnitureClick(){
		Furniture.click();
		
	}
	
	public void cartClick() {
		cart.click();
	}
	

	}


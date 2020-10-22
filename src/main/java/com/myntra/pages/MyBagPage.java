package com.myntra.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myntra.base.Driver;

public class MyBagPage extends BasePage {
	
	public static Logger log=LogManager.getLogger(MyBagPage.class.getName());
	
	@FindBy(xpath = "(//*[@class = 'desktop-cart'] /span)[1]")
    WebElement bagIkon;
    @FindBy(className = "itemContainer-base-brand")
    WebElement cartProductBrandName;
    @FindBy(className = "button-base-button")
    WebElement checkOutButton;
    
    

  
    public MyBagPage() {
        driver = Driver.driver;
        PageFactory.initElements(driver, this);
    }

    public void checkOut(String brand) {
    	
    	
    	waitForElementToBeDisplay(bagIkon);
    	bagIkon.click();
    	
    	if(cartProductBrandName.getText().contains(brand)) {
    		checkOutButton.click();
    		
    		
    		}
    	else
    	{
    		log.info("product not added in cart");
    	}
    	
    }
    

}

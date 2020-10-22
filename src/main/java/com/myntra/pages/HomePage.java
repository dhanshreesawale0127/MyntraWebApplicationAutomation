package com.myntra.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myntra.base.Driver;

public class HomePage extends BasePage {

	public static Logger log=LogManager.getLogger(HomePage.class.getName());
    @FindBy(className = "desktop-searchBar")
    WebElement productSearchTextBox;
    
    @FindBy(className = "myntraweb-sprite mobile-mSearch")
    WebElement productSearchTextBoxNew;
    

    
    @FindBy(className = "vh79eN")
    WebElement searchButton;

    @FindBy(className = "title-title")
    WebElement searchResult;

    public HomePage() {
        driver = Driver.driver;
        PageFactory.initElements(driver, this);
    }

    public String pageTitle() {
    	log.info("USer redirected to Home Page");
    	return driver.getTitle();
    }
    
    
    public void searchProductSearchTextBox(String searchProductName) {
        waitForElementToBeDisplay(productSearchTextBox);
        productSearchTextBox.sendKeys(searchProductName);
        productSearchTextBox.sendKeys(Keys.ENTER);
      
        waitForElementToBeDisplay(searchResult);
        Assert.assertTrue(searchResult.getText().toLowerCase().contains(searchProductName), "search product is not available");
       

    }

    
}

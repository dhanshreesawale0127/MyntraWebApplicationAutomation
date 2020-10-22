package com.myntra.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myntra.base.Driver;

public class ProductSearchPage extends BasePage {
	public static Logger log = LogManager.getLogger(ProductSearchPage.class.getName());

	@FindBy(xpath = "//*[@class = 'gender-list']/li")
	private List<WebElement> ListOfGenderFilter;
	

	@FindBy(xpath = "//*[@class = 'filter-search-inputBox']")
	private WebElement searchProductByBrand;



	public ProductSearchPage() {
		driver = Driver.driver;
		PageFactory.initElements(driver, this);
	}

	public void isAllGenderFilterOptionsIsDisplay() {
		log.info("Page load with search result and filters in left side pf page");
		waitForListOfElementToBeDisplay(ListOfGenderFilter);
		ListOfGenderFilter.forEach(e -> Assert.assertTrue(e.isDisplayed()));

	}

	public void searchProductByBrand(String brand) {
		waitForElementToBeDisplay(searchProductByBrand);
		searchProductByBrand.sendKeys(brand);

	}

}

package com.myntra.tests;



import org.testng.Assert;
import org.testng.annotations.Test;


import com.myntra.testBase.TestBase;

public class SearchProductTestCases extends TestBase {
	
	
	@Test(priority=0, description ="go  to myntra.com and Verify Home page title" )
	public void verifyHomePageTitileTest() {
		log.info("verifying HomePageTitle");
		String title = homePage.pageTitle();
		log.info("Found homePageTitle->"+title);
		Assert.assertEquals(title,prop.getProperty("homePageTitle"));
		log.info("Title Verified!");
	}



	
	@Test(priority = 1, description = "go  to myntra.com and Search the shoes and apply low to high sorting ")
	public void sortProductByPriceLowToHigh() {
		

		homePage.searchProductSearchTextBox(prop.getProperty("productSearch"));
		productSearchPage.isAllGenderFilterOptionsIsDisplay();
	

	}

	
	@Test(priority = 2, description = "go  to myntra.com and Search the shoes and filter the shoes by brand name and click on first search product")
	public void filterProductByBrand() throws InterruptedException {
		homePage.searchProductSearchTextBox(prop.getProperty("productSearch"));
		productSearchPage.isAllGenderFilterOptionsIsDisplay();
		productDetailPage.searchBrand(prop.getProperty("brand"));
		productDetailPage.clickOnFirstSearchProduct();

	}

	
	@Test(priority = 3, description = "go  to myntra.com and Search the shoes and select first searched product")
	public void selectFirstSearchProduct() throws InterruptedException {
		homePage.searchProductSearchTextBox(prop.getProperty("productSearch"));
		productSearchPage.isAllGenderFilterOptionsIsDisplay();
		productDetailPage.searchBrand(prop.getProperty("brand"));
		productDetailPage.clickOnFirstSearchProduct();
		productDetailPage.selectSizeOfProduct(prop.getProperty("size"));
		productDetailPage.clickOnaddToBagButton();
		Thread.sleep(18000);

	}
	
	
	@Test(priority = 4, description = "go  to myntra.com and Search the shoes and select first searched product and Add to Bag and Checkout")
	public void checkOutFromCart() throws InterruptedException {
		homePage.searchProductSearchTextBox(prop.getProperty("productSearch"));
		productSearchPage.isAllGenderFilterOptionsIsDisplay();
		productDetailPage.searchBrand(prop.getProperty("brand"));
		productDetailPage.clickOnFirstSearchProduct();
		productDetailPage.selectSizeOfProduct(prop.getProperty("size"));
		productDetailPage.clickOnaddToBagButton();
		mybagpage.checkOut(prop.getProperty("brand"));
		

	}
}

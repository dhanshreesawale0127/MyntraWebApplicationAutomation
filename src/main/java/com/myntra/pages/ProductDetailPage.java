package com.myntra.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myntra.base.Driver;

public class ProductDetailPage extends BasePage {
	public static Logger log=LogManager.getLogger(ProductDetailPage.class.getName());

    @FindBy(xpath = "(//*[@class='img-responsive'])[1]")
    private WebElement firstSearchedProduct;

    @FindBy(className  = "size-buttons-unified-size")
    private List<WebElement> sizeOfProduct;

    @FindBy(className = "_1wX7_H")
    private List<WebElement> unAvailableSize;

    @FindBy(xpath  = "//*[contains(text(), 'ADD TO BAG')]")
    private WebElement addToBagButton;

    @FindBy(xpath = "(//span[@class = 'myntraweb-sprite filter-search-iconSearch sprites-search'])[1]")
    private WebElement searchBrandTool;
    
    @FindBy(className  = "filter-search-inputBox")
    private WebElement searchBoxBrand;
    
    @FindBy(xpath = "//*[@class='brand-list']/li")
    private List<WebElement> selectBrand;
    @FindBy(className = "product-brand")
    private WebElement firstSearchedProductName;

    public ProductDetailPage() {
        driver = Driver.driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFirstSearchProduct() throws InterruptedException {
        waitForElementToBeDisplay(firstSearchedProduct);
        jsClick(firstSearchedProduct);
       
        

		 
    }

    public void selectSizeOfProduct(String size) {
        switchToActiveTab();
        waitForListOfElementToBeDisplay(sizeOfProduct);
        for (WebElement e : sizeOfProduct) {
            if (e.getText().equalsIgnoreCase(size)) {
                jsClick(e);
                break;
            } else {

                System.out.println("size of product is not available");

            }

        }


    }

    public void clickOnaddToBagButton() {
        waitForElementToBeDisplay(addToBagButton);
        System.out.println(addToBagButton.getText());
        addToBagButton.click();
    }


    public void searchBrand(String brandName) throws InterruptedException {
        waitForElementToBeDisplay(searchBrandTool);

        mouseHoverJScript(driver, searchBrandTool);
        jsClick(searchBrandTool);
        searchBoxBrand.sendKeys(brandName);
        Thread.sleep(18000);
        for (WebElement e : selectBrand) {
            if (e.getText().toLowerCase().contains(brandName)) {

            	e.click();
                break;
            }
            log.info("searched brand is not available");

        }
        wait(3000);
        waitForElementToBeDisplay(firstSearchedProductName);
        System.out.println(firstSearchedProductName.getText().toLowerCase());
        Assert.assertTrue(firstSearchedProductName.getText().toLowerCase().contains(brandName), String.format("user is not able to search product for this brand %s ", brandName));

    }

}

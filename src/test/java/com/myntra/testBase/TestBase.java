package com.myntra.testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.myntra.base.Driver;
import com.myntra.pages.HomePage;
import com.myntra.pages.MyBagPage;
import com.myntra.pages.ProductDetailPage;
import com.myntra.pages.ProductSearchPage;

public class TestBase extends Driver{

    public static WebDriver driver;
    protected String url;


    
    protected HomePage homePage;
    protected ProductSearchPage productSearchPage;
    protected ProductDetailPage productDetailPage;
    protected MyBagPage mybagpage;
   

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
        initialize();
        
        homePage = new HomePage();
        productSearchPage = new ProductSearchPage();
        productDetailPage = new ProductDetailPage();
        mybagpage 		= new MyBagPage();
        
        
        

    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        
    	tearDown();
        
    }

    


   


}


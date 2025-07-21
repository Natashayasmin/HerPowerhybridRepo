package TestCaseForSellerPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AllPagesForSeller.HomePageForSeller;
import AllPagesForSeller.ShopNowPage;
import BaseInfoPage.BaseClassOne;
import CommonPage.LoginPage;
import DashboardPageHerPower.DashboardPageHerPower;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseForShopNowPage  extends BaseClassOne {

	  public  WebDriver driver;
	    DashboardPageHerPower dashboardPage;
	    LoginPage loginPage;
	    HomePageForSeller homePage;
	    ShopNowPage shopnowpage;

	    @BeforeMethod
	    public void browserSetup() {
	        loadPropertiesFileOfHerPower();
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get(propForHerPower.getProperty("url"));
	        driver.manage().window().maximize();
	        loginPage = new LoginPage(driver);
	        dashboardPage = loginPage.loginAsSeller(
	            propForHerPower.getProperty("validEmailforSeller"),
	            propForHerPower.getProperty("validPassword"));
	        homePage = new HomePageForSeller(driver);
	        shopnowpage =new ShopNowPage(driver);
	        
	    }

	    @AfterMethod
	    public void teardown() {
	        driver.quit();
	    }
	    @Test(priority = 0)
	    public void shouldNavigateToNewProductSeeAllSection() {
	        shopnowpage.navigateToNewProductSeeAll();
	        new WebDriverWait(driver, Duration.ofSeconds(20))
	            .until(ExpectedConditions.urlContains("/shop-now/new-products"));
	        
	        Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/new-products"), 
	            "Did not navigate to Shop Now > New Products page");
	    }
	    @Test(priority = 1)
	    public void shouldNavigateToPopularProductSeeAllSection() {
	        shopnowpage.navigateToPopularProductSeeAll();
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.urlContains("http://192.168.0.3:4021/en/shop-now/popular-products"));
	        
	        Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/popular-products"), 
	            "Did not navigate to Shop Now > Popular Products page");
	    }
	    
	    @Test(priority = 2)
	    public void shouldNavigateToexploreByCategoriesSeeAllSection() {
	        shopnowpage.navigateToexploreByCategoriestSeeAll();
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.urlContains("/shop-now/explore-by-category/all"));
	        
	        Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/explore-by-category/all"), 
	            "Did not navigate to Shop Now > exploreByCategories page");
	    }
	    
	    @Test(priority = 3)
	    public void shouldNavigateToshopNowCategoriesSeeAllSection() {
	        shopnowpage.navigateToshopNowCategoriestSeeAll();
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.urlContains("/shop-now/explore-by-category/all"));
	        
	        Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/explore-by-category/all"), 
	            "Did not navigate to Shop Now > exploreByCategories page");
	    }
	    
	    @Test(priority = 4)
	    public void shouldNavigateToshopNowallProducstSection() {
	        shopnowpage.navigateToshopNowallProducts();
	        new WebDriverWait(driver, Duration.ofSeconds(20))
	            .until(ExpectedConditions.urlContains("/shop-now/all-products"));
	        
	        Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/all-products"), 
	            "Did not navigate to Shop Now > allProducts page");
	    }
	    
	    @Test(priority = 5)
	    public void shouldNavigateTonextPageallProducstSection() {
	        shopnowpage.navigateTonextPageallProducts();
	        new WebDriverWait(driver, Duration.ofSeconds(20))
	            .until(ExpectedConditions.urlContains("/shop-now/all-products"));
	        
	        Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/all-products"), 
	            "Did not navigate to Shop Now > nextPageallProducts page");
	    }
	    @Test(priority = 6)
	    public void shouldNavigateTosearchOptionSection() {
	        shopnowpage.navigateTosearchProduct("nose pin"); // 👈 Correct method call with argument

	        Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/searched-products?productName=nose%20pin"),
	            "Did not navigate to Shop Now > searchProducts page");
	    }
	    
}




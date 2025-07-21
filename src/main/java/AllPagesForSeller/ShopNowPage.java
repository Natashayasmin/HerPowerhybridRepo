package AllPagesForSeller;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopNowPage {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//p[normalize-space()='Shop Now']")
	 private WebElement shopNowBtn;
	
	@FindBy(xpath="//a[contains(@href, '/shop-now/new-products')]//button[contains(text(),'See All')]")
	private WebElement newProductSeeAll;
	
	@FindBy(xpath="//a[@href='/en/shop-now/popular-products']//button[@class='flex items-center gap-2 text-base text-[#09020C]'][normalize-space()='See All']")
	private WebElement popularProductSeeAll;

	@FindBy(xpath="//a[@href='/en/shop-now/explore-by-category/all']//button[@class='flex items-center gap-2 text-base text-[#09020C]'][normalize-space()='See All']")
	private WebElement exploreByCategoriesSeeAll;
	
	@FindBy(xpath="//a[normalize-space()='Categories']")
	private WebElement shopNowCategoriesbtn;
	
	@FindBy(xpath="//input[@placeholder='Search for products']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	private WebElement searchbtn;

	@FindBy(xpath="//a[normalize-space()='All Products']")
	private WebElement allProductsbtn;

	@FindBy(xpath="//button[normalize-space()='Next']")
	private WebElement nextPageallProducts;
	
	
	
	
	
	
	
	//constructor
	public ShopNowPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
			
	 //Actions
	public void navigateToNewProductSeeAll() {
	    wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn)).click();
	    wait.until(ExpectedConditions.visibilityOf(newProductSeeAll));
	    wait.until(ExpectedConditions.elementToBeClickable(newProductSeeAll)).click();
	    wait.until(ExpectedConditions.urlContains("/shop-now/new-products"));
	}
	
	public void navigateToPopularProductSeeAll() {
		wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn)).click();
		wait.until(ExpectedConditions.visibilityOf(popularProductSeeAll));
	    wait.until(ExpectedConditions.elementToBeClickable(popularProductSeeAll)).click();
	    wait.until(ExpectedConditions.urlContains("/shop-now/popular-products"));
	}
	
	public void navigateToexploreByCategoriestSeeAll() {
		wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn)).click();
		wait.until(ExpectedConditions.visibilityOf(exploreByCategoriesSeeAll));
	    wait.until(ExpectedConditions.elementToBeClickable(exploreByCategoriesSeeAll)).click();
	    wait.until(ExpectedConditions.urlContains("/shop-now/explore-by-category/all"));
	}
	
	public void navigateToshopNowCategoriestSeeAll() {
		wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn)).click();
		wait.until(ExpectedConditions.visibilityOf(shopNowCategoriesbtn));
	    wait.until(ExpectedConditions.elementToBeClickable(shopNowCategoriesbtn)).click();
	    wait.until(ExpectedConditions.urlContains("/shop-now/explore-by-category/all"));
	}
	
	public void navigateToshopNowallProducts() {
		wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn)).click();
		wait.until(ExpectedConditions.visibilityOf(allProductsbtn));
	    wait.until(ExpectedConditions.elementToBeClickable(allProductsbtn)).click();
	    wait.until(ExpectedConditions.urlContains("/shop-now/all-products"));
	}
	
	public void navigateTonextPageallProducts() {
		wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn)).click();
		new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(allProductsbtn));
		new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(allProductsbtn)).click();
	    new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(nextPageallProducts));
	    new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(nextPageallProducts)).click();
	    new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.urlContains("/shop-now/all-products"));
	}
	
	public void navigateTosearchProduct(String SearchProductName) {
	    wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn)).click();
	    wait.until(ExpectedConditions.visibilityOf(shopNowCategoriesbtn));
	    wait.until(ExpectedConditions.elementToBeClickable(shopNowCategoriesbtn)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(SearchProductName);
	    wait.until(ExpectedConditions.elementToBeClickable(searchbtn)).click();
	    wait.until(ExpectedConditions.urlContains("/shop-now/searched-products?productName=" + 
	        SearchProductName.replace(" ", "%20")));
	
	}
}


package AllPagesForSeller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePageForSeller {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(),'Categories')]")
    private WebElement categoriesBtn;

    @FindBy(xpath = "//a[contains(@class, 'hover:underline') and contains(@class, 'text-center')]")
    private WebElement exploreCourseBtn;

    @FindBy(xpath = "//a[@class='text-center hover:underline underline-offset-8 decoration-black decoration-2 transition-all']")
    private WebElement contactBtn;

    @FindBy(xpath = "//img[@class='h-8 w-8 object-cover rounded-full border-2 border-brandDs z-10']")
    private WebElement profileIconBtn;

    @FindBy(xpath = "//p[normalize-space()='Shop Now']")
    private WebElement shopNowBtn;

    public HomePageForSeller(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToCategories() {
        wait.until(ExpectedConditions.elementToBeClickable(categoriesBtn)).click();
    }

    public void navigateToExploreCourse() {
        wait.until(ExpectedConditions.elementToBeClickable(exploreCourseBtn)).click();
    }

    public void navigateToContactPage() {
        wait.until(ExpectedConditions.elementToBeClickable(contactBtn)).click();
    }

    public void navigateToProfileIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(profileIconBtn)).click();
    }

    public void navigateToShopNow() {
        wait.until(ExpectedConditions.elementToBeClickable(shopNowBtn)).click();
        
    
    }
    
    @FindBy(xpath="//a[contains(@href, '/shop-now/new-products')]//button[normalize-space()='See All']")
	private WebElement newProductSeeAll;

    // Optional: Add verification methods if needed
    public boolean isProfileIconVisible() {
        return profileIconBtn.isDisplayed();
    }

	public void navigateTonewProductSeeAll() {
		 wait.until(ExpectedConditions.elementToBeClickable(newProductSeeAll)).click();
	 }
		
	}

package DashboardPageHerPower;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPageHerPower {

    private WebDriverWait wait;

    public DashboardPageHerPower(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Utility Methods
    private void clickWhenReady(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private String getTextWhenVisible(WebElement element) {
        waitForVisibility(element);
        return element.getText().trim();
    }

    private String getAltText(WebElement element) {
        waitForVisibility(element);
        return element.getAttribute("alt").trim();
    }

    // Locators
    @FindBy(id = "radix-:Raav5ufja:-trigger-radix-:R3aav5ufja:") private WebElement Categories;
    @FindBy(css = "a[class='text-center hover:underline underline-offset-8 decoration-black decoration-2 transition-all']") private WebElement ContactUs;
    @FindBy(css = ".h-16.w-auto") private WebElement HerPowerHomePage;

    @FindBy(xpath = "//p[normalize-space()='Shop Now']") private WebElement ShopNowPage;
    @FindBy(xpath = "//p[@class='text-center']") private WebElement ShopNowHeading;

    @FindBy(xpath = "//p[normalize-space()='Explore Course']") private WebElement ExploreCoursebtn;
    @FindBy(xpath = "//p[normalize-space()='Career & Placement']") private WebElement CareerAndPlacement;
    @FindBy(xpath = "//div[normalize-space()='Jobs for you']") private WebElement JobsForyoutextValue;

    @FindBy(xpath = "//p[normalize-space()='Events']") private WebElement Events;
    @FindBy(xpath = "//img[@alt='Events Banner']") private WebElement eventBannerImage;

    @FindBy(xpath = "//p[normalize-space()='Blogs']") private WebElement Blogsbtn;
    @FindBy(xpath = "//img[@alt='Food Blog blog image']") private WebElement foodBlogerImage;

    @FindBy(css = "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1)") private WebElement ResourceLibrarybtn;
    @FindBy(xpath = "//h1[normalize-space()='Articles']") private WebElement ArticleText;

    @FindBy(xpath = "//p[normalize-space()='Success Stories']") private WebElement SuccessStoriesbtn;
    @FindBy(xpath = "//h1[normalize-space()='Success Stories']") private WebElement SuccessStoriesTextValue;

    @FindBy(xpath = "//p[normalize-space()='Challenges']") private WebElement Challengesbtn;
    @FindBy(xpath = "//h1[normalize-space()='Challenges']") private WebElement ChallengesTextHeading;

    @FindBy(xpath = "//button[normalize-space()='Login']") private WebElement LoginBtn;
    @FindBy(xpath = "//h6[normalize-space()='Enter your credentials to access your account']") private WebElement LoginPageTextValue;

    @FindBy(xpath = "//button[normalize-space()='See All']") private WebElement SeeAll;
    @FindBy(xpath = "//div[@class='text-center text-xl font-md py-8']") private WebElement LatestNewsTextValue;

    // Page Actions

    public DashboardPageHerPower DashboardToCategories() {
        clickWhenReady(Categories);
        return this;
    }

    public DashboardPageHerPower DashboardToExploreCoursePage() {
        clickWhenReady(ExploreCoursebtn);
        return this;
    }

    public DashboardPageHerPower DashboardToContactUsPage() {
        clickWhenReady(ContactUs);
        return this;
    }

    public DashboardPageHerPower DashboardToShopNowPage() {
        clickWhenReady(ShopNowPage);
        waitForVisibility(ShopNowHeading);
        return this;
    }

    public String ActualShopNowHeadingtextValue() {
        return getTextWhenVisible(ShopNowHeading);
    }

    public DashboardPageHerPower DashboardToCareerAndPlacement() {
        clickWhenReady(CareerAndPlacement);
        waitForVisibility(JobsForyoutextValue);
        return this;
    }

    public String ActualJobsForyoutextValue() {
        return getTextWhenVisible(JobsForyoutextValue);
    }

    public DashboardPageHerPower DashboardToEvent() {
        clickWhenReady(Events);
        wait.until(ExpectedConditions.urlContains("/events"));
        waitForVisibility(eventBannerImage);
        return this;
    }

    public String getEventHeadingText() {
        return getAltText(eventBannerImage);
    }

    public DashboardPageHerPower DashboardToBlogs() {
        clickWhenReady(Blogsbtn);
        waitForVisibility(foodBlogerImage);
        return this;
    }

    public String getBlogtHeadingText() {
        return getAltText(foodBlogerImage);
    }

    public DashboardPageHerPower DashboardToResourceLibrary() {
        clickWhenReady(ResourceLibrarybtn);
        waitForVisibility(ArticleText);
        return this;
    }

    public String ActualTextValue() {
        return getTextWhenVisible(ArticleText);
    }

    public DashboardPageHerPower DashboardToSuccessStoriesPage() {
        clickWhenReady(SuccessStoriesbtn);
        waitForVisibility(SuccessStoriesTextValue);
        return this;
    }

    public String ActualSuccessStoriesTextValue() {
        return getTextWhenVisible(SuccessStoriesTextValue);
    }

    public DashboardPageHerPower DashboardToChallengesPage() {
        clickWhenReady(Challengesbtn);
        waitForVisibility(ChallengesTextHeading);
        return this;
    }

    public String ActualChallengesTextValue() {
        return getTextWhenVisible(ChallengesTextHeading);
    }

    public DashboardPageHerPower DashboardToLatestNews() {
        clickWhenReady(SeeAll);
        waitForVisibility(LatestNewsTextValue);
        return this;
    }

    public String ActualLatestNewsTextValue() {
        return getTextWhenVisible(LatestNewsTextValue);
    }

    public DashboardPageHerPower DashboardToLoginPage() {
        clickWhenReady(LoginBtn);
        waitForVisibility(LoginPageTextValue);
        return this;
    }

    public String ActualLoginTextValue() {
        return getTextWhenVisible(LoginPageTextValue);
    }
}
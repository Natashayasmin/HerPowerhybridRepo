package TestCasesForDashboard;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseInfoPage.BaseClassOne;
import DashboardPageHerPower.DashboardPageHerPower;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseForDashboardPage extends BaseClassOne {
    
    public WebDriver driver;
    public DashboardPageHerPower dashboardherpower;
    
    @BeforeMethod
    public void setupBrowser() {
        loadPropertiesFileOfHerPower(); // make sure this sets up propForHerPower correctly

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = propForHerPower.getProperty("url");
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("URL is missing in properties file!");
        }
        driver.get(url);

        new WebDriverWait(driver, Duration.ofSeconds(10));
        dashboardherpower = new DashboardPageHerPower(driver);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Utility for scrolling
    private void scrollDown(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }

    @Test(priority = 0)
    public void verifyNavigateToDashboardPage() {
    	Assert.assertEquals(driver.getTitle(), "Her Power", "Incorrect page title");

    }

    @Test(priority = 1)
    public void verifyNavigateToCategories() {
        dashboardherpower.DashboardToCategories();
    }

    @Test(priority = 2)
    public void verifyNavigateToExploreCoursePage() {
        dashboardherpower.DashboardToExploreCoursePage();
    }

    @Test(priority = 3)
    public void verifyNavigateToShopNowPage() {
        dashboardherpower.DashboardToShopNowPage();
        String actual = dashboardherpower.ActualShopNowHeadingtextValue();
        String expected = DataPropForHerPower.getProperty("ExpectedTextValue5");
        Assert.assertEquals(actual, expected, "Shop Now heading mismatch");
    }

    @Test(priority = 4)
    public void verifyNavigateToContactUsPage() {
        dashboardherpower.DashboardToContactUsPage();
    }

    @Test(priority = 6)
    public void verifyNavigateToExploreCoursePageAgain() {
        dashboardherpower.DashboardToExploreCoursePage();
    }

    @Test(priority = 7)
    public void verifyNavigateToCareerAndPlacementPage() {
        dashboardherpower.DashboardToCareerAndPlacement();
        String actual = dashboardherpower.ActualJobsForyoutextValue();
        String expected = DataPropForHerPower.getProperty("ExpectedTextValue2");
        Assert.assertEquals(actual, expected, "Career & Placement heading mismatch");
    }

    @Test(priority = 8)
    public void verifyNavigateToEventPage() {
        dashboardherpower.DashboardToEvent();
        scrollDown(400);
        Assert.assertEquals(dashboardherpower.getEventHeadingText(), "Events Banner", "Event image alt text mismatch");
    }

    @Test(priority = 9)
    public void verifyNavigateToBlogs() {
        dashboardherpower.DashboardToBlogs();
        scrollDown(400);
        Assert.assertEquals(dashboardherpower.getBlogtHeadingText(), "Food Blog blog image", "Blog image alt text mismatch");
    }

    @Test(priority = 10)
    public void verifyNavigateToResourceLibrary() {
        dashboardherpower.DashboardToResourceLibrary();
        Assert.assertEquals(dashboardherpower.ActualTextValue(),
                DataPropForHerPower.getProperty("ExpectedTextValue1"), "Resource Library heading mismatch");
    }

    @Test(priority = 11)
    public void verifyNavigateToSuccessStoriesPage() {
        dashboardherpower.DashboardToSuccessStoriesPage();
        Assert.assertEquals(dashboardherpower.ActualSuccessStoriesTextValue(),
                DataPropForHerPower.getProperty("ExpectedTextValue3"), "Success Stories heading mismatch");
    }

    @Test(priority = 12)
    public void verifyNavigateToChallengesPage() {
        dashboardherpower.DashboardToChallengesPage();
        Assert.assertEquals(dashboardherpower.ActualChallengesTextValue(),
                DataPropForHerPower.getProperty("ExpectedTextValue4"), "Challenges heading mismatch");
    }

    @Test(priority = 13)
    public void verifyNavigateToLatestNews() {
        dashboardherpower.DashboardToLatestNews();
        Assert.assertEquals(dashboardherpower.ActualLatestNewsTextValue(),
                DataPropForHerPower.getProperty("ExpectedTextValue"), "Latest News heading mismatch");
    }

    @Test(priority = 14)
    public void verifyLoginFunctionality() {
        dashboardherpower.DashboardToLoginPage();
        Assert.assertEquals(dashboardherpower.ActualLoginTextValue(),
                DataPropForHerPower.getProperty("ExpectedTextValue6"), "Login heading mismatch");
    }
}
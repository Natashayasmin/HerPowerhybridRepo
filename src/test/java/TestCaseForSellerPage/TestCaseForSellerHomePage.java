package TestCaseForSellerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import AllPagesForSeller.HomePageForSeller;
import BaseInfoPage.BaseClassOne;
import CommonPage.LoginPage;
import DashboardPageHerPower.DashboardPageHerPower;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseForSellerHomePage extends BaseClassOne {

  public  WebDriver driver;
    DashboardPageHerPower dashboardPage;
    LoginPage loginPage;
    HomePageForSeller homePage;

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
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void verifyNavigateToCategories() {
        homePage.navigateToCategories();
        Assert.assertTrue(driver.getCurrentUrl().contains("http://192.168.0.3:4021/en"), "Did not navigate to Categories page");
    }

    @Test(priority = 1)
    public void verifyNavigateToExploreCoursePage() {
        homePage.navigateToExploreCourse();
        Assert.assertTrue(driver.getCurrentUrl().contains("http://192.168.0.3:4021/en"), "Did not navigate to Explore Course page");
    }

    @Test(priority = 2)
    public void verifyNavigateToContactPage() {
        homePage.navigateToContactPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("http://192.168.0.3:4021/en"), "Did not navigate to Contact page");
    }

    @Test(priority = 3)
    public void verifyNavigateToProfileIcon() {
        homePage.navigateToProfileIcon();
        Assert.assertTrue(homePage.isProfileIconVisible(), "Profile icon not visible");
    }

    @Test(priority = 4)
    public void verifyNavigateToShopNowPage() {
        homePage.navigateToShopNow();
        Assert.assertTrue(driver.getCurrentUrl().contains("http://192.168.0.3:4021/en"), "Did not navigate to Shop Now page");
    }
}
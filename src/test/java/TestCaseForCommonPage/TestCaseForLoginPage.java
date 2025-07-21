package TestCaseForCommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import BaseInfoPage.BaseClassOne;
import CommonPage.LoginPage;
import DashboardPageHerPower.DashboardPageHerPower;
import UtilitiesPackage.ScreenshotAndXcelClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseForLoginPage extends BaseClassOne {

   public WebDriver driver;
    LoginPage loginPage;
    DashboardPageHerPower dashboardPage;

    @BeforeMethod
    public void setupBrowser() {
        loadPropertiesFileOfHerPower();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(propForHerPower.getProperty("url"));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    @Test(priority = 0)
    public void verifyNavigateToSignUpPage() {
        loginPage.navigateToSignUpPage();
        // You can assert page title or URL here if needed
    }

    @Test(priority = 1)
    public void verifySellerLoginWithValidCredential() {
        dashboardPage = loginPage.loginAsSeller(
            propForHerPower.getProperty("validEmailforSeller"),
            propForHerPower.getProperty("validPassword")
        );
        Assert.assertTrue(driver.getCurrentUrl().contains("http://192.168.0.3:4021/en"), "Login failed or Dashboard not loaded");
    }

    @DataProvider(name = "VerifyLoginInSellerWithValidCredential")
    public Object[][] testLoginData() {
        return ScreenshotAndXcelClass.getTestDataFromExcel("Login");
    }

    @Test(priority = 2)
    public void verifySellerLoginWithInvalidCredential() {
        dashboardPage = loginPage.loginAsSeller(
            propForHerPower.getProperty("validEmailforSeller"),
            propForHerPower.getProperty("invalidPassword")
        );
        Assert.assertEquals(
            loginPage.getLoginFailWarningMessage(),
            DataPropForHerPower.getProperty("ExpectedFailedValue"),
            "Warning message mismatch for failed login"
        );
    }

    @Test(priority = 3)
    public void verifyCustomerLoginWithValidCredential() {
        dashboardPage = loginPage.loginAsCustomer(
            propForHerPower.getProperty("validEmailForCustomer"),
            propForHerPower.getProperty("validPassword")
        );
        Assert.assertTrue(driver.getCurrentUrl().contains("http://192.168.0.3:4021/en"), "Customer Dashboard not reached");
    }

    @Test(priority = 4)
    public void verifyAdminLoginWithValidCredential() {
        dashboardPage = loginPage.loginAsAdmin(
            propForHerPower.getProperty("validEmailForAdmin"),
            propForHerPower.getProperty("validPassword")
        );
        Assert.assertTrue(driver.getCurrentUrl().contains("http://192.168.0.3:4021/en"), "Admin Dashboard not reached");
    }
}
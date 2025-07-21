package TestCaseForCommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import BaseInfoPage.BaseClassOne;
import CommonPage.LoginPage;
import CommonPage.SignUpPage;
import DashboardPageHerPower.DashboardPageHerPower;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseForSignUpPage extends BaseClassOne {

   public WebDriver driver;
    LoginPage loginPage;
    SignUpPage signUpPage;
    DashboardPageHerPower dashboardPage;

    @BeforeMethod
    public void setupBrowser() {
        loadPropertiesFileOfHerPower();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(propForHerPower.getProperty("url"));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    @Test(priority = 0)
    public void verifyAllFormFieldsFillUp() {
        signUpPage.fillForm(
            DataPropForHerPower.getProperty("FirstNameText"),
            DataPropForHerPower.getProperty("LastNameText"),
            DataPropForHerPower.getProperty("ImageFile"),
            DataPropForHerPower.getProperty("PhoneNumber"),
            DataPropForHerPower.getProperty("Email"),
            DataPropForHerPower.getProperty("Username"),
            DataPropForHerPower.getProperty("NID"),
            DataPropForHerPower.getProperty("Address"),
            DataPropForHerPower.getProperty("Area"),
            DataPropForHerPower.getProperty("City"),
            DataPropForHerPower.getProperty("ZipCode"),
            DataPropForHerPower.getProperty("Password"),
            DataPropForHerPower.getProperty("ConfirmPassword")
        );
        Assert.assertEquals(signUpPage.firstNameInput.getText(), "", "Field text should be empty");
       
    }

    @Test(priority = 1)
    public void verifyNavigateBackToLoginPage() {
        signUpPage.navigateBackToLogin();
        String expectedTitle = "Her Power"; // Replace with actual title
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch after navigating back to login");
    }
}
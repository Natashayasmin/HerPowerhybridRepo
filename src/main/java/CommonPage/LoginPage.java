package CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DashboardPageHerPower.DashboardPageHerPower;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginModalBtn;

    @FindBy(xpath = "//input[@placeholder='Enter your email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginSubmitBtn;

    @FindBy(xpath = "//div[contains(text(),'Login Failed')]")
    private WebElement loginFailWarning;

    @FindBy(css = "body > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(6) > p:nth-child(1)")
    private WebElement backToHomeBtn;

    @FindBy(xpath = "//a[normalize-space()='Sign up']")
    private WebElement signUpBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private void enterCredentials(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitBtn)).click();
    }

    public DashboardPageHerPower loginAsSeller(String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(loginModalBtn)).click();
        enterCredentials(email, password);
        return new DashboardPageHerPower(driver);
    }

    public DashboardPageHerPower loginAsCustomer(String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(loginModalBtn)).click();
        enterCredentials(email, password);
        return new DashboardPageHerPower(driver);
    }

    public DashboardPageHerPower loginAsAdmin(String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(loginModalBtn)).click();
        enterCredentials(email, password);
        return new DashboardPageHerPower(driver);
    }

    public LoginPage navigateToHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginModalBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(backToHomeBtn)).click();
        return new LoginPage(driver);
    }

    public LoginPage navigateToSignUpPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginModalBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
        return new LoginPage(driver);
    }

    public String getLoginFailWarningMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginFailWarning));
        return loginFailWarning.getText();
    }
}
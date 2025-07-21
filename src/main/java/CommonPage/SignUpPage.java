package CommonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SignUpPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//button[normalize-space()='Login']")
    private WebElement loginModalBtn;

    @FindBy(xpath="//a[normalize-space()='Sign up']")
    private WebElement signUpBtn;

    @FindBy(xpath="//label[normalize-space()='Upload an Image']")
    private WebElement uploadLabel;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileInput;

    @FindBy(xpath="//input[@placeholder='Enter your first name']")
	public WebElement firstNameInput;

    @FindBy(xpath="//input[@placeholder='Enter your last name']")
    private WebElement lastNameInput;

    @FindBy(xpath="//input[@placeholder='Ex. 01xxxxxxxx']")
    private WebElement phoneNumberField;

    @FindBy(xpath="//input[@placeholder='Enter your email']")
	private WebElement emailField;

    @FindBy(xpath="//input[@placeholder='Enter your username']")
    private WebElement usernameField;

    @FindBy(xpath="//input[@value='nid']")
    private WebElement nidCheckBox;

    @FindBy(xpath="//input[@placeholder='Enter your NID']")
    private WebElement nidField;

    @FindBy(xpath="//input[@placeholder='Ex. House number and street name']")
    private WebElement addressField;

    @FindBy(xpath="//input[@placeholder='Ex. Dhaka-north']")
    private WebElement cityField;

    @FindBy(xpath="//input[@placeholder='Ex. Banani']")
    private WebElement areaField;

    @FindBy(xpath="//input[@placeholder='Ex. 1230']")
    private WebElement zipCodeField;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath="//input[@name='confirm_password']")
    private WebElement confirmPasswordField;

    @FindBy(xpath="//input[@value='Submit']")
    private WebElement submitBtn;

    @FindBy(xpath="//button[normalize-space()='Clear']")
    private WebElement clearBtn;

    @FindBy(xpath="//a[normalize-space()='Click here to login']")
    private WebElement backToLoginBtn;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public SignUpPage fillForm(String firstName, String lastName, String imagePath,
                               String phone, String email, String username, String nid,
                               String address, String area, String city, String zip,
                               String password, String confirmPassword) {

        wait.until(ExpectedConditions.elementToBeClickable(loginModalBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();

        wait.until(ExpectedConditions.visibilityOf(uploadLabel)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']"))).sendKeys(imagePath);

        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        phoneNumberField.sendKeys(phone);
        emailField.sendKeys(email);
        usernameField.sendKeys(username);
        nidCheckBox.click();
        nidField.sendKeys(nid);
        addressField.sendKeys(address);
        areaField.sendKeys(area);
        cityField.sendKeys(city);
        zipCodeField.sendKeys(zip);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        clearBtn.click();  // Optional: Replace with submitBtn.click() to trigger submit

        return new SignUpPage(driver);
    }

    public SignUpPage navigateBackToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginModalBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(backToLoginBtn)).click();

        return new SignUpPage(driver);
    }
}
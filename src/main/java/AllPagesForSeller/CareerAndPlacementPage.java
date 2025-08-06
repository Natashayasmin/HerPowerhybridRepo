package AllPagesForSeller;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerAndPlacementPage {

	public WebDriver driver;
	WebDriverWait wait;

	//POM
	@FindBy(xpath="//p[normalize-space()='Career & Placement']")
	private WebElement careerAndPlacementbtn;

	@FindBy(xpath="//a[normalize-space()='Find Jobs']")
	private WebElement findJobsbtn;

	@FindBy(xpath="//a[normalize-space()='Find Freelance Services']")
	private WebElement findFreelancejobBtn;

	@FindBy(xpath="//input[@placeholder='Search career']")
	private WebElement searchOption;

	@FindBy(xpath="//button[normalize-space()='Search']")
	private WebElement searchbtn;

	@FindBy(xpath="//button[normalize-space()='Register']")
	private WebElement registerbtn;

	@FindBy(xpath="//p[normalize-space()='I am a Job Provider']")
	private WebElement IamJobProviderbtn;

	@FindBy(xpath="//input[@placeholder='Enter your company name']")
	private WebElement companyField;

	@FindBy(xpath="//input[@placeholder='Enter your designation']")
	private WebElement designationField;

	@FindBy(xpath="//input[@placeholder='Enter company address']")
	private WebElement addressField;

	@FindBy(xpath="//input[@placeholder='Enter company type']")
	private WebElement typeField;

	@FindBy(xpath="//input[@placeholder='Enter company website url']")
	private WebElement websiteField;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement providerSubmit;

	@FindBy(xpath="//p[normalize-space()='I am a Jobs Seeker']")
	private WebElement IamAJobSeekerbtn;






	//Constructor
	public CareerAndPlacementPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	//Actions

	public boolean verifyOnPage() {
		try {
			wait.until(ExpectedConditions.urlContains("/en/career"));
			return driver.getCurrentUrl().contains("/en/career");
		} catch (TimeoutException e) {
			return false;
		}
	}

	public CareerAndPlacementPage navigateToecareerAndPlacementPage() {
		wait.until(ExpectedConditions.elementToBeClickable(careerAndPlacementbtn)).click();
		wait.until(ExpectedConditions.urlContains("/en/career"));
		return this;
	}

	public CareerAndPlacementPage navigateTosearchOptions(String searchJobs) {
		wait.until(ExpectedConditions.elementToBeClickable(careerAndPlacementbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(searchOption)).sendKeys(searchJobs);
		wait.until(ExpectedConditions.elementToBeClickable(searchbtn)).click();
		wait.until(ExpectedConditions.urlContains("/en/career/search?search=test"));
		return this;
	}

	public CareerAndPlacementPage navigateToefindJobsPage() {
		wait.until(ExpectedConditions.elementToBeClickable(careerAndPlacementbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(findJobsbtn)).click();
		wait.until(ExpectedConditions.urlContains("/en/career/all-jobs"));
		return this;
	}



	public CareerAndPlacementPage navigateToefindFreelanceJobsPage() {
		wait.until(ExpectedConditions.elementToBeClickable(careerAndPlacementbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(findFreelancejobBtn)).click();
		wait.until(ExpectedConditions.urlContains("/en/career/all-tasks"));
		return this;
	}

	public CareerAndPlacementPage navigateToIamJobProviderPage(String companyName, String desigName, String companyAddress,
			String companyType, String companyWebsite) {
		
		wait.until(ExpectedConditions.visibilityOf(careerAndPlacementbtn));
		wait.until(ExpectedConditions.elementToBeClickable(careerAndPlacementbtn)).click();
		
		wait.until(ExpectedConditions.visibilityOf(registerbtn));
		wait.until(ExpectedConditions.elementToBeClickable(registerbtn)).click();
		
		wait.until(ExpectedConditions.visibilityOf(IamJobProviderbtn));
		wait.until(ExpectedConditions.elementToBeClickable(IamJobProviderbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(companyField)).sendKeys(companyName);
		wait.until(ExpectedConditions.elementToBeClickable(designationField)).sendKeys(desigName);
		wait.until(ExpectedConditions.elementToBeClickable(addressField)).sendKeys(companyAddress);
		wait.until(ExpectedConditions.elementToBeClickable(typeField)).sendKeys(companyType);
		wait.until(ExpectedConditions.elementToBeClickable(websiteField)).sendKeys(companyWebsite);
		
		wait.until(ExpectedConditions.visibilityOf(providerSubmit));
		wait.until(ExpectedConditions.elementToBeClickable(providerSubmit)).click();

		wait.until(ExpectedConditions.urlContains("/en/career/job-provider-registration"));
		return this;
	}

	public boolean verifyOnPage1() {
		return driver.getCurrentUrl().contains("/en/career/job-provider-registration");
	}


	public CareerAndPlacementPage navigateToIamJobSeekerPage() {
		wait.until(ExpectedConditions.elementToBeClickable(careerAndPlacementbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(registerbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(IamAJobSeekerbtn)).click();
		wait.until(ExpectedConditions.urlContains("/en/career/job-seeker-registration"));
		return this;
	}





}

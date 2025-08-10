package AllPagesForSeller;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	//job seeker registration
	
	@FindBy(xpath="//a[normalize-space()='Seeker Profile']")
	private WebElement seekerProfilebtn;
	
	@FindBy(xpath="//a[@href='/en/career/job-seeker-edit']//*[name()='svg']")
	private WebElement editbtn;

	@FindBy(xpath="//p[normalize-space()='I am a Jobs Seeker']")
	private WebElement IamAJobSeekerbtn;
	
	@FindBy(xpath="//p[normalize-space()='Natasha']")
	private WebElement firstNameField;
	
	@FindBy (xpath="//p[normalize-space()='Seller']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//p[normalize-space()='natashay580@gmail.com']")
	private WebElement emailField;
	
	@FindBy(xpath="//p[normalize-space()='01711225588']")
	private WebElement numberField;
	
	@FindBy(xpath="//h1[normalize-space()='Address']")
	private WebElement addressField1;
	
	@FindBy(xpath="//div[@class='mt-4']//div[6]//h1[1]")
	private WebElement areaNameField;
	
	@FindBy(xpath="//div[7]//h1[1]")
	private WebElement areaNameField1;
	
	@FindBy(xpath="//h1[normalize-space()='Zip Code']")
	private WebElement zipCodeField;
	
	//Education
	@FindBy(xpath="//input[@placeholder='Enter your degree name']")
	private WebElement degreeField;
	
	@FindBy(xpath="//input[@placeholder='Enter your group/department']")
	private WebElement departmentField;
	
	@FindBy(xpath="//input[@placeholder='Enter passing year']")
	private WebElement passYearField;
	
	@FindBy(xpath="//input[@placeholder='GPA/CGPA']")
	private WebElement cgpaField;
	
	@FindBy(xpath="//input[@placeholder='4/5']")
	private WebElement outOfgpaField;
	
	@FindBy(xpath="//select[@name='skill_info")
	private WebElement skilField;
	
	@FindBy(xpath="//input[@placeholder='Enter your job title']")
	private WebElement titleFieldexp;
	
	@FindBy(xpath="//input[@placeholder='Enter your experience']")
	private WebElement experienceField;
	
	@FindBy(xpath="//input[@placeholder='Enter your organization']")
	private WebElement orgField;
	
	@FindBy(xpath="//input[@placeholder='Enter your achievment title']")
	private WebElement titleFieldachv;
	
	@FindBy(xpath="//label[normalize-space()='Choose file']")
	private WebElement chooseFile;
	
	 @FindBy(xpath = "//input[@type='file']")
     private WebElement fileInput;
	 
	 @FindBy(xpath="//input[@placeholder='Enter your portfolio here']")
	 private WebElement portfolioField;
	 
	 @FindBy(xpath="//label[normalize-space()='Upload a file']")
	 private WebElement imageuploadField;
	 
	 @FindBy(xpath="//button[normalize-space()='Submit']")
	 private WebElement submitbtn;
	
	






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
	        // Step 1: Click "Career & Placement"
	        wait.until(ExpectedConditions.elementToBeClickable(careerAndPlacementbtn)).click();

	        // Step 2: Click "Seeker Profile"
	        wait.until(ExpectedConditions.elementToBeClickable(seekerProfilebtn)).click();

	        // Step 3: Wait for overlay/header to disappear
	        try {
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(
	                By.cssSelector("div.flex.justify-between.items-center.lg\\:gap-3")
	            ));
	        } catch (TimeoutException e) {
	            System.out.println("Overlay still visible — will try to scroll and click anyway");
	        }

	        // Step 4: Scroll the edit button into view with offset to avoid sticky header
	        WebElement editElement = wait.until(ExpectedConditions.visibilityOfElementLocated((By) editbtn));
	        ((JavascriptExecutor) driver).executeScript(
	            "window.scrollTo(0, arguments[0].getBoundingClientRect().top + window.scrollY - 100);", 
	            editElement
	        );

	        // Step 5: Ensure clickable, then click
	        wait.until(ExpectedConditions.elementToBeClickable(editElement)).click();

	        // Step 6: Confirm URL navigation
	        wait.until(ExpectedConditions.urlContains("/en/career/job-seeker-edit"));

	        return this;
	    }
	
	 

	    // ===== Fill Form =====
	    public CareerAndPlacementPage FillupseekerForm(
	            String firstNameUpdate,
	            String lastNameUpdate,
	            String emailUpdate,
	            String PhoneNumberUpdate,
	            String address,
	            String areaName,
	            String areaName2,
	            String zipCode,
	            String degree,
	            String department,
	            String passYear,
	            String cgpa,
	            String outOf,
	            String titleExp,
	            String experience,
	            String organization,
	            String titleAchv,
	            String documentFile,
	            String portfolio,
	            String imageFile) {

	       
	                    wait.until(ExpectedConditions.elementToBeClickable(careerAndPlacementbtn)).click();
	        
	        	        // Step 2: Click "Seeker Profile"
	        
	                    wait.until(ExpectedConditions.visibilityOf(seekerProfilebtn));
	        	        wait.until(ExpectedConditions.elementToBeClickable(seekerProfilebtn)).click();
	        	        wait.until(ExpectedConditions.visibilityOf(editbtn));
	        	        wait.until(ExpectedConditions.elementToBeClickable(editbtn)).click();

	        // Personal Info
	        wait.until(ExpectedConditions.visibilityOf(firstNameField)).clear();
	        firstNameField.sendKeys(firstNameUpdate);

	        lastNameField.clear();
	        lastNameField.sendKeys(lastNameUpdate);

	        emailField.clear();
	        emailField.sendKeys(emailUpdate);

	        numberField.clear();
	        numberField.sendKeys(PhoneNumberUpdate);

	        // Address
	        addressField1.clear();
	        addressField1.sendKeys(address);

	        areaNameField1.clear();
	        areaNameField1.sendKeys(areaName);

	        areaNameField.clear();
	        areaNameField.sendKeys(areaName2);

	        zipCodeField.clear();
	        zipCodeField.sendKeys(zipCode);

	        // Academic Info
	        degreeField.clear();
	        degreeField.sendKeys(degree);

	        departmentField.clear();
	        departmentField.sendKeys(department);

	        passYearField.clear();
	        passYearField.sendKeys(passYear);

	        cgpaField.clear();
	        cgpaField.sendKeys(cgpa);

	        outOfgpaField.clear();
	        outOfgpaField.sendKeys(outOf);

	        // Work Experience
	        skilField.clear();
	        skilField.sendKeys(titleExp);

	        experienceField.clear();
	        experienceField.sendKeys(experience);

	        orgField.clear();
	        orgField.sendKeys(organization);

	        titleFieldachv.clear();
	        titleFieldachv.sendKeys(titleAchv);

	        // File Uploads
	        wait.until(ExpectedConditions.elementToBeClickable(chooseFile)).click();
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")))
	                .sendKeys(documentFile.replace("\\", "\\\\"));

	        portfolioField.clear();
	        portfolioField.sendKeys(portfolio);

	        wait.until(ExpectedConditions.elementToBeClickable(imageuploadField)).click();
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")))
	                .sendKeys(imageFile.replace("\\", "\\\\"));

	        // Submit
	        wait.until(ExpectedConditions.elementToBeClickable(submitbtn)).click();

	        return new CareerAndPlacementPage(driver);
	    }

	    public boolean isFormSubmittedSuccessfully() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[contains(text(),'Form submitted successfully')]")));
	            return true;
	        } catch (TimeoutException e) {
	            return false;
	        }
	    }
	}
	









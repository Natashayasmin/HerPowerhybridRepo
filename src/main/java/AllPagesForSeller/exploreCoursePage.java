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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class exploreCoursePage {

	public WebDriver driver;
	WebDriverWait wait;

	//POM
	@FindBy(xpath="//p[normalize-space()='Explore Course']")
	private WebElement exploreCoursebtn;

	@FindBy(xpath = "//a[contains(@href, 'online-courses')]")
	private WebElement onlineCoursebtn;

	@FindBy(xpath="//p[normalize-space()='Physical Courses']")
	private WebElement physicalCoursebtn;

	@FindBy(xpath="//p[normalize-space()='Blended Courses']")
	private WebElement blendedCoursebtn;

	@FindBy(xpath="//button[normalize-space()='My Courses']")
	private WebElement myCoursesbtn;

	@FindBy(xpath="//button[normalize-space()='Student Profile']")
	private WebElement studentProfilebtn;

	@FindBy(xpath="//a[@href='/en/course/edit-student']//*[name()='svg']")
	private WebElement profileEditbtn;

	@FindBy(xpath="//div//div//div//div//div//div//div//div[3]//div[2]//div[2]//a[2]//p[1]")
	private WebElement CourseDetailsbtn;

	@FindBy(xpath="//button[normalize-space()='Enroll Now']")
	private WebElement enrolledNowbtn;

	@FindBy(xpath="//button[normalize-space()='Cancel']")
	private WebElement registrationCancelbtn;

	@FindBy(xpath="//button[normalize-space()='Confirm']")
	private WebElement registrationConfirmbtn;

	@FindBy(xpath="//div[6]//div[2]//div[2]//a[2]//p[1]")
	private WebElement viewOfCourseDetails;

	@FindBy(xpath="//button[normalize-space()='View Course']")
	private WebElement viewCoursebtn;

	@FindBy(xpath="//div[normalize-space()='QA Part 11']")
	private WebElement lessonTitleName;

	@FindBy(xpath="//p[normalize-space()='Student Information']")
	private WebElement studentInformation;
	
    
	//EditStudentPage
	@FindBy(xpath="//*[name()='path' and contains(@d,'M402.6 83.')]")
	private WebElement profileEdit;
	
	@FindBy(xpath="//input[@placeholder='Enter your full name here...']")
	private WebElement FullNameField;
	
	@FindBy(xpath="//input[@placeholder='yyyy-mm-dd']")
	private WebElement DOB;
	
	@FindBy(css="input[placeholder='Degree'][name='education_info.0.degree']")
	private WebElement degreeField;
	
	@FindBy(css="input[placeholder='Group/Department'][name='education_info.0.group']")
	private WebElement departField;
	
	@FindBy(css="input[placeholder='Passing Year'][name='education_info.0.passing_year']")
	private WebElement passYearField;
	
	@FindBy(css="input[placeholder='GPA/CGPA'][name='education_info.0.result']")
	private WebElement gpaField;
	
	@FindBy(xpath="//select[@name='education_info.0.gpa_cgpa_outof']")
	private WebElement outOfGpaField;
	
	@FindBy(css="input[placeholder='Degree'][name='education_info.1.degree']")
	private WebElement degreeField1;
	
	@FindBy(css="input[placeholder='Group/Department'][name='education_info.1.group']")
	private WebElement departField1;
	
	@FindBy(css="input[placeholder='Passing Year'][name='education_info.1.passing_year']")
	private WebElement passYearField1;
	
	@FindBy(css="input[placeholder='GPA/CGPA'][name='education_info.1.result']")
	private WebElement gpaField1;
	
	@FindBy(xpath="//select[@name='education_info.1.gpa_cgpa_outof']")
	private WebElement outOfGpaField1;
	
	@FindBy(css="input[placeholder='Degree'][name='education_info.2.degree']")
	private WebElement degreeField2;
	
	@FindBy(css="input[placeholder='Group/Department'][name='education_info.2.group']")
	private WebElement departField2;
	
	@FindBy(css="input[placeholder='Passing Year'][name='education_info.2.passing_year']")
	private WebElement passYearField2;
	
	@FindBy(css="input[placeholder='GPA/CGPA'][name='education_info.2.result']")
	private WebElement gpaField2;
	
	@FindBy(xpath="//body/div/div[@class='mt-24']/div/div/div/section[@class='container p-4']/main[@class='my-12']/form[@class='my-8']/div[@class='my-8']/div[1]")
	private WebElement outOfGpaField2;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement submitbtn;
	
	
	
	
	






	//Constructor
	public exploreCoursePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}


	//Actions


	public boolean verifyOnPage() {
		try {
			wait.until(ExpectedConditions.urlContains("/en/course"));
			return driver.getCurrentUrl().contains("/en/course");
		} catch (TimeoutException e) {
			return false;
		}
	}

	public exploreCoursePage navigateToexploreCoursePage() {
		wait.until(ExpectedConditions.elementToBeClickable(exploreCoursebtn)).click();
		wait.until(ExpectedConditions.urlContains("/en/course"));
		return this;
	}
	public exploreCoursePage navigateToOnlinecoursePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// First navigate to explore course page
		navigateToexploreCoursePage();

		// Ensure the element is present and scrolled into view
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Online Courses']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", onlineCoursebtn);

		// Wait until it is both visible and clickable
		wait.until(ExpectedConditions.visibilityOf(onlineCoursebtn));
		wait.until(ExpectedConditions.elementToBeClickable(onlineCoursebtn)).click();

		// Confirm the navigation was successful
		wait.until(ExpectedConditions.urlContains("/en/course/online-courses"));

		return this;
	}



	public boolean verifyOnPhysicalCoursePage() {

		return driver.getCurrentUrl().contains("/en/course/physical-courses");
	}

	public exploreCoursePage navigateToPhysicalCoursePage() {
		// First navigate to explore course page
		navigateToexploreCoursePage();

		// Ensure the element is present and scrolled into view
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Physical Courses']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", physicalCoursebtn);

		// Wait until it is both visible and clickable
		wait.until(ExpectedConditions.visibilityOf(physicalCoursebtn));
		wait.until(ExpectedConditions.elementToBeClickable(physicalCoursebtn)).click();

		// Confirm the navigation was successful
		wait.until(ExpectedConditions.urlContains("/en/course/physical-courses"));

		return this;
	}



	public boolean verifyOnphysicalCoursePage() {
		return driver.getCurrentUrl().contains("/en/course/physical-courses");

	}





	public exploreCoursePage navigateToBlendedCoursePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// First navigate to explore course page
		navigateToexploreCoursePage();

		// Ensure the element is present and scrolled into view
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Blended Courses']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", blendedCoursebtn);

		// Wait until it is both visible and clickable
		wait.until(ExpectedConditions.visibilityOf(blendedCoursebtn));
		wait.until(ExpectedConditions.elementToBeClickable(blendedCoursebtn)).click();

		// Confirm the navigation was successful
		wait.until(ExpectedConditions.urlContains("/en/course/blended-courses"));

		return this;
	}



	public boolean verifyOnblendedCoursePage() {
		return driver.getCurrentUrl().contains("/en/course/blended-courses");

	}


	public exploreCoursePage navigateTomyCoursesPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// First navigate to explore course page
		navigateToexploreCoursePage();



		// Wait until it is both visible and clickable
		wait.until(ExpectedConditions.visibilityOf(myCoursesbtn));
		wait.until(ExpectedConditions.elementToBeClickable(myCoursesbtn)).click();

		// Confirm the navigation was successful
		wait.until(ExpectedConditions.urlContains("/en/course/student-courses"));

		return this;


	}

	public exploreCoursePage navigateTostudentProfilePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// First navigate to explore course page
		navigateToexploreCoursePage();



		// Wait until it is both visible and clickable
		wait.until(ExpectedConditions.visibilityOf(studentProfilebtn));
		wait.until(ExpectedConditions.elementToBeClickable(studentProfilebtn)).click();

		// Confirm the navigation was successful
		wait.until(ExpectedConditions.urlContains("/en/course/student-profile"));

		return this;


	}

	public exploreCoursePage navigateTostudentprofileEditPage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// First navigate to explore course page
		navigateToexploreCoursePage();

		// Wait until it is both visible and clickable
		wait.until(ExpectedConditions.visibilityOf(studentProfilebtn));
		wait.until(ExpectedConditions.elementToBeClickable(studentProfilebtn)).click();

		// Wait until it is both visible and clickable
		wait.until(ExpectedConditions.visibilityOf(profileEditbtn));
		wait.until(ExpectedConditions.elementToBeClickable(profileEditbtn)).click();


		// Confirm the navigation was successful
		wait.until(ExpectedConditions.urlContains("/en/course/edit-student"));

		return this;


	}

	public exploreCoursePage verifytheRegistrationCourseCancel() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// First navigate to explore course page
		navigateToexploreCoursePage();

		// Ensure the element is present and scrolled into view
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Online Courses']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", onlineCoursebtn);

		// Wait until it is both visible and clickable
		wait.until(ExpectedConditions.visibilityOf(onlineCoursebtn));
		wait.until(ExpectedConditions.elementToBeClickable(onlineCoursebtn)).click();

		wait.until(ExpectedConditions.visibilityOf(CourseDetailsbtn));
		wait.until(ExpectedConditions.elementToBeClickable(CourseDetailsbtn)).click();

		// Ensure the element is present and scrolled into view
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Enroll Now']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", enrolledNowbtn);

		wait.until(ExpectedConditions.visibilityOf(enrolledNowbtn));
		wait.until(ExpectedConditions.elementToBeClickable(enrolledNowbtn)).click();



		wait.until(ExpectedConditions.visibilityOf(registrationCancelbtn));
		wait.until(ExpectedConditions.elementToBeClickable(registrationCancelbtn)).click();


		// Confirm the navigation was successful
		wait.until(ExpectedConditions.urlContains("/en/course/courses/C250400000132"));

		return this;

	}

	public exploreCoursePage verifytheRegistrationCourseConfirm() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// First navigate to explore course page
		navigateToexploreCoursePage();

		// Ensure the element is present and scrolled into view
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Online Courses']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", onlineCoursebtn);

		// Wait until it is both visible and clickable
		wait.until(ExpectedConditions.visibilityOf(onlineCoursebtn));
		wait.until(ExpectedConditions.elementToBeClickable(onlineCoursebtn)).click();

		wait.until(ExpectedConditions.visibilityOf(CourseDetailsbtn));
		wait.until(ExpectedConditions.elementToBeClickable(CourseDetailsbtn)).click();

		// Ensure the element is present and scrolled into view
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Enroll Now']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", enrolledNowbtn);

		wait.until(ExpectedConditions.visibilityOf(enrolledNowbtn));
		wait.until(ExpectedConditions.elementToBeClickable(enrolledNowbtn)).click();



		wait.until(ExpectedConditions.visibilityOf(registrationConfirmbtn));
		wait.until(ExpectedConditions.elementToBeClickable(registrationConfirmbtn)).click();


		// Confirm the navigation was successful
		wait.until(ExpectedConditions.urlContains("/en/course/courses/C250400000132"));

		return this;

	}

	public exploreCoursePage verifyViewCourse(String LessonName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Navigate to explore course page
		navigateToexploreCoursePage();

		// Click "Online Courses"
		WebElement onlineCourseBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Online Courses']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", onlineCourseBtn);
		wait.until(ExpectedConditions.elementToBeClickable(onlineCourseBtn)).click();

		// Click course details
		wait.until(ExpectedConditions.visibilityOf(viewOfCourseDetails));
		wait.until(ExpectedConditions.elementToBeClickable(viewOfCourseDetails)).click();

		// Click "View Course"
		WebElement viewCourseBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='View Course']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", viewCourseBtn);
		wait.until(ExpectedConditions.elementToBeClickable(viewCourseBtn)).click();

		// Confirm URL navigation
		wait.until(ExpectedConditions.urlContains("/en/course/video/C250300000110"));

		// ✅ Assert the lesson title is visible and matches the expected value
		wait.until(ExpectedConditions.visibilityOf(lessonTitleName));
		Assert.assertTrue(lessonTitleName.isDisplayed(), "❌ Lesson title is not displayed.");
		Assert.assertEquals(lessonTitleName.getText().trim(), LessonName, "❌ Lesson title does not match the expected value.");

		System.out.println("✅ Lesson name is correctly displayed: " + lessonTitleName.getText());

		return this;
	}

	public exploreCoursePage navigateTostudentInfoPage(String profile) {
		// Navigate to Explore Course Page
		navigateToexploreCoursePage();

		// Click "My Courses"
		wait.until(ExpectedConditions.visibilityOf(myCoursesbtn));
		wait.until(ExpectedConditions.elementToBeClickable(myCoursesbtn)).click();

		// Click "Student Information"
		wait.until(ExpectedConditions.visibilityOf(studentInformation));
		wait.until(ExpectedConditions.elementToBeClickable(studentInformation)).click();

		// Confirm URL navigation
		wait.until(ExpectedConditions.urlContains("/en/course/student-profile"));

		// ✅ Validate the profile section name
		wait.until(ExpectedConditions.visibilityOf(studentInformation));
		Assert.assertTrue(studentInformation.isDisplayed(), "❌ Profile title is not displayed.");
		Assert.assertEquals(studentInformation.getText().trim(), profile, "❌ Profile title does not match expected value.");

		System.out.println("✅ Profile section is correctly displayed: " + studentInformation.getText());

		return this;
	}
	
	//For selecting outofgpa
	public void selectGpaCgpaOutOf(String outOfGpaField) {
	    try {
	        WebElement gpaDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gpaCgpaOutOf")));
	        Select select = new Select(gpaDropdown);
	        select.selectByVisibleText(outOfGpaField);
	        System.out.println("✅ GPA/CGPA value selected: " + outOfGpaField);
	    } catch (Exception e) {
	        System.out.println("❌ Failed to select GPA/CGPA value: " + e.getMessage());
	        throw new RuntimeException("❌ Failed to select GPA/CGPA value");
	    }
	}
	
	public void selectGpaCgpaOutOf1(String outOfGpaField1) {
	    try {
	        WebElement gpaDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gpaCgpaOutOf")));
	        Select select = new Select(gpaDropdown);
	        select.selectByVisibleText(outOfGpaField1);
	        System.out.println("✅ GPA/CGPA value selected: " + outOfGpaField1);
	    } catch (Exception e) {
	        System.out.println("❌ Failed to select GPA/CGPA value: " + e.getMessage());
	        throw new RuntimeException("❌ Failed to select GPA/CGPA value");
	    }
	}
	
	public void selectGpaCgpaOutOf2(String outOfGpaField2) {
	    try {
	        WebElement gpaDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gpaCgpaOutOf")));
	        Select select = new Select(gpaDropdown);
	        select.selectByVisibleText(outOfGpaField2);
	        System.out.println("✅ GPA/CGPA value selected: " + outOfGpaField2);
	    } catch (Exception e) {
	        System.out.println("❌ Failed to select GPA/CGPA value: " + e.getMessage());
	        throw new RuntimeException("❌ Failed to select GPA/CGPA value");
	    }
	}
	


	public exploreCoursePage verifyStudentEditAndUpdate(
		    String Name, String Degree, String Department, String PassingYear, String GPA, String OutOfgpa,
		    String Degree1, String Department1, String PassingYear1, String GPA1, String OutOfgpa1, 
		    String Degree2, String Department2, String PassingYear2, String GPA2, String OutOfgpa2
		) {
		    // ✅ Step 1: Navigate to student edit form
		    navigateToexploreCoursePage();

		    wait.until(ExpectedConditions.elementToBeClickable(myCoursesbtn)).click();
		    wait.until(ExpectedConditions.elementToBeClickable(studentInformation)).click();
		    wait.until(ExpectedConditions.elementToBeClickable(profileEdit)).click();

		    // ✅ Step 2: Enter full name
		    wait.until(ExpectedConditions.visibilityOf(FullNameField)).clear();
		    FullNameField.sendKeys(Name);

		    // ✅ Step 3: Enter DOB
		    try {
		        WebElement dobInput = wait.until(ExpectedConditions.elementToBeClickable(DOB));
		        dobInput.clear();
		        dobInput.sendKeys("12/31/1998");
		        System.out.println("✅ DOB entered successfully");
		    } catch (Exception e) {
		        throw new RuntimeException("❌ Failed to input DOB: " + e.getMessage(), e);
		    }

		    // ✅ Step 4: Select GPA/CGPA Out Of
		    try {
		        selectGpaCgpaOutOf(OutOfgpa);
		    } catch (Exception e) {
		        throw new RuntimeException("❌ Failed to select GPA/CGPA value: " + e.getMessage(), e);
		    }
		    
		 // ✅ Step 4: Select GPA/CGPA Out Of1
		    try {
		        selectGpaCgpaOutOf(OutOfgpa1);
		    } catch (Exception e) {
		        throw new RuntimeException("❌ Failed to select GPA/CGPA value: " + e.getMessage(), e);
		    }
		    
		    // ✅ Step 4: Select GPA/CGPA Out Of2
		    try {
		        selectGpaCgpaOutOf(OutOfgpa2);
		    } catch (Exception e) {
		        throw new RuntimeException("❌ Failed to select GPA/CGPA value: " + e.getMessage(), e);
		    }
		    

		    // ✅ Step 5: Fill academic fields
		    try {
		        wait.until(ExpectedConditions.visibilityOf(degreeField)).clear();
		        degreeField.sendKeys(Degree);
		        wait.until(ExpectedConditions.visibilityOf(departField)).clear();
		        departField.sendKeys(Department);
		        wait.until(ExpectedConditions.visibilityOf(passYearField)).clear();
		        passYearField.sendKeys(PassingYear);
		        wait.until(ExpectedConditions.visibilityOf(gpaField)).clear();
		        gpaField.sendKeys(GPA);

		        wait.until(ExpectedConditions.visibilityOf(degreeField1)).clear();
		        degreeField1.sendKeys(Degree1);
		        wait.until(ExpectedConditions.visibilityOf(departField1)).clear();
		        departField1.sendKeys(Department1);
		        wait.until(ExpectedConditions.visibilityOf(passYearField1)).clear();
		        passYearField1.sendKeys(PassingYear1);
		        wait.until(ExpectedConditions.visibilityOf(gpaField1)).clear();
		        gpaField1.sendKeys(GPA1);

		        wait.until(ExpectedConditions.visibilityOf(degreeField2)).clear();
		        degreeField2.sendKeys(Degree2);
		        wait.until(ExpectedConditions.visibilityOf(departField2)).clear();
		        departField2.sendKeys(Department2);
		        wait.until(ExpectedConditions.visibilityOf(passYearField2)).clear();
		        passYearField2.sendKeys(PassingYear2);
		        wait.until(ExpectedConditions.visibilityOf(gpaField2)).clear();
		        gpaField2.sendKeys(GPA2);

		        System.out.println("✅ Academic fields filled in successfully");
		    } catch (Exception e) {
		        throw new RuntimeException("❌ Failed to fill academic info fields: " + e.getMessage(), e);
		    }

		    // ✅ Step 6: Submit and Confirm
		    try {
		        wait.until(ExpectedConditions.elementToBeClickable(submitbtn)).click();
		        wait.until(ExpectedConditions.urlContains("/en/course/edit-student"));
		        System.out.println("✅ Student information updated and URL confirmed");
		    } catch (Exception e) {
		        throw new RuntimeException("❌ Failed to submit or confirm student info update: " + e.getMessage(), e);
		    }

		    return this;
		}


}






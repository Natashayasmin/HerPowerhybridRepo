package TestCaseForSellerPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AllPagesForSeller.HomePageForSeller;
import AllPagesForSeller.exploreCoursePage;
import BaseInfoPage.BaseClassOne;
import CommonPage.LoginPage;
import DashboardPageHerPower.DashboardPageHerPower;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseForExploreCoursePage {
	
	public class TestCaseForexploreCoursePage extends BaseClassOne  {

		public  WebDriver driver;
		DashboardPageHerPower dashboardPage;
		LoginPage loginPage;
		HomePageForSeller homePage;
		exploreCoursePage explorecoursepage;
		
		 @Parameters("browser")
		    @BeforeMethod
		    public void browserSetup(@Optional("chrome") String browser) {
		        loadPropertiesFileOfHerPower();

		        if (browser.equalsIgnoreCase("chrome")) {
		            WebDriverManager.chromedriver().setup();
		            driver = new ChromeDriver();
		        } else if (browser.equalsIgnoreCase("edge")) {
		            WebDriverManager.edgedriver().setup();
		            driver = new EdgeDriver();
		        } else {
		            throw new IllegalArgumentException("Unsupported browser: " + browser);
		        }

		        driver.manage().window().maximize();
		        driver.get(propForHerPower.getProperty("url"));

		        loginPage = new LoginPage(driver);
		        dashboardPage = loginPage.loginAsSeller(
		                propForHerPower.getProperty("validEmailforSeller"),
		                propForHerPower.getProperty("validPassword"));
		        homePage = new HomePageForSeller(driver);
		        explorecoursepage = new exploreCoursePage(driver);
		    }

		@AfterMethod
		public void teardown() {
			driver.quit();
		}
		
		@Test(priority = 0)
		public void shouldNavigateToexploreCourseSection() {
		    explorecoursepage.navigateToexploreCoursePage();

		    Assert.assertTrue(explorecoursepage.verifyOnPage(),
		        "❌ Not on Explore Course Page after navigation. Actual URL: " + driver.getCurrentUrl());

		    System.out.println("✅ On the correct Explore Course Page.");
		}
		
		 @Test(priority = 1)
		    public void testNavigateToOnlineCoursePage() {
		        explorecoursepage.navigateToOnlinecoursePage();

		        Assert.assertTrue(explorecoursepage.verifyOnPage(),
		            "❌ Navigation failed! Expected URL to contain: /en/course/online-courses");

		        System.out.println("✅ Navigation to Online Course Page successful. URL: " + driver.getCurrentUrl());
		    }
		 
		 @Test(priority = 2)
		    public void testNavigateToPhysicalCoursePage() {
		        explorecoursepage.navigateToPhysicalCoursePage();

		        Assert.assertTrue(explorecoursepage.verifyOnPhysicalCoursePage(),
		            "❌ Navigation failed! Expected URL to contain: /en/course/physical-courses");

		        System.out.println("✅ Navigation to Physical Course Page successful. URL: " + driver.getCurrentUrl());
		    }
		 
		 @Test(priority = 3)
		    public void testNavigateToblendedCoursePage() {
		        explorecoursepage.navigateToBlendedCoursePage();

		        Assert.assertTrue(explorecoursepage.verifyOnblendedCoursePage(),
		            "❌ Navigation failed! Expected URL to contain: /en/course/blended-courses");

		        System.out.println("✅ Navigation to Blended Course Page successful. URL: " + driver.getCurrentUrl());
		    }
		 
		 @Test(priority = 4)
		    public void testNavigateTomyCoursesPage() {
		        explorecoursepage.navigateTomyCoursesPage();

		        Assert.assertTrue(explorecoursepage.verifyOnPage(),
		            "❌ Navigation failed! Expected URL to contain: /en/course/student-courses");

		        System.out.println("✅ Navigation to My Courses Page successful. URL: " + driver.getCurrentUrl());
		    }
		 
		 @Test(priority = 5)
		    public void testNavigateTostudentProfilePage() {
		        explorecoursepage.navigateTostudentProfilePage();

		        Assert.assertTrue(explorecoursepage.verifyOnPage(),
		            "❌ Navigation failed! Expected URL to contain: /en/course/student-profile");

		        System.out.println("✅ Navigation to Student Profile Page successful. URL: " + driver.getCurrentUrl());
		    }
		 
		 @Test(priority = 6)
		    public void testNavigateTostudentprofileEditPage() {
		        explorecoursepage.navigateTostudentprofileEditPage();

		        Assert.assertTrue(explorecoursepage.verifyOnPage(),
		            "❌ Navigation failed! Expected URL to contain: /en/course/edit-student");

		        System.out.println("✅ Navigation to Profile Edit Page successful. URL: " + driver.getCurrentUrl());
		    }
		 
		 @Test(priority = 7)
		 public void verifyToCourseRegistrationCancel() {
		     exploreCoursePage exploreCoursePage = new exploreCoursePage(driver);
		     
		     exploreCoursePage.verifytheRegistrationCourseCancel();

		     Assert.assertTrue(exploreCoursePage.verifyOnPage(),
		         "❌ Navigation failed! Expected URL to contain: /en/course/courses/C250400000132");

		     System.out.println("✅ Navigation to Registration Course Cancel successful. URL: " + driver.getCurrentUrl());
		 }
		 
		 @Test(priority = 8)
		 public void verifyToCourseRegistrationConfirmation() {
		     exploreCoursePage exploreCoursePage = new exploreCoursePage(driver);
		     
		     exploreCoursePage.verifytheRegistrationCourseConfirm();

		     Assert.assertTrue(exploreCoursePage.verifyOnPage(),
		         "❌ Navigation failed! Expected URL to contain: /en/course/courses/C250400000132");

		     System.out.println("✅ Successfully registered the Course! URL: " + driver.getCurrentUrl());
		 }
		 
		 @Test(priority= 9)
		    public void testVerifyLessonNameDisplayed() {
		        // Define expected lesson name
		        String expectedLessonName = "QA Part 11";

		        // Instantiate page object
		        exploreCoursePage coursePage = new exploreCoursePage(driver);

		        // Run method and verify lesson name
		        coursePage.verifyViewCourse(expectedLessonName);
		        
		        // You can add extra assertions here if needed
		        // Example: Check URL after navigation
		        Assert.assertTrue(driver.getCurrentUrl().contains("/en/course/video/C250300000110"),
		            "❌ URL does not match expected course video page.");
		        
		        System.out.println("✅ Test completed: Lesson name and page verified successfully.");
		    }
		 
		 
		  @Test(priority = 10)
		    public void testStudentInfoPageNavigation() {
		        // 🔹 Expected title of the Student Information section
		        String expectedProfileTitle = "Student Information";

		        // 🔹 Instantiate the page object
		        exploreCoursePage coursePage = new exploreCoursePage(driver);

		        // 🔹 Call the method and perform internal validations
		        coursePage.navigateTostudentInfoPage(expectedProfileTitle);

		        // 🔹 Final URL validation after navigation
		        String currentUrl = driver.getCurrentUrl();
		        Assert.assertTrue(currentUrl.contains("/en/course/student-profile"),
		            "❌ Unexpected URL after navigation: " + currentUrl);

		        System.out.println("✅ Test passed: Student Information section and URL displayed successfully.");
		    }
		  
		 
		  @Test(priority = 11)
		  public void shouldVerifyStudentInfoUpdated() {
		      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		      exploreCoursePage explorePage = new exploreCoursePage(driver);

		      explorePage.verifyStudentEditAndUpdate(
		          DataPropForHerPower.getProperty("Name"),
		          DataPropForHerPower.getProperty("Degree"),
		          DataPropForHerPower.getProperty("Department"),
		          DataPropForHerPower.getProperty("PassingYear"),
		          DataPropForHerPower.getProperty("GPA"),
		          DataPropForHerPower.getProperty("OutOfgpa"),

		          DataPropForHerPower.getProperty("Degree1"),
		          DataPropForHerPower.getProperty("Department1"),
		          DataPropForHerPower.getProperty("PassingYear1"),
		          DataPropForHerPower.getProperty("GPA1"),
		          DataPropForHerPower.getProperty("OutOfgpa1"),

		          DataPropForHerPower.getProperty("Degree2"),
		          DataPropForHerPower.getProperty("Department2"),
		          DataPropForHerPower.getProperty("PassingYear2"),
		          DataPropForHerPower.getProperty("GPA2"),
		          DataPropForHerPower.getProperty("OutOfgpa2")
		      );

		      // Optional: Check for confirmation toast or URL
		      try {
		          String expectedFragment = DataPropForHerPower.getProperty("expectedUrlFragment");
		          wait.until(ExpectedConditions.urlContains(expectedFragment));
		          String actualUrl = driver.getCurrentUrl();
		          Assert.assertTrue(actualUrl.contains(expectedFragment),
		              "❌ URL mismatch. Expected fragment: '" + expectedFragment + "', but was: " + actualUrl);
		          System.out.println("✅ URL verified: " + actualUrl);
		      } catch (TimeoutException e) {
		          try {
		              WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                  By.xpath("//*[contains(text(), 'Student information updated')]")
		              ));
		              Assert.assertTrue(toastMsg.isDisplayed(), "❌ Toast not shown.");
		              System.out.println("✅ Confirmation via toast");
		          } catch (TimeoutException toastFail) {
		              throw new AssertionError("❌ Neither redirect nor toast confirmed update.");
		          }
		      }
		  }
		  }
		  
	}
	
	
		
		        
		    
		
		
	


	
	

	


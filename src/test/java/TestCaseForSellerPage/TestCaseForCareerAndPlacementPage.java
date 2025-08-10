package TestCaseForSellerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AllPagesForSeller.CareerAndPlacementPage;
import AllPagesForSeller.HomePageForSeller;
import BaseInfoPage.BaseClassOne;
import CommonPage.LoginPage;
import DashboardPageHerPower.DashboardPageHerPower;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Properties;

public class TestCaseForCareerAndPlacementPage extends BaseClassOne {

	public  WebDriver driver;
	DashboardPageHerPower dashboardPage;
	LoginPage loginPage;
	HomePageForSeller homePage;
	CareerAndPlacementPage careerandplaceent;
	
	Properties properties = new Properties();

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
		careerandplaceent = new CareerAndPlacementPage(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 0)
	public void shouldNavigateTocareerAndPlacementSection() {
		careerandplaceent.navigateToecareerAndPlacementPage();

		Assert.assertTrue(careerandplaceent.verifyOnPage(),
				"❌ Not on CareerAndPlacement Page after navigation. Actual URL: " + driver.getCurrentUrl());

		System.out.println("✅ On the correct CareerAndPlacement Page.");
	}
	
	 @Test(priority = 1)
	    public void testNavigateToFindJobsPage() {
		 careerandplaceent.navigateToefindJobsPage();

	        Assert.assertTrue(careerandplaceent.verifyOnPage(),
	            "❌ Navigation failed! Expected URL to contain: /en/career/all-jobs");

	        System.out.println("✅ Navigation to FindJobs Page successful. URL: " + driver.getCurrentUrl());
	    }
	 
	 @Test(priority = 2)
	    public void testNavigateToFindFreelanceJobsPage() {
		 careerandplaceent.navigateToefindFreelanceJobsPage();

	        Assert.assertTrue(careerandplaceent.verifyOnPage(),
	            "❌ Navigation failed! Expected URL to contain: /en/career/all-jobs");

	        System.out.println("✅ Navigation to FindFreelanceJobs Page successful. URL: " + driver.getCurrentUrl());
	    }
	 
	  @Test(priority = 3)
	    public void testNavigateToIamJobProviderPage() {
	        careerandplaceent.navigateToIamJobProviderPage(
	            DataPropForHerPower.getProperty("companyName"),
	            DataPropForHerPower.getProperty("desigName"),
	            DataPropForHerPower.getProperty("companyAddress"),
	            DataPropForHerPower.getProperty("companyType"),
	            DataPropForHerPower.getProperty("companyWebsite")
	        );

	        Assert.assertTrue(careerandplaceent.verifyOnPage(),
	            "❌ Navigation failed! Expected URL to contain: /en/career/job-provider-registration");

	        System.out.println("✅ Navigation to I am a Job Provider Page successful. URL: " + driver.getCurrentUrl());
	    }
	
	 
	 @Test(priority = 4)
	    public void testNavigateToIamJobSeekerPage() {
		 careerandplaceent.navigateToIamJobSeekerPage();

	        Assert.assertTrue(careerandplaceent.verifyOnPage(),
	            "❌ Navigation failed! Expected URL to contain: /en/career/job-seeker-registration");

	        System.out.println("✅ Navigation to I am a Job Seeker Page successful. URL: " + driver.getCurrentUrl());
	    }
	 
//	 @Test(priority = 5)
//	 public void shouldSearchCareerOptionsSuccessfully() {
//	     String searchKeyword = "test"; // You can replace this with any relevant keyword
//
//	     CareerAndPlacement careerPage = new CareerAndPlacement(driver);
//	     careerPage.navigateTosearchOptions(searchKeyword);
//
//	     // Verify the URL contains the expected search term
//	     String currentUrl = driver.getCurrentUrl();
//	     Assert.assertTrue(currentUrl.contains("/en/career/search?search=" + searchKeyword),
//	         "❌ Unexpected URL after search: " + currentUrl);
//
//	     System.out.println("✅ Test passed: Career search for '" + searchKeyword + "' completed successfully.");
//	 }
	 
	 @Test(priority = 5)
	 public void testNavigateToSearchOptionsWithProperties() {
	     // Load value from properties file
		 String keyword = properties.getProperty("searchJobs", "test");

	     // ✅ Defensive check
	     Assert.assertNotNull(keyword, "❌ Property 'searchJobs' is missing.");
	     Assert.assertFalse(keyword.trim().isEmpty(), "❌ Property 'searchJobs' is empty.");

	     // Instantiate Page Object
	     CareerAndPlacementPage careerPage = new CareerAndPlacementPage(driver);

	     // Call the method to perform the search
	     careerPage.navigateTosearchOptions(keyword);

	     // Verify the URL contains the expected keyword
	     String currentUrl = driver.getCurrentUrl();
	     Assert.assertTrue(
	         currentUrl.contains("/en/career/search?search=" + keyword),
	         "❌ URL did not contain expected keyword. Found: " + currentUrl
	     );

	     System.out.println("✅ Test passed: Career search using properties value '" + keyword + "' succeeded.");
	 }
	 
	 @Test(priority = 6)
	 public void testFillupSeekerForm() {
	     Properties data = DataPropForHerPower;

	     CareerAndPlacementPage page = new CareerAndPlacementPage(driver);
	     CareerAndPlacementPage resultPage = page.FillupseekerForm(
	         data.getProperty("firstName"),
	         data.getProperty("lastName"),
	         data.getProperty("email"),
	         data.getProperty("phone"),
	         data.getProperty("address"),
	         data.getProperty("area1"),
	         data.getProperty("area2"),
	         data.getProperty("zip"),
	         data.getProperty("degree"),
	         data.getProperty("department"),
	         data.getProperty("passYear"),
	         data.getProperty("cgpa"),
	         data.getProperty("outOf"),
	         data.getProperty("titleExp"),
	         data.getProperty("experience"),
	         data.getProperty("organization"),
	         data.getProperty("titleAchv"),
	         data.getProperty("documentFile"),
	         data.getProperty("portfolio"),
	         data.getProperty("imageFile")
	     );

	     Assert.assertNotNull(resultPage, "Form submission should return a valid CareerAndPlacementPage instance");
	     Assert.assertTrue(resultPage.isFormSubmittedSuccessfully(), "Form should be submitted successfully");
	 }


}

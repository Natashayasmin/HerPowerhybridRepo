package TestCaseForSellerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AllPagesForSeller.HomePageForSeller;
import AllPagesForSeller.exploreCoursePage;
import BaseInfoPage.BaseClassOne;
import CommonPage.LoginPage;
import DashboardPageHerPower.DashboardPageHerPower;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseForExploreCoursePage {
	
	public class TestCaseForProfileIconPage extends BaseClassOne  {

		public  WebDriver driver;
		DashboardPageHerPower dashboardPage;
		LoginPage loginPage;
		HomePageForSeller homePage;
		exploreCoursePage explorecoursepage;

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
			explorecoursepage =new exploreCoursePage(driver);

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
}
}

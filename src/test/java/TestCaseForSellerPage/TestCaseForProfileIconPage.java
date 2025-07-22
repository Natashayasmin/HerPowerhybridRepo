package TestCaseForSellerPage;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AllPagesForSeller.HomePageForSeller;
import AllPagesForSeller.ProfileIconPage;
import BaseInfoPage.BaseClassOne;
import CommonPage.LoginPage;
import DashboardPageHerPower.DashboardPageHerPower;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseForProfileIconPage extends BaseClassOne  {

	public  WebDriver driver;
	DashboardPageHerPower dashboardPage;
	LoginPage loginPage;
	HomePageForSeller homePage;
	ProfileIconPage profileiconpage;

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
		profileiconpage =new ProfileIconPage(driver);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 0)
	public void shouldNavigateToprofileIconSection() {
		profileiconpage.navigateToprofileIcon();
		new WebDriverWait(driver, Duration.ofSeconds(20))
		.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard"));

		Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/seller/dashboard"), 
				"Did not navigate to Home Page > ProfileIcon page");
	}
	@Test(priority = 1)
	public void shouldNavigateToorderListNextPageSection() {

		profileiconpage.navigateToOrderListNext();
		new WebDriverWait(driver, Duration.ofSeconds(15))
		.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard"));

		Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/seller/dashboard"), 
				"Did not navigate to Home Page > ProfileIcon page >orderListNext");
	}

	@Test(priority = 2)
	public void testSelectAllEntriesOption() {
		profileiconpage.getSelectedDropdownOptionText();

		String expectedOption = "All entries";
		System.out.println("Selecting '" + expectedOption + "' from the Show Entries dropdown");

		profileiconpage.selectShowEntriesOption(expectedOption);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(profileiconpage.DropdownMenu, expectedOption));

		String selected = profileiconpage.getSelectedDropdownOptionText();
		System.out.println("Selected value from dropdown: " + selected);

		Assert.assertEquals(selected, expectedOption,
				"Mismatch in dropdown selection: expected '" + expectedOption + "', but found '" + selected + "'");
	}


	@Test(priority = 3)
	public void testGoToPage2() {
		ProfileIconPage profileiconpage = new ProfileIconPage(driver);

		int targetPage = 3;
		System.out.println("Attempting to navigate to page " + targetPage);

		// Trigger pagination
		profileiconpage.goToPageNumber(targetPage);

		// Optional debug log
		System.out.println("Go To Page input completed for page " + targetPage);



	}
	@Test(priority = 4)
	public void shouldNavigateTosearchSection() {
		String typedValue = profileiconpage.navigateTosearchText();

		new WebDriverWait(driver, Duration.ofSeconds(30))
		.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard"));

		Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/seller/dashboard"),
				"Did not navigate to Home Page > ProfileIcon page > orderListNext");

		System.out.println("Search box input value: " + typedValue);
	}



	@Test(priority = 5)
	public void shouldNavigateToeditProfileAndUpdatePage() {


		profileiconpage.navigateToeditYourProfileAndUpdatePage();

		// Optional debug
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);


	}

	@Test(priority = 6)
	public void shouldNavigateToUpdatePasswordPage() {
		profileiconpage.navigateToUpdatePasswordPage();

		// Debug (optional)
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		// ✅ Confirm the right field is visible
		WebElement newPasswordField = driver.findElement(By.xpath("//label[contains(text(),'New Password')]"));
		Assert.assertTrue(newPasswordField.isDisplayed(), "Update Password page did not load properly.");
	}

	@Test(priority = 7)
	public void shouldNavigateToChatPage() {
		profileiconpage.navigateToChatPage();

		WebElement qaHeader = driver.findElement(By.xpath("//*[text()='Question & Answer']"));
		Assert.assertTrue(qaHeader.isDisplayed(), "Chat page (Q&A section) did not load properly.");
	}

	@Test(priority = 8)
	public void shouldFailIfImageFieldMissing() {
		ProfileIconPage profileiconpage = new ProfileIconPage(driver);

		boolean isImageVisible = profileiconpage.isImageFieldVisible();
		System.out.println("Is 'Image' field visible? → " + isImageVisible);

		Assert.assertTrue(isImageVisible, "'Image' field is missing or not visible.");
	}
	
	@Test(priority = 9)
	public void shouldNavigateToViewOrderListAndSearchSection() {
	    String typedValue = profileiconpage.navigateToViewOrderListAndSearch();

	    new WebDriverWait(driver, Duration.ofSeconds(15))
	        .until(ExpectedConditions.urlContains("/shop-now/seller/dashboard/all-product"));

	    Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/seller/dashboard/all-product"),
	        "Did not navigate to the expected dashboard URL.");


	    System.out.println("Search box input value: " + typedValue);
	}
	
	@Test(priority = 10)
	public void shouldEditAndUpdateProductName() {
	    String ProductNameUpdate = "Delux1";

	    profileiconpage.navigateToeditAndUpdateProd(ProductNameUpdate);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Confirm updated product name appears (adjust XPath as needed)
	    By updatedProductLocator = By.xpath("//*[contains(text(), '" + ProductNameUpdate + "')]");

	    WebElement updatedNameLabel = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(updatedProductLocator)
	    );

	    Assert.assertTrue(updatedNameLabel.getText().contains(ProductNameUpdate),
	        "Product name was not updated successfully.");

	    System.out.println(" Product Updated successfully: " + ProductNameUpdate);
	}
	
//	@Test(priority = 11)
//	public void shouldAddNewProductPage()  {
//		
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//	    
//
//
//	    profileiconpage.verifyaddNewProducts(
//	        DataPropForHerPower.getProperty("productName"),
//	        DataPropForHerPower.getProperty("brandModel"),
//	        DataPropForHerPower.getProperty("brandName"),
//	       // DataPropForHerPower.getProperty("categoryName"),
//	      //  DataPropForHerPower.getProperty("descField"),
//	        DataPropForHerPower.getProperty("imageFile"),        // Full local path required
//	        DataPropForHerPower.getProperty("variantName"),
//	        DataPropForHerPower.getProperty("oldPrice"),
//	        DataPropForHerPower.getProperty("newPrice"),
//	            
//	        
//	        DataPropForHerPower.getProperty("stockCount"),
//	        DataPropForHerPower.getProperty("descfield2"), null
//	        
//	    );
//	    
//	    String expectedOption = "Footwear";
//		System.out.println("Selecting '" + expectedOption + "' from the Category ");
//
//	    String expectedFragment = "/shop-now/seller/dashboard/add-product";
//
//	    try {
//	        // Try redirect verification
//	        wait.until(ExpectedConditions.urlContains(expectedFragment));
//	        String actualUrl = driver.getCurrentUrl();
//	        Assert.assertTrue(actualUrl.contains(expectedFragment),
//	            "❌ Redirect failed. Landed on unexpected URL: " + actualUrl);
//	        System.out.println("✅ Redirected to dashboard after publishing: " + actualUrl);
//
//	    } catch (TimeoutException e) {
//	        // If redirect fails, check for success toast or UI confirmation
//	        try {
//	            WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	                By.xpath("//*[contains(text(), 'Product added')]")
//	            ));
//	            Assert.assertTrue(successToast.isDisplayed(), "❌ Success toast not visible.");
//	            System.out.println("✅ Product added successfully. Toast message displayed.");
//	        } catch (TimeoutException toastFail) {
//	            throw new AssertionError("❌ Neither dashboard redirect nor success message detected. Product publish may have failed.");
//	        }
//	        
//	    }
//	        }
	
	@Test(priority =12)
	public void shouldNavigateToaddProductwithoutdataSection() {
		profileiconpage.verifyaddNewProducts();
		new WebDriverWait(driver, Duration.ofSeconds(20))
		.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard"));

		Assert.assertTrue(driver.getCurrentUrl().contains("/shop-now/seller/dashboard"), 
				"Did not navigate to Home Page > ProfileIcon page");
	}
	    }
	
	    
	


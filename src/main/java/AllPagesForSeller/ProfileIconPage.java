package AllPagesForSeller;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileIconPage {

	public WebDriver driver;
	WebDriverWait wait;

	//POM
	@FindBy(xpath="//img[@class='h-8 w-8 object-cover rounded-full border-2 border-brandDs z-10']")
	private WebElement profileIconbtn;

	private By orderListNextPage = By.xpath("//body//div//button[3]//*[name()='svg']");

	@FindBy(xpath="//select[@class='px-2 py-2 rounded-md outline-none']")
	public WebElement DropdownMenu;

	@FindBy(xpath="//input[@type='number']")
	private WebElement GoToPage;

	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchOption;

	@FindBy(xpath="//div[text()='My Account' and contains(@class,'cursor-pointer')]")
	private WebElement myAccountbtn;

	@FindBy(xpath = "//h1[contains(text(),'Edit your profile')]")
	private WebElement editYourProfile;

	@FindBy(xpath="//button[normalize-space()='Save Changes']")
	private WebElement updateProfile;

	@FindBy(xpath="//h1[normalize-space()='Change Password']")
	private WebElement changePasswordbtn;

	@FindBy(xpath="//button[normalize-space()='Save Changes']")
	private WebElement updatePassword;

	@FindBy(xpath = "//div[contains(@class, 'cursor-pointer') and normalize-space(text())='Chat']")
	private WebElement chatBtn;

	@FindBy(xpath = "//button[normalize-space()='View All Products']")
	private WebElement viewAllProducts;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchProducts;

	@FindBy(xpath="//tbody/tr[1]/td[7]/button[1]/div[1]//*[name()='svg']")
	private WebElement editBtn;

	@FindBy(xpath = "//input[@placeholder='Type product name here...']")
	private WebElement productName;

	@FindBy(xpath="//button[normalize-space()='Update Product']")
	private WebElement updateProduct;

	@FindBy(xpath="//button[normalize-space()='Add New Product']")
	private WebElement addNewProductbtn;

	//Add new Product

	@FindBy(css = "input[placeholder='Type product name here...']")
private WebElement productNameNewField;

	@FindBy(xpath = "//input[@placeholder='Type brand model here...']")
	private WebElement brandModelField;

	@FindBy(xpath = "//input[@placeholder='Type brand name here...']")
	private WebElement brandNameField;

	@FindBy(xpath = "//button[contains(@class, 'justify-between') and contains(@class, 'rounded-full')]")
	private WebElement productCategory;

	@FindBy(xpath = "//div[contains(@class, 'ql-editor')]")
	private WebElement descFieldName;

	@FindBy(xpath = "//label[contains(text(),'Upload')]")
	private WebElement uploadLabel;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileInput;

	@FindBy(xpath = "//input[contains(@placeholder,'variant name')]")
	private WebElement variant1Field;

	@FindBy(xpath = "//input[contains(@placeholder,'variant old price')]")
	private WebElement oldPriceField;

	@FindBy(xpath = "//input[contains(@placeholder,'variant new price')]")
	private WebElement newPriceField;

	@FindBy(xpath = "//input[contains(@placeholder,'variant stock')]")
	private WebElement stockField;

	@FindBy(xpath = "//input[contains(@placeholder,'variant description')]")
	private WebElement descField2;

	@FindBy(css = "button[type='submit']")
	private WebElement publishBtn;

	//Constructor
	public ProfileIconPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	//Actions
	public ProfileIconPage navigateToprofileIcon() {
		new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();

		wait.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard"));

		return new ProfileIconPage(driver);
	}

	public ProfileIconPage navigateToOrderListNext() {
		new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(orderListNextPage)).click();

		wait.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard"));

		return this;
	}

	// Select option
	// Selects a value from the Show Entries dropdown
	// Select option

	public ProfileIconPage selectShowEntriesOption(String allentries) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(DropdownMenu)));
		select.selectByVisibleText(allentries);

		return this;
	}

	public String getSelectedDropdownOptionText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(DropdownMenu)));
		wait.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard"));
		return select.getFirstSelectedOption().getText();
	}



	public ProfileIconPage goToPageNumber(int pageNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();
		WebElement GoToPage = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//input[@type='number' or contains(@placeholder, 'Page')]")
						));

		GoToPage.clear();
		GoToPage.sendKeys(String.valueOf(2));
		GoToPage.sendKeys(Keys.ENTER);

		return this;
	}

	public String navigateTosearchText() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();


		WebElement searchInput = wait.until(ExpectedConditions.visibilityOf(searchOption));
		searchInput.sendKeys("anika"); 


		wait.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard"));
		return searchInput.getAttribute("value");
	}



	public ProfileIconPage navigateToeditYourProfileAndUpdatePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();

		wait.until(ExpectedConditions.visibilityOf(myAccountbtn));
		wait.until(ExpectedConditions.elementToBeClickable(myAccountbtn)).click();

		wait.until(ExpectedConditions.visibilityOf(editYourProfile));
		wait.until(ExpectedConditions.elementToBeClickable(editYourProfile)).click();

		wait.until(ExpectedConditions.elementToBeClickable(updateProfile)).click();
		wait.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard"));

		return new ProfileIconPage(driver);


	}


	public ProfileIconPage navigateToUpdatePasswordPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();

		wait.until(ExpectedConditions.elementToBeClickable(myAccountbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(editYourProfile)).click();

		wait.until(ExpectedConditions.elementToBeClickable(changePasswordbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(updatePassword)).click();

		// Final wait: Ensure the page is fully loaded by waiting for a unique element
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[contains(text(),'New Password')]")
				));
		return new ProfileIconPage(driver);
	}

	public ProfileIconPage navigateToChatPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Click profile icon if needed (only if chat button is under profile menu)
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();

		// Wait and click Chat button
		wait.until(ExpectedConditions.visibilityOf(chatBtn));
		wait.until(ExpectedConditions.elementToBeClickable(chatBtn)).click();

		// Wait for something inside the Chat section to become visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[text()='Question & Answer']")
				));
		return new ProfileIconPage(driver);
	}

	public boolean isImageFielNamedVisible() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement imageLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//label[normalize-space()='Image']")
					));
			return imageLabel.isDisplayed();
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("❌ 'Image' field label not found or not visible.");
			return false;
		}
	}

	public String navigateToViewOrderListAndSearch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();
		wait.until(ExpectedConditions.visibilityOf(viewAllProducts));
		wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts)).click();
		wait.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard/all-product"));
		wait.until(ExpectedConditions.visibilityOf(searchProducts));

		String typedValue = "Delux";
		searchProducts.clear(); // Optional: clear before typing
		searchProducts.sendKeys(typedValue);

		return typedValue;
	}

	public ProfileIconPage navigateToeditAndUpdateProd(String ProductNameUpdate) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Click on Profile Icon
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();

		// Click on "View All Products"
		wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts)).click();

		// Click on Edit button for the product
		wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();

		// Clear and enter new product name
		wait.until(ExpectedConditions.visibilityOf(productName));
		productName.clear(); // Clear existing text before input
		productName.sendKeys(ProductNameUpdate);

		// Click on "Update Product" button
		wait.until(ExpectedConditions.elementToBeClickable(updateProduct)).click();

		// Return the updated page object
		return this;
	}

	public ProfileIconPage verifyaddNewProductsformfillup(
		    String productName,
		    String brandModel,
		    String brandName,
		    String description,
		    String imageFile,
		    String variantName,
		    String oldPrice,
		    String newPrice,
		 //   String categoryName,
		    String stockCount,
		    String descfield2
		) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    // Navigate to "Add New Product"
		    wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();
		    wait.until(ExpectedConditions.elementToBeClickable(addNewProductbtn)).click();

		    // Fill product details
		    wait.until(ExpectedConditions.visibilityOf(productNameNewField)).sendKeys(productName);
		    brandModelField.sendKeys(brandModel);
		    brandNameField.sendKeys(brandName);

//		    // --- CUSTOM DROPDOWN HANDLING START ---
//		    // 1. Open the dropdown
//		    WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
//		        By.xpath("//button[contains(@class,'h-10') and .//span[text()='Product Category']]")
//		    ));
//		    dropdownButton.click();
//
//		    // 2. Wait for dropdown options to be visible
//		    wait.until(ExpectedConditions.visibilityOfElementLocated(
//		        By.xpath("//ul[contains(@class,'absolute') and contains(@class,'z-')]")
//		    ));
//
//		    // 3. Select the option dynamically
//		    By optionLocator = By.xpath("//li[normalize-space(text())='" + categoryName + "']");
//		    WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
//		    js.executeScript("arguments[0].scrollIntoView(true);", option);
//		    wait.until(ExpectedConditions.elementToBeClickable(option)).click();
//
//		    // --- CUSTOM DROPDOWN HANDLING END ---

		    // Image upload
		    uploadLabel.click();
		    fileInput.sendKeys(imageFile);
		    
		    descFieldName.sendKeys(description);

		    // Pricing and variant
		    variant1Field.sendKeys(variantName);
		    oldPriceField.sendKeys(oldPrice);
		    newPriceField.sendKeys(newPrice);
		    stockField.sendKeys(stockCount);
		    descField2.sendKeys(descfield2);

		    // Submit
		    wait.until(ExpectedConditions.elementToBeClickable(publishBtn)).click();

		    // Wait for success confirmation
		    wait.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard/add-product"));

		    return this;
		}
	
	public ProfileIconPage verifyaddNewProducts() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(profileIconbtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(addNewProductbtn)).click();
		wait.until(ExpectedConditions.visibilityOf(publishBtn));
		wait.until(ExpectedConditions.elementToBeClickable(publishBtn)).click();
		wait.until(ExpectedConditions.urlContains("/shop-now/seller/dashboard/add-product"));
		
	    return this;
		
	}
}











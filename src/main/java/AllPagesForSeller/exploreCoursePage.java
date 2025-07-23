package AllPagesForSeller;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exploreCoursePage {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	//POM
	@FindBy(xpath="//p[normalize-space()='Explore Course']")
	private WebElement exploreCoursebtn;
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		}



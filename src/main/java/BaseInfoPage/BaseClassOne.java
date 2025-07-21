package BaseInfoPage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClassOne {
	WebDriver driver; ;
	public Properties propForHerPower;
	public Properties DataPropForHerPower;

	public void loadPropertiesFileOfHerPower() {

		propForHerPower = new Properties();
		File BaseDatafile = new File(System.getProperty("user.dir") +"\\BaseInfoConfig");
		try {
			FileInputStream BaseDatafis = new FileInputStream(BaseDatafile);
			propForHerPower.load(BaseDatafis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}

		DataPropForHerPower = new Properties();
		File TestDatafile = new File(System.getProperty("user.dir")+"\\TestDataFileHerPower");
		try {
			FileInputStream TestDatafis = new FileInputStream(TestDatafile);
			DataPropForHerPower.load(TestDatafis);	
		} catch (Throwable e) {
			e.printStackTrace();
		}


	}
	public  WebDriver intilizeBrowserAndOpenApplicationURL(String browserName) {
		if(browserName.equals("chrome")){
			driver = new ChromeDriver();
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if(browserName.equals("safari")) {
			driver = new SafariDriver();
		}
		return driver;
	}
}




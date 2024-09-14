package com.qa.formy.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.formy.Factory.DriverFactory;
import com.qa.formy.pages.AutocompletePage;
import com.qa.formy.pages.ButtonPage;
import com.qa.formy.pages.Dropdown_page;
import com.qa.formy.pages.Home_page;
import com.qa.formy.pages.SwithWindow_page;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	DriverFactory driverFactory;
	protected AutocompletePage autocompletePage;
	protected SoftAssert softAssert;
	protected ButtonPage buttonPage;
	protected Dropdown_page dropdown_page;
	protected Home_page home_page;
	protected SwithWindow_page swithWindow_page;
	
	
	public static final Logger log = LogManager.getLogger(BaseTest.class);

	@Parameters({ "browser", "browserversion" })
	@BeforeTest
	public void setup(String browserName, String browserVersion) {

		driverFactory = new DriverFactory();
		prop = driverFactory.initProp();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);

		}

		driver = driverFactory.initDriver(prop);
		softAssert = new SoftAssert();
		autocompletePage = new AutocompletePage(this.driver);
		buttonPage = new ButtonPage(this.driver);
	//	dropdown_page = new Dropdown_page(this.driver);
		home_page = new Home_page(this.driver);
		swithWindow_page = new SwithWindow_page(this.driver);
		
		

	}

	@AfterTest
	public void teardown() {
		driver.quit();

	}

}

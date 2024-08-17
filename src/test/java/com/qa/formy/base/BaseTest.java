package com.qa.formy.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.formy.Factory.DriverFactory;
import com.qa.formy.pages.AutocompletePage;
import com.qa.formy.pages.ButtonPage;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	DriverFactory driverFactory;
	protected AutocompletePage autocompletePage;
	protected SoftAssert softAssert;
	public ButtonPage buttonPage;
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
		autocompletePage = new AutocompletePage(this.driver);
		buttonPage = new ButtonPage(this.driver);
		softAssert = new SoftAssert();

	}

	@AfterTest
	public void teardown() {
		driver.quit();

	}

}

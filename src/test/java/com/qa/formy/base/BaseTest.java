package com.qa.formy.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.qa.formy.Factory.DriverFactory;
import com.qa.formy.pages.AutocompletePage;
import com.qa.formy.pages.ButtonPage;

public class BaseTest {
	
	protected WebDriver driver;
	DriverFactory driverFactory;
	protected Properties prop;
	protected AutocompletePage autocompletePage;
	protected SoftAssert softAssert;
	public ButtonPage buttonPage;

	@BeforeClass
	public void setup() {

		driverFactory = new DriverFactory();
		prop = driverFactory.initProp();
		driver = driverFactory.initDriver(prop);

		autocompletePage = new AutocompletePage(this.driver);
		buttonPage = new ButtonPage(this.driver);
		softAssert = new SoftAssert();

	//	System.out.println("buttonPage initialized: " + (buttonPage != null));

	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}

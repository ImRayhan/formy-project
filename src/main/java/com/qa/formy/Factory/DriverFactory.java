package com.qa.formy.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.formy.constants.AppConstant;
import com.qa.formy.exeption.FreameworkExeption;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	OptionMnager optionMnager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();



	public static final Logger log = LogManager.getLogger(DriverFactory.class);

	public WebDriver initDriver(Properties prop) {

		String browserName = prop.getProperty("browser");
		log.info("browser name input in properties file: " + browserName);

		optionMnager = new OptionMnager(prop);

		switch (browserName.toLowerCase().trim()) {

		case "chrome":
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				initRemoteDriver(browserName);
				log.info("Running in remote");
			}

			else {

				tlDriver.set(new ChromeDriver(optionMnager.getChromeOption()));
				log.info("Browser run local  name: " + browserName);
			}
			break;

		case "firefox":
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				initRemoteDriver(browserName);
				log.info("Running in remote");
			} else {
				tlDriver.set(new FirefoxDriver(optionMnager.getFirefoxOption()));
				log.info("Browser is: " + browserName);
			}
			break;

		case "edge":
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				initRemoteDriver(browserName);
				log.info("Running in remote");
			} else {
				tlDriver.set(new EdgeDriver(optionMnager.getedgeOption()));
				log.info("Browser is: " + browserName);
			}
			break;

		default:
			log.info("Please pass the right browser name");
			break;
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(AppConstant.MEDIUM_DEFULT_WAIT));
		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}

	public Properties initProp() {

		FileInputStream ip = null;
		prop = new Properties();
		String envName = System.getProperty("env");

		try {

			if (envName == null) {
				ip = new FileInputStream("src/test/resources/config/config.qa.properties");
				log.info("Running on qa env");
				log.info(ip);

			}

			else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("src/test/resources/config/config.qa.properties");
					log.info("Running on qa env from properties");
					break;
				case "dev":
					ip = new FileInputStream("src/test/resources/config/config.dev.properties");

					break;
				case "stage":
					ip = new FileInputStream("src/test/resources/config/config.stage.properties");

					break;
				case "uat":
					ip = new FileInputStream("src/test/resources/config/config.uat.properties");
					log.info("Running on uat env");

					break;

				default:
					log.info("please pass the right env" + envName);

					throw new FreameworkExeption("Wrong env name" + envName);

				}
			}
		} catch (FileNotFoundException e) {

		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	private void initRemoteDriver(String browserName) {

		log.info("Running test on grid with browser: " + browserName);
		try {
			// Read the hub URL from the properties file
			String hubUrlString = prop.getProperty("huburl");

			// Construct the URI and then convert to URL
			URI hubUri = new URI(hubUrlString);
			URL hubUrl = hubUri.toURL();

			switch (browserName.toLowerCase().trim()) {
			case "chrome":
				log.info("Setting up Chrome driver in remote...");
				tlDriver.set(new RemoteWebDriver(hubUrl,optionMnager.getChromeOption()));
				break;

			case "firefox":
				log.info("Setting up firefox driver...");
				tlDriver.set(new RemoteWebDriver(hubUrl, optionMnager.getFirefoxOption()));
				break;

			case "edge":
				log.info("Setting up edge driver...");
				tlDriver.set(new RemoteWebDriver(hubUrl, optionMnager.getedgeOption()));
				;
				break;

			default:
				log.info("Wrong browser info .. cannot run in grid machine");
				break;
			}
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();

	}

	/**
	 * take screenshot
	 */
	public static String getScreenshot(String methodName) {
		// Define the directory path for storing screenshots
		String screenshotDir = System.getProperty("user.dir") + "/screenshot/";
		File dir = new File(screenshotDir);

		// Create the directory if it doesn't exist
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// Capture the screenshot and save it to the specified path
		String path = screenshotDir + methodName + "_" + System.currentTimeMillis() + ".png";
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		File destination = new File(path);

		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}

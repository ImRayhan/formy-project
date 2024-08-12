package com.qa.formy.Factory;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionMnager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public static final Logger log = LogManager.getLogger(OptionMnager.class);

	public OptionMnager(Properties prop) {
		this.prop = prop;

	}

	public ChromeOptions getChromeOption() {
		co = new ChromeOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			co.addArguments("--headless");
			log.info("Chrome browser run in headless mood");

		}

		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			co.addArguments("--incognito");
			log.info("Chrome browser run in incognito mood");

		}
		return co;

	}

	public FirefoxOptions getFirefoxOption() {
		fo = new FirefoxOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			fo.addArguments("--headless");
			log.info("Firefox browser run in headless mood");

		}

		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			fo.addArguments("--incognito");
			log.info("Firefox browser run in incognito mood");

		}
		return fo;

	}

	public EdgeOptions getedgeOption() {
		eo = new EdgeOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			eo.addArguments("--headless");
			log.info("Edge browser run in headless mood");

		}

		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			eo.addArguments("--incognito");
			log.info("Edge browser run in incognito mood");

		}
		return eo;

	}

}

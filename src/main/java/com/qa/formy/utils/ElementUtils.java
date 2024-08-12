package com.qa.formy.utils;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private WebDriver driver;
	WebDriverWait wait;

	private static Logger log = LogManager.getLogger(ElementUtils.class);

	public ElementUtils(WebDriver driver) {
		this.driver = driver;

	}

	private void logLocator(By locator) {

		log.info("locator : " + locator);
	}

	public WebElement getElement(By locator) {

		logLocator(locator);
		WebElement element = driver.findElement(locator);

		return element;
	}

	public List<WebElement> getElements(By locator) {

		logLocator(locator);
		List<WebElement> element = driver.findElements(locator);

		return element;
	}

	public List<WebElement> waitGetElements(By locator, int duration) {

		logLocator(locator);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElements(getElements(locator)));

		return element;
	}

	public void doClick(By locator) {

		getElement(locator).click();
	}

	public void doSendkeys(By locator, String value) {

		getElement(locator).clear();
		getElement(locator).sendKeys(value);

	}

	public boolean checkingElementEnbled(By locator) {

		return getElement(locator).isEnabled();

	}

	public void name() {

	}

	public String waitForTitle(String title, int timeout) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		try {
			if (wait.until(ExpectedConditions.titleIs(title))) {
				return driver.getTitle();

			}

		} catch (Exception e) {

			log.info(title + " title value is not present....");
			e.printStackTrace();
		}
		return null;

	}

}

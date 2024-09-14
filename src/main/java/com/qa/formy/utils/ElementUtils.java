package com.qa.formy.utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.formy.constants.AppConstant;

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
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		return element;
	}

	public WebElement waitGetElement(By locator, int duration) {

		logLocator(locator);

		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element;
	}

	public WebElement fluentWaitGetelement(By locator, int timeout) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(timeout)).withMessage("_time out is done element is not found")
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public List<WebElement> fluentWaitGetelements(By locator, int timeout) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(timeout)).withMessage("_time out is done element is not found")
				.ignoring(NoSuchElementException.class);

		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		return element;

	}

	public void doClick(By locator) {

		getElement(locator).click();
	}

	public void WaitClick(By locator, int explicitWait) {

		waitGetElement(locator, explicitWait).click();

	}

	public void fluentWaitClick(By locator, int waittime) {

		fluentWaitGetelement(locator, waittime).click();

	}

	public void doSendkeys(By locator, String value) {

		getElement(locator).clear();
		getElement(locator).sendKeys(value);

	}

	public boolean checkingElementEnbled(By locator) {

		return getElement(locator).isEnabled();

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

	public void selectTextNonSelectClass(By locator, String text, int time) {

		List<WebElement> slecctText = fluentWaitGetelements(locator, time);

		for (WebElement iterable_element : slecctText) {

			String textElement = iterable_element.getText();

			if (textElement.equalsIgnoreCase(text)) {

				iterable_element.click();
				break;

			}

		}

	}

	public Alert waitAlertPresent(int waitTime) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public void alertAccept() {

		Alert al = driver.switchTo().alert();
		al.accept();

	}

	public void waitAndAcceptAllert(int timeout) {

		waitAlertPresent(timeout).accept();

	}

	public void waitAndDismissAllert(int timeout) {

		waitAlertPresent(timeout).dismiss();

	}

	public String getAlertText(int timeOut) {
		return waitAlertPresent(timeOut).getText();
	}

}

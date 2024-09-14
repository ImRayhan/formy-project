package com.qa.formy.pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.formy.constants.AppConstant;
import com.qa.formy.utils.ElementUtils;

public class SwithWindow_page {

	private WebDriver driver;
	ElementUtils elementUtils;

	public SwithWindow_page(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);

	}

	Logger log = LogManager.getLogger(SwithWindow_page.class);

	By swithWindowElement = By.linkText("Switch Window");

	By openNewTabElement = By.id("new-tab-button");

	By alertElement = By.id("alert-button");

	public void navigatetoSwithWindow() {

		elementUtils.doClick(swithWindowElement);

	}

	public void swithNewTab() {

		elementUtils.doClick(openNewTabElement);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);

	}

	public String newTabWindowTitle() {
		return driver.getCurrentUrl();

	}

	public void clickOnAlert() {

		elementUtils.doClick(alertElement);

	}

	public void acceptTheAlert() {

		elementUtils.waitAndAcceptAllert(AppConstant.LONG_DEFULT_WAIT);

	}

	public String name() {

		return elementUtils.getAlertText(5);

	}
	
	

}

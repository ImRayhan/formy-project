package com.qa.formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.formy.constants.AppConstant;
import com.qa.formy.utils.ElementUtils;

public class Dropdown_page {

	private WebDriver driver;
	private ElementUtils elementUtils;
	private Home_page home_page;

	public Dropdown_page(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
		home_page = new Home_page(driver);

	}

	By dropdownElement = By.xpath("//a[normalize-space()= 'Dropdown' and @class='btn btn-lg']");
	By dropdownBtnElement = By.xpath("//div[@class='dropdown']/button");
	By dropdownBtnElements = By.xpath("//button[@id='dropdownMenuButton']/following-sibling::div/a");
	By formyElement = By.xpath("//*[@id=\"logo\"]");

	public void navigateDropdownPage() {
	elementUtils.fluentWaitClick(dropdownElement, AppConstant.LONG_DEFULT_WAIT);

		// elementUtils.WaitClick(dropdownElement, AppConstant.MEDIUM_DEFULT_WAIT);

	}

	public void clickOnDropdownBtn() {

		//elementUtils.WaitClick(dropdownBtnElement, AppConstant.MEDIUM_DEFULT_WAIT);
		elementUtils.fluentWaitClick(dropdownBtnElement, AppConstant.LONG_DEFULT_WAIT);

	}

	public String selectTextInDropdown(String text, int waitTime) throws InterruptedException {
		Thread.sleep(1000);

		navigateDropdownPage();
		Thread.sleep(1000);
		clickOnDropdownBtn();
		elementUtils.selectTextNonSelectClass(dropdownBtnElements, text, waitTime);
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		try {
			home_page.navigateHomePage();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return url;

	}

}

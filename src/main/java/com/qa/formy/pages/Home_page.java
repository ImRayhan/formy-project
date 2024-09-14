package com.qa.formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.formy.constants.AppConstant;
import com.qa.formy.utils.ElementUtils;

public class Home_page {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public Home_page(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);

	}

	By dropdownElement = By.xpath("//a[normalize-space()= 'Dropdown' and @class='btn btn-lg']");
	By formyElement = By.xpath("/html/body/div/nav/a[@id='logo']");

	public Dropdown_page navigateDropdown() {

		// elementUtils.doClick(dropdownElement);
		return new Dropdown_page(driver);

	}

	public void navigateHomePage() {
		elementUtils.WaitClick(formyElement, AppConstant.LONG_DEFULT_WAIT);

	}

}

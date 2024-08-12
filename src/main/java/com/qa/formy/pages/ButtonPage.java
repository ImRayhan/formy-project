package com.qa.formy.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.formy.utils.ElementUtils;

public class ButtonPage {

	private WebDriver driver;
	ElementUtils elementUtils;

	public ButtonPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);

	}

	By buttons = By.linkText("Buttons");

	By PrimaryBtn = By.xpath("//form/div//button");

	By dropdownLinkText = By.xpath("//div[@class='dropdown-menu show']/a");

	public void navigateButtons() {

		elementUtils.doClick(buttons);
	}

	public List<String> allTheButtonFIeldText() {

		navigateButtons();
		ArrayList<String> arrays = new ArrayList<>();

		List<WebElement> el = elementUtils.getElements(PrimaryBtn);

		for (WebElement webElement : el) {
			String elementsText = webElement.getText();
			arrays.add(elementsText);

			if (elementsText.contains("Dropdown")) {
				webElement.click();

				List<WebElement> e = elementUtils.getElements(dropdownLinkText);

				for (WebElement a : e) {
					String textDropdown = a.getText();
					arrays.add(textDropdown);

					if (textDropdown.equalsIgnoreCase("Dropdown link 2")) {
						break;

					}

				}

			}

		}
		return arrays;

	}

}

package com.qa.formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.formy.constants.AppConstant;
import com.qa.formy.utils.ElementUtils;

public class AutocompletePage {

	private WebDriver driver;
	ElementUtils elementUtils;
	ButtonPage buttonPage;

	public AutocompletePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);

	}

	By autocomplete = By.xpath("//a[text()='Autocomplete' and @class='btn btn-lg']");

	By addressField = By.xpath("//input[@id='autocomplete']");

	By streetAdressField = By.id("street_number");

	By streetAdress2Field = By.id("route");

	By cityField = By.id("locality");

	By stateField = By.id("administrative_area_level_1");

	By zipcodeField = By.id("postal_code");

	By countrycodeField = By.id("country");

	By headerText = By.xpath("//h1[text()='Autocomplete']");
	
	By butonsLink = By.linkText("Buttons");


	public void navigateToAutocomplete() {

		elementUtils.doClick(autocomplete);

	}

	public String autocompletePageTitle() {

		navigateToAutocomplete();
		String title = elementUtils.waitForTitle(AppConstant.TITLE_AUTOCOMPLETE_FORM, AppConstant.MEDIUM_DEFULT_WAIT);
		return title;
	}

	public void inputDataOnAutocompleteForm(String adress, String strretAdress, String streetAdress2, String city,
			String state, String zipCodde, String country) {

		elementUtils.doSendkeys(addressField, adress);
		elementUtils.doSendkeys(streetAdressField, strretAdress);
		elementUtils.doSendkeys(streetAdress2Field, streetAdress2);
		elementUtils.doSendkeys(cityField, city);
		elementUtils.doSendkeys(stateField, state);
		elementUtils.doSendkeys(zipcodeField, zipCodde);
		elementUtils.doSendkeys(countrycodeField, country);

	}

	public boolean adressFieldEnbled() {

		boolean el = elementUtils.checkingElementEnbled(addressField);
		return el;

	}

	public boolean streetAdressFieldEnbled() {
		boolean el = elementUtils.checkingElementEnbled(streetAdressField);
		return el;

	}

	public boolean streetAdress2FieldEnbled() {
		boolean el = elementUtils.checkingElementEnbled(streetAdress2Field);
		return el;

	}

	public boolean cityFieldEnbled() {
		boolean el = elementUtils.checkingElementEnbled(streetAdress2Field);
		return el;

	}

	public boolean stateFieldEnbled() {
		boolean el = elementUtils.checkingElementEnbled(streetAdress2Field);
		return el;

	}

	public boolean zipcodeFieldEnbled() {
		boolean el = elementUtils.checkingElementEnbled(streetAdress2Field);
		return el;

	}

	public boolean contryFieldEnbled() {
		boolean el = elementUtils.checkingElementEnbled(streetAdress2Field);
		return el;

	}


}

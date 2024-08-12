package com.qa.formy.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.formy.base.BaseTest;
import com.qa.formy.constants.AppConstant;
import com.qa.formy.utils.ElementUtils;

public class Autocomplete_Test extends BaseTest {

	private static Logger log = LogManager.getLogger(ElementUtils.class);

	@Test(priority = 1)
	public void verifyTitle() {

		String actualTitle = autocompletePage.autocompletePageTitle();
		AssertJUnit.assertEquals(actualTitle, AppConstant.TITLE_AUTOCOMPLETE_FORM);
		log.info("Actual titls Autocomplete Form page: " + actualTitle);

	}

	@DataProvider
	public Object[][] getAutocompleteFormData() {

		Object data[][] = { { "hillcrest dr", "hillcrest", "amherstBuffalo", "Amherst", "NY", "14226", "USA" },
				{ "DhakaMirpur", "Mi", "Mipur", "Dhaka", "BD", "14", "BD" } };

		return data;
	}

	@Test(priority = 2, dependsOnMethods = "verifyTitle")
	public void veryfyInputFieldEnbled() {

		AssertJUnit.assertTrue(autocompletePage.adressFieldEnbled());
		AssertJUnit.assertTrue(autocompletePage.streetAdressFieldEnbled());
		AssertJUnit.assertTrue(autocompletePage.streetAdress2FieldEnbled());
		AssertJUnit.assertTrue(autocompletePage.cityFieldEnbled());
		AssertJUnit.assertTrue(autocompletePage.stateFieldEnbled());
		AssertJUnit.assertTrue(autocompletePage.zipcodeFieldEnbled());
		AssertJUnit.assertTrue(autocompletePage.contryFieldEnbled());
		softAssert.assertAll();

	}

	@Test(priority = 3, dependsOnMethods = "verifyTitle", dataProvider = "getAutocompleteFormData")
	public void validateFormAutocompleteField(String adress, String strretAdress, String streetAdress2, String city,
			String state, String zipCodde, String country) {

		autocompletePage.inputDataOnAutocompleteForm(adress, strretAdress, streetAdress2, city, state, zipCodde,
				country);

	}
	


}

package com.qa.formy.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.qa.formy.base.BaseTest;
import com.qa.formy.constants.AppConstant;

public class SwithWindow_test extends BaseTest {

	@Test
	public void verifyNewWindowUrl() {

		swithWindow_page.navigatetoSwithWindow();

		swithWindow_page.swithNewTab();

		String expecteditle = AppConstant.URL_HOMEPAGE;
		String actualTitle = swithWindow_page.newTabWindowTitle();

		assertEquals(expecteditle, actualTitle);

	}

	@Test(dependsOnMethods = "verifyNewWindowUrl")
	public void validateAlertTextPrasentAndAccept() {

		swithWindow_page.navigatetoSwithWindow();
		swithWindow_page.clickOnAlert();

		String expectedAlertText = swithWindow_page.name();
		String actualAlertText = "This is a test alert!";
		assertEquals(expectedAlertText, actualAlertText);

		swithWindow_page.acceptTheAlert();

	}

}

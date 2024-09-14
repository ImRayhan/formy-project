package com.qa.formy.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.formy.base.BaseTest;
import com.qa.formy.constants.AppConstant;

public class Dropdown_Test extends BaseTest {

	@BeforeClass
	public void dropdownSetup() {

		dropdown_page = home_page.navigateDropdown();

	}

	@DataProvider
	public Object getDta() {

		return new Object[][] { { "Page Scroll" }, { "Modal" }, { "Autocomplete" }, { "Buttons" }, { "Checkbox" },
				{ "Datepicker" }, { "Drag and Drop" }, { "Dropdown" }, { "Enabled and disabled elements" },
				{ "File Upload" }, { "Key and Mouse Press" }, { "Radio Button" }, { "Switch Window" },
				{ "Complete Web Form" }, { "File Download" } };

	}

	@Test(dataProvider = "getDta")
	public void verifyTheDropdownFunctionality(String userText) throws InterruptedException {

		switch (userText) {
		case "Page Scroll":

			String expectedUrl = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl, AppConstant.URL_PAGESCROLL);

			break;

		case "Modal":

			String expectedUrl1 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl1, AppConstant.URL_MODAL_PAGE);
	
			break;

		case "Autocomplete":

			String expectedUrl2 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl2, AppConstant.URL_AUTOCOMPLETEL_PAGE);
		
			break;
		case "Buttons":

			String expectedUrl3 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl3, AppConstant.URL_BUTTONS_PAGE);
			
			break;
		case "Checkbox":

			String expectedUrl4 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl4, AppConstant.URL_CHECKBOX_PAGE);
		
			break;
		case "Datepicker":

			String expectedUrl5 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl5, AppConstant.URL_DATEPICKER_PAGE);
			
			break;
		case "Drag and Drop":

			String expectedUrl6 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl6, AppConstant.URL_DRAGANDDROP_PAGE);
		
			break;
		case "Dropdown":

			String expectedUrl7 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl7, AppConstant.URL_DROPDOWN_PAGE);
			
			break;
		case "Enabled and disabled elements":

			String expectedUrl8 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl8, AppConstant.URL_ENBLEDANDDISABLEDELEMENTS_PAGE);
			
			break;
		case "File Upload":

			String expectedUrl9 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl9, AppConstant.URL_FILEUPLOAD_PAGE);
			
			break;
		case "File Download":

			String expectedUrl10 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl10, AppConstant.URL_FILEDOWNLOAD_PAGE);

			break;
		case "Key and Mouse Press":

			String expectedUrl11 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl11, AppConstant.URL_KEYANDMOUSEPRESS_PAGE);
			
			break;
		case "Switch Window":

			String expectedUrl13 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl13, AppConstant.URL_SWITHWINDOW_PAGE);
		
			break;
		case "Radio Button":

			String expectedUrl12 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl12, AppConstant.RADIObUTTONS_PAGE);
		
			break;
		case "Complete Web Form":

			String expectedUrl14 = dropdown_page.selectTextInDropdown(userText, AppConstant.MEDIUM_DEFULT_WAIT);

			assertEquals(expectedUrl14, AppConstant.URL_COMPLETEWEBFORM_PAGE);
		

			break;

		default:
			break;
		}


	}

}

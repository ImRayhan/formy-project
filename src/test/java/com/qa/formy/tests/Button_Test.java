package com.qa.formy.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.formy.base.BaseTest;


public class Button_Test extends BaseTest {



	@Test
	public void veryfyAlltheButtonPresent() {

		ArrayList<String> expectedlistTextBtn = new ArrayList<>(
				Arrays.asList("Primary", "Success", "Info", "Warning", "Danger", "Link", "Left", "Middle", "Right", "1",
						"2", "Dropdown", "Dropdown link 1", "Dropdown link 2"));

		List<String> actualtextBtn = buttonPage.allTheButtonFIeldText();
		Assert.assertEquals(expectedlistTextBtn, actualtextBtn);

	}
	//

}

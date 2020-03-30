package by.myFin.steps;

import static org.testng.AssertJUnit.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import by.myFin.page.CurrencyRatePage;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;

public class NavigationSteps extends BaseStepDefinition
{
	@Autowired
	CurrencyRatePage currencyRatePage;

	///////////------------Verification Steps-----------------/////////////

	/*
	 * Verifies that page is displayed
	 */
	@Step
	@Then("^Verify \"([^\"]*)\" page displayed$")
	public void verifyPageDisplayed(String pageTitle)
	{
		assertTrue(pageTitle + " page is not displayed!:", currencyRatePage.getPageTitle().contains(pageTitle));
	}
}

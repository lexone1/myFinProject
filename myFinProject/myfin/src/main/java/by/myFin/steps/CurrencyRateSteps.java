package by.myFin.steps;

import static org.testng.AssertJUnit.assertTrue;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import by.myFin.page.CurrencyRatePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;

public class CurrencyRateSteps extends BaseStepDefinition
{
	@Autowired
	CurrencyRatePage currencyRatePage;
	private static Logger log = Logger.getLogger(CurrencyRateSteps.class.getName());

	///////////------------Action Steps-----------------/////////////

	/**
	 * Navigates to currency page
	 */
	@When("^I open MyFin currency page$")
	public void openMyFinCurrencyPage()
	{
		currencyRatePage.getNavigation().goToURL(properties.get("applicationUrl"));
	}

	/**
	 * Returns current rate according to currency type
	 *
	 * @param currencyType currency type
	 */
	@When("^I get current \"([^\"]*)\" rate$")
	public float getCurrentRate(String currencyType) throws Exception
	{
		float currentRate;
		switch (currencyType)
		{
			case "USD":
				currentRate = currencyRatePage.getUSDCurrentRate();
				break;
			case "EUR":
				currentRate = currencyRatePage.getEURCurrentRate();
				break;
			case "RUB":
				currentRate = currencyRatePage.getRUBCurrentRate();
				break;
			default:
				throw new Exception("No such rate found!");
		}
		globals.put(currencyType + "currentRate", currentRate);
		return currentRate;
	}

	///////////------------Verification Steps-----------------/////////////

	/**
	 * Verifies value of current rate according to entering data
	 *
	 * @param currencyType - currency type
	 * @param criticalRate - critical rate
	 */
	@Step
	@Then("^I should see current \"([^\"]*)\" rate greater \"([^\"]*)\"$")
	public void verifyCurrentRate(String currencyType, Double criticalRate) throws Exception
	{
		float currencyRate = getCurrentRate(currencyType);
		assertTrue("Current currency rate " + currencyRate + " cannot be lower " + criticalRate,
				currencyRate > criticalRate);
	}

	/**
	 * Compares current and future currency rates according to currency type
	 *
	 * @param currencyType - currency type
	 */
	@Step
	@Then("^I compare current and future \"([^\"]*)\" rates$")
	public void compareCurrentFutureRate(String currencyType)
	{

		Float currentCurrencyRate = globals.get(currencyType + "currentRate");
		Float futureCurrencyRate = globals.get(currencyType + "futureRate");
		int compareResult = currentCurrencyRate.compareTo(futureCurrencyRate);
		switch (compareResult)
		{
			case -1:
				log.info(currencyType + " current currency rate lower than future currency rate.");
				break;
			case 0:
				log.info(currencyType + " current and future currency rates are equals.");
				break;
			case 1:
				log.info(currencyType + " current currency rate higher than future currency rate.");
				break;
		}
	}
}

package by.myFin.steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import cucumber.api.java.en.When;
import io.restassured.RestAssured;

public class FutureCurrencyRateSteps extends BaseStepDefinition
{
	/**
	 * Returns future rate according to currency type
	 *
	 * @param currencyType currency type
	 */
	@When("^I get future \"([^\"]*)\" rate via REST$")
	public float getFutureRateViaRest(String currencyType) throws Exception
	{
		int curID = getCurID(currencyType);
		String basePath = properties.get("currencyRates.basePath");
		String futureDate = getFutureDate();
		float futureRate = RestAssured.given().get(basePath + curID + "?onDate=" + futureDate).jsonPath().get(
				"Cur_OfficialRate");
		globals.put(currencyType + "futureRate", futureRate);
		return futureRate;
	}

	///////////------------helper methods-----------------/////////////

	/**
	 * @param currencyType
	 * @return currency ID
	 */
	private int getCurID(String currencyType) throws Exception
	{
		String curID;
		switch (currencyType)
		{
			case "USD":
				curID = properties.get("curID.USD");
				break;
			case "EUR":
				curID = properties.get("curID.EUR");
				break;
			case "RUB":
				curID = properties.get("curID.RUB");
				break;
			default:
				throw new Exception("No such currency found!");
		}
		return Integer.parseInt(curID);
	}

	/**
	 * @return future date
	 */
	private String getFutureDate()
	{
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);  // number of days to add
		return (String) (formattedDate.format(c.getTime()));
	}
}

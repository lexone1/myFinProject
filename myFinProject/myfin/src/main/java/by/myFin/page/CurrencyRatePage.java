package by.myFin.page;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import by.myFin.annotation.QAComponent;

@QAComponent("currencyPage")
public class CurrencyRatePage extends BasePage
{
	/**
	 * @return current rate table element
	 */
	public SelenideElement getCurrentRateTableElement()
	{
		return $(By.xpath(properties.get("currencyPage.currentRateTableElement")));
	}

	/**
	 * @return current USD current rate
	 */
	public float getUSDCurrentRate()
	{
		return Float.parseFloat($(By.xpath(properties.get("currencyPage.USDCurrentRate"))).getText());
	}

	/**
	 * @return current EUR current rate
	 */
	public float getEURCurrentRate()
	{
		return Float.parseFloat($(By.xpath(properties.get("currencyPage.EURCurrentRate"))).getText());
	}

	/**
	 * @return current RUB current rate
	 */
	public float getRUBCurrentRate()
	{
		return Float.parseFloat($(By.xpath(properties.get("currencyPage.RUBCurrentRate"))).getText());
	}
}

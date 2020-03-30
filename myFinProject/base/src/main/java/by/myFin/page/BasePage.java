package by.myFin.page;

import static com.codeborne.selenide.Selenide.title;

import org.springframework.beans.factory.annotation.Autowired;

import by.myFin.navigation.Navigation;
import by.myFin.properties.PropertiesManager;

public class BasePage
{
	@Autowired
	PropertiesManager properties;
	@Autowired
	Navigation navigation;

	/**
	 * @return page title
	 */
	public String getPageTitle()
	{
		return title();
	}

	/**
	 * @return by.myFin.navigation helper
	 */
	public Navigation getNavigation()
	{
		return navigation;
	}
}

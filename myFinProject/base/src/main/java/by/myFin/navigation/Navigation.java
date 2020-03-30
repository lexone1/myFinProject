package by.myFin.navigation;

import static com.codeborne.selenide.Selenide.open;

import org.springframework.beans.factory.annotation.Autowired;

import by.myFin.annotation.QAComponent;

@QAComponent("navigation")
public class Navigation
{
	/**
	 * Navigates to any URL
	 *
	 * @param url
	 */
	public void goToURL(String url)
	{
		open(url);
	}

}

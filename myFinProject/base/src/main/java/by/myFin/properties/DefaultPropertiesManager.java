package by.myFin.properties;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import by.myFin.annotation.QAComponent;

@QAComponent("propertiesManager")
public class DefaultPropertiesManager implements PropertiesManager
{
	@Autowired
	private ResourceBundleMessageSource messageSource;

	@PostConstruct
	public void init()
	{
		messageSource.setDefaultEncoding("UTF-8");
	}

	@Override
	public String get(String key)
	{
		String value = System.getProperty(key);

		if (value == null)
		{
			Object o = messageSource.getMessage(key, null, Locale.getDefault());
			value = o != null ? o.toString() : null;
		}
		return value;
	}

	@Override
	public String get(String key, String... values)
	{
		Object o = messageSource.getMessage(key, values, Locale.getDefault());

		return o != null ? o.toString() : null;
	}
}

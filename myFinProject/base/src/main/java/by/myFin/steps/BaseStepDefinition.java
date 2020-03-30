package by.myFin.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import by.myFin.properties.PropertiesManager;
import by.myFin.utility.Globals;

@ContextConfiguration("classpath:cucumber.xml")
public class BaseStepDefinition
{
	@Autowired
	protected PropertiesManager properties;
	@Autowired
	protected Globals globals;

}

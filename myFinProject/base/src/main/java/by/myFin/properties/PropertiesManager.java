package by.myFin.properties;

public interface PropertiesManager
{
	String get(String key);
	String get(String key, String... values);
}

package by.myFin.utility;

import java.util.HashMap;
import java.util.Map;

import by.myFin.annotation.QAComponent;

/**
 * Utility class to track global objects.
 */
@QAComponent("globals")
public class Globals
{
	private ThreadLocal<Map<String, Object>> temporaryValues = new ThreadLocal<Map<String, Object>>();

	/**
	 * Adds an object to the map.
	 *
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value)
	{
		getMap().put(key, value);
	}

	/**
	 * Returns the object matching the specified key.
	 *
	 * @param key
	 * @param <T>
	 * @return
	 */
	public <T> T get(String key)
	{
		return (T) getMap().get(key);
	}

	/**
	 * Internal method used to access the thread-local map and initialize it (if not yet initialized).
	 *
	 * @return
	 */
	private Map<String, Object> getMap()
	{
		Map<String, Object> map = temporaryValues.get();
		if (map == null)
		{
			map = new HashMap<String, Object>();
			temporaryValues.set(map);
		}
		return map;
	}
}

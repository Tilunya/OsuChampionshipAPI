package com.tilundev.ocapi.internal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {
	private static String _apiKey = "";
	private static String _timeCacheValidity = "";
	

	private final static String API_KEY = "API_Key";
	private final static String VALIDITY_CACHE = "Duration_validity_of_cache";
	
	public final static String API_ADDRESS = "https://osu.ppy.sh/api";
	public final static String CONFIG_PATH = "config/config.properties";
	
	public static String getApiKey() {
		return _apiKey;
	}
	
	public static Long getTimeCacheValidity() {
		try {
			return Long.parseLong(_timeCacheValidity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void initConfig() {
		try(InputStream input = new FileInputStream(CONFIG_PATH)){
			Properties prop = new Properties();
			
			prop.load(input);
			
			_apiKey = prop.getProperty(API_KEY);
			_timeCacheValidity = prop.getProperty(VALIDITY_CACHE);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveConfig() {
		try(OutputStream output = new FileOutputStream(CONFIG_PATH)){
			Properties prop = new Properties();
			
			prop.setProperty(API_KEY, _apiKey);
			prop.setProperty(VALIDITY_CACHE, _timeCacheValidity);
			
			prop.store(output, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

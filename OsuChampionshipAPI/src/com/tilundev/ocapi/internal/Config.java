package com.tilundev.ocapi.internal;

public class Config {
	private static String _apiKey = "";
	
	public final static String API_ADDRESS = "https://osu.ppy.sh/api";
	
	public static String getApiKey() {
		return _apiKey;
	}
}

package com.tilundev.ocapi.external.parameters;

public enum BeatmapParametersEnum {

	SINCE_DATE("Since date","since"),
	API_KEY("APIU Key","k"),
	BEATMAP_SET_ID("Beatmap set ID","s"),
	BEATMAP_ID("Beatmap ID","b"),
	USER_ID("User ID","u"),
	USER_TYPE_DATA("User data type","type"),
	MODE("Mode","m"),
	MODE_CONVERTER("Mode Converter","a"),
	BEATMAP_HASH("Beatmap Hash","h"),
	LIMIT_RESULT("Limit","limit");
	
	private String name;
	private String paramNaming;
	
	private BeatmapParametersEnum(String name, String paramNaming) {
		this.name = name;
		this.paramNaming = paramNaming;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getParamNaming() {
		return this.paramNaming;
	}
}

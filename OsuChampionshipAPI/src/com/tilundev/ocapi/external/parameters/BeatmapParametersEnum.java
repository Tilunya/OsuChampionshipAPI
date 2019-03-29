package com.tilundev.ocapi.external.parameters;

public enum BeatmapParametersEnum {

	SINCE_DATE("Since date"),
	BEATMAP_SET_ID("Beatmap set ID"),
	BEATMAP_ID("Beatmap ID"),
	USER_ID("User ID"),
	USER_TYPE_DATA("User data type"),
	MODE("Mode"),
	MODE_CONVERTER("Mode Converter"),
	BEATMAP_HASH("Beatmap Hash"),
	LIMIT_RESULT("Limit");
	
	private String name;
	
	private BeatmapParametersEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

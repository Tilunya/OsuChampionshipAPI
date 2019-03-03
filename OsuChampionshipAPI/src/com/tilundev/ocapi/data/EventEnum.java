package com.tilundev.ocapi.data;

public enum EventEnum {
	DISPLAY_HTML("display_html"),
	BEATMAP_ID("beatmap_id"),
	BEATMAPSET_ID("beatmapset_id"),
	DATE("date"),
	EPIC_FACTOR("epicfactor");
	
	private String name;
	
	private EventEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

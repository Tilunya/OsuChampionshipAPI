package com.tilundev.ocapi.data;

public enum ScoreEnum {
	SCORE_ID("score_id"),
	SCORE("score"),
	USERNAME("username"),
	COUNT_300("count300"),
	COUNT_100("count100"),
	COUNT_50("count50"),
	COUNT_MISS("countmiss"),
	MAX_COMBO("maxcombo"),
	COUNT_KATU("countkatu"),
	COUNT_GEKI("countgeki"),
	PERFECT("perfect"),
	ENABLED_MODS("enabled_mods"),
	USER_ID("user_id"),
	DATE("date"),
	RANK("rank"),
	PP("pp"),
	REPLAY_AVAILABLE("replay_available");
	
	private String name;
	
	private ScoreEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

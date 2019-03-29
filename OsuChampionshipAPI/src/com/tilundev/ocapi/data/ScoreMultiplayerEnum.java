package com.tilundev.ocapi.data;

public enum ScoreMultiplayerEnum {
	
	SLOT("slot"),
	TEAM("team"),
	USER_ID("user_id"),
	SCORE("score"),
	MAX_COMBO("maxcombo"),
	RANK("rank"),
	COUNT_50("count50"),
	COUNT_100("count100"),
	COUNT_300("count300"),
	COUNT_MISS("countmiss"),
	COUNT_GEKI("countgeki"),
	COUNT_KATU("countkatu"),
	PERFECT("perfect"),
	PASS("pass");

	private String name;
	
	private ScoreMultiplayerEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}

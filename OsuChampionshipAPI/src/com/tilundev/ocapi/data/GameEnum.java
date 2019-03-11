package com.tilundev.ocapi.data;

public enum GameEnum {

	GAME_ID("game_id"),
	START_TIME("start_time"),
	END_TIME("end_time"),
	BEATMAP_ID("beatmap_id"),
	PLAY_MODE("play_mode"),
	MATCH_TYPE("match_type"),
	SCORING_TYPE("scoring_type"),
	TEAM_TYPE("team_type"),
	MODS("mods"),
	SCORES("scores");
	
	
	private String name;
	
	private GameEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

package com.tilundev.ocapi.data;

public enum UserEnum {
	USER_ID("user_id"),
	USERNAME("username"),
	JOIN_DATE("join_date"),
	COUNT300("count300"),
	COUNT100("count100"),
	COUNT50("count50"),
	PLAY_COUNT("playcount"),
	RANKED_SCORE("ranked_score"),
	TOTAL_SCORE("total_score"),
	PP_RANK("pp_rank"),
	ACCURACY("accuracy"),
	PP_RAW("pp_raw"),
	LEVEL("level"),
	COUNT_RANK_SS("count_rank_ss"),
	COUNT_RANK_SSH("count_rank_ssh"),
	COUNT_RANK_S("count_rank_s"),
	COUNT_RANK_SH("count_rank_sh"),
	COUNT_RANK_A("count_rank_a"),
	COUNTRY("country"),
	TOTAL_SECONDS_PLAYED("total_seconds_played"),
	PP_COUNTRY_RANK("pp_country_rank"),
	EVENTS("events");
	
	private String name;
	
	UserEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}

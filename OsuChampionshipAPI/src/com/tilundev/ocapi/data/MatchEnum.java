package com.tilundev.ocapi.data;

public enum MatchEnum {

	MATCH_ID("match_id"),
	NAME("name"),
	START_TIME("start_time"),
	END_TIME("end_time");
	
	private String name;
	
	MatchEnum(String name){
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

package com.tilundev.ocapi.internal.request;

public enum RequestEnum {

	GET_BEATMAP_REQUEST("Get Beatmaps","/get_beatmaps",100),
	GET_USER("Get Users","/get_user",101),
	GET_SCORE("Get Scores","/get_scores",102);

	private String name;
	private String request;
	private int id;
	
	private RequestEnum(String name, String request, int id) {
		this.name = name;
		this.request = request;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRequest() {
		return this.request;
	}
	
	public int getID() {
		return this.id;
	}
}

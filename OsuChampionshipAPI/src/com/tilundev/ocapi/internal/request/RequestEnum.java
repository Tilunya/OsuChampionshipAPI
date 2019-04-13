package com.tilundev.ocapi.internal.request;

public enum RequestEnum {

	GET_BEATMAP_REQUEST("/get_beatmaps",100),
	GET_USER("/get_user",101);
	
	private String request;
	private int id;
	
	private RequestEnum(String request, int id) {
		this.request = request;
		this.id = id;
	}
	
	public String getRequest() {
		return this.request;
	}
	
	public int getID() {
		return this.id;
	}
}

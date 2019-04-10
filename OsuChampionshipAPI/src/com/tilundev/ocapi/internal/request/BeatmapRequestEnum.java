package com.tilundev.ocapi.internal.request;

public enum BeatmapRequestEnum {

	GET_BEATMAP_REQUEST("/get_beatmaps",100);
	
	private String request;
	private int id;
	
	private BeatmapRequestEnum(String request, int id) {
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

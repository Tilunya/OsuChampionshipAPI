package com.tilundev.ocapi.data;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;

public class Event {
	private String _displayHTML;
	private Long _beatmapId;
	private Long _beatmapSetId;
	private Date _date;
	private int _epicFactor; // ????
	
	/*          GETTER           */ 
	public String get_displayHTML() {
		return _displayHTML;
	}
	public Long get_beatmapId() {
		return _beatmapId;
	}
	public Long get_beatmapSetId() {
		return _beatmapSetId;
	}
	public Date get_date() {
		return _date;
	}
	public int get_epicFactor() {
		return _epicFactor;
	}
	

	/*          SETTER           */ 
	
	
	public void set_displayHTML(String _displayHTML) {
		this._displayHTML = _displayHTML;
	}
	public void set_beatmapId(Long _beatmapId) {
		this._beatmapId = _beatmapId;
	}
	public void set_beatmapSetId(Long _beatmapSetId) {
		this._beatmapSetId = _beatmapSetId;
	}
	public void set_date(Date _date) {
		this._date = _date;
	}
	public void set_epicFactor(int _epicFactor) {
		this._epicFactor = _epicFactor;
	}
	
	
	public Event(JSONObject json) throws JSONException, BadJSONDateFormatException {
		this._displayHTML = json.getString(EventEnum.DISPLAY_HTML.getName());
		this._beatmapId = json.getLong(EventEnum.BEATMAP_ID.getName());
		this._beatmapSetId = json.getLong(EventEnum.BEATMAPSET_ID.getName());
		this._date = DateUtil.parseDate(json.getString(EventEnum.DATE.getName()));
		this._epicFactor = json.getInt(EventEnum.EPIC_FACTOR.getName());
	}
	
}

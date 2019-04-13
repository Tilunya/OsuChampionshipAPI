package com.tilundev.ocapi.data;

import java.util.Date;

import org.json.JSONObject;

import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;

public class Match {
	private Long _matchId;
	private String _name;
	private Date _startTime;
	private Date _endTime;
	
	
	
	public Long get_matchId() {
		return _matchId;
	}
	public String get_name() {
		return _name;
	}
	public Date get_startTime() {
		return _startTime;
	}
	public Date get_endTime() {
		return _endTime;
	}
	
	
	public void set_matchId(Long _matchId) {
		this._matchId = _matchId;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public void set_startTime(Date _startTime) {
		this._startTime = _startTime;
	}
	public void set_endTime(Date _endTime) {
		this._endTime = _endTime;
	}
	
	
	public Match() {
		
	}
	
	public Match(JSONObject json) throws BadJSONDateFormatException {
		this._matchId = json.get(MatchEnum.MATCH_ID.getName()) != JSONObject.NULL ? json.getLong(MatchEnum.MATCH_ID.getName()) : null;
		this._name = json.get(MatchEnum.NAME.getName()) != JSONObject.NULL ? json.getString(MatchEnum.NAME.getName()) : null;
		this._startTime = json.get(MatchEnum.START_TIME.getName()) != JSONObject.NULL ? DateUtil.parseDate(json.getString(MatchEnum.START_TIME.getName())) : null;
		String endTime = json.get(MatchEnum.END_TIME.getName()) != JSONObject.NULL ? json.getString(MatchEnum.END_TIME.getName()) : null;
		this._endTime = (endTime == null) ? null : DateUtil.parseDate(endTime); 
	}
}

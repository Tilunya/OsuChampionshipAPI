package com.tilundev.ocapi.data;

import org.json.JSONObject;

public class ScoreMultiplayer extends Score {

	private int _slot;
	private int _team;
	private boolean _pass;
	
	// GETTER
	
	public int get_slot() {
		return _slot;
	}
	public int get_team() {
		return _team;
	}
	public boolean is_pass() {
		return _pass;
	}
	
	// SETTER
	public void set_slot(int _slot) {
		this._slot = _slot;
	}
	public void set_team(int _team) {
		this._team = _team;
	}
	public void set_pass(boolean _pass) {
		this._pass = _pass;
	}
	
	public ScoreMultiplayer() {
		super();
	}
	
	public ScoreMultiplayer(JSONObject json) {
		this._slot = json.get(ScoreMultiplayerEnum.SLOT.getName()) != JSONObject.NULL ? json.getInt(ScoreMultiplayerEnum.SLOT.getName()) : null;
		this._team = json.get(ScoreMultiplayerEnum.TEAM.getName()) != JSONObject.NULL ? json.getInt(ScoreMultiplayerEnum.TEAM.getName()) : null;
		this.set_userId(json.get(ScoreMultiplayerEnum.USER_ID.getName()) != JSONObject.NULL ? json.getLong(ScoreMultiplayerEnum.USER_ID.getName()) : null);
		this.set_score(json.get(ScoreMultiplayerEnum.SCORE.getName()) != JSONObject.NULL ? json.getLong(ScoreMultiplayerEnum.SCORE.getName()) : null);
		this.set_maxCombo(json.get(ScoreMultiplayerEnum.MAX_COMBO.getName()) != JSONObject.NULL ? json.getInt(ScoreMultiplayerEnum.MAX_COMBO.getName()) : null);
		this.set_rank(json.get(ScoreMultiplayerEnum.RANK.getName()) != JSONObject.NULL ? json.getString(ScoreMultiplayerEnum.RANK.getName()) : null);
		this.set_count50(json.get(ScoreMultiplayerEnum.COUNT_50.getName()) != JSONObject.NULL ? json.getInt(ScoreMultiplayerEnum.COUNT_50.getName()) : null);
		this.set_count100(json.get(ScoreMultiplayerEnum.COUNT_100.getName()) != JSONObject.NULL ? json.getInt(ScoreMultiplayerEnum.COUNT_100.getName()) : null);
		this.set_count300(json.get(ScoreMultiplayerEnum.COUNT_300.getName()) != JSONObject.NULL ? json.getInt(ScoreMultiplayerEnum.COUNT_300.getName()) : null);
		this.set_countMiss(json.get(ScoreMultiplayerEnum.COUNT_MISS.getName()) != JSONObject.NULL ? json.getInt(ScoreMultiplayerEnum.COUNT_MISS.getName()) : null);
		this.set_countGeki(json.get(ScoreMultiplayerEnum.COUNT_GEKI.getName()) != JSONObject.NULL ? json.getInt(ScoreMultiplayerEnum.COUNT_GEKI.getName()) : null);
		this.set_countKatu(json.get(ScoreMultiplayerEnum.COUNT_KATU.getName()) != JSONObject.NULL ? json.getInt(ScoreMultiplayerEnum.COUNT_KATU.getName()) : null);
		this.set_perfect(json.get(ScoreMultiplayerEnum.PERFECT.getName()) != JSONObject.NULL ? (json.getInt(ScoreMultiplayerEnum.PERFECT.getName()) == 1 ? true : false) : null);
		this._pass = json.get(ScoreMultiplayerEnum.PASS.getName()) != JSONObject.NULL ? (json.getInt(ScoreMultiplayerEnum.PASS.getName()) == 1 ? true : false) : null ;
	}
}

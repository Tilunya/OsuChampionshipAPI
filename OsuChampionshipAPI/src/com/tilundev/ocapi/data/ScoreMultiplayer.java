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
		this._slot = json.getInt(ScoreMultiplayerEnum.SLOT.getName());
		this._team = json.getInt(ScoreMultiplayerEnum.TEAM.getName());
		this.set_userId(json.getLong(ScoreMultiplayerEnum.USER_ID.getName()));
		this.set_score(json.getLong(ScoreMultiplayerEnum.SCORE.getName()));
		this.set_maxCombo(json.getInt(ScoreMultiplayerEnum.MAX_COMBO.getName()));
		this.set_rank(json.getString(ScoreMultiplayerEnum.RANK.getName()));
		this.set_count50(json.getInt(ScoreMultiplayerEnum.COUNT_50.getName()));
		this.set_count100(json.getInt(ScoreMultiplayerEnum.COUNT_100.getName()));
		this.set_count300(json.getInt(ScoreMultiplayerEnum.COUNT_300.getName()));
		this.set_countMiss(json.getInt(ScoreMultiplayerEnum.COUNT_MISS.getName()));
		this.set_countGeki(json.getInt(ScoreMultiplayerEnum.COUNT_GEKI.getName()));
		this.set_countKatu(json.getInt(ScoreMultiplayerEnum.COUNT_KATU.getName()));
		this.set_perfect(json.getInt(ScoreMultiplayerEnum.PERFECT.getName()) == 1 ? true : false);
		this._pass = json.getInt(ScoreMultiplayerEnum.PASS.getName()) == 1 ? true : false ;
	}
}

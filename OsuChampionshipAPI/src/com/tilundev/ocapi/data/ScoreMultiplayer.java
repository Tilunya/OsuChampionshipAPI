package com.tilundev.ocapi.data;

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
	
	
}

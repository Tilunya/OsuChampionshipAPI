package com.tilundev.ocapi.data;

import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.util.ModsUtil;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;
import com.tilundev.ocapi.utilexcept.NoModFoundException;
import com.tilundev.ocapi.utilexcept.NoScoringTypeFoundException;
import com.tilundev.ocapi.utilexcept.NoTeamTypeFoundException;

public class Game {
	private Long _gameId;
	private Date _startTime;
	private Date _endTime;
	private Long _beatmapId;
	private ModEnum _playMod;
	private String _matchType; // No Used in Osu! API
	private ScoringTypeEnum _scoringType;
	private TeamTypeEnum _teamType;
	private List<ModsEnum> _modsList;
	private List<Score> _scoreList;
	
	
	public Long get_gameId() {
		return _gameId;
	}
	public Date get_startTime() {
		return _startTime;
	}
	public Date get_endTime() {
		return _endTime;
	}
	public Long get_beatmapId() {
		return _beatmapId;
	}
	public ModEnum get_playMod() {
		return _playMod;
	}
	public String get_matchType() {
		return _matchType;
	}
	public ScoringTypeEnum get_scoringType() {
		return _scoringType;
	}
	public TeamTypeEnum get_teamType() {
		return _teamType;
	}
	public List<ModsEnum> get_modsList() {
		return _modsList;
	}
	
	
	public void set_gameId(Long _gameId) {
		this._gameId = _gameId;
	}
	public void set_startTime(Date _startTime) {
		this._startTime = _startTime;
	}
	public void set_endTime(Date _endTime) {
		this._endTime = _endTime;
	}
	public void set_beatmapId(Long _beatmapId) {
		this._beatmapId = _beatmapId;
	}
	public void set_playMod(ModEnum _playMod) {
		this._playMod = _playMod;
	}
	public void set_matchType(String _matchType) {
		this._matchType = _matchType;
	}
	public void set_scoringType(ScoringTypeEnum _scoringType) {
		this._scoringType = _scoringType;
	}
	public void set_teamType(TeamTypeEnum _teamType) {
		this._teamType = _teamType;
	}
	public void set_modsList(List<ModsEnum> _modsList) {
		this._modsList = _modsList;
	}
	
	
	public Game() {
		
	}
	
	public Game(JSONObject json) throws JSONException, BadJSONDateFormatException, NoModFoundException, NoScoringTypeFoundException, NoTeamTypeFoundException {
		this._gameId = json.getLong(GameEnum.GAME_ID.getName());
		this._startTime = DateUtil.parseDate(json.getString(GameEnum.START_TIME.getName()));
		this._endTime = DateUtil.parseDate(json.getString(GameEnum.END_TIME.getName()));
		this._beatmapId = json.getLong(GameEnum.BEATMAP_ID.getName());
		this._playMod = ModEnum.getEnum(json.getInt(GameEnum.PLAY_MODE.getName()));
		this._matchType = json.getString(GameEnum.MATCH_TYPE.getName());
		this._scoringType = ScoringTypeEnum.getEnum(json.getInt(GameEnum.SCORING_TYPE.getName()));
		this._teamType = TeamTypeEnum.getEnum(json.getInt(GameEnum.TEAM_TYPE.getName()));
		this._modsList = ModsUtil.parseMods(json.getLong(GameEnum.MODS.getName()));
	}
	
	
}

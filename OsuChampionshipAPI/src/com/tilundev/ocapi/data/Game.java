package com.tilundev.ocapi.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
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
	private List<ScoreMultiplayer> _scoreList;
	
	
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
	public List<ScoreMultiplayer> get_scoreList() {
		return _scoreList;
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
	public void set_scoreList(List<ScoreMultiplayer> _scoreList) {
		this._scoreList = _scoreList;
	}
	
	
	public Game() {
		
	}
	
	public Game(JSONObject json) throws JSONException, BadJSONDateFormatException, NoModFoundException, NoScoringTypeFoundException, NoTeamTypeFoundException {
		this._gameId = json.get(GameEnum.GAME_ID.getName()) != JSONObject.NULL ? json.getLong(GameEnum.GAME_ID.getName()) : null;
		this._startTime = json.get(GameEnum.START_TIME.getName()) != JSONObject.NULL ? DateUtil.parseDate(json.getString(GameEnum.START_TIME.getName())) : null;
		this._endTime = json.get(GameEnum.END_TIME.getName()) != JSONObject.NULL ? DateUtil.parseDate(json.getString(GameEnum.END_TIME.getName())) : null;
		this._beatmapId = json.get(GameEnum.BEATMAP_ID.getName()) != JSONObject.NULL ? json.getLong(GameEnum.BEATMAP_ID.getName()) : null;
		this._playMod = json.get(GameEnum.PLAY_MODE.getName()) != JSONObject.NULL ? ModEnum.getEnum(json.getInt(GameEnum.PLAY_MODE.getName())) : null;
		this._matchType = json.get(GameEnum.MATCH_TYPE.getName()) != JSONObject.NULL ? json.getString(GameEnum.MATCH_TYPE.getName()) : null;
		this._scoringType = json.get(GameEnum.SCORING_TYPE.getName()) != JSONObject.NULL ? ScoringTypeEnum.getEnum(json.getInt(GameEnum.SCORING_TYPE.getName())) : null;
		this._teamType = json.get(GameEnum.TEAM_TYPE.getName()) != JSONObject.NULL ? TeamTypeEnum.getEnum(json.getInt(GameEnum.TEAM_TYPE.getName())) : null;
		this._modsList = json.get(GameEnum.MODS.getName()) != JSONObject.NULL ? ModsUtil.parseMods(json.getLong(GameEnum.MODS.getName())) : null;
		JSONArray scoreArray = json.get(GameEnum.SCORES.getName()) != JSONObject.NULL ? json.getJSONArray(GameEnum.SCORES.getName()) : null;
		this._scoreList = new ArrayList<ScoreMultiplayer>();
		if(scoreArray != null) {
			for (int i = 0; i < scoreArray.length(); i++) {
				JSONObject jsonScore = scoreArray.getJSONObject(i);
				this._scoreList.add(new ScoreMultiplayer(jsonScore));
			}
		}
	}
	
	
}

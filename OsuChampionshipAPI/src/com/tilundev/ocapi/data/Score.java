package com.tilundev.ocapi.data;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.util.ModsUtil;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;

public class Score {
	private Long _scoreId;
	private Long _score;
	private String _username;
	private Long _userId;
	private Long _beatmapId;
	private int _count300;
	private int _count100;
	private int _count50;
	private int _countMiss;
	private int _maxCombo;
	private int _countKatu;
	private int _countGeki;
	private boolean _perfect;
	private List<ModsEnum> _enabledMods;
	private Date _date;
	private String _rank;
	private Double _pp;
	private boolean _replayAvailable;
	private User _user;
	private Beatmap _beatmap;
	
	
	/*                      GETTER                      */ 
	public Long get_scoreId() {
		return _scoreId;
	}
	public Long get_score() {
		return _score;
	}
	public String get_username() {
		return _username;
	}
	public Long get_userId() {
		return _userId;
	}
	public Long get_beatmapId() {
		return _beatmapId;
	}
	public int get_count300() {
		return _count300;
	}
	public int get_count100() {
		return _count100;
	}
	public int get_count50() {
		return _count50;
	}
	public int get_countMiss() {
		return _countMiss;
	}
	public int get_maxCombo() {
		return _maxCombo;
	}
	public int get_countKatu() {
		return _countKatu;
	}
	public int get_countGeki() {
		return _countGeki;
	}
	public boolean is_perfect() {
		return _perfect;
	}
	public List<ModsEnum> get_enabledMods() {
		return _enabledMods;
	}
	public Date get_date() {
		return _date;
	}
	public String get_rank() {
		return _rank;
	}
	public Double get_pp() {
		return _pp;
	}
	public boolean is_replayAvailable() {
		return _replayAvailable;
	}
	public User get_user() {
		return _user;
	}
	public Beatmap get_beatmap() {
		return _beatmap;
	}
	
	

	/*                      SETTER                      */ 
	
	
	
	public void set_scoreId(Long _scoreId) {
		this._scoreId = _scoreId;
	}
	public void set_score(Long _score) {
		this._score = _score;
	}
	public void set_username(String _username) {
		this._username = _username;
	}
	public void set_userId(Long _userId) {
		this._userId = _userId;
	}
	public void set_beatmapId(Long _beatmapId) {
		this._beatmapId = _beatmapId;
	}
	public void set_count300(int _count300) {
		this._count300 = _count300;
	}
	public void set_count100(int _count100) {
		this._count100 = _count100;
	}
	public void set_count50(int _count50) {
		this._count50 = _count50;
	}
	public void set_countMiss(int _countMiss) {
		this._countMiss = _countMiss;
	}
	public void set_maxCombo(int _maxCombo) {
		this._maxCombo = _maxCombo;
	}
	public void set_countKatu(int _countKatu) {
		this._countKatu = _countKatu;
	}
	public void set_countGeki(int _countGeki) {
		this._countGeki = _countGeki;
	}
	public void set_perfect(boolean _perfect) {
		this._perfect = _perfect;
	}
	public void set_enabledMods(List<ModsEnum> _enabledMods) {
		this._enabledMods = _enabledMods;
	}
	public void set_date(Date _date) {
		this._date = _date;
	}
	public void set_rank(String _rank) {
		this._rank = _rank;
	}
	public void set_pp(Double _pp) {
		this._pp = _pp;
	}
	public void set_replayAvailable(boolean _replayAvailable) {
		this._replayAvailable = _replayAvailable;
	}
	public void set_user(User _user) {
		this._user = _user;
	}
	public void set_beatmap(Beatmap _beatmap) {
		this._beatmap = _beatmap;
	}
	
	/**
	 *  [FR] Ajouter une condition sur le replayAvailable pour ne pas faire de replay s'il n'existe pas (Appel BestPerf et RecentlyPlayed)
	 * @param json
	 * @throws BadJSONDateFormatException
	 */
	public Score(JSONObject json) throws BadJSONDateFormatException {
		this._scoreId = json.get(ScoreEnum.SCORE_ID.getName()) != JSONObject.NULL ? json.getLong(ScoreEnum.SCORE_ID.getName()) : null;
		this._score = json.get(ScoreEnum.SCORE.getName()) != JSONObject.NULL ? json.getLong(ScoreEnum.SCORE.getName()) : null;
		this._username = json.get(ScoreEnum.USERNAME.getName()) != JSONObject.NULL ? json.getString(ScoreEnum.USERNAME.getName()) : null;
		this._count300 = json.get(ScoreEnum.COUNT_300.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_300.getName()) : null;
		this._count100 = json.get(ScoreEnum.COUNT_100.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_100.getName()) : null;
		this._count50 = json.get(ScoreEnum.COUNT_50.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_50.getName()) : null;
		this._countMiss = json.get(ScoreEnum.COUNT_MISS.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_MISS.getName()) : null;
		this._maxCombo = json.get(ScoreEnum.MAX_COMBO.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.MAX_COMBO.getName()) : null;
		this._countKatu = json.get(ScoreEnum.COUNT_KATU.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_KATU.getName()) : null;
		this._countGeki = json.get(ScoreEnum.COUNT_GEKI.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_GEKI.getName()) : null;
		this._perfect = json.get(ScoreEnum.PERFECT.getName()) != JSONObject.NULL ? (json.getInt(ScoreEnum.PERFECT.getName()) == 1 ? true : false) : null;
		this._enabledMods = json.get(ScoreEnum.ENABLED_MODS.getName()) != JSONObject.NULL ? ModsUtil.parseMods(json.getLong(ScoreEnum.ENABLED_MODS.getName())) : null;
		this._userId = json.get(ScoreEnum.USER_ID.getName()) != JSONObject.NULL ? json.getLong(ScoreEnum.USER_ID.getName()) : null;
		this._date = json.get(ScoreEnum.DATE.getName()) != JSONObject.NULL ? DateUtil.parseDate(json.getString(ScoreEnum.DATE.getName())) : null;
		this._rank = json.get(ScoreEnum.RANK.getName()) != JSONObject.NULL ? json.getString(ScoreEnum.RANK.getName()) : null;
		this._pp = json.get(ScoreEnum.PP.getName()) != JSONObject.NULL ? json.getDouble(ScoreEnum.PP.getName()) : null;
		this._replayAvailable = json.get(ScoreEnum.REPLAY_AVAILABLE.getName()) != JSONObject.NULL ? (json.getInt(ScoreEnum.REPLAY_AVAILABLE.getName()) == 1 ? true : false)  : null;
	}
	
	public Score() {
		
	}
	

}

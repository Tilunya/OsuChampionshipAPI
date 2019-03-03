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
	
	/**
	 *  [FR] Ajouter une condition sur le replayAvailable pour ne pas faire de replay s'il n'existe pas (Appel BestPerf et RecentlyPlayed)
	 * @param json
	 * @throws BadJSONDateFormatException
	 */
	public Score(JSONObject json) throws BadJSONDateFormatException {
		this._scoreId = json.getLong(ScoreEnum.SCORE_ID.getName());
		this._score = json.getLong(ScoreEnum.SCORE.getName());
		this._username = json.getString(ScoreEnum.USERNAME.getName());
		this._count300 = json.getInt(ScoreEnum.COUNT_300.getName());
		this._count100 = json.getInt(ScoreEnum.COUNT_100.getName());
		this._count50 = json.getInt(ScoreEnum.COUNT_50.getName());
		this._countMiss = json.getInt(ScoreEnum.COUNT_MISS.getName());
		this._maxCombo = json.getInt(ScoreEnum.MAX_COMBO.getName());
		this._countKatu = json.getInt(ScoreEnum.COUNT_KATU.getName());
		this._countGeki = json.getInt(ScoreEnum.COUNT_GEKI.getName());
		this._perfect = json.getInt(ScoreEnum.PERFECT.getName()) == 1 ? true : false;
		this._enabledMods = ModsUtil.parseMods(json.getLong(ScoreEnum.ENABLED_MODS.getName()));
		this._userId = json.getLong(ScoreEnum.USER_ID.getName());
		this._date = DateUtil.parseDate(ScoreEnum.DATE.getName());
		this._rank = json.getString(ScoreEnum.RANK.getName());
		this._pp = json.getDouble(ScoreEnum.PP.getName());
		this._replayAvailable = json.getInt(ScoreEnum.REPLAY_AVAILABLE.getName()) == 1 ? true : false;
	}
	

}

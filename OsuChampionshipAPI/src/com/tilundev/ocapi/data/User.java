package com.tilundev.ocapi.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.neovisionaries.i18n.CountryCode;
import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;

public class User {
	
	private Long _userId;
	private String _username;
	private Date _joinDate;
	private Long _count300;
	private Long _count100;
	private Long _count50;
	private Long _playCount;
	private Long _rankedScore;
	private Long _totalScore;
	private Long _ppRank;
	private Double _level;
	private Double _ppRaw;
	private Double _accuracy;
	private Long _countRankSS;
	private Long _countRankSSH;
	private Long _countRankS;
	private Long _countRankSH;
	private Long _countRankA;
	private CountryCode _country;
	private Long _totalSecondPlayed;
	private Long _ppCountryRank;
	private List<Event> _eventsList;
	
	
	
	

	/*            GETTERS            */
	
	
	public Long get_userId() {
		return _userId;
	}
	public String get_username() {
		return _username;
	}
	public Date get_joinDate() {
		return _joinDate;
	}
	public Long get_count300() {
		return _count300;
	}
	public Long get_count100() {
		return _count100;
	}
	public Long get_count50() {
		return _count50;
	}
	public Long get_playCount() {
		return _playCount;
	}
	public Long get_rankedScore() {
		return _rankedScore;
	}
	public Long get_totalScore() {
		return _totalScore;
	}
	public Long get_ppRank() {
		return _ppRank;
	}
	public Double get_level() {
		return _level;
	}
	public Double get_ppRaw() {
		return _ppRaw;
	}
	public Double get_accuracy() {
		return _accuracy;
	}
	public Long get_countRankSS() {
		return _countRankSS;
	}
	public Long get_countRankSSH() {
		return _countRankSSH;
	}
	public Long get_countRankS() {
		return _countRankS;
	}
	public Long get_countRankSH() {
		return _countRankSH;
	}
	public Long get_countRankA() {
		return _countRankA;
	}
	public CountryCode get_country() {
		return _country;
	}
	public Long get_totalSecondPlayed() {
		return _totalSecondPlayed;
	}
	public Long get_ppCountryRank() {
		return _ppCountryRank;
	}
	public List<Event> get_eventsList() {
		return _eventsList;
	}
	
	
	/*            SETTERS            */
	
	public void set_userId(Long _userId) {
		this._userId = _userId;
	}
	public void set_username(String _username) {
		this._username = _username;
	}
	public void set_joinDate(Date _joinDate) {
		this._joinDate = _joinDate;
	}
	public void set_count300(Long _count300) {
		this._count300 = _count300;
	}
	public void set_count100(Long _count100) {
		this._count100 = _count100;
	}
	public void set_count50(Long _count50) {
		this._count50 = _count50;
	}
	public void set_playCount(Long _playCount) {
		this._playCount = _playCount;
	}
	public void set_rankedScore(Long _rankedScore) {
		this._rankedScore = _rankedScore;
	}
	public void set_totalScore(Long _totalScore) {
		this._totalScore = _totalScore;
	}
	public void set_ppRank(Long _ppRank) {
		this._ppRank = _ppRank;
	}
	public void set_level(Double _level) {
		this._level = _level;
	}
	public void set_ppRaw(Double _ppRaw) {
		this._ppRaw = _ppRaw;
	}
	public void set_accuracy(Double _accuracy) {
		this._accuracy = _accuracy;
	}
	public void set_countRankSS(Long _countRankSS) {
		this._countRankSS = _countRankSS;
	}
	public void set_countRankSSH(Long _countRankSSH) {
		this._countRankSSH = _countRankSSH;
	}
	public void set_countRankS(Long _countRankS) {
		this._countRankS = _countRankS;
	}
	public void set_countRankSH(Long _countRankSH) {
		this._countRankSH = _countRankSH;
	}
	public void set_countRankA(Long _countRankA) {
		this._countRankA = _countRankA;
	}
	public void set_country(CountryCode _country) {
		this._country = _country;
	}
	public void set_totalSecondPlayed(Long _totalSecondPlayed) {
		this._totalSecondPlayed = _totalSecondPlayed;
	}
	public void set_ppCountryRank(Long _ppCountryRank) {
		this._ppCountryRank = _ppCountryRank;
	}
	public void set_eventsList(List<Event> _eventsList) {
		this._eventsList = _eventsList;
	}
	
	
	public User(JSONObject json) throws JSONException, BadJSONDateFormatException {
		this._userId = json.getLong(UserEnum.USER_ID.getName());
		this._username = json.getString(UserEnum.USERNAME.getName());
		this._joinDate = DateUtil.parseDate(json.getString(UserEnum.JOIN_DATE.getName()));
		this._count300 = json.getLong(UserEnum.COUNT300.getName());
		this._count100 = json.getLong(UserEnum.COUNT100.getName());
		this._count50 = json.getLong(UserEnum.COUNT50.getName());
		this._playCount = json.getLong(UserEnum.PLAY_COUNT.getName());
		this._rankedScore = json.getLong(UserEnum.RANKED_SCORE.getName());
		this._totalScore = json.getLong(UserEnum.TOTAL_SCORE.getName());
		this._ppRank = json.getLong(UserEnum.PP_RANK.getName());
		this._level = json.getDouble(UserEnum.LEVEL.getName());
		this._ppRaw = json.getDouble(UserEnum.PP_RAW.getName());
		this._accuracy = json.getDouble(UserEnum.ACCURACY.getName());
		this._countRankSS = json.getLong(UserEnum.COUNT_RANK_SS.getName());
		this._countRankSSH = json.getLong(UserEnum.COUNT_RANK_SSH.getName());
		this._countRankS = json.getLong(UserEnum.COUNT_RANK_S.getName());
		this._countRankSH = json.getLong(UserEnum.COUNT_RANK_SH.getName());
		this._countRankA = json.getLong(UserEnum.COUNT_RANK_A.getName());
		this._country = CountryCode.getByCode(UserEnum.COUNTRY.getName());
		this._totalSecondPlayed = json.getLong(UserEnum.TOTAL_SECONDS_PLAYED.getName());
		this._ppCountryRank = json.getLong(UserEnum.PP_COUNTRY_RANK.getName());
		this._eventsList = new ArrayList<Event>();
		JSONArray eventArray = json.getJSONArray(UserEnum.EVENTS.getName());
		for (int i = 0; i < eventArray.length(); i++) {
			this._eventsList.add(new Event(eventArray.getJSONObject(i)));
		}
	}

}

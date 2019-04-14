package com.tilundev.ocapi.data;

import java.util.ArrayList;
import java.util.List;

public class ResultRequestData {
	private List<Beatmap> _beatmapsList = new ArrayList<Beatmap>();
	private List<User> _usersList = new ArrayList<User>();
	private List<Score> _scoresList = new ArrayList<Score>();
	private List<BestScore> _bestScoresList = new ArrayList<BestScore>();
	private List<RecentScore> _recentScoresList = new ArrayList<RecentScore>();
	private List<MultiplayerGame> _multiplayerGamesList = new ArrayList<MultiplayerGame>();
	
	public List<Beatmap> get_beatmapsList() {
		return _beatmapsList;
	}
	public List<User> get_usersList() {
		return _usersList;
	}
	public List<Score> get_scoresList() {
		return _scoresList;
	}
	public List<BestScore> get_bestScoresList() {
		return _bestScoresList;
	}
	public List<RecentScore> get_recentScoresList() {
		return _recentScoresList;
	}
	public List<MultiplayerGame> get_multiplayerGamesList() {
		return _multiplayerGamesList;
	}
	
	public void set_beatmapsList(List<Beatmap> _beatmapsList) {
		this._beatmapsList = _beatmapsList;
	}
	public void set_usersList(List<User> _usersList) {
		this._usersList = _usersList;
	}
	public void set_scoresList(List<Score> _scoresList) {
		this._scoresList = _scoresList;
	}
	public void set_bestScoresList(List<BestScore> _bestScoresList) {
		this._bestScoresList = _bestScoresList;
	}
	public void set_recentScoresList(List<RecentScore> _recentScoresList) {
		this._recentScoresList = _recentScoresList;
	}
	public void set_multiplayerGamesList(List<MultiplayerGame> _multiplayerGamesList) {
		this._multiplayerGamesList = _multiplayerGamesList;
	}
	
	public ResultRequestData() {
		
	}
	
}

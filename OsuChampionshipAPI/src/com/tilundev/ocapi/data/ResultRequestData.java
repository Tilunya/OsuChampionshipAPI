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
	
	public Beatmap getBeatmapInBeatmapListByID(Long beatmapID) {
		return this._beatmapsList.stream().filter(beatmap -> beatmap.get_beatmapId() == beatmapID).findFirst().get();
	}
	
	public User getUserInUserListByID(Long userID) {
		return this._usersList.stream().filter(user -> user.get_userId() == userID).findFirst().get();
	}
	
	public Score getScoreInScoreListByID(Long userID, Long beatmapID) {
		return this._scoresList.stream().filter(score -> score.get_userId() == userID && score.get_beatmapId() == beatmapID).findFirst().get();
	}
	
	public BestScore getBestScoreInBestScoreListByDoubleID(Long userID, Long beatmapID) {
		return this._bestScoresList.stream().filter(bestScore -> bestScore.get_userId() == userID && bestScore.get_beatmapId() == beatmapID).findFirst().get();
	}
	
	public RecentScore getRecentScoreInRecentScoreListByDoubleID(Long userID, Long beatmapID) {
		return this._recentScoresList.stream().filter(recentScore -> recentScore.get_userId() == userID && recentScore.get_beatmapId() == beatmapID).findFirst().get();
	}
	
	public Game getGameInMultiplayerGamesListByBeatmapID(Long beatmapID) {
		for (int i = 0; i < this._multiplayerGamesList.size(); i++) {
			MultiplayerGame m = this._multiplayerGamesList.get(i);
			for (int j = 0; j < m.get_gameList().size(); j++) {
				Game g = m.get_gameList().get(j);
				if(g.get_beatmapId() == beatmapID) {
					return g;
				}
			}
		}
		return null;
	}
	
	public ScoreMultiplayer getScoreMultiplayerInMultiplayerGamesListByDoubleID(Long beatmapID, Long userID) {
		for (int i = 0; i < this._multiplayerGamesList.size(); i++) {
			MultiplayerGame m = this._multiplayerGamesList.get(i);
			for (int j = 0; j < m.get_gameList().size(); j++) {
				Game g = m.get_gameList().get(j);
				for (int k = 0; k < g.get_scoreList().size(); k++) {
					ScoreMultiplayer sm = g.get_scoreList().get(k);
					if(sm.get_beatmapId() == beatmapID && sm.get_userId() == userID) {
						return sm;
					}
				}
			}
		}
		return null;
	}
	
}

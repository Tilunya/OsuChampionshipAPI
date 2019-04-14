package com.tilundev.ocapi.data;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;
import com.tilundev.ocapi.utilexcept.NoModFoundException;
import com.tilundev.ocapi.utilexcept.NoScoringTypeFoundException;
import com.tilundev.ocapi.utilexcept.NoTeamTypeFoundException;

public class MultiplayerGame {
	private Match _match;
	private List<Game> _gameList = new ArrayList<Game>();
	
	private final static String MATCH = "match";
	private final static String GAMES = "games";
	
	public MultiplayerGame() {
	}
	
	public MultiplayerGame(JSONObject json) throws JSONException, BadJSONDateFormatException, NoModFoundException, NoScoringTypeFoundException, NoTeamTypeFoundException {
		this._match = json.get(MATCH) != JSONObject.NULL ? new Match(json.getJSONObject(MATCH)) : null;
		if(json.get(GAMES) != JSONObject.NULL) {
			JSONArray jsonArr = json.getJSONArray(GAMES);
			for (int i = 0; i < jsonArr.length(); i++) {
				this._gameList.add(new Game(jsonArr.getJSONObject(i)));
			}
		}
	}

	public Match get_match() {
		return _match;
	}

	public List<Game> get_gameList() {
		return _gameList;
	}

	
	
	public void set_match(Match _match) {
		this._match = _match;
	}

	public void set_gameList(List<Game> _gameList) {
		this._gameList = _gameList;
	}
	
	
}

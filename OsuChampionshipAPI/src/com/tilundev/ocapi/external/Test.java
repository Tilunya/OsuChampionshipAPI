package com.tilundev.ocapi.external;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;
import com.tilundev.ocapi.data.BestScore;
import com.tilundev.ocapi.data.Game;
import com.tilundev.ocapi.data.Match;
import com.tilundev.ocapi.data.MultiplayerGame;
import com.tilundev.ocapi.data.RecentScore;
import com.tilundev.ocapi.data.ResultRequestData;
import com.tilundev.ocapi.external.parameters.RequestParametersEnum;
import com.tilundev.ocapi.internal.Config;
import com.tilundev.ocapi.internal.request.RequestEnum;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;
import com.tilundev.ocapi.utilexcept.BadRequestException;
import com.tilundev.ocapi.utilexcept.NoApprouvedFoundException;
import com.tilundev.ocapi.utilexcept.NoGenreFoundException;
import com.tilundev.ocapi.utilexcept.NoLanguageFoundException;
import com.tilundev.ocapi.utilexcept.NoModFoundException;

public class Test {

	public static void main(String[] args) throws JSONException, BadJSONDateFormatException, NoApprouvedFoundException, NoGenreFoundException, NoLanguageFoundException, NoModFoundException, BadRequestException {
		
		boolean isConfig = false;
		if(isConfig) {
			Config.saveConfig();
		} else {
			Config.initConfig();
			Request br = new Request();
			br.setRequest(RequestEnum.GET_MATCH)
				.setParameter(RequestParametersEnum.MATCH_ID, "51092401")
				.deepRequestActive(); // Room Multi
			try {
				br.start();
				ResultRequestData rrd = br.getConstructData();
				MultiplayerGame mpg = rrd.get_multiplayerGamesList().get(0);
				Match m = mpg.get_match();
				List<Game> li = mpg.get_gameList();
				System.out.println("Room " + m.get_name() + " For " + li.size() + " Games");
				for (int j = 0; j < li.size(); j++) {
					Game g = li.get(j);
					System.out.println("Beatmap Id :" + g.get_beatmapId() + "("+ (g.get_beatmap()!=null ? g.get_beatmap().get_title() : "null") +") Start at : " + g.get_startTime().toString());
					if(g.get_scoreList() != null) {
						for (int i = 0; i < g.get_scoreList().size(); i++) {
							System.out.println( (i+1) +" : " + g.get_scoreList().get(i).get_userId() +" (" + (g.get_scoreList().get(i).get_user() != null ? g.get_scoreList().get(i).get_user().get_username() : "null") +")");
						}
					}
				}
			}
			catch (Exception e) {
				System.out.println("OSKUR JE SUIS CASSE");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}

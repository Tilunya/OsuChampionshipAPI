package com.tilundev.ocapi.external;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.mashape.unirest.http.JsonNode;
import com.tilundev.ocapi.data.Score;
import com.tilundev.ocapi.data.User;
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
		// TODO Auto-generated method stub
		Config.initConfig();
		Request br = new Request();
		br.setRequest(RequestEnum.GET_SCORE)
			.setParameter(RequestParametersEnum.BEATMAP_ID, "1839761");
		try {
			br.start();
			JsonNode node = br.getBody();
			JSONArray arr = node.getArray();
			List<Score> li = new ArrayList<Score>();
			System.out.println("Bonjour");
			for (int i = 0; i < arr.length(); i++) {
				li.add(new Score(arr.getJSONObject(i)));
			}
			for (int j = 0; j < li.size(); j++) {
				Score s = li.get(j);
				System.out.println(j+" : " + s.get_username() + " - " + s.get_score() +" - " + s.get_rank());
			}
		}
		catch (Exception e) {
			System.out.println("OSKUR JE SUIS CASSE");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}

package com.tilundev.ocapi.external;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.tilundev.ocapi.data.Beatmap;
import com.tilundev.ocapi.external.parameters.RequestParametersEnum;
import com.tilundev.ocapi.internal.Config;
import com.tilundev.ocapi.internal.request.RequestEnum;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;
import com.tilundev.ocapi.utilexcept.NoApprouvedFoundException;
import com.tilundev.ocapi.utilexcept.NoGenreFoundException;
import com.tilundev.ocapi.utilexcept.NoLanguageFoundException;
import com.tilundev.ocapi.utilexcept.NoModFoundException;

public class Test {

	public static void main(String[] args) throws JSONException, BadJSONDateFormatException, NoApprouvedFoundException, NoGenreFoundException, NoLanguageFoundException, NoModFoundException {
		// TODO Auto-generated method stub
		Config.initConfig();
		Request br = new Request();
		br.setParameter(RequestParametersEnum.USER_TYPE_DATA, "id")
			.setParameter(RequestParametersEnum.USER_ID, "4452992");
		try {
			br.setRequest(RequestEnum.GET_BEATMAP_REQUEST).start();
			JSONArray arr = br.getBody();
			List<Beatmap> li = new ArrayList<Beatmap>();
			for (int i = 0; i < arr.length(); i++) {
				li.add(new Beatmap(arr.getJSONObject(i)));
			}
			li.forEach(bm -> {
				System.out.println("Map : " + bm.get_title() + " bpm : " + bm.get_bpm());
			});
		}
		catch (Exception e) {
			System.out.println("OSKUR JE SUIS CASSE");
		}
	}

}

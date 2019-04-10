package com.tilundev.ocapi.external;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.tilundev.ocapi.data.Beatmap;
import com.tilundev.ocapi.external.parameters.BeatmapParametersEnum;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;
import com.tilundev.ocapi.utilexcept.NoApprouvedFoundException;
import com.tilundev.ocapi.utilexcept.NoGenreFoundException;
import com.tilundev.ocapi.utilexcept.NoLanguageFoundException;
import com.tilundev.ocapi.utilexcept.NoModFoundException;

public class Test {

	public static void main(String[] args) throws JSONException, BadJSONDateFormatException, NoApprouvedFoundException, NoGenreFoundException, NoLanguageFoundException, NoModFoundException {
		// TODO Auto-generated method stub
		BeatmapRequest br = new BeatmapRequest();
		br.setParameter(BeatmapParametersEnum.USER_TYPE_DATA, "id");
		br.setParameter(BeatmapParametersEnum.USER_ID, "4452992");
		//br.setParameter(BeatmapParametersEnum.BEATMAP_ID, "1950484");
		br.start();
		JSONArray arr = br.getBody();
		List<Beatmap> li = new ArrayList<Beatmap>();
		for (int i = 0; i < arr.length(); i++) {
			li.add(new Beatmap(arr.getJSONObject(i)));
		}
		li.forEach(bm -> {
			System.out.println("Map : " + bm.get_title() + " bpm : " + bm.get_bpm());
		});
		System.out.println("Yes");
	}

}

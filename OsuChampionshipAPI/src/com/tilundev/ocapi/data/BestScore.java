package com.tilundev.ocapi.data;

import org.json.JSONObject;

import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.util.ModsUtil;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;

public class BestScore extends Score {
	
	private Long _beatmap_id;
	
	

	public Long get_beatmap_id() {
		return _beatmap_id;
	}



	public void set_beatmap_id(Long _beatmap_id) {
		this._beatmap_id = _beatmap_id;
	}



	public BestScore(JSONObject json) throws BadJSONDateFormatException {
		super();
		this._beatmap_id = json.getLong(ScoreEnum.BEATMAP_ID.getName());
		this.set_score(json.getLong(ScoreEnum.SCORE.getName()));
		this.set_count300(json.getInt(ScoreEnum.COUNT_300.getName()));
		this.set_count100(json.getInt(ScoreEnum.COUNT_100.getName()));
		this.set_count50(json.getInt(ScoreEnum.COUNT_50.getName()));
		this.set_countMiss(json.getInt(ScoreEnum.COUNT_MISS.getName()));
		this.set_maxCombo(json.getInt(ScoreEnum.MAX_COMBO.getName()));
		this.set_countKatu(json.getInt(ScoreEnum.COUNT_KATU.getName()));
		this.set_countGeki(json.getInt(ScoreEnum.COUNT_GEKI.getName()));
		this.set_perfect(json.getInt(ScoreEnum.PERFECT.getName()) == 1 ? true : false);
		this.set_enabledMods(ModsUtil.parseMods(json.getLong(ScoreEnum.ENABLED_MODS.getName())));
		this.set_userId(json.getLong(ScoreEnum.USER_ID.getName()));
		this.set_date(DateUtil.parseDate(ScoreEnum.DATE.getName()));
		this.set_rank(json.getString(ScoreEnum.RANK.getName()));
		this.set_pp(json.getDouble(ScoreEnum.PP.getName()));
	}
	
	public BestScore() {
		
	}

}

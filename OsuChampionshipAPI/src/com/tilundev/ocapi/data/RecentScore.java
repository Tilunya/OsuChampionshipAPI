package com.tilundev.ocapi.data;

import org.json.JSONObject;

import com.tilundev.ocapi.util.DateUtil;
import com.tilundev.ocapi.util.ModsUtil;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;

public class RecentScore extends Score {

	public RecentScore(JSONObject json) throws BadJSONDateFormatException {
		super();
		this.set_beatmapId(json.get(ScoreEnum.BEATMAP_ID.getName()) != JSONObject.NULL ? json.getLong(ScoreEnum.BEATMAP_ID.getName()) : null);
		this.set_score(json.get(ScoreEnum.SCORE.getName()) != JSONObject.NULL ? json.getLong(ScoreEnum.SCORE.getName()) : null);
		this.set_count300(json.get(ScoreEnum.COUNT_300.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_300.getName()) : null);
		this.set_count100(json.get(ScoreEnum.COUNT_100.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_100.getName()) : null);
		this.set_count50(json.get(ScoreEnum.COUNT_50.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_50.getName()) : null);
		this.set_countMiss(json.get(ScoreEnum.COUNT_MISS.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_MISS.getName()) : null);
		this.set_maxCombo(json.get(ScoreEnum.MAX_COMBO.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.MAX_COMBO.getName()) : null);
		this.set_countKatu(json.get(ScoreEnum.COUNT_KATU.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_KATU.getName()) : null);
		this.set_countGeki(json.get(ScoreEnum.COUNT_GEKI.getName()) != JSONObject.NULL ? json.getInt(ScoreEnum.COUNT_GEKI.getName()) : null);
		this.set_perfect(json.get(ScoreEnum.PERFECT.getName()) != JSONObject.NULL ? (json.getInt(ScoreEnum.PERFECT.getName()) == 1 ? true : false) : null);
		this.set_enabledMods(json.get(ScoreEnum.ENABLED_MODS.getName()) != JSONObject.NULL ? ModsUtil.parseMods(json.getLong(ScoreEnum.ENABLED_MODS.getName())) : null);
		this.set_userId(json.get(ScoreEnum.USER_ID.getName()) != JSONObject.NULL ? json.getLong(ScoreEnum.USER_ID.getName()) : null);
		this.set_date(json.get(ScoreEnum.DATE.getName()) != JSONObject.NULL ? DateUtil.parseDate(json.getString(ScoreEnum.DATE.getName())) : null);
		this.set_rank(json.get(ScoreEnum.RANK.getName()) != JSONObject.NULL ? json.getString(ScoreEnum.RANK.getName()) : null);
	}
}

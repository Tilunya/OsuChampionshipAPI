package com.tilundev.ocapi.data;

public enum GetBeatmapEnum {
	APPROVED("approved"),
	APPROVED_DATE("approved_date"),
	LAST_UPDATE("last_update"),
	ARTIST("artist"),
	BEATMAP_ID("beatmap_id"),
	BEATMAPSET_ID("beatmapset_id"),
	BPM("bpm"),
	CREATOR("creator"),
	CREATOR_ID("creator_id"),
	DIFFICULTY_RATING("difficultyrating"),
	DIFF_SIZE("diff_size"),
	DIFF_OVERALL("diff_overall"),
	DIFF_APPROACH("diff_approach"),
	DIFF_DRAIN("diff_drain"),
	HIT_LENGTH("hit_length"),
	SOURCE("source"),
	GENRE_ID("genre_id"),
	LANGUAGE_ID("language_id"),
	TITLE("title"),
	TOTAL_LENGTH("total_length"),
	VERSION("version"),
	FILE_MD5("file_md5"),
	MODE("mode"),
	TAGS("tags"),
	FAVOURITE_COUNTS("favourite_count"),
	PLAYCOUNT("playcount"),
	PASSCOUNT("passcount"),
	MAX_COMBO("max_combo");
	
	private String name;
	
	GetBeatmapEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	

}

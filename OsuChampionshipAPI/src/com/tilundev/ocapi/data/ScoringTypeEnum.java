package com.tilundev.ocapi.data;

import com.tilundev.ocapi.utilexcept.NoScoringTypeFoundException;

public enum ScoringTypeEnum {
	
	SCORE("score",0),
	ACCURACY("accuracy",1),
	COMBO("combo",2),
	SCORE_V2("scoreV2",3);
	
	private String name;
	private int id;
	
	private ScoringTypeEnum(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public static ScoringTypeEnum getEnum(int key) throws NoScoringTypeFoundException {
		switch (key) {
		case 0:
			return ScoringTypeEnum.SCORE;
		case 1:
			return ScoringTypeEnum.ACCURACY;
		case 2:
			return ScoringTypeEnum.COMBO;
		case 3:
			return ScoringTypeEnum.SCORE_V2;
		default:
			String message = "No Scoring Type found for this key (" + key +").";
			throw new NoScoringTypeFoundException(message);
		}
	}

}

package com.tilundev.ocapi.data;

import com.tilundev.ocapi.utilexcept.NoLanguageFoundException;

public enum LanguageEnum {
	ANY("Any",0),
	OTHER("Other",1),
	ENGLISH("English",2),
	JAPANESE("Japanese",3),
	CHINESE("Chinese",4),
	INSTRUMENTAL("Instrumental",5),
	KOREAN("Korean",6),
	FRENCH("French",7),
	GERMAN("German",8),
	SWEDISH("Swedish",9),
	SPANISH("Spanish",10),
	ITALIAN("Italian",11);

	
	private String name;
	private int qualifier;
	
	LanguageEnum(String name, int qualifier){
		this.name = name;
		this.qualifier = qualifier;
	}

	public String getName() {
		return this.name;
	}

	public int getQualifier() {
		return this.qualifier;
	}
	
	public static LanguageEnum getEnum(int key) throws NoLanguageFoundException {
		switch (key) {
		case 0:
			return LanguageEnum.ANY;
		case 1:
			return LanguageEnum.OTHER;
		case 2:
			return LanguageEnum.ENGLISH;
		case 3:
			return LanguageEnum.JAPANESE;
		case 4:
			return LanguageEnum.CHINESE;
		case 5:
			return LanguageEnum.INSTRUMENTAL;
		case 6:
			return LanguageEnum.KOREAN;
		case 7:
			return LanguageEnum.FRENCH;
		case 8:
			return LanguageEnum.GERMAN;
		case 9:
			return LanguageEnum.SWEDISH;
		case 10:
			return LanguageEnum.SPANISH;
		case 11:
			return LanguageEnum.ITALIAN;
		default:
			String message = "No language found for this key (" + key +").";
			throw new NoLanguageFoundException(message);
		}
	}

}

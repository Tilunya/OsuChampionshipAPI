package com.tilundev.ocapi.data;

import com.tilundev.ocapi.utilexcept.NoModFoundException;

public enum ModEnum {
	OSU("Osu!",0),
	TAIKO("Osu!Taiko",1),
	CTB("Osu!Catch",2),
	OSU_MANIA("Osu!Mania",3);
	
	private String name;
	private int qualifier;
	
	ModEnum(String name, int qualifier) {
		this.name = name;
		this.qualifier = qualifier;
	}

	public String getName() {
		return name;
	}

	public int getQualifier() {
		return qualifier;
	}
	
	public static ModEnum getEnum(int key) throws NoModFoundException{
		switch (key) {
		case 0:
			return ModEnum.OSU;
		case 1:
			return ModEnum.TAIKO;
		case 2:
			return ModEnum.CTB;
		case 3:
			return ModEnum.OSU_MANIA;
		default:
			String message = "No mode found for this key (" + key +").";
			throw new NoModFoundException(message);
		}
		
	}
	

}

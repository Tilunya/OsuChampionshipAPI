package com.tilundev.ocapi.data;

import com.tilundev.ocapi.utilexcept.NoTeamTypeFoundException;

public enum TeamTypeEnum {
	HEAD_TO_HEAD("Head to Head",0),
	COOP("Coop",1),
	TEAM_VS("Team VS",2),
	TAG_TEAM_VS("Tag team VS",3);
	
	private String name;
	private int id;
	
	private TeamTypeEnum(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public static TeamTypeEnum getEnum(int key) throws NoTeamTypeFoundException {
		switch (key) {
		case 0:
			return TeamTypeEnum.HEAD_TO_HEAD;
		case 1:
			return TeamTypeEnum.COOP;
		case 2:
			return TeamTypeEnum.TEAM_VS;
		case 3:
			return TeamTypeEnum.TAG_TEAM_VS;
		default:
			String message = "No Team Type found for this key (" + key +").";
			throw new NoTeamTypeFoundException(message);
		}
	}
}

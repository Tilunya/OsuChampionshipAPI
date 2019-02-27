package com.tilundev.ocapi.data;

import com.tilundev.ocapi.utilexcept.NoApprouvedFoundException;

public enum ApprouvedEnum {
	GRAVEYARD("Graveyard",-2),
	WIP("Work in Progress",-1),
	PENDING("Pending", 0),
	RANKED("Ranked",1),
	APPROVED("Approved",2),
	QUALIFIED("Qualified",3),
	LOVED("Loved",4);
	
	
	private String name;
	private int quantifier;
	
	ApprouvedEnum(String name,int i){
		this.name = name;
		this.quantifier = i;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getQuantifier() {
		return this.quantifier;
	}
	
	public static ApprouvedEnum getEnum(int key) throws NoApprouvedFoundException {
		switch (key) {
		case -2:
			return ApprouvedEnum.GRAVEYARD;
		case -1:
			return ApprouvedEnum.WIP;
		case 0:
			return ApprouvedEnum.PENDING;
		case 1:
			return ApprouvedEnum.RANKED;
		case 2:
			return ApprouvedEnum.APPROVED;
		case 3:
			return ApprouvedEnum.QUALIFIED;
		case 4:
			return ApprouvedEnum.LOVED;
		default:
			String message = "No Approuved found for this key (" + key +").";
			throw new NoApprouvedFoundException(message);
		}
	}

}

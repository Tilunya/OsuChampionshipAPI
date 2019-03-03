package com.tilundev.ocapi.util;

import java.util.ArrayList;
import java.util.List;

import com.tilundev.ocapi.data.ModsEnum;

public class ModsUtil {
	
	public static List<ModsEnum> parseMods(long num){
		List<ModsEnum> modList = new ArrayList<ModsEnum>();
		while(num > 0) {
			ModsEnum mod = getMaxContain(num);
			modList.add(mod);
			num = num - mod.getId();
		}
		if(modList.isEmpty()) {
			modList.add(ModsEnum.NONE);
		}
		return modList;
	}
	
	public static ModsEnum getMaxContain(long num) {
		ModsEnum[] meList = ModsEnum.values();
		ModsEnum max = ModsEnum.NONE;
		for (int i = 0; i < meList.length; i++) {
			if(meList[i].getId() <= num) {
				if(max.getId() < meList[i].getId()) {
					max = meList[i];
				}
			}
		}
		return max;
	}
}

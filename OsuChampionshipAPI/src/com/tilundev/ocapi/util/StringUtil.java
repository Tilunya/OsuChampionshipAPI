package com.tilundev.ocapi.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	public static List<String> split(String text, String regexp){
		String[] buff = text.split(regexp);
		List<String> l = new ArrayList<String>();
		for (String string : buff) {
			l.add(string);
		}
		
		if(buff.length == 0) {
			l.add(text);
		}
		return l;
	}
}

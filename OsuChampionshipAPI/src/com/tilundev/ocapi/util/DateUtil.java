package com.tilundev.ocapi.util;

import java.util.Date;
import java.util.GregorianCalendar;

import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;

public class DateUtil {

	public static Date parseDate(String date) throws BadJSONDateFormatException {
		String[] dateSep1 = date.split(" ");
		GregorianCalendar cal = new GregorianCalendar();
		boolean dateSuccess = false;
		if(dateSep1.length == 2 ) {
			String[] datejma = dateSep1[0].split("-");
			String[] datehms = dateSep1[1].split(":");
			if(datejma.length == 3 && datehms.length == 3) {
				cal.set(Integer.parseInt(datejma[0]), Integer.parseInt(datejma[1]), Integer.parseInt(datejma[2]), Integer.parseInt(datehms[0]), Integer.parseInt(datehms[1]), Integer.parseInt(datehms[2]));
				dateSuccess = true;
			}
		}
		
		if(dateSuccess) {
			return cal.getTime();
		} else {
			throw new BadJSONDateFormatException("The date \"" + date +"\" is not well formed");
		}
	}

}

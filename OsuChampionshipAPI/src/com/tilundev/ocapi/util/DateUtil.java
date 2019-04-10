package com.tilundev.ocapi.util;

import java.util.Date;
import java.util.GregorianCalendar;

import org.json.JSONObject;

import com.google.gson.JsonNull;
import com.tilundev.ocapi.utilexcept.BadJSONDateFormatException;

public class DateUtil {

	public static Date parseDate(Object date) throws BadJSONDateFormatException {
		if(date == JSONObject.NULL) {
			return null;
		} 
		String dateStr = date.toString();
		String[] dateSep1 = dateStr.split(" ");
		GregorianCalendar cal = new GregorianCalendar();
		boolean dateSuccess = false;
		if(dateSep1.length == 2 ) {
			String[] datejma = dateSep1[0].split("-");
			String[] datehms = dateSep1[1].split(":");
			if(datejma.length == 3 && datehms.length == 3) {
				try {
				cal.set(Integer.parseInt(datejma[0]), Integer.parseInt(datejma[1]), Integer.parseInt(datejma[2]), Integer.parseInt(datehms[0]), Integer.parseInt(datehms[1]), Integer.parseInt(datehms[2]));
				dateSuccess = true;
				} catch (Exception e) {
					dateSuccess = false;
				}
			}
		}
		
		if(dateSuccess) {
			return cal.getTime();
		} else {
			throw new BadJSONDateFormatException("The date \"" + dateStr +"\" is not well formed");
		}
	}
	
	public static boolean isDateCorrect(String dates) throws BadJSONDateFormatException {
		String[] dateArray = dates.split("-");
		if(dateArray.length == 3) {
			try {
				int year = Integer.parseInt(dateArray[0]);
				int month = Integer.parseInt(dateArray[1]);
				int date = Integer.parseInt(dateArray[2]);
				if(month < 1 && month > 12 && date <1 && date > 31) {
					return true;
				}
			}catch (Exception e) {
				throw new BadJSONDateFormatException("The date \"" + dates +"\" is not well formed");
			}
		}
		return false;
	}

}

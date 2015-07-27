package com.almundo.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {

	public Utils() {
	}
	
	public String convertToSpecifDate(String date) {
		String [] dates;
		String departureDate;
		String returnDate;
		String reqDate;
		if (date.contains("-")) {
			dates = date.split("-");
			departureDate = getStringDate(dates [0].trim());
			returnDate = getStringDate(dates [1].trim());
			reqDate = departureDate + "," + returnDate;
		} else {
			reqDate = getStringDate(date);
			
		}
		return reqDate;
	}
	
	
	private String getStringDate(String days) {
		String sDays = days.substring(0,
				days.indexOf("d") - 1);
		int daysToLeave = Integer.parseInt(sDays);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, daysToLeave);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
	}

}

package com.alura.reservaciones.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MyDate {
	public static boolean validateDates(Date date, Date dateAfter) {

		return validateCheckInDate(date) && validateCheckOutDate(date, dateAfter);
	}

	private static boolean validateCheckInDate(Date checkIn) {
		boolean isNotNull = checkIn != null;
		boolean isValidCheckIn = calculateDaysBetween(new Date(), checkIn) >= 0;
		return isNotNull && isValidCheckIn;
	}

	private static boolean validateCheckOutDate(Date checkIn, Date checkOut) {
		boolean isNotNull = checkOut != null;
		boolean isValidCheckOut = calculateDaysBetween(checkIn, checkOut) > 0;
		return isNotNull && isValidCheckOut;
	}

	public static int calculateDaysBetween(Date date, Date dateAfter) {
		long checkInMs = date.getTime();
		long checkOutMs = dateAfter.getTime();

		long timeBetweenDatesInMs = checkOutMs - checkInMs;

		return Long.valueOf(TimeUnit.DAYS.convert(timeBetweenDatesInMs, TimeUnit.MILLISECONDS)).intValue();
	}

	public static int calculateYearsBetween(Date date, Date dateAfter) {
		Calendar calendarDate = Calendar.getInstance(Locale.US);
		calendarDate.setTime(date);

		Calendar calendarDateAfter = Calendar.getInstance(Locale.US);
		calendarDateAfter.setTime(dateAfter);

		int datesDiff = calendarDateAfter.get(Calendar.YEAR) - calendarDate.get(Calendar.YEAR);

		if (calendarDate.get(Calendar.MONTH) > calendarDateAfter.get(Calendar.MONTH)
				|| (calendarDate.get(Calendar.MONTH) == calendarDateAfter.get(Calendar.MONTH)
						&& calendarDate.get(Calendar.DATE) > calendarDateAfter.get(Calendar.DATE))) {
			datesDiff--;
		}
		return datesDiff;
	}

	public static Date getTomorrowDate(Date date) {
		if (date == null)
			date = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		date = c.getTime();

		return date;
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String dateToString(Date date) {
		String pattern = "yyyy/MM/dd";

		DateFormat df = new SimpleDateFormat(pattern);

		Date today = Calendar.getInstance().getTime();

		return df.format(today);
	}

	public static java.sql.Date javaDateToSQL(java.util.Date date) {

		java.sql.Date mySQLDate = new java.sql.Date(date.getTime());
		return mySQLDate;

	}

	public static java.util.Date SQLDateToJava(java.sql.Date date) {

		java.util.Date javaDate = new java.util.Date(date.getTime());
		return javaDate;

	}
}

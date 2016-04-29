package com.samples.java8.datetime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * Created by alakus on 4/27/2016.
 */
public class LocalDateTimes {
	public static void main(String[] args) {
		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

		DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek);      // WEDNESDAY

		Month month = sylvester.getMonth();
		System.out.println(month);          // DECEMBER

		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);    // 1439

		System.out.println(sylvester);

		Instant instant = sylvester
				.atZone(ZoneId.systemDefault())
				.toInstant();

		Date legacyDate = Date.from(instant);
		System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014
	}
}

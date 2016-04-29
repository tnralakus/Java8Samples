package com.samples.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Created by alakus on 4/27/2016.
 */
public class DateTimeFormatters {
	public static void main(String[] args) {
		DateTimeFormatter germanFormatter =
				DateTimeFormatter
						.ofLocalizedTime(FormatStyle.SHORT)
						.withLocale(Locale.GERMAN);

		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime);   // 13:37


		DateTimeFormatter germanDateFormatter =
				DateTimeFormatter
						.ofLocalizedDate(FormatStyle.MEDIUM)
						.withLocale(Locale.GERMAN);

		LocalDate xmas = LocalDate.parse("24.12.2014", germanDateFormatter);
		System.out.println(xmas);   // 2014-12-24

		DateTimeFormatter formatter =
				DateTimeFormatter
						.ofPattern("MMM dd, yyyy - HH:mm");

		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
		String string = formatter.format(parsed);
		System.out.println(string);     // Nov 03, 2014 - 07:13
	}
}

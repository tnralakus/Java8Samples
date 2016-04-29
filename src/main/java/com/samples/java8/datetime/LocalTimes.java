package com.samples.java8.datetime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * Created by alakus on 4/27/2016.
 */
public class LocalTimes {
	public static void main(String[] args) {
		LocalTime now1 = LocalTime.now(ZoneId.of("Europe/Berlin"));
		LocalTime now2 = LocalTime.now(ZoneId.of("Brazil/East"));

		System.out.println(now1.isBefore(now2));  // false

		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

		System.out.println(hoursBetween);       // -3
		System.out.println(minutesBetween);     // -239

		LocalTime late = LocalTime.of(23, 59, 59);
		System.out.println(late);       // 23:59:59
	}
}

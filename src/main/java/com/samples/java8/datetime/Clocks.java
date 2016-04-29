package com.samples.java8.datetime;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * Created by alakus on 4/27/2016.
 */
public class Clocks {
	public static void main(String[] args) {
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		System.out.println(millis);

		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);   // legacy java.util.Date
		System.out.println(legacyDate);
	}
}

package com.samples.java8.datetime;

import java.time.ZoneId;

/**
 * Created by alakus on 4/27/2016.
 */
public class Zones {
	public static void main(String[] args) {
		System.out.println(ZoneId.getAvailableZoneIds());
		// prints all available timezone ids

		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());

		// ZoneRules[currentStandardOffset=+01:00]
		// ZoneRules[currentStandardOffset=-03:00]
	}
}

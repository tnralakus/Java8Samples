package com.samples.java8.datetime;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Set;

/**
 * Created by Alakus on 12/1/2015.
 */
public class DateTimeExample {
    public static void main(String[] args) {
        // runLocalDateExample();

        // runLocalTimeExample();

        // runLocalDateTimeExample();

        // runZoneIdExample();
    }

    private static void runZoneIdExample() {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        zones.stream().sorted().forEach(System.out::println);

        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println(defaultZoneId);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Now : " + zonedDateTime);
        ZoneId istanbul = ZoneId.of("Europe/Istanbul");
        ZonedDateTime nowInIstanbul = ZonedDateTime.now(istanbul);
        System.out.println("Istanbul Time : " + nowInIstanbul);
        System.out.println(nowInIstanbul.get(ChronoField.HOUR_OF_DAY));

        LocalDateTime localDateTime = nowInIstanbul.toLocalDateTime();
        LocalDate localDate = nowInIstanbul.toLocalDate();
        LocalTime localTime = nowInIstanbul.toLocalTime();
    }

    private static void runLocalDateTimeExample() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime dateTime = LocalDateTime.of(2014, 12, 30, 12, 22, 32);
        System.out.println("Second : " + dateTime.getSecond() + " Minute : " + dateTime.getMinute() + " Hour : " + dateTime.getHour()
                + " Day : " + dateTime.getDayOfMonth() + " Month : " + dateTime.getMonth() + " Year : " + dateTime.getYear());

        LocalDate localDate = dateTime.toLocalDate();
        LocalTime localTime = dateTime.toLocalTime();
    }

    private static void runLocalTimeExample() {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime time = LocalTime.of(10, 20, 59);
        System.out.println(time);

        System.out.println("Hour : " + time.getHour() + " Minute : " + time.getMinute() + " Second : " + time.getSecond());

        time = time.plusSeconds(10).plus(2, ChronoUnit.MINUTES).minus(5, ChronoUnit.HOURS);
        System.out.println(time);

        System.out.println("Noon : " + LocalTime.NOON);
        System.out.println("Midnight : " + LocalTime.MIDNIGHT);

        LocalTime parsedTime = LocalTime.parse("10:40");
        System.out.println("Hour : " + parsedTime.get(ChronoField.HOUR_OF_DAY));
    }

    private static void runLocalDateExample() {
        LocalDate localDate = LocalDate.of(2015, 12, 1);
        LocalDate localDate2 = LocalDate.of(2015, Month.DECEMBER, 1);

        LocalDate now = LocalDate.now();
        now = now.withYear(2014);
        System.out.println(now);
        now = now.withDayOfMonth(2).withMonth(11);
        System.out.println(now);
        now = now.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println(now);

        now = now.plusWeeks(1);
        System.out.println(now);
        now = now.plus(2, ChronoUnit.DAYS);
        System.out.println(now);

        now = now.minus(10, ChronoUnit.DECADES);
        System.out.println(now);
    }
}

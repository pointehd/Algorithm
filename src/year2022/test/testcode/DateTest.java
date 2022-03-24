package year2022.test.testcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTest {

    public static void main(String[] args) {
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        ZoneId koreazone = ZoneId.of("Asia/Seoul");

        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime, newYorkOffset);
        System.out.println(offsetDateTime);
        Chronology japan = Chronology.ofLocale(Locale.JAPAN);
        ChronoLocalDate now = japan.dateNow();
        System.out.println(now);

//        TemporalAdjusters
    }
    public static class NextWorkingDay implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK)); // 요일가져오기
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            else if(dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    }
}

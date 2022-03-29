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
import java.util.TimeZone;

public class DateTest {

    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now(); // 2022-03-21
        LocalDate nextFriday = nowDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)); // 2022-03-25
//        LocalDate nextWorkDay = nextFriday.with(new NextWorkingDay()); // 2022-03-28
//        System.out.println(nextWorkDay);
        new NextWorkingDay();
    }
    public static class NextWorkingDay implements TemporalAdjuster {
        public void test() {
            System.out.println("testsetestsetse");
        }
        @Override
        public Temporal adjustInto(Temporal temporal) {
            System.out.println("test");
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK)); // 요일가져오기
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            else if(dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    }
}

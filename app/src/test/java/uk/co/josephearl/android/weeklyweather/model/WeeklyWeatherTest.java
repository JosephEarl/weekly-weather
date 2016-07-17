package uk.co.josephearl.android.weeklyweather.model;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeeklyWeatherTest {
  @Test
  public void dailyWeather_mapsThreeHourWeatherToCorrectDays() throws Exception {
    Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-07-17 15:00:00");
    WeeklyWeather weeklyWeather = createWeeklyWeather(startDate, 40);

    List<DailyWeather> dailyWeather = weeklyWeather.dailyWeather();

    assertThat(dailyWeather).hasSize(6);
    assertThat(dailyWeather.get(0).day).hasYear(2016);
    assertThat(dailyWeather.get(0).day).hasMonth(7);
    assertThat(dailyWeather.get(0).day).hasDayOfMonth(17);
    assertThat(dailyWeather.get(0).day).hasHourOfDay(15);
    assertThat(dailyWeather.get(0).day).hasMinute(0);
    assertThat(dailyWeather.get(0).threeHourWeather).hasSize(3);
    assertThat(dailyWeather.get(1).threeHourWeather).hasSize(8);
    assertThat(dailyWeather.get(1).day).hasYear(2016);
    assertThat(dailyWeather.get(1).day).hasMonth(7);
    assertThat(dailyWeather.get(1).day).hasDayOfMonth(18);
    assertThat(dailyWeather.get(1).day).hasHourOfDay(0);
    assertThat(dailyWeather.get(1).day).hasMinute(0);
    assertThat(dailyWeather.get(5).threeHourWeather).hasSize(5);
    assertThat(dailyWeather.get(5).day).hasYear(2016);
    assertThat(dailyWeather.get(5).day).hasMonth(7);
    assertThat(dailyWeather.get(5).day).hasDayOfMonth(22);
    assertThat(dailyWeather.get(5).day).hasHourOfDay(0);
    assertThat(dailyWeather.get(5).day).hasMinute(0);
  }

  @Test
  public void fiveDayWeather_returnsFirstFiveDays() throws Exception {
    Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-07-17 15:00:00");
    WeeklyWeather weeklyWeather = createWeeklyWeather(startDate, 40);

    List<DailyWeather> fiveDayWeather = weeklyWeather.fiveDayWeather();

    assertThat(fiveDayWeather).hasSize(5);
  }

  private static WeeklyWeather createWeeklyWeather(Date start, int count) {
    List<ThreeHourWeather> threeHourWeather = new ArrayList<>(count);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(start);
    for (int i = 0; i < count; i++) {
      threeHourWeather.add(createThreeHourWeather(calendar));
      calendar.add(Calendar.HOUR_OF_DAY, 3);
    }
    return new WeeklyWeather(null, null, null, null, threeHourWeather);
  }

  private static ThreeHourWeather createThreeHourWeather(Calendar calendar) {
    return new ThreeHourWeather(calendar.getTimeInMillis(), null, new ArrayList<Weather>(), null, null, null, null, calendar.getTime());
  }
}

package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class WeeklyWeather {
  private static final SimpleDateFormat DAY_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  @SerializedName("city")
  @Expose
  public final City city;
  @SerializedName("cod")
  @Expose
  public final String cod;
  @SerializedName("message")
  @Expose
  public final Double message;
  @SerializedName("cnt")
  @Expose
  public final Integer cnt;
  @SerializedName("list")
  @Expose
  public final List<ThreeHourWeather> threeHourWeather;

  public WeeklyWeather(City city, String cod, Double message, Integer cnt, List<ThreeHourWeather> threeHourWeather) {
    this.city = city;
    this.cod = cod;
    this.message = message;
    this.cnt = cnt;
    this.threeHourWeather = Collections.unmodifiableList(threeHourWeather);
  }

  public List<DailyWeather> dailyWeather() {
    List<ThreeHourWeather> dailyThreeHourWeather = new ArrayList<>(8);
    List<DailyWeather> dailyWeather = new ArrayList<>();
    Date previousThreeHourWeatherDay = null;
    for (ThreeHourWeather weather : threeHourWeather) {
      if (isDifferentDay(weather.date, previousThreeHourWeatherDay)) {
        dailyWeather.add(createDailyWeather(dailyThreeHourWeather));
        dailyThreeHourWeather.clear();
      }
      dailyThreeHourWeather.add(weather);
      previousThreeHourWeatherDay = weather.date;
    }
    if (!dailyThreeHourWeather.isEmpty()) {
      dailyWeather.add(createDailyWeather(dailyThreeHourWeather));
    }
    return dailyWeather;
  }

  public List<DailyWeather> fiveDayWeather() {
    List<DailyWeather> dailyWeather = dailyWeather();
    return dailyWeather.size() > 5 ? dailyWeather.subList(0, 5) : dailyWeather;
  }

  private static DailyWeather createDailyWeather(List<ThreeHourWeather> dailyThreeHourWeather) {
    return new DailyWeather(new Date(dailyThreeHourWeather.get(0).date.getTime()), dailyThreeHourWeather);
  }

  private static boolean isDifferentDay(Date date, Date previousDate) {
    return previousDate != null && !DAY_DATE_FORMAT.format(date).equals(DAY_DATE_FORMAT.format(previousDate));
  }
}

package uk.co.josephearl.android.weeklyweather.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DailyWeather {
  public final Date day;
  public final List<ThreeHourWeather> threeHourWeather;

  public DailyWeather(Date day, List<ThreeHourWeather> threeHourWeather) {
    this.day = new Date(day.getTime());
    this.threeHourWeather = Collections.unmodifiableList(new ArrayList<>(threeHourWeather));
  }
}

package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ThreeHourWeather {
  @SerializedName("dt")
  @Expose
  public final long time;
  @SerializedName("main")
  @Expose
  public final Forecast forecast;
  @SerializedName("weather")
  @Expose
  public final List<Weather> weather;
  @SerializedName("clouds")
  @Expose
  public final Clouds clouds;
  @SerializedName("wind")
  @Expose
  public final Wind wind;
  @SerializedName("rain")
  @Expose
  public final Rain rain;
  @SerializedName("sys")
  @Expose
  public final ThreeHourWeatherStats stats;
  @SerializedName("dt_txt")
  @Expose
  public final Date date;

  public ThreeHourWeather(long time, Forecast forecast, List<Weather> weather, Clouds clouds, Wind wind, Rain rain, ThreeHourWeatherStats stats, Date date) {
    this.time = time;
    this.forecast = forecast;
    this.weather = Collections.unmodifiableList(new ArrayList<>(weather));
    this.clouds = clouds;
    this.wind = wind;
    this.rain = rain;
    this.stats = stats;
    this.date = new Date(date.getTime());
  }
}

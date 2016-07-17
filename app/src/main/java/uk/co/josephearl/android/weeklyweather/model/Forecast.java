package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {
  @SerializedName("temp")
  @Expose
  public final Double temp;
  @SerializedName("temp_min")
  @Expose
  public final Double tempMin;
  @SerializedName("temp_max")
  @Expose
  public final Double tempMax;
  @SerializedName("pressure")
  @Expose
  public final Double pressure;
  @SerializedName("sea_level")
  @Expose
  public final Double seaLevel;
  @SerializedName("grnd_level")
  @Expose
  public final Double grndLevel;
  @SerializedName("humidity")
  @Expose
  public final Integer humidity;
  @SerializedName("temp_kf")
  @Expose
  public final Double tempKf;

  public Forecast(Double temp, Double tempMin, Double tempMax, Double pressure, Double seaLevel, Double grndLevel, Integer humidity, Double tempKf) {
    this.temp = temp;
    this.tempMin = tempMin;
    this.tempMax = tempMax;
    this.pressure = pressure;
    this.seaLevel = seaLevel;
    this.grndLevel = grndLevel;
    this.humidity = humidity;
    this.tempKf = tempKf;
  }
}

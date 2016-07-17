package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {
  @SerializedName("id")
  @Expose
  public final Integer id;
  @SerializedName("main")
  @Expose
  public final String main;
  @SerializedName("description")
  @Expose
  public final String description;
  @SerializedName("icon")
  @Expose
  public final String icon;

  public Weather(Integer id, String main, String description, String icon) {
    this.id = id;
    this.main = main;
    this.description = description;
    this.icon = icon;
  }
}

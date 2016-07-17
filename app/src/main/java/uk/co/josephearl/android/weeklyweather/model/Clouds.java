package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {
  @SerializedName("all")
  @Expose
  public final Integer all;

  public Clouds(Integer all) {
    this.all = all;
  }
}

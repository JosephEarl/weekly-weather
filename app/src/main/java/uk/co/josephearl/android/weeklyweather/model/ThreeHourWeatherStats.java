package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThreeHourWeatherStats {
  @SerializedName("pod")
  @Expose
  public final String pod;

  public ThreeHourWeatherStats(String pod) {
    this.pod = pod;
  }
}

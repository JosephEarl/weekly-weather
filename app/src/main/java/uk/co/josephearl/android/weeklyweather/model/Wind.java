
package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {
  @SerializedName("speed")
  @Expose
  public final Double speed;
  @SerializedName("deg")
  @Expose
  public final Double deg;

  public Wind(Double speed, Double deg) {
    this.speed = speed;
    this.deg = deg;
  }
}

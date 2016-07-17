package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord {
  @SerializedName("lon")
  @Expose
  public final Double lon;
  @SerializedName("lat")
  @Expose
  public final Double lat;

  public Coord(Double lon, Double lat) {
    this.lon = lon;
    this.lat = lat;
  }
}

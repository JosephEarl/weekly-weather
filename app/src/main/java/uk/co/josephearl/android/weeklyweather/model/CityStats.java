package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityStats {
  @SerializedName("population")
  @Expose
  public final Integer population;

  public CityStats(Integer population) {
    this.population = population;
  }
}

package uk.co.josephearl.android.weeklyweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {
  @SerializedName("id")
  @Expose
  public final Integer id;
  @SerializedName("name")
  @Expose
  public final String name;
  @SerializedName("coord")
  @Expose
  public final Coord coord;
  @SerializedName("country")
  @Expose
  public final String country;
  @SerializedName("population")
  @Expose
  public final Integer population;
  @SerializedName("sys")
  @Expose
  public final CityStats stats;

  public City(Integer id, String name, Coord coord, String country, Integer population, CityStats stats) {
    this.id = id;
    this.name = name;
    this.coord = coord;
    this.country = country;
    this.population = population;
    this.stats = stats;
  }
}

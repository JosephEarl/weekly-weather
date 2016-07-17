package uk.co.josephearl.android.weeklyweather.api;

import retrofit2.Retrofit;

public class WeeklyWeatherServiceFactory {
  private WeeklyWeatherServiceFactory() {
  }

  public static WeeklyWeatherService create(Retrofit retrofit) {
    return retrofit.create(WeeklyWeatherService.class);
  }
}

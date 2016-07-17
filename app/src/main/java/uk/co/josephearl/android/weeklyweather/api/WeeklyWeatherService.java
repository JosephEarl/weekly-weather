package uk.co.josephearl.android.weeklyweather.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;
import uk.co.josephearl.android.weeklyweather.BuildConfig;
import uk.co.josephearl.android.weeklyweather.model.WeeklyWeather;

public interface WeeklyWeatherService {
  @GET("data/2.5/forecast?mode=json&APPID=" + BuildConfig.WEEKLY_WEATHER_API_KEY)
  Single<WeeklyWeather> forecast(@Query("q") String city);
}

package uk.co.josephearl.android.weeklyweather;

import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import uk.co.josephearl.android.weeklyweather.api.GsonConverterFactory;
import uk.co.josephearl.android.weeklyweather.api.RetrofitFactory;
import uk.co.josephearl.android.weeklyweather.api.WeeklyWeatherService;
import uk.co.josephearl.android.weeklyweather.api.WeeklyWeatherServiceFactory;

import javax.inject.Singleton;

@Module
public class WeeklyWeatherModule {
  private final String baseUrl;

  public WeeklyWeatherModule(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  @Provides
  @Singleton
  Gson provideGson() {
    return GsonConverterFactory.gson();
  }

  @Provides
  @Singleton
  Retrofit provideRetrofit(Gson gson) {
    return RetrofitFactory.create(gson, baseUrl);
  }

  @Provides
  @Singleton
  WeeklyWeatherService provideWeeklyWeatherService(Retrofit retrofit) {
    return WeeklyWeatherServiceFactory.create(retrofit);
  }
}

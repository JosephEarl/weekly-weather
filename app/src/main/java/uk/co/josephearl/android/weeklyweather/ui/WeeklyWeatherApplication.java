package uk.co.josephearl.android.weeklyweather.ui;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import uk.co.josephearl.android.weeklyweather.*;

public class WeeklyWeatherApplication extends Application {
  private WeeklyWeatherComponent weeklyWeatherComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    LeakCanary.install(this);
    weeklyWeatherComponent = DaggerWeeklyWeatherComponent.builder()
        .weeklyWeatherModule(new WeeklyWeatherModule("http://api.openweathermap.org/"))
        .build();
  }

  public WeeklyWeatherComponent getWeeklyWeatherComponent() {
    return weeklyWeatherComponent;
  }
}

package uk.co.josephearl.android.weeklyweather;

import dagger.Component;
import uk.co.josephearl.android.weeklyweather.ui.WeeklyWeatherActivity;

import javax.inject.Singleton;

@Singleton
@Component(modules = {WeeklyWeatherModule.class})
public interface WeeklyWeatherComponent {
  void inject(WeeklyWeatherActivity activity);
}

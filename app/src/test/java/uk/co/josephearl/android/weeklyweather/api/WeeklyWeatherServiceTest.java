package uk.co.josephearl.android.weeklyweather.api;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;
import uk.co.josephearl.android.weeklyweather.api.GsonConverterFactory;
import uk.co.josephearl.android.weeklyweather.api.RetrofitFactory;
import uk.co.josephearl.android.weeklyweather.api.WeeklyWeatherService;
import uk.co.josephearl.android.weeklyweather.api.WeeklyWeatherServiceFactory;
import uk.co.josephearl.android.weeklyweather.model.WeeklyWeather;

public class WeeklyWeatherServiceTest {
  @Test
  public void forecastForLondon_returnsData() throws Exception {
    WeeklyWeatherService weeklyWeatherService = WeeklyWeatherServiceFactory.create(RetrofitFactory.create(GsonConverterFactory.gson(), "http://api.openweathermap.org/"));

    WeeklyWeather weeklyWeather = weeklyWeatherService.forecast("London,uk").toBlocking().value();

    assertThat(weeklyWeather).isNotNull();
    assertThat(weeklyWeather.city.name).isEqualTo("London");
    assertThat(weeklyWeather.city.country).isEqualTo("GB");
    assertThat(weeklyWeather.cnt).isGreaterThan(0);
    assertThat(weeklyWeather.threeHourWeather.size()).isGreaterThan(0);
  }
}
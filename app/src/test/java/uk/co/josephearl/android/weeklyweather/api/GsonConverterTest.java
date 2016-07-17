package uk.co.josephearl.android.weeklyweather.api;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import uk.co.josephearl.android.weeklyweather.api.GsonConverterFactory;
import uk.co.josephearl.android.weeklyweather.model.ThreeHourWeather;
import uk.co.josephearl.android.weeklyweather.model.WeeklyWeather;

public class GsonConverterTest {
  @Test
  public void deserializeWeeklyWeather_isCorrect() throws Exception {
    Gson gson = GsonConverterFactory.gson();
    String json = IOUtils.toString(getClass().getResourceAsStream("weekly_weather.json"), "UTF-8");

    WeeklyWeather weeklyWeather = gson.fromJson(json, WeeklyWeather.class);

    assertThat(weeklyWeather).isNotNull();
    assertThat(weeklyWeather.city.name).isEqualTo("London");
    assertThat(weeklyWeather.city.country).isEqualTo("GB");
    assertThat(weeklyWeather.cnt).isEqualTo(40);
    assertThat(weeklyWeather.threeHourWeather).hasSize(40);
    ThreeHourWeather firstThreeHourWeather = weeklyWeather.threeHourWeather.get(0);
    assertThat(firstThreeHourWeather.date).hasYear(2016);
    assertThat(firstThreeHourWeather.date).hasMonth(7);
    assertThat(firstThreeHourWeather.date).hasDayOfMonth(17);
    assertThat(firstThreeHourWeather.date).hasHourOfDay(15);
    assertThat(firstThreeHourWeather.date).hasMinute(0);
  }
}


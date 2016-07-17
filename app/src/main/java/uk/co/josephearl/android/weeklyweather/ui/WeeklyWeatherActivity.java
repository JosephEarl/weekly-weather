package uk.co.josephearl.android.weeklyweather.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import uk.co.josephearl.android.weeklyweather.R;
import uk.co.josephearl.android.weeklyweather.api.WeeklyWeatherService;
import uk.co.josephearl.android.weeklyweather.model.DailyWeather;
import uk.co.josephearl.android.weeklyweather.model.WeeklyWeather;

import java.util.List;

import javax.inject.Inject;

public class WeeklyWeatherActivity extends AppCompatActivity {
  private DailyWeatherListAdapter dailyWeatherListAdapter;
  private Subscription weeklyWeatherServiceSubscription;
  @Inject
  WeeklyWeatherService weeklyWeatherService;
  @BindView(R.id.daily_weather_list)
  RecyclerView dailyWeatherList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weekly_weather);
    ButterKnife.bind(this);

    ((WeeklyWeatherApplication) getApplication()).getWeeklyWeatherComponent().inject(this);

    dailyWeatherList.setHasFixedSize(true);
    dailyWeatherList.setLayoutManager(new LinearLayoutManager(this));
    dailyWeatherListAdapter = new DailyWeatherListAdapter();
    dailyWeatherList.setAdapter(dailyWeatherListAdapter);

    weeklyWeatherServiceSubscription = weeklyWeatherService.forecast("London,uk")
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .map(new Func1<WeeklyWeather, List<DailyWeather>>() {
          @Override
          public List<DailyWeather> call(WeeklyWeather weeklyWeather) {
            return weeklyWeather.fiveDayWeather();
          }
        }).subscribe(new Action1<List<DailyWeather>>() {
      @Override
      public void call(List<DailyWeather> dailyWeather) {
        dailyWeatherListAdapter.bind(dailyWeather);
      }
    });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    weeklyWeatherServiceSubscription.unsubscribe();
  }
}

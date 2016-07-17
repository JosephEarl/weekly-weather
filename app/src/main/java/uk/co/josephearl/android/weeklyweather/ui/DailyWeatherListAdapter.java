package uk.co.josephearl.android.weeklyweather.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.josephearl.android.weeklyweather.R;
import uk.co.josephearl.android.weeklyweather.model.DailyWeather;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DailyWeatherListAdapter extends RecyclerView.Adapter<DailyWeatherListAdapter.ViewHolder> {
  private final Calendar calendar = Calendar.getInstance();;
  private final List<DailyWeather> dailyWeather;

  public DailyWeatherListAdapter() {
    dailyWeather = new ArrayList<>();
  }

  public DailyWeatherListAdapter(List<DailyWeather> dailyWeather) {
    this.dailyWeather = new ArrayList<>(dailyWeather);
  }

  public void bind(List<DailyWeather> dailyWeather) {
    this.dailyWeather.clear();
    this.dailyWeather.addAll(dailyWeather);
    notifyDataSetChanged();
  }

  @Override
  public DailyWeatherListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_weather_card, parent, false);
    return new ViewHolder(v, calendar);
  }

  @Override
  public void onBindViewHolder(DailyWeatherListAdapter.ViewHolder holder, int position) {
    holder.bind(dailyWeather.get(position));
  }

  @Override
  public int getItemCount() {
    return dailyWeather.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    private final Calendar calendar;
    private final ThreeHourWeatherListAdapter threeHourWeatherListAdapter;
    @BindView(R.id.day)
    TextView day;
    @BindView(R.id.three_hour_weather_list)
    RecyclerView threeHourWeatherList;

    ViewHolder(View itemView, Calendar calendar) {
      super(itemView);
      this.calendar = calendar;
      ButterKnife.bind(this, itemView);
      threeHourWeatherList.setHasFixedSize(true);
      threeHourWeatherList.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
      threeHourWeatherListAdapter = new ThreeHourWeatherListAdapter();
      threeHourWeatherList.setAdapter(threeHourWeatherListAdapter);
    }

    void bind(DailyWeather weather) {
      calendar.setTime(weather.day);
      day.setText(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, day.getTextLocale()));
      threeHourWeatherList.setAdapter(new ThreeHourWeatherListAdapter(weather.threeHourWeather));
    }
  }
}

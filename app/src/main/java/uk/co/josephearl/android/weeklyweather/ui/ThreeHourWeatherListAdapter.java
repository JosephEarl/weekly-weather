package uk.co.josephearl.android.weeklyweather.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.josephearl.android.weeklyweather.R;
import uk.co.josephearl.android.weeklyweather.model.ThreeHourWeather;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ThreeHourWeatherListAdapter extends RecyclerView.Adapter<ThreeHourWeatherListAdapter.ViewHolder> {
  private final SimpleDateFormat hourFormat = new SimpleDateFormat("HH:00", Locale.US);
  private final List<ThreeHourWeather> threeHourWeather;

  public ThreeHourWeatherListAdapter() {
    threeHourWeather = new ArrayList<>();
  }

  @Override
  public ThreeHourWeatherListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.three_hour_weather, parent, false);
    return new ViewHolder(v, hourFormat);
  }

  @Override
  public void onBindViewHolder(ThreeHourWeatherListAdapter.ViewHolder holder, int position) {
    holder.bind(threeHourWeather.get(position));
  }

  @Override
  public int getItemCount() {
    return threeHourWeather.size();
  }

  public ThreeHourWeatherListAdapter(List<ThreeHourWeather> threeHourWeather) {
    this.threeHourWeather = new ArrayList<>(threeHourWeather);
  }

  public void bind(List<ThreeHourWeather> threeHourWeather) {
    this.threeHourWeather.clear();
    this.threeHourWeather.addAll(threeHourWeather);
    notifyDataSetChanged();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    private final SimpleDateFormat hourFormat;
    @BindView(R.id.hour)
    TextView hour;
    @BindView(R.id.temperature)
    TextView temperature;
    @BindView(R.id.description)
    TextView description;
    ViewHolder(View itemView, SimpleDateFormat hourFormat) {
      super(itemView);
      this.hourFormat = hourFormat;
      ButterKnife.bind(this, itemView);
    }

    void bind(ThreeHourWeather weather) {
      hour.setText(hourFormat.format(weather.date));
      temperature.setText(inCelsius(temperature.getTextLocale(), weather.forecast.temp));
      description.setText(weather.weather.get(0).description);
    }

    private static String inCelsius(Locale locale, double temperature) {
      return String.format(locale, "%.1f°C", temperature - 273.15);
    }
  }
}

package uk.co.josephearl.android.weeklyweather.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonConverterFactory {
  private GsonConverterFactory() {
  }

  public static retrofit2.converter.gson.GsonConverterFactory create(Gson gson) {
    return retrofit2.converter.gson.GsonConverterFactory.create(gson());
  }

  public static Gson gson() {
    return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  }
}

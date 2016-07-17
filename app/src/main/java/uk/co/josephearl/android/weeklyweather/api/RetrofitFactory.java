package uk.co.josephearl.android.weeklyweather.api;

import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class RetrofitFactory {
  private RetrofitFactory() {
  }

  public static Retrofit create(Gson gson, String url) {
    return new Retrofit.Builder()
        .baseUrl(url)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
  }
}

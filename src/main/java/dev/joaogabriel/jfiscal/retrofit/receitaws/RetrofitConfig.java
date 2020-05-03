package dev.joaogabriel.jfiscal.retrofit.receitaws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private static Retrofit retrofit = null;

    public static Retrofit getInstance() {
        if (retrofit != null)
            return retrofit;
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        retrofit = new Retrofit.Builder().baseUrl("https://www.receitaws.com.br/").addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit;
    }
}
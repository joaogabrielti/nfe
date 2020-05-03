package dev.joaogabriel.jfiscal.retrofit.fiscalws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FiscalConfig {
    private static Retrofit retrofit = null;

    public static Retrofit getInstance() {
        if (retrofit != null)
            return retrofit;
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        retrofit = new Retrofit.Builder().baseUrl("http://127.0.0.1:8000/").addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit;
    }
}

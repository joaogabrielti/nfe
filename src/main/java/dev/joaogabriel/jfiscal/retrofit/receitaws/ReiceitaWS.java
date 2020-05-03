package dev.joaogabriel.jfiscal.retrofit.receitaws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReiceitaWS {
    @GET("v1/cnpj/{cnpj}")
    Call<ReceitaResponse> buscaCNPJ(@Path("cnpj") String cnpj);
}
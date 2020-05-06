package dev.joaogabriel.jfiscal.retrofit.fiscalws;

import dev.joaogabriel.jfiscal.model.Empresa;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import java.util.List;

public interface FiscalWS {
    @POST("emitente") Call<Empresa> cadastrarEmitente(@Body Empresa body);
    @POST("cliente") Call<Empresa> cadastrarCliente(@Body Empresa body);
    @GET("emitente") Call<List<Empresa>> emitentes();
    @GET("cliente") Call<List<Empresa>> clientes();
}

package dev.joaogabriel.jfiscal.retrofit.fiscalws;

import dev.joaogabriel.jfiscal.model.Empresa;
import dev.joaogabriel.jfiscal.model.Endereco;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FiscalWS {
    @POST("endereco") @FormUrlEncoded Call<Endereco> cadastrarEndereco(@Field("rua") String rua, @Field("numero") String numero, @Field("bairro") String bairro, @Field("cidade") String cidade, @Field("estado") String estado, @Field("pais") String pais, @Field("cep") String cep, @Field("codigo_municipio") int codigo_municipio, @Field("observacoes") String observacoes);
    @POST("emitente") @FormUrlEncoded Call<Empresa> cadastrarEmitente(@Field("cnpj_cpf") String cnpj_cpf, @Field("fantasia") String fantasia, @Field("razao_social") String razao_social, @Field("inscricao_estadual") String inscricao_estadual, @Field("tipo") int tipo, @Field("endereco_id") int endereco_id, @Field("site") String site, @Field("contato") String contato, @Field("observacoes") String observacoes);
    @POST("cliente") @FormUrlEncoded Call<Empresa> cadastrarCliente(@Field("cnpj_cpf") String cnpj_cpf, @Field("fantasia") String fantasia, @Field("razao_social") String razao_social, @Field("inscricao_estadual") String inscricao_estadual, @Field("tipo") int tipo, @Field("endereco_id") int endereco_id, @Field("site") String site, @Field("contato") String contato, @Field("observacoes") String observacoes);
}

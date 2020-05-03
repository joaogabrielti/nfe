package dev.joaogabriel.jfiscal.view;

import dev.joaogabriel.jfiscal.model.*;
import dev.joaogabriel.jfiscal.retrofit.fiscalws.FiscalConfig;
import dev.joaogabriel.jfiscal.retrofit.fiscalws.FiscalWS;
import dev.joaogabriel.jfiscal.retrofit.receitaws.ReceitaResponse;
import dev.joaogabriel.jfiscal.retrofit.receitaws.ReiceitaWS;
import dev.joaogabriel.jfiscal.retrofit.receitaws.RetrofitConfig;
import dev.joaogabriel.jfiscal.util.AutoCompleteComboBoxListener;
import dev.joaogabriel.jfiscal.util.GEOHelper;
import dev.joaogabriel.jfiscal.util.MaskFieldUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;

public class JanelaCadastroCliente {
    public TextField tf_cpfCnpjBusca;
    public TextField tf_codigo;
    public TextField tf_cpfCnpj;
    public TextField tf_ie;
    public TextField tf_razaoSocial;
    public TextField tf_fantasia;
    public TextField tf_site;
    public TextField tf_contato;
    public TextField tf_rua;
    public TextField tf_numero;
    public TextField tf_bairro;
    public ComboBox<String> cb_tipo;
    public ComboBox<Municipio> cb_cidade;
    public ComboBox<Estado> cb_estado;
    public ComboBox<Pais> cb_pais;
    public TextField tf_cep;
    public TextField tf_codigoMunicipal;
    public TextArea ta_observacoes;
    public TextArea ta_observacoesEndereco;
    public Button bt_buscar;
    public Button bt_salvar;
    public Label lb_mensagem;
    public ImageView img_loading;

    private ArrayList<Municipio> municipios;

    public void initialize() {
        mostrarMensagem("Iniciando widgets da janela... Aguarde...", true);

        GEOHelper geo = new GEOHelper();

        cb_tipo.getItems().addAll("PJ", "PF");

        cb_cidade.getItems().addAll(geo.municipios);
        cb_cidade.addEventHandler(KeyEvent.KEY_TYPED, new AutoCompleteComboBoxListener<Municipio>(cb_cidade));

        cb_estado.getItems().addAll(geo.estados);
        cb_estado.addEventHandler(KeyEvent.KEY_TYPED, new AutoCompleteComboBoxListener<Estado>(cb_estado));

        cb_pais.getItems().addAll(geo.paises);
        cb_pais.addEventHandler(KeyEvent.KEY_TYPED, new AutoCompleteComboBoxListener<Pais>(cb_pais));

        cb_cidade.setOnAction(actionEvent -> {
            try {
                Municipio municipioSelecionado = cb_cidade.getValue();
                tf_codigoMunicipal.setText(municipioSelecionado.getCod_municipio() + "");
            } catch (ClassCastException ignored) { }
        });

        mostrarMensagem("", false);

        this.municipios = new ArrayList<>();
        this.municipios.addAll(geo.municipios);
    }

    public void aplicarMascaraCNPJ(KeyEvent keyEvent) {
        MaskFieldUtil.cpfCnpjField(this.tf_cpfCnpjBusca);
        MaskFieldUtil.cpfCnpjField(this.tf_cpfCnpj);
    }

    public void aplicarMascaraCEP(KeyEvent keyEvent) {
        MaskFieldUtil.cepField(this.tf_cep);
    }

    public void buscarInformacoesReceitaWS(ActionEvent actionEvent) {
        String texto = tf_cpfCnpjBusca.getText().toLowerCase();
        String cnpj = texto.replaceAll("\\D", "");

        mostrarMensagem("Buscando dados na ReceitaWS, aguarde...", true);

        Call<ReceitaResponse> call = RetrofitConfig.getInstance().create(ReiceitaWS.class).buscaCNPJ(cnpj);
        call.enqueue(new Callback<ReceitaResponse>() {
            @Override
            public void onResponse(@NotNull Call<ReceitaResponse> call, @NotNull Response<ReceitaResponse> response) {
                if (response.isSuccessful()) {
                    ReceitaResponse dados = response.body();

                    Platform.runLater(() -> {
                        assert dados != null;
                        tf_cpfCnpj.setText(dados.getCnpj());
                        tf_razaoSocial.setText(dados.getNome());
                        tf_fantasia.setText(dados.getFantasia());
                        cb_tipo.getSelectionModel().select(0);
                        tf_rua.setText(dados.getLogradouro());
                        tf_numero.setText(dados.getNumero());
                        tf_bairro.setText(dados.getBairro());
                        cb_cidade.getEditor().setText(dados.getMunicipio());
                        cb_estado.getEditor().setText(dados.getUf());
                        cb_pais.getEditor().setText("BRASIL");
                        tf_cep.setText(dados.getCep());

                        for (Municipio municipio : municipios) {
                            if (dados.getMunicipio().equals(municipio.getNome_municipio().toUpperCase())) {
                                tf_codigoMunicipal.setText(municipio.getCod_municipio() + "");
                                break;
                            }
                        }

                        mostrarMensagem("", false);
                    });

                } else {
                    Platform.runLater(() -> mostrarMensagem("Ocorreu um erro na consulta de dados na ReceitaWS. Código: " + response.code() + " " + response.message(), true));
                }
            }
            @Override
            public void onFailure(@NotNull Call<ReceitaResponse> call, @NotNull Throwable throwable) {
                System.out.println("Ocorreu um erro na consulta de dados na ReceitaWS. Erro: " + throwable.getMessage());
            }
        });
    }

    private void mostrarMensagem(String mensagem, boolean loading) {
        lb_mensagem.setText(mensagem);
        img_loading.setVisible(loading);
    }

    public void cadastrarCliente(ActionEvent actionEvent) {
        mostrarMensagem("Cadastrando dados no servidor. Por favor, aguarde...", true);

        String rua = tf_rua.getText();
        String numero = tf_numero.getText();
        String bairro = tf_bairro.getText();
        String cidade = cb_cidade.getEditor().getText();
        String estado = cb_estado.getEditor().getText();
        String pais = cb_pais.getEditor().getText();
        String cep = tf_cep.getText();
        int codigo_municipio = Integer.parseInt(tf_codigoMunicipal.getText());
        String observacoes_endereco = ta_observacoesEndereco.getText();

        Call<Endereco> enderecoCall = FiscalConfig.getInstance().create(FiscalWS.class).cadastrarEndereco(rua, numero, bairro, cidade, estado, pais, cep, codigo_municipio, observacoes_endereco);
        enderecoCall.enqueue(new Callback<Endereco>() {
            @Override
            public void onResponse(@NotNull Call<Endereco> call, @NotNull Response<Endereco> response) {
                Endereco endereco = response.body();
                assert endereco != null;

                String cnpj_cpf = tf_cpfCnpj.getText();
                String fantasia = tf_fantasia.getText();
                String razao_social = tf_razaoSocial.getText();
                String inscricao_estadual = tf_ie.getText();
                int tipo = cb_tipo.getSelectionModel().getSelectedItem().equals("PJ") ? 1 : 0;
                int endereco_id = endereco.getCodigo();
                String site = tf_site.getText();
                String contato = tf_contato.getText();
                String observacoes = ta_observacoes.getText();

                Call<Empresa> empresaCall = FiscalConfig.getInstance().create(FiscalWS.class).cadastrarCliente(cnpj_cpf, fantasia, razao_social, inscricao_estadual, tipo, endereco_id, site, contato, observacoes);
                empresaCall.enqueue(new Callback<Empresa>() {
                    @Override
                    public void onResponse(@NotNull Call<Empresa> call, @NotNull Response<Empresa> response) {
                        if (response.isSuccessful()) {
                            Platform.runLater(() -> mostrarMensagem("Dados do cliente cadastrados com sucesso!", false));
                        } else {
                            Platform.runLater(() -> mostrarMensagem("Erro ao cadastrar os dados do cliente! " + response.code() + " " + response.message(), false));
                        }
                    }
                    @Override
                    public void onFailure(@NotNull Call<Empresa> call, @NotNull Throwable throwable) {
                        System.out.println("Ocorreu um erro no cadastro dos dados. Erro: " + throwable.getMessage());
                        Platform.runLater(() -> mostrarMensagem("Erro no cadastro da Pessoa Física/Jurídica.", false));
                    }
                });
            }
            @Override
            public void onFailure(@NotNull Call<Endereco> call, @NotNull Throwable throwable) {
                System.out.println("Ocorreu um erro no cadastro dos dados. Erro: " + throwable.getMessage());
                Platform.runLater(() -> mostrarMensagem("Erro no cadastro do Endereço.", false));
            }
        });
    }
}

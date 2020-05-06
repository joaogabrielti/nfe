package dev.joaogabriel.jfiscal.view;

import dev.joaogabriel.jfiscal.model.Empresa;
import dev.joaogabriel.jfiscal.model.Estado;
import dev.joaogabriel.jfiscal.model.Municipio;
import dev.joaogabriel.jfiscal.retrofit.fiscalws.FiscalConfig;
import dev.joaogabriel.jfiscal.retrofit.fiscalws.FiscalWS;
import dev.joaogabriel.jfiscal.util.AutoCompleteComboBoxListener;
import dev.joaogabriel.jfiscal.util.CFOPHelper;
import dev.joaogabriel.jfiscal.util.GEOHelper;
import dev.joaogabriel.jfiscal.util.MaskFieldUtil;
import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JanelaNFE {
    public ComboBox<Empresa> cb_emitente;
    public ComboBox<String> cb_operacao;
    public ComboBox<String> cb_formapgto;
    public ComboBox<String> cb_finalidade;
    public ComboBox<Empresa> cb_destinatario;
    public ComboBox<String> cb_nome;
    public ComboBox<String> cb_frete;
    public TextField tf_numero;
    public TextField tf_serie;
    public TextField tf_data;
    public TextField tf_dataes;
    public TextField tf_horaes;
    public TextField tf_cfop;
    public TextField tf_cfop_desc;
    public TextField tf_cnpj_cpf;
    public TextField tf_endereco;
    public TextField tf_ie;
    public TextField tf_placa;
    public TextField tf_uf_placa;
    public ComboBox<Municipio> cb_cidade;
    public ComboBox<Estado> cb_uf;
    public TextField tf_especie;
    public TextField tf_qtd_volume;
    public TextField tf_antt;
    public TextField tf_peso_bruto;
    public TextField tf_peso_liquido;
    public TextArea ta_info;

    public void initialize() {
        Call<List<Empresa>> call_emitentes = FiscalConfig.getInstance().create(FiscalWS.class).emitentes();
        call_emitentes.enqueue(new Callback<List<Empresa>>() {
            @Override
            public void onResponse(@NotNull Call<List<Empresa>> call, @NotNull Response<List<Empresa>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Platform.runLater(() -> {
                        cb_emitente.getItems().addAll(response.body());
                        cb_emitente.getSelectionModel().select(0);
                    });
                } else {
                    System.out.println("Response Error: " + response.code() + " - " + response.message());
                }
            }
            @Override
            public void onFailure(@NotNull Call<List<Empresa>> call, @NotNull Throwable throwable) {
                System.out.println("Request Fail: " + throwable.getMessage());
            }
        });

        cb_operacao.getItems().addAll("ENTRADA", "SAÍDA");
        cb_operacao.getSelectionModel().select(0);
        cb_formapgto.getItems().addAll("A VISTA", "A PRAZO", "OUTROS");
        cb_formapgto.getSelectionModel().select(0);
        cb_finalidade.getItems().addAll("NORMAL", "COMPLEMENTAR", "AJUSTE", "DEVOLUÇÃO");
        cb_finalidade.getSelectionModel().select(0);
        cb_frete.getItems().addAll("CONTRATAÇÃO REMETENTE", "CONTRATAÇÃO DESTINATÁRIO", "CONTRATAÇÃO TERCEIROS", "PRÓPRIO REMETENTE", "PRÓPRIO DESTINATÁRIO", "SEM TRANSPORTE");
        cb_frete.getSelectionModel().select(1);

        Date data_hoje = new Date();
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");

        tf_data.setText(dateTimeFormatter.format(data_hoje));
        tf_dataes.setText(dateFormatter.format(data_hoje));
        tf_horaes.setText(timeFormatter.format(new Date(System.currentTimeMillis() + (10 * 60000))));

        GEOHelper geo = new GEOHelper();
        cb_cidade.getItems().addAll(geo.municipios);
        cb_cidade.addEventHandler(KeyEvent.KEY_TYPED, new AutoCompleteComboBoxListener<Municipio>(cb_cidade));
        cb_uf.getItems().addAll(geo.estados);
        cb_uf.addEventHandler(KeyEvent.KEY_TYPED, new AutoCompleteComboBoxListener<Estado>(cb_uf));

        tf_cnpj_cpf.addEventHandler(KeyEvent.KEY_TYPED, keyEvent -> MaskFieldUtil.cpfCnpjField(tf_cnpj_cpf));

        CFOPHelper cfop = new CFOPHelper();
        tf_cfop.addEventHandler(KeyEvent.KEY_TYPED, keyEvent -> {
            MaskFieldUtil.cfopField(tf_cfop);
            if (tf_cfop.getText().length() == 5) {
                for (int i = cfop.cfops.size() - 1; i >= 0; i--) {
                    //System.out.println("Verificando " + tf_cfop.getText() + " com " + cfop.cfops.get(i).getCfop());
                    if (cfop.cfops.get(i).getCfop().equals(tf_cfop.getText())) {
                        tf_cfop_desc.setText(cfop.cfops.get(i).toString());
                        break;
                    } else tf_cfop_desc.setText("");
                }
            }
        });
    }
}

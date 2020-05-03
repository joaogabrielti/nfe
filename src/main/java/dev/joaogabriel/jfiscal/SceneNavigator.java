package dev.joaogabriel.jfiscal;

import dev.joaogabriel.jfiscal.view.JanelaBase;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class SceneNavigator {
    public static final String BASE = "fxml/janela_base.fxml";
    public static final String PRINCIPAL = "fxml/janela_principal.fxml";
    public static final String CADASTRO_EMITENTE = "fxml/janela_cadastro_emitente.fxml";
    public static final String CADASTRO_CLIENTE = "fxml/janela_cadastro_cliente.fxml";

    private static JanelaBase controller;

    public static void setController(JanelaBase controller) {
        SceneNavigator.controller = controller;
    }

    public static void loadJanela(String fxml) {
        try {
            controller.setJanelaBase(FXMLLoader.load(SceneNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

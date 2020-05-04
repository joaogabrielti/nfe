package dev.joaogabriel.jfiscal.view;

import dev.joaogabriel.jfiscal.SceneNavigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class JanelaBase {
    @FXML
    private StackPane janelaBase;

    public void setJanelaBase(Node node){
        this.janelaBase.getChildren().setAll(node);
    }

    public void abrirJanelaCadastroEmitente(ActionEvent actionEvent) {
        SceneNavigator.loadJanela(SceneNavigator.CADASTRO_EMITENTE);
    }

    public void abrirJanelaCadastroCliente(ActionEvent actionEvent) {
        SceneNavigator.loadJanela(SceneNavigator.CADASTRO_CLIENTE);
    }

    public void abrirJanelaNFE(ActionEvent actionEvent) {
        SceneNavigator.loadJanela(SceneNavigator.NOTAS_FISCAIS_PROPRIAS);
    }
}

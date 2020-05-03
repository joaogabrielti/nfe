package dev.joaogabriel.jfiscal;

import dev.joaogabriel.jfiscal.view.JanelaBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = loadMainPane();
        stage.setTitle("JFiscal 1.0");
        stage.setScene(new Scene(root, 1280, 720));
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = loader.load(getClass().getResourceAsStream(SceneNavigator.BASE));
        JanelaBase controller = loader.getController();

        SceneNavigator.setController(controller);
        SceneNavigator.loadJanela(SceneNavigator.PRINCIPAL);

        return mainPane;
    }
}

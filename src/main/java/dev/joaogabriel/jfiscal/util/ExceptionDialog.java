package dev.joaogabriel.jfiscal.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionDialog {
    public static void showExceptionDialog(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("SGTA Exception Dialog");
        alert.setHeaderText("Ocorreu um erro fatal durante a execução, por favor, entre em contato com um técnico.");
        alert.setContentText(e.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String exceptionText = sw.toString();

        LocalDateTime date = LocalDateTime.now();
        try {
            FileWriter fileWriter = new FileWriter("stacktrace_" + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_H-m-s")) + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.printf("%s\n\n%s", e.getMessage(), exceptionText);

            printWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }
}
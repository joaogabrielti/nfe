package dev.joaogabriel.jfiscal.util;

import com.google.gson.Gson;
import dev.joaogabriel.jfiscal.model.CFOP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class CFOPHelper {
    public final ObservableList<CFOP> cfops = FXCollections.observableArrayList();

    public CFOPHelper() {
        cfops.addAll(Arrays.asList(new Gson().fromJson(readFile("cfops.json"), CFOP[].class)));
    }

    private static String readFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}

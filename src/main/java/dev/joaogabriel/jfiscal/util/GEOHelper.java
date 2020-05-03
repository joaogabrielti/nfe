package dev.joaogabriel.jfiscal.util;

import com.google.gson.Gson;
import dev.joaogabriel.jfiscal.model.Estado;
import dev.joaogabriel.jfiscal.model.Municipio;
import dev.joaogabriel.jfiscal.model.Pais;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.stream.Stream;

public class GEOHelper {
    public final ObservableList<Municipio> municipios = FXCollections.observableArrayList();
    public final ObservableList<Estado> estados = FXCollections.observableArrayList();
    public final ObservableList<Pais> paises = FXCollections.observableArrayList();

    public GEOHelper() {
        municipios.addAll(Arrays.asList(new Gson().fromJson(readFile("municipios.json"), Municipio[].class)));
        estados.addAll(Arrays.asList(new Gson().fromJson(readFile("estados.json"), Estado[].class)));
        paises.addAll(Arrays.asList(new Gson().fromJson(readFile("paises.json"), Pais[].class)));

        for (Municipio municipio : municipios) {
            municipio.setNome_municipio(removerAcentos(municipio.getNome_municipio()));
        }
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

    private static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
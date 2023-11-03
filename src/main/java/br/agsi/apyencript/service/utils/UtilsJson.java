package br.agsi.apyencript.service.utils;

import br.agsi.apyencript.entities.json.ContextEntity;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;

public class UtilsJson {

    public static ContextEntity readJsonFile(String path) {
        String jsonRead = null;
        try {
            File f = new File(path);
            jsonRead = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);

            if (!jsonRead.isEmpty()) {
                ContextEntity context = convertJsonToContext(jsonRead);
                 if(context !=null)
                    return context;
            }

        } catch (NoSuchFileException e ){
            System.out.println("ERRO!!! Não foi possível encontrar o arquivo " + path + "!!! -> " + e.toString())  ;

        } catch (IOException e) {
            System.out.println("ERRO!!! - Não foi possível ler o Arquivo: " + path);

        }
        return null;
    }

    public static ContextEntity convertJsonToContext(String jsonRead) {
        Gson gson = new Gson();
        ContextEntity context = gson.fromJson(jsonRead, ContextEntity.class);
        return context;
    }
}

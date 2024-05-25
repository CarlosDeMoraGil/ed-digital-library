package com.iesam.digitallibrary.feature.resource.music.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digitallibrary.feature.resource.music.domain.Music;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MusicFileLocalDataSource {
    private String nameFile = "music.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Music>>() {
    }.getType();

    public void save(Music model) {
        List<Music> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<Music> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Music> models) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(models));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurriscro un error al guardar la información.");
            e.printStackTrace();
        }
    }

    public Music findByiscr(String iscr) {
        List<Music> models = findAll();
        for (Music model : models) {
            if (Objects.equals(model.getISRC(), iscr)) {
                return model;
            }
        }
        return null;
    }

    public List<Music> findAll() {
        try {
            File myObj = new File(nameFile);
            if (!myObj.exists()) {
                myObj.createNewFile();
            }
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurriscro un error al obtener el listado.");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Ha ocurriscro un error al crear el fichero.");
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public void getAll() {

        List<Music> models = findAll();

        for(Music Music : models){
            System.out.println(Music.toString());
        }

    }

    public void delete(String modeliscr) {
        List<Music> newList = new ArrayList<>();
        List<Music> models = findAll();
        for (Music model : models) {
            if (!model.getISRC().equals(modeliscr)) {

                newList.add(model);
            }
        }
        saveList(newList);
    }

    public void modify(String iscr, Music newMusic) {
        List<Music> models = findAll();
        for (int i = 0; i < models.size(); i++) {
            Music Music = models.get(i);
            if (Objects.equals(Music.getISRC(), iscr)) {
                // Reemplazar el usuario antiguo con el nuevo usuario
                models.set(i, newMusic);
                saveList(models);
                System.out.println("Usuario modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún usuario con el iscr proporcionado.");
    }

}
package com.iesam.digitallibrary.feature.digitalBook.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digitallibrary.feature.digitalBook.domain.DigitalBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DigitalBookFileLocalDataSource {
    private String nameFile = "DigitalBooks.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<DigitalBook>>() {
    }.getType();

    public void save(DigitalBook model) {
        List<DigitalBook> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<DigitalBook> models) {
        saveToFile(models);
    }

    private void saveToFile(List<DigitalBook> models) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(models));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrisbno un error al guardar la información.");
            e.printStackTrace();
        }
    }

    public DigitalBook findByisbn(String isbn) {
        List<DigitalBook> models = findAll();
        for (DigitalBook model : models) {
            if (Objects.equals(model.isbn, isbn)) {
                return model;
            }
        }
        return null;
    }

    public List<DigitalBook> findAll() {
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
            System.out.println("Ha ocurrisbno un error al obtener el listado.");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Ha ocurrisbno un error al crear el fichero.");
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public void getAll() {

        List<DigitalBook> models = findAll();

        for(DigitalBook DigitalBook : models){
            System.out.println(DigitalBook.toString());
        }

    }

    public void delete(String modelisbn) {
        List<DigitalBook> newList = new ArrayList<>();
        List<DigitalBook> models = findAll();
        for (DigitalBook model : models) {
            if (!model.isbn.equals(modelisbn)) {

                newList.add(model);
            }
        }
        saveList(newList);
    }

    public void modify(String isbn, DigitalBook newDigitalBook) {
        List<DigitalBook> models = findAll();
        for (int i = 0; i < models.size(); i++) {
            DigitalBook DigitalBook = models.get(i);
            if (Objects.equals(DigitalBook.getIsbn(), isbn)) {
                // Reemplazar el usuario antiguo con el nuevo usuario
                models.set(i, newDigitalBook);
                saveList(models);
                System.out.println("Usuario modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún usuario con el isbn proporcionado.");
    }

}
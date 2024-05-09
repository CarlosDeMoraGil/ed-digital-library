package com.iesam.digitallibrary.feature.loan.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digitallibrary.feature.loan.domain.Loan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LoanFileLocalDataSource {
    private String nameFile = "Loans.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Loan>>() {
    }.getType();

    public void save(Loan model) {
        List<Loan> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<Loan> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Loan> models) {
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

    public Loan findByisbn(String isbn) {
        List<Loan> models = findAll();
        for (Loan model : models) {
            if (Objects.equals(model.isbn, isbn)) {
                return model;
            }
        }
        return null;
    }

    public List<Loan> findAll() {
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

        List<Loan> models = findAll();

        for(Loan Loan : models){
            System.out.println(Loan.toString());
        }

    }

    public void delete(String modelisbn) {
        List<Loan> newList = new ArrayList<>();
        List<Loan> models = findAll();
        for (Loan model : models) {
            if (!model.isbn.equals(modelisbn)) {

                newList.add(model);
            }
        }
        saveList(newList);
    }

    public void modify(String isbn, Loan newLoan) {
        List<Loan> models = findAll();
        for (int i = 0; i < models.size(); i++) {
            Loan Loan = models.get(i);
            if (Objects.equals(Loan.getIsbn(), isbn)) {
                // Reemplazar el usuario antiguo con el nuevo usuario
                models.set(i, newLoan);
                saveList(models);
                System.out.println("Usuario modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún usuario con el isbn proporcionado.");
    }

}
package com.iesam.digitallibrary.feature.loan.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.digitallibrary.feature.loan.domain.Loan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    public Loan findByid(String id) {
        List<Loan> models = findAll();
        for (Loan model : models) {
            if (Objects.equals(model.id, id)) {
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
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el fichero.");
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

    public void delete(String modelid) {
        List<Loan> newList = new ArrayList<>();
        List<Loan> models = findAll();
        for (Loan model : models) {
            if (!model.id.equals(modelid)) {

                newList.add(model);
            }
        }
        saveList(newList);
    }

    public void modify(String id, Loan newLoan) {
        List<Loan> models = findAll();
        for (int i = 0; i < models.size(); i++) {
            Loan Loan = models.get(i);
            if (Objects.equals(Loan.id, id)) {
                // Reemplazar el usuario antiguo con el nuevo usuario
                models.set(i, newLoan);
                saveList(models);
                System.out.println("Usuario modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún usuario con el id proporcionado.");
    }

    public void getFinishedLoan(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        List<Loan> lista = findAll();

        Date fechaHoy = new Date();

        try{

            for(Loan loan : lista){
                Date fechaFin = formato.parse(loan.getFechaEnd());
                if(fechaFin.before(fechaHoy)){
                    System.out.println(loan);
                }
            }

        }catch (ParseException e){
            System.out.println(e.getMessage());
        }

    }


}
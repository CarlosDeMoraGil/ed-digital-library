package com.iesam.digitallibrary.feature;

import com.iesam.digitallibrary.feature.user.presentation.UserMain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = -1;

        while(opcion != 0){

            System.out.println(" ");
            System.out.println("---BIBLIOTECA---");

            System.out.println("0. Salir");
            System.out.println("1. Añadir Usuario");
            System.out.println("2. Borrar Usuario");

            System.out.println("Selecciona una opcion: ");
            opcion = sc.nextInt();
            
            switch (opcion){

                case 1:
                    UserMain.addUser();
                    break;

                case 2:
                    UserMain.deleteUser();
                    break;

            }

        }

    }
}
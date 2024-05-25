package com.iesam.digitallibrary.feature;

import com.iesam.digitallibrary.feature.loan.presentation.LoanMain;
import com.iesam.digitallibrary.feature.resource.presentation.ResourceMain;
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
            System.out.println("1. Usuarios");
            System.out.println("2. Recursos");
            System.out.println("3. Loan");

            System.out.println("Selecciona una opcion: ");
            opcion = sc.nextInt();
            
            switch (opcion) {

                case 1:
                    System.out.println("---USUARIOS---");
                    System.out.println("1. Añadir Usuario");
                    System.out.println("2. Borrar Usuario");
                    System.out.println("3. Modificar Usuario");
                    System.out.println("4. Mostrar Usuarios");
                    System.out.println("Selecciona una opcion: ");
                    opcion = sc.nextInt();

                    switch (opcion) {

                        case 1:
                            UserMain.addUser();
                            break;
                        case 2:
                            UserMain.deleteUser();
                            break;

                        case 3:
                            UserMain.modifyUser();
                            break;

                        case 4:
                            UserMain.getUsers();
                            break;

                    }

                    break;
                case 2:
                    System.out.println("---RECURSOS---");
                    System.out.println("1. Libros");
                    System.out.println("2. Música");
                    System.out.println("Selecciona una opcion: ");
                    opcion = sc.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("---LIBROS---");
                            System.out.println("1. Añadir Libro");
                            System.out.println("2. Borrar Libro");
                            System.out.println("3. Modificar Libro");
                            System.out.println("4. Mostrar Libros");
                            System.out.println("Selecciona una opcion: ");
                            opcion = sc.nextInt();

                            switch (opcion) {
                                case 1:
                                    ResourceMain.addDigitalBook();
                                    break;

                                case 2:
                                    ResourceMain.deleteDigitalBook();
                                    break;

                                case 3:
                                    ResourceMain.modifyDigitalBook();
                                    break;

                                case 4:
                                    ResourceMain.getDigittalBooks();
                                    break;
                            }

                        case 2:
                            System.out.println("---MÚSICA---");
                            System.out.println("1. Añadir Música");
                            System.out.println("2. Borrar Música");
                            System.out.println("3. Modificar Música");
                            System.out.println("4. Mostrar Música");
                            System.out.println("Selecciona una opcion: ");
                            opcion = sc.nextInt();

                            switch (opcion) {
                                case 1:
                                    ResourceMain.addMusic();
                                    break;

                                case 2:
                                    ResourceMain.deleteMusic();
                                    break;

                                case 3:
                                    ResourceMain.modifyMusic();
                                    break;

                                case 4:
                                    ResourceMain.getMusic();
                                    break;
                            }

                            break;
                    }
                    break;

                case 3:
                    System.out.println("---PRESTAMOS---");
                    System.out.println("1. Añadir Prestamo");
                    System.out.println("2. Borrar Prestamo");
                    System.out.println("3. Mostrar Prestamos Finalizados");
                    System.out.println("4. Mostrar Prestamos No Finalizados");
                    System.out.println("Selecciona una opcion: ");
                    opcion = sc.nextInt();

                    switch (opcion) {
                        case 1:
                            LoanMain.addLoan();
                            break;

                        case 2:
                            LoanMain.deleteLoan();
                            break;

                        case 3:
                            LoanMain.getFinishedLoan();
                            break;

                        case 4:
                            LoanMain.getUnfinishedLoan();
                            break;
                    }
                    break;

            }
        }

    }
}
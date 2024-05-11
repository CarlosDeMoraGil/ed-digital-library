package com.iesam.digitallibrary.feature;

import com.iesam.digitallibrary.feature.digitalBook.presentation.DigitalBookMain;
import com.iesam.digitallibrary.feature.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.feature.loan.presentation.LoanMain;
import com.iesam.digitallibrary.feature.user.presentation.UserMain;

import java.util.Date;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = -1;

        while(opcion != 0){

            System.out.println(" ");
            System.out.println("---BIBLIOTECA---");

            System.out.println("0. Salir");
            System.out.println("---USUARIOS---");
            System.out.println("1. Añadir Usuario");
            System.out.println("2. Borrar Usuario");
            System.out.println("3. Modificar Usuario");
            System.out.println("4. Mostrar Usuarios");
            System.out.println("---LIBROS---");
            System.out.println("5. Añadir Libro");
            System.out.println("6. Borrar Libro");
            System.out.println("7. Modificar Libro");
            System.out.println("8. Mostrar Libros");
            System.out.println("---PRESTAMOS---");
            System.out.println("9. Añadir Prestamo");
            System.out.println("10. Borrar Prestamo");

            System.out.println("Selecciona una opcion: ");
            opcion = sc.nextInt();
            
            switch (opcion){

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
                
                case 5:
                    DigitalBookMain.addDigitalBook();
                    break;

                case 6:
                    DigitalBookMain.deleteDigitalBook();
                    break;

                case 7:
                    DigitalBookMain.modifyDigitalBook();
                    break;

                case 8:
                    DigitalBookMain.getDigittalBooks();
                    break;

                case 9:
                    LoanMain.addLoan();
                    break;
                case 10:
                    LoanMain.deleteLoan();
                    break;
            }

        }

    }
}
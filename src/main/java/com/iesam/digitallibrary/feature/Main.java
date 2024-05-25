package com.iesam.digitallibrary.feature;

import com.iesam.digitallibrary.feature.resource.presentation.ResourceMain;
import com.iesam.digitallibrary.feature.loan.presentation.LoanMain;
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
            System.out.println("11. Mostrar Prestamos Finalizados");
            System.out.println("12. Mostrar Prestamos No Finalizados");
            System.out.println("---MÚSICA---");
            System.out.println("13. Añadir Música");
            System.out.println("14. Borrar Música");
            System.out.println("15. Modificar Música");
            System.out.println("16. Mostrar Música");



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
                    ResourceMain.addDigitalBook();
                    break;

                case 6:
                    ResourceMain.deleteDigitalBook();
                    break;

                case 7:
                    ResourceMain.modifyDigitalBook();
                    break;

                case 8:
                    ResourceMain.getDigittalBooks();
                    break;

                case 9:
                    LoanMain.addLoan();
                    break;
                case 10:
                    LoanMain.deleteLoan();
                    break;

                case 11:
                    LoanMain.getFinishedLoan();
                    break;

                case 12:
                    LoanMain.getUnfinishedLoan();
                    break;
                case 13:
                    ResourceMain.addMusic();
                    break;
                case 14:
                    ResourceMain.deleteMusic();
                    break;
                case 15:
                    ResourceMain.modifyMusic();
                    break;
                case 16:
                    ResourceMain.getMusic();
                    break;
            }

        }

    }
}
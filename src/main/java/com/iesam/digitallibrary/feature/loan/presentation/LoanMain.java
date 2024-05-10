package com.iesam.digitallibrary.feature.loan.presentation;

import com.iesam.digitallibrary.feature.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.feature.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.feature.loan.domain.CreateLoanUseCase;
import com.iesam.digitallibrary.feature.loan.domain.Loan;
import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.Scanner;

public class LoanMain {

    static Scanner sc = new Scanner(System.in);
    public static void addUser(){

        System.out.println("---AÑADIR PRESTAMO---");

        System.out.println("Introduce el ID: ");
        String loanId = sc.nextLine();

        System.out.println("---INFORMACION DEL USUARIO---");
        System.out.println("Introduce el ID: ");
        String id = sc.nextLine();

        System.out.println("Introduce el nombre: ");
        String userName = sc.nextLine();

        System.out.println("Introduce el apellido: ");
        String surname = sc.nextLine();

        System.out.println("Introduce la fecha de nacimiento (DD-MM-YYYY): ");
        String dateBorn = sc.nextLine();

        System.out.println("Introduce el correo electrónico: ");
        String email = sc.nextLine();

        System.out.println("Introduce la dirección: ");
        String address = sc.nextLine();

        System.out.println("Introduce el número de teléfono: ");
        String number = sc.nextLine();

        System.out.println("---INFORMACION DEL LIBRO---");
        System.out.println("Introduce el ISBN: ");
        String isbn = sc.nextLine();

        System.out.println("Introduce el nombre: ");
        String name = sc.nextLine();

        System.out.println("Introduce el autor: ");
        String author = sc.nextLine();

        System.out.println("Introduce la fecha de publicacion (DD-MM-YYYY): ");
        String relaseDate = sc.nextLine();

        System.out.println("Introduce la editorial: ");
        String publisher = sc.nextLine();


        User user = new User(id, userName, surname, dateBorn, email, address, number);
        DigitalBook digitalBook = new DigitalBook(isbn, name, author, publisher, relaseDate);
        Loan loan = new Loan(loanId, user, digitalBook,"15/3/2024", "15/4/2024");
        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        createLoanUseCase.execute(loan);

    }

}

package com.iesam.digitallibrary.feature.loan.presentation;

import com.iesam.digitallibrary.feature.digitalBook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.feature.digitalBook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.feature.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalBook.domain.GetDigitalBookUseCase;
import com.iesam.digitallibrary.feature.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.feature.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.feature.loan.domain.*;

import com.iesam.digitallibrary.feature.loan.domain.GetFinishedLoanUseCase;
import com.iesam.digitallibrary.feature.loan.domain.Loan;
import com.iesam.digitallibrary.feature.user.data.UserDataRepository;
import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.GetUserUseCase;
import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.Scanner;

public class LoanMain {

    static Scanner sc = new Scanner(System.in);
    public static void addLoan(){

        System.out.println("---AÑADIR PRESTAMO---");

        System.out.println("Introduce el ID: ");
        String loanId = sc.nextLine();

        System.out.println("---INFORMACION USUARIO---");
        System.out.println("Introduce el ID: ");
        String id = sc.nextLine();

        GetUserUseCase getUserUseCase = new GetUserUseCase(new UserDataRepository(new UserFileLocalDataSource()));
        User user = getUserUseCase.execute(id);

        System.out.println("---INFORMACION LIBRO---");
        System.out.println("Introduce el ISBN: ");
        String isbn = sc.nextLine();

        GetDigitalBookUseCase GetDigitalBookUseCase = new GetDigitalBookUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        DigitalBook digitalBook = GetDigitalBookUseCase.execute(isbn);

        Loan loan = new Loan(loanId, user, digitalBook,"15/06/2024");
        Loan loan = new Loan(loanId, user, digitalBook,"01/04/2024");

        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        createLoanUseCase.execute(loan);

    }

    public static void deleteLoan(){

        System.out.println("---BORRAR PRESTAMO---");
        System.out.println("Introduce el ID: ");
        String id = sc.nextLine();

        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        deleteLoanUseCase.execute(id);

    }

    public static void getFinishedLoan(){

        System.out.println("---PRESTAMOS FINALIZADOS---");

        GetFinishedLoanUseCase getFinishedLoanUseCase = new GetFinishedLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource())) ;
        getFinishedLoanUseCase.execute();

    }

    public static void getUnfinishedLoan(){

        System.out.println("---PRESTAMOS NO FINALIZADOS---");

        GetUnfinichedLoansUseCase getUnfinichedLoansUseCase = new GetUnfinichedLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        getUnfinichedLoansUseCase.execute();



    }

}

package com.iesam.digitallibrary.feature.loan.presentation;

import com.iesam.digitallibrary.feature.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.feature.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.feature.loan.domain.CreateLoanUseCase;
import com.iesam.digitallibrary.feature.loan.domain.Loan;
import com.iesam.digitallibrary.feature.user.data.UserDataRepository;
import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.CreateUserUserCase;
import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.Scanner;

public class LoanMain {

    static Scanner sc = new Scanner(System.in);
    public static void addUser(){

        System.out.println("---AÑADIR PRESTAMO---");
        System.out.println("Introduce el ID: ");
        String id = sc.nextLine();

        System.out.println("Introduce el UserId: ");
        String userId = sc.nextLine();

        System.out.println("Introduce el ISBN: ");
        String isbn = sc.nextLine();

        Loan loan = new Loan(id, userId, isbn,"15/3/2024", "15/4/2024");
        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        createLoanUseCase.execute(loan);

    }

}

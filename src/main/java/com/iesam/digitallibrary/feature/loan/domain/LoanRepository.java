package com.iesam.digitallibrary.feature.loan.domain;

public interface LoanRepository {

    void addLoan(Loan loan);
    void deleteLoan(String id);
    void getFinishedLoans();
    void getUnfinishedLoans();

}

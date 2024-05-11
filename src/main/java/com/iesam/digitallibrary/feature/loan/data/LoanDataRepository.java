package com.iesam.digitallibrary.feature.loan.data;

import com.iesam.digitallibrary.feature.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.feature.loan.domain.Loan;
import com.iesam.digitallibrary.feature.loan.domain.LoanRepository;

public class LoanDataRepository implements LoanRepository {

    private LoanFileLocalDataSource loanFileLocalDataSource;

    public LoanDataRepository(LoanFileLocalDataSource loanFileLocalDataSource) {
        this.loanFileLocalDataSource = loanFileLocalDataSource;
    }

    @Override
    public void addLoan(Loan loan) {
        loanFileLocalDataSource.save(loan);
    }
  
    @Override
    public void deleteLoan(String id) {
        loanFileLocalDataSource.delete(id);
    }

    @Override
    public void getFinishedLoans() {
        loanFileLocalDataSource.getFinishedLoan();
    }

}

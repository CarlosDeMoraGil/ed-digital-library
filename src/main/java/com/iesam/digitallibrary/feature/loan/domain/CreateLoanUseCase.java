package com.iesam.digitallibrary.feature.loan.domain;

public class CreateLoanUseCase {

    private LoanRepository loanRepository;

    public CreateLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(Loan loan){
        this.loanRepository.addLoan(loan);
    }

}

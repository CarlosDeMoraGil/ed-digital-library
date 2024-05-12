package com.iesam.digitallibrary.feature.loan.domain;

public class GetFinishedLoanUseCase {

    private LoanRepository loanRepository;

    public GetFinishedLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(){
        this.loanRepository.getFinishedLoans();
    }

}

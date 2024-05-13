package com.iesam.digitallibrary.feature.loan.domain;

public class GetUnfinichedLoansUseCase {

    private LoanRepository loanRepository;

    public GetUnfinichedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(){
        this.loanRepository.getUnfinishedLoans();
    }

}

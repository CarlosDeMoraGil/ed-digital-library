package com.iesam.digitallibrary.feature.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetUnfinichedLoansUseCaseTest {

    @Mock
    LoanRepository loanRepository;
    GetUnfinichedLoansUseCase getUnFinishedLoanUseCase;

    @BeforeEach
    void setUp() {
        getUnFinishedLoanUseCase = new GetUnfinichedLoansUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        getUnFinishedLoanUseCase = null;
    }

    @Test
    public void reciboTodosLosPrestamosNoFinalizados(){

        //Given

        //When
        getUnFinishedLoanUseCase.execute();

        //Then
        Mockito.verify(loanRepository, Mockito.times(1)).getUnfinishedLoans();

    }

}
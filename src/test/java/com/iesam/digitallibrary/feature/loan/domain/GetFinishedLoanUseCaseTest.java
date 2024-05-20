package com.iesam.digitallibrary.feature.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetFinishedLoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;
    GetFinishedLoanUseCase getFinishedLoanUseCase;

    @BeforeEach
    void setUp() {
        getFinishedLoanUseCase = new GetFinishedLoanUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        getFinishedLoanUseCase = null;
    }

    @Test
    public void reciboTodosLosPrestamosFinalizados(){

        //Given

        //When
        getFinishedLoanUseCase.execute();

        //Then
        Mockito.verify(loanRepository, Mockito.times(1)).getFinishedLoans();

    }

}
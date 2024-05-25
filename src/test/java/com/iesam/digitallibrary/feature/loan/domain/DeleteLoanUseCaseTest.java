package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteLoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;
    DeleteLoanUseCase deleteLoanUseCase;

    @BeforeEach
    void setUp() {
        deleteLoanUseCase = new DeleteLoanUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        deleteLoanUseCase = null;
    }

    @Test
    public void reciboUnIdYBorroElPrestamo(){

        //Given
        DigitalBook music = new DigitalBook("1234abcd","The Woman In Me","Britney Spears","25/10/2023","Santillana");
        User user = new User("1","Carlos","DMG","04/09/2005","carlos@gmail.com","Calle 31","640");
        Loan loan = new Loan("1001",user, music,"25/06/2024");

        //When
        deleteLoanUseCase.execute("1001");

        //Then
        Mockito.verify(loanRepository, Mockito.times(1)).deleteLoan("1001");

    }

}
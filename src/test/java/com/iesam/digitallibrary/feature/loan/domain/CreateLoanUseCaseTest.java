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
class CreateLoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;
    CreateLoanUseCase createLoanUseCase;

    @BeforeEach
    void setUp() {
        createLoanUseCase = new CreateLoanUseCase(loanRepository);
    }

    @AfterEach
    void tearDown() {
        createLoanUseCase = null;
    }

    @Test
    public void reciboUnPrestamoYLoGuardo(){

        //Given
        DigitalBook digitalBook = new DigitalBook("1234abcd","The Woman In Me","Britney Spears","25/10/2023","Santillana");
        User user = new User("1","Carlos","DMG","04/09/2005","carlos@gmail.com","Calle 31","640");
        Loan loan = new Loan("1001",user,digitalBook,"25/06/2024");

        //When
        createLoanUseCase.execute(loan);

        //Then
        Mockito.verify(loanRepository, Mockito.times(1)).addLoan(loan);

    }

}
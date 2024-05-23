package com.iesam.digitallibrary.feature.digitalBook.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetDigitalBooksUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;
    GetDigitalBooksUseCase getDigitalBooksUseCase;

    @BeforeEach
    void setUp() {
        getDigitalBooksUseCase = new GetDigitalBooksUseCase(digitalBookRepository);
    }

    @AfterEach
    void tearDown() {
        getDigitalBooksUseCase = null;
    }

    @Test
    public void returnAllSavedBooks(){

        //Given


        //When
        getDigitalBooksUseCase.execute();

        //Then
        Mockito.verify(digitalBookRepository,Mockito.times(1)).getDigitalBooks();

    }
}
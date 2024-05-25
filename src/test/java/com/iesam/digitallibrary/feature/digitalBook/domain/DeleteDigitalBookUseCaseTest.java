package com.iesam.digitallibrary.feature.digitalBook.domain;

import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DeleteDigitalBookUseCase;
import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DigitalBookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DeleteDigitalBookUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;
    DeleteDigitalBookUseCase deleteDigitalBookUseCase;

    @BeforeEach
    void setUp() {
        deleteDigitalBookUseCase = new DeleteDigitalBookUseCase(digitalBookRepository);
    }

    @AfterEach
    void tearDown() {
        deleteDigitalBookUseCase = null;
    }

    @Test
    public void givenBookIsbnThenDeleteBook(){

        //Given
        DigitalBook digitalBook = new DigitalBook("1234abcd","The Woman In Me","Britney Spears","25/10/2023","Santillana");

        //When
        deleteDigitalBookUseCase.execute("1234abcd");

        //Then
        Mockito.verify(digitalBookRepository, Mockito.times(1)).deleteDigitalBook("1234abcd");

    }

}
package com.iesam.digitallibrary.feature.digitalBook.domain;

import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DigitalBookRepository;
import com.iesam.digitallibrary.feature.resource.digitalBook.domain.ModifyDigitalBookUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ModifyDigitalBookUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;
    ModifyDigitalBookUseCase modifyDigitalBookUseCase;

    @BeforeEach
    void setUp() {
        modifyDigitalBookUseCase = new ModifyDigitalBookUseCase(digitalBookRepository);
    }

    @AfterEach
    void tearDown() {
        modifyDigitalBookUseCase = null;
    }

    @Test
    public void givenValidIdAndBookReturnModifyBook(){

        //Given
        DigitalBook book = new DigitalBook("1234abcd","The Woman In Me","Britney Spears","Santillana","25/10/2023");
        DigitalBook bookModified = new DigitalBook("1234abcd","La Vida De Pi","Pi","Anaya","17/07/1990");

        //When
        modifyDigitalBookUseCase.execute("1234abcd", bookModified);

        //Then
        Mockito.verify(digitalBookRepository, Mockito.times(1)).modifyDigitalBook("1234abcd", bookModified);
    }

}
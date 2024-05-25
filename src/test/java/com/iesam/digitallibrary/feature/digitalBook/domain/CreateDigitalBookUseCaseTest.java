package com.iesam.digitallibrary.feature.digitalBook.domain;

import com.iesam.digitallibrary.feature.resource.digitalBook.domain.CreateDigitalBookUseCase;
import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DigitalBookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateDigitalBookUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;
    CreateDigitalBookUseCase createDigitalBookUseCase;

    @BeforeEach
    void setUp() {
        createDigitalBookUseCase = new CreateDigitalBookUseCase(digitalBookRepository);
    }

    @AfterEach
    void tearDown() {
        digitalBookRepository = null;
    }

    @Test
    public void givenBookThenSaveBook(){

        //Given
        DigitalBook digitalBook = new DigitalBook("1234abcd","The Woman In Me","Britney Spears","25/10/2023","Santillana");

        //When
        createDigitalBookUseCase.execute(digitalBook);

        //Then
        Mockito.verify(digitalBookRepository, Mockito.times(1)).addDigitalBook(digitalBook);

    }

}
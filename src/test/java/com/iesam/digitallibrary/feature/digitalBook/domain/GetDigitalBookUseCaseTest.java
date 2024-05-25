package com.iesam.digitallibrary.feature.digitalBook.domain;


import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.resource.digitalBook.domain.DigitalBookRepository;
import com.iesam.digitallibrary.feature.resource.digitalBook.domain.GetDigitalBookUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetDigitalBookUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;
    GetDigitalBookUseCase getDigitalBookUseCase;

    @BeforeEach
    void setUp() {
        getDigitalBookUseCase = new  GetDigitalBookUseCase(digitalBookRepository);
    }

    @AfterEach
    void tearDown() {
        getDigitalBookUseCase = null;
    }  
    
    @Test
    public void givenValidIsbnThenReturnExpectedBook(){
        
        //Given
        DigitalBook bookExpected = new DigitalBook("1234abcd","The Woman In Me","Britney Spears","Santillana","25/10/2023");
        Mockito.when(digitalBookRepository.getDigitalBook("1234abcd")).thenReturn(bookExpected);
        
        //When
        DigitalBook bookRecived = getDigitalBookUseCase.execute("1234abcd");
        
        //Then
        Assertions.assertEquals(bookExpected.getIsbn(), "1234abcd");
        Assertions.assertEquals(bookExpected.getTitle(), "The Woman In Me");
        Assertions.assertEquals(bookExpected.getAuthor(), "Britney Spears");
        Assertions.assertEquals(bookExpected.getReleaseDate(), "25/10/2023");
        Assertions.assertEquals(bookExpected.getPublisher(), "Santillana");
        
    }

    @Test
    public void givenNotValidIdThenNullIsReturned(){
        //Given
        DigitalBook notValidBook = new DigitalBook("1234abcd","The Woman In Me","Britney Spears","Santillana","25/10/2023");
        Mockito.when(digitalBookRepository.getDigitalBook("1234abcd")).thenReturn(null);
        //When
        DigitalBook bookRecived = getDigitalBookUseCase.execute(notValidBook.getIsbn());
        //Then
        Assertions.assertNull(bookRecived);
    }
    
}
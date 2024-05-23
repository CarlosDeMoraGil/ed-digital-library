package com.iesam.digitallibrary.feature.digitalBook.domain;


import com.iesam.digitallibrary.feature.user.domain.User;
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
    GetDigitalBookUseCase  getDigitalBookUseCase;

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
        Assertions.assertEquals(bookExpected.isbn, "1234abcd");
        Assertions.assertEquals(bookExpected.name, "The Woman In Me");
        Assertions.assertEquals(bookExpected.author, "Britney Spears");
        Assertions.assertEquals(bookExpected.relaseDate, "25/10/2023");
        Assertions.assertEquals(bookExpected.publisher, "Santillana");
        
    }

    @Test
    public void givenNotValidIdThenNullIsReturned(){
        //Given
        DigitalBook notValidBook = new DigitalBook("1234abcd","The Woman In Me","Britney Spears","Santillana","25/10/2023");
        Mockito.when(digitalBookRepository.getDigitalBook("1234abcd")).thenReturn(null);
        //When
        DigitalBook bookRecived = getDigitalBookUseCase.execute(notValidBook.isbn);
        //Then
        Assertions.assertNull(bookRecived);
    }
    
}
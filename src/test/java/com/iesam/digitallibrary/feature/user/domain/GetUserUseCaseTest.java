package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetUserUseCaseTest {

    @Mock
    UserRepository userRepository;
    GetUserUseCase getUserUseCase;

    @BeforeEach
    void setUp() {
        getUserUseCase = new GetUserUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        getUserUseCase = null;
    }

    @Test
    public void givenValidIdThenReturnExpectedUser(){

        //Given
        User userExcepted = new User("1","Carlos","DMG","04/09/2005","carlos@gmail.com","Calle 31","640");
        Mockito.when(userRepository.getUser("1")).thenReturn(userExcepted);

        //When
        User userRecived = getUserUseCase.execute("1");

        //Then
        Assertions.assertEquals(userExcepted.id, "1");
        Assertions.assertEquals(userExcepted.name, "Carlos");
        Assertions.assertEquals(userExcepted.surname, "DMG");
        Assertions.assertEquals(userExcepted.dateBorn, "04/09/2005");
        Assertions.assertEquals(userExcepted.email, "carlos@gmail.com");
        Assertions.assertEquals(userExcepted.address, "Calle 31");
        Assertions.assertEquals(userExcepted.number, "640");

    }

    @Test
    public void givenNotValidIdThenNullIsReturned(){
        //Given
        User notValidUser = new User("1","Carlos","DMG","04/09/2005","carlos@gmail.com","Calle 31","640");
        Mockito.when(userRepository.getUser(notValidUser.getId())).thenReturn(null);
        //When
        User userReceived = getUserUseCase.execute(notValidUser.getId());
        //Then
        Assertions.assertNull(userReceived);
    }

}
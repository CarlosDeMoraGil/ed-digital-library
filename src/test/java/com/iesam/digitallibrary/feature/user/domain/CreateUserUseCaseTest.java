package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

    @Mock
    UserRepository userRepository;
    CreateUserUseCase createUserUseCase;

    @BeforeEach
    void setUp() {
        createUserUseCase = new CreateUserUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        createUserUseCase = null;
    }

    @Test
    public void givenUserThenSaveUser(){

        //Given
        User user = new User("1","Carlos","DMG","04/09/2005","carlos@gmail.com","Calle 31","640");

        //Whem
        createUserUseCase.execute(user);

        //Then
        Mockito.verify(userRepository, Mockito.times(1)).addUser(user);


    }

}
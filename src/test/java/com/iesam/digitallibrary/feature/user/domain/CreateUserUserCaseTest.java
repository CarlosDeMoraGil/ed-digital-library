package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateUserUserCaseTest {

    @Mock
    UserRepository userRepository;
    CreateUserUserCase createUserUserCase;

    @BeforeEach
    void setUp() {
        createUserUserCase = new CreateUserUserCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        createUserUserCase = null;
    }

    @Test
    public void reciboUnUsuarioYLoGuardo(){

        //Given
        User user = new User("1","Carlos","DMG","04/09/2005","carlos@gmail.com","Calle 31","640");

        //Whem
        createUserUserCase.execute(user);

        //Then
        Mockito.verify(userRepository, Mockito.times(1)).addUser(user);


    }

}
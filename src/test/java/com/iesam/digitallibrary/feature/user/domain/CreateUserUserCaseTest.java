package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void recivoUnUsuarioYLoGuardo() {
        //Given
        User user = new User("708","Carlos","de Mora Gil","04/09/2005","carlos@gmail.com","Calle 31","640");

        //When
        createUserUserCase.execute(user);

        //Then
        Mockito.verify(userRepository, Mockito.times(1)).addUser(user);

    }


}
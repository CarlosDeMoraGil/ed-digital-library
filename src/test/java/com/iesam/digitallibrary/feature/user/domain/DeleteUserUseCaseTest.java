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
class DeleteUserUseCaseTest {

    @Mock
    UserRepository userRepository;
    DeleteUserUseCase deleteUserUseCase;

    @BeforeEach
    void setUp() {
        deleteUserUseCase = new DeleteUserUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        deleteUserUseCase = null;
    }

    @Test
    void introduzcoUnIdValidoYBorraElUsuarioCorrecto() {

        //Given
        User user = new User("708","Carlos","de Mora Gil","04/09/2005","carlos@gmail.com","Calle 31","640");

        //When
        deleteUserUseCase.execute("708");

        //Then
        Mockito.verify(userRepository, Mockito.times(1)).deleteUser("708");

    }


}
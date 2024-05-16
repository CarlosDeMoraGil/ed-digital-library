package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteUserUseCaseTest {

    @Mock
    UserRepository userRepository;
    DeleteUserUseCase deleteUserUserCase;

    @BeforeEach
    public void setUp(){
        deleteUserUserCase = new DeleteUserUseCase(userRepository);

    }

    @AfterEach
    public void clear(){
        deleteUserUserCase = null;
    }

    @Test
    void reciboElIdDeUnUsuarioYLoBorro() {

        //Given
        User user = new User("708", "Carlos", "DMG", "04/09/2005", "carlos@gmail.com", "Calle 31", "640");

        //When
        deleteUserUserCase.execute("708");

        //Then
        Mockito.verify(userRepository, Mockito.times(1)).deleteUser("708");

    }

}
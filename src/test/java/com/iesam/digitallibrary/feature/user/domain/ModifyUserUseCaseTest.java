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
class ModifyUserUseCaseTest {

    @Mock
    UserRepository userRepository;
    ModifyUserUseCase modifyUserUseCase;

    @BeforeEach
    void setUp() {
        modifyUserUseCase = new ModifyUserUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        modifyUserUseCase = null;
    }

    @Test
    public void reciboUnUsuarioYLoGuardo(){

        //Given
        User user = new User("1","Carlos","DMG","04/09/2005","carlos@gmail.com","Calle 31","640");
        User userModify= new User("1","Carlos","Gil","04/09/2000","carlos@yahoo.com","Calle 65","984");


        //Whem
        modifyUserUseCase.execute("1",userModify);

        //Then
        Mockito.verify(userRepository, Mockito.times(1)).modifyUser("1",userModify);


    }

}
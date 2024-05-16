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
class GetUsersUseCaseTest {

    @Mock
    UserRepository userRepository;
    GetUsersUseCase getUsersUseCase;

    @BeforeEach
    void setUp() {
        getUsersUseCase = new GetUsersUseCase(userRepository);
    }

    @AfterEach
    void tearDown() {
        getUsersUseCase = null;
    }

    @Test
    public void reciboTodosLosUsuariosAlmacenados(){

        //Given ¿?


        //Whem
        getUsersUseCase.execeute();

        //Then
        Mockito.verify(userRepository,Mockito.times(1)).getUsers();

    }

}
package com.iesam.digitallibrary.feature.user.presentation;

import com.iesam.digitallibrary.feature.user.data.UserDataRepository;
import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.*;

import java.util.Scanner;

public class UserMain {

    static Scanner sc = new Scanner(System.in);

    public static void addUser(){

        System.out.println("---CREAR USUARIO---");
        System.out.println("Introduce el ID: ");
        String id = sc.nextLine();

        System.out.println("Introduce el nombre: ");
        String name = sc.nextLine();

        System.out.println("Introduce el apellido: ");
        String surname = sc.nextLine();

        System.out.println("Introduce la fecha de nacimiento (DD-MM-YYYY): ");
        String dateBorn = sc.nextLine();

        System.out.println("Introduce el correo electrónico: ");
        String email = sc.nextLine();

        System.out.println("Introduce la dirección: ");
        String address = sc.nextLine();

        System.out.println("Introduce el número de teléfono: ");
        String number = sc.nextLine();

        User user = new User(id, name, surname, dateBorn, email, address, number);
        CreateUserUserCase createUserUserCase = new CreateUserUserCase( new UserDataRepository(new UserFileLocalDataSource()));
        createUserUserCase.execute(user);

        UserFileLocalDataSource.save(user);

    }

}

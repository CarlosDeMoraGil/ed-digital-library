package com.iesam.digitallibrary.feature.digitalBook.presentation;

import com.iesam.digitallibrary.feature.digitalBook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.feature.digitalBook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.feature.digitalBook.domain.CreateDigitalBookUseCase;
import com.iesam.digitallibrary.feature.digitalBook.domain.DeleteDigitalBookUseCase;
import com.iesam.digitallibrary.feature.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalBook.domain.ModifyDigitalBookUseCase;

import java.util.Scanner;

public class DigitalBookMain {

    static Scanner sc = new Scanner(System.in);

    public static void addDigitalBook(){

        System.out.println("---AÑADIR LIBRO DIGITAL---");
        System.out.println("Introduce el ISBN: ");
        String isbn = sc.nextLine();

        System.out.println("Introduce el nombre: ");
        String name = sc.nextLine();

        System.out.println("Introduce el autor: ");
        String author = sc.nextLine();

        System.out.println("Introduce la fecha de publicacion (DD-MM-YYYY): ");
        String relaseDate = sc.nextLine();

        System.out.println("Introduce la editorial: ");
        String publisher = sc.nextLine();

        DigitalBook digitalBook = new DigitalBook(isbn, name, author, publisher, relaseDate);
        CreateDigitalBookUseCase createDigitalBookUseCase = new CreateDigitalBookUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        createDigitalBookUseCase.execute(digitalBook);

    }

    public static void deleteDigitalBook(){

        System.out.println("---BORRAR LIBRO DIGIRAL---");
        System.out.println("Introduce el ISBN: ");
        String isbn = sc.nextLine();

        DeleteDigitalBookUseCase deleteDigitalBookUseCase = new DeleteDigitalBookUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        deleteDigitalBookUseCase.execute(isbn);

    }

    public static void modifyDigitalBook(){

        System.out.println("---MODIFICAR LIBRO---");
        System.out.println("Introduce el ISBN: ");
        String isbn = sc.nextLine();

        System.out.println("Introduce el nombre: ");
        String name = sc.nextLine();

        System.out.println("Introduce el autor: ");
        String author = sc.nextLine();

        System.out.println("Introduce la fecha de publicacion (DD-MM-YYYY): ");
        String relaseDate = sc.nextLine();

        System.out.println("Introduce la editorial: ");
        String publisher = sc.nextLine();

        DigitalBook digitalBook = new DigitalBook(isbn, name, author, publisher, relaseDate);

        ModifyDigitalBookUseCase modifyUserUseCase = new ModifyDigitalBookUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        modifyUserUseCase.execute(isbn, digitalBook);


    }

}

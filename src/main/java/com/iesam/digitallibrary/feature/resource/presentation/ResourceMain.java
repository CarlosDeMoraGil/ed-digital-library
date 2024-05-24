package com.iesam.digitallibrary.feature.resource.presentation;

import com.iesam.digitallibrary.feature.resource.digitalBook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.feature.resource.digitalBook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.feature.resource.digitalBook.domain.*;

import java.util.Scanner;

public class ResourceMain {

    static Scanner sc = new Scanner(System.in);

    public static void addDigitalBook(){

        System.out.println("---AÑADIR LIBRO DIGITAL---");
        System.out.println("Introduce el ISBN: ");
        String isbn = sc.nextLine();

        System.out.println("Introduce el titulo: ");
        String title = sc.nextLine();

        System.out.println("Introduce el autor: ");
        String author = sc.nextLine();

        System.out.println("Introduce la fecha de publicacion (DD-MM-YYYY): ");
        String relaseDate = sc.nextLine();

        System.out.println("Introduce la editorial: ");
        String publisher = sc.nextLine();

        DigitalBook digitalBook = new DigitalBook(isbn, title, author, publisher, relaseDate);
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

        ModifyDigitalBookUseCase modifyDigitalBookUseCase = new ModifyDigitalBookUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        modifyDigitalBookUseCase.execute(isbn, digitalBook);
    }

    public static void getDigittalBooks(){

        System.out.println("---LISTA DE LIBROS---");

        GetDigitalBooksUseCase getDigitalBooksUseCase = new GetDigitalBooksUseCase(new DigitalBookDataRepository(new DigitalBookFileLocalDataSource()));
        getDigitalBooksUseCase.execute();
    }


}

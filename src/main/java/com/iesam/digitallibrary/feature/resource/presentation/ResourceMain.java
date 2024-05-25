package com.iesam.digitallibrary.feature.resource.presentation;

import com.iesam.digitallibrary.feature.resource.music.data.MusicDataRepository;
import com.iesam.digitallibrary.feature.resource.music.data.local.MusicFileLocalDataSource;
import com.iesam.digitallibrary.feature.resource.music.domain.*;

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

    public static void addMusic(){

        System.out.println("---AÑADIR MÚSICA DIGITAL---");
        System.out.println("Introduce el ISRC (CC-XXX-YY-NNNNN): ");
        String isrc = sc.nextLine();

        System.out.println("Introduce el titulo: ");
        String title = sc.nextLine();

        System.out.println("Introduce el autor: ");
        String author = sc.nextLine();

        System.out.println("Introduce el album: ");
        String album = sc.nextLine();

        System.out.println("Introduce la duracion: ");
        String duration = sc.nextLine();
        
        System.out.println("Introduce la fecha de publicacion (DD-MM-YYYY): ");
        String relaseDate = sc.nextLine();

        Music music = new Music(isrc, title, author, album, duration, relaseDate);
        CreateMusicUseCase createMusicUseCase = new CreateMusicUseCase(new MusicDataRepository(new MusicFileLocalDataSource()));
        createMusicUseCase.execute(music);

    }

    public static void deleteMusic(){

        System.out.println("---BORRAR MÚSICA DIGIRAL---");
        System.out.println("Introduce el ISRC (CC-XXX-YY-NNNNN): ");
        String isrc = sc.nextLine();

        DeleteMusicUseCase deleteMusicUseCase = new DeleteMusicUseCase(new MusicDataRepository(new MusicFileLocalDataSource()));
        deleteMusicUseCase.execute(isrc);

    }

    public static void modifyMusic(){

        System.out.println("---AÑADIR MÚSICA DIGITAL---");
        System.out.println("Introduce el ISRC (CC-XXX-YY-NNNNN): ");
        String isrc = sc.nextLine();

        System.out.println("Introduce el titulo: ");
        String title = sc.nextLine();

        System.out.println("Introduce el autor: ");
        String author = sc.nextLine();

        System.out.println("Introduce el album: ");
        String album = sc.nextLine();

        System.out.println("Introduce la duracion: ");
        String duration = sc.nextLine();

        System.out.println("Introduce la fecha de publicacion (DD-MM-YYYY): ");
        String relaseDate = sc.nextLine();

        Music music = new Music(isrc, title, author, album, duration, relaseDate);

        ModifyMusicUseCase modifyMusicUseCase = new ModifyMusicUseCase(new MusicDataRepository(new MusicFileLocalDataSource()));
        modifyMusicUseCase.execute(isrc, music);
    }

    public static void getMusic(){

        System.out.println("---LISTA DE MÚSICA---");

        GetMusicsUseCase getMusicsUseCase = new GetMusicsUseCase(new MusicDataRepository(new MusicFileLocalDataSource()));
        getMusicsUseCase.execute();
    }


}

package com.iesam.digitallibrary.feature.digitalBook.domain;


public interface DigitalBookRepository {

    void addDigitalBook(DigitalBook digitalBook);
    void deleteDigitalBook(String isbn);
    void modifyDigitalBook(String isbn, DigitalBook digitalBook);
    void getDigitalBooks();
    DigitalBook getUser(String id);
}

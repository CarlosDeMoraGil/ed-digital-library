package com.iesam.digitallibrary.feature.resource.digitalBook.domain;


public interface DigitalBookRepository {

    void addDigitalBook(DigitalBook digitalBook);
    void deleteDigitalBook(String isbn);
    void modifyDigitalBook(String isbn, DigitalBook digitalBook);
    void getDigitalBooks();
    DigitalBook getDigitalBook(String id);
}

package com.iesam.digitallibrary.feature.digitalBook.data;

import com.iesam.digitallibrary.feature.digitalBook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.feature.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalBook.domain.DigitalBookRepository;

public class DigitalBookDataRepository implements DigitalBookRepository {


    private DigitalBookFileLocalDataSource digitalBookFileLocalDataSource;

    public DigitalBookDataRepository(DigitalBookFileLocalDataSource digitalBookFileLocalDataSource) {
        this.digitalBookFileLocalDataSource = digitalBookFileLocalDataSource;
    }


    @Override
    public void addDigitalBook(DigitalBook digitalBook) {
        digitalBookFileLocalDataSource.save(digitalBook);
    }

    @Override
    public void deleteDigitalBook(String isbn) {
        digitalBookFileLocalDataSource.delete(isbn);
    }
    @Override
    public void modifyDigitalBook(String isbn, DigitalBook digitalBook) {
        digitalBookFileLocalDataSource.modify(isbn, digitalBook);
    }

    @Override
    public void getDigitalBooks() {
        digitalBookFileLocalDataSource.getAll();
    }

    @Override
    public DigitalBook getUser(String isbn) {
        return digitalBookFileLocalDataSource.findByisbn(isbn);
    }

}
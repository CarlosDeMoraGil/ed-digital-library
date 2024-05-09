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

}
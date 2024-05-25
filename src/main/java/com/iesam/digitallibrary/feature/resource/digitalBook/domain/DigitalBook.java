package com.iesam.digitallibrary.feature.resource.digitalBook.domain;

import com.iesam.digitallibrary.feature.resource.domain.Resource;

public class DigitalBook extends Resource {

    private final String isbn;
    private final String publisher;

    public DigitalBook(String isbn, String title, String author, String publisher, String releaseDate) {
        super(title, author, releaseDate);
        this.isbn = isbn;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Digital Book" + '\n' +
                " id  = " + getId() + '\n' +
                " isbn  = " + isbn + '\n' +
                " name = " + getTitle() + '\n' +
                " author = " + getAuthor() + '\n' +
                " publisher = " + publisher + '\n' +
                " releaseDate = " + getReleaseDate() + '\n';
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

}

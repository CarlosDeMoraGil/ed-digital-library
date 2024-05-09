package com.iesam.digitallibrary.feature.digitalBook.domain;

import java.io.Serializable;

public class DigitalBook implements Serializable {
    
    public final String isbn;
    public final String name;
    public final String author;
    public final String publisher;
    public final String relaseDate;

    public DigitalBook(String isbn, String name, String author, String publisher, String relaseDate) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.relaseDate = relaseDate;
    }

    @Override
    public String toString() {
        return "User" +
                " isbn  = " + isbn + '\n' +
                " name = " + name + '\n' +
                " author = " + author + '\n' +
                " relaseDate = " + relaseDate + '\n';
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getauthor() {
        return author;
    }

    public String getpublisher() {
        return publisher;
    }


    public String getrelaseDate() {
        return relaseDate;
    }


}

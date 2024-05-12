package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.digitalBook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.Date;

public class Loan {


    public final String id;

    public final User user;
    public final DigitalBook book;
    public final Date fechaInit = new Date();
    public final String fechaEnd;

    public Loan(String id, User user, DigitalBook book, String fechaEnd) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.fechaEnd = fechaEnd;
    }

    @Override
    public String toString() {
        return "Loan" +
                " Id  = " + id + '\n' +
                " User = " + user.toString() + '\n' +
                " Book = " + book.toString() + '\n' +
                " FechaInit = " + fechaInit + '\n' +
                " FechaEnd = " + fechaEnd + '\n';
    }


    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public DigitalBook getBook() {
        return book;
    }

    public Date getFechaInit() {
        return fechaInit;
    }

    public String getFechaEnd() {
        return fechaEnd;
    }
}

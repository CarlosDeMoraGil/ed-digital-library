package com.iesam.digitallibrary.feature.loan.domain;

import java.util.Date;

public class Loan {

    private final Date date = new Date();
    public final String id;
    public final String userId;
    public final String isbn;
    public final String fechaInit;
    public final String fechaEnd;

    public Loan(String id, String userId, String isbn, String fechaInit, String fechaEnd) {
        this.id = id;
        this.userId = userId;
        this.isbn = isbn;
        this.fechaInit = fechaInit;
        this.fechaEnd = fechaEnd;
    }

    @Override
    public String toString() {
        return "Loan" +
                " Id  = " + id + '\n' +
                " UserId = " + userId + '\n' +
                " Isbn = " + isbn + '\n' +
                " FechaInit = " + fechaInit + '\n' +
                " FechaEnd = " + fechaEnd + '\n';
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getFechaInit() {
        return fechaInit;
    }

    public String getFechaEnd() {
        return fechaEnd;
    }

    public Date getDate() {
        return date;
    }
}

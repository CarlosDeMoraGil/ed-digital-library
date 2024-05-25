package com.iesam.digitallibrary.feature.resource.domain;

public class Resource {

    private static int nextId = 0;
    private final int id;
    private final String title;
    private final String author;
    private final String releaseDate;

    public Resource(String title, String author, String releaseDate) {
        this.id = ++nextId;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}

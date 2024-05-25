package com.iesam.digitallibrary.feature.resource.music.domain;
import com.iesam.digitallibrary.feature.resource.domain.Resource;

public class Music extends Resource {

    public final String ISRC;
    public final String duration;
    public final String album;

    public Music(String ISRC, String title, String author, String album,String duration,  String releaseDate) {
        super(title, author, releaseDate);
        this.ISRC = ISRC;
        this.duration = duration;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Music" + '\n' +
                " id  = " + getId() + '\n' +
                " isbn  = " + ISRC + '\n' +
                " name = " + getTitle() + '\n' +
                " name = " + getTitle() + '\n' +
                " name = " + album + '\n' +
                " author = " + duration + '\n' +
                " releaseDate = " + getReleaseDate() + '\n';
    }

    public String getISRC() {
        return ISRC;
    }

    public String getDuration() {
        return duration;
    }

    public String getAlbum() {
        return album;
    }
}

package com.iesam.digitallibrary.feature.resource.music.domain;


public interface MusicRepository {

    void addMusic(Music music);
    void deleteMusic(String isbn);
    void modifyMusic(String isbn, Music music);
    void getMusics();
    Music getMusic(String isbn);
}

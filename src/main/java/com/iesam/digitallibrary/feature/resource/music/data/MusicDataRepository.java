package com.iesam.digitallibrary.feature.resource.music.data;

import com.iesam.digitallibrary.feature.resource.music.data.local.MusicFileLocalDataSource;
import com.iesam.digitallibrary.feature.resource.music.domain.Music;
import com.iesam.digitallibrary.feature.resource.music.domain.MusicRepository;

public class MusicDataRepository implements MusicRepository {


    private MusicFileLocalDataSource MusicFileLocalDataSource;

    public MusicDataRepository(MusicFileLocalDataSource MusicFileLocalDataSource) {
        this.MusicFileLocalDataSource = MusicFileLocalDataSource;
    }


    @Override
    public void addMusic(Music music) {
        MusicFileLocalDataSource.save(music);
    }

    @Override
    public void deleteMusic(String iscr) {
        MusicFileLocalDataSource.delete(iscr);
    }
    @Override
    public void modifyMusic(String iscr, Music music) {
        MusicFileLocalDataSource.modify(iscr, music);
    }

    @Override
    public void getMusics() {
        MusicFileLocalDataSource.getAll();
    }

    @Override
    public Music getMusic(String iscr) {
        return MusicFileLocalDataSource.findByiscr(iscr);
    }

}
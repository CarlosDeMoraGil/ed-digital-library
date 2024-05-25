package com.iesam.digitallibrary.feature.resource.music.domain;


public class GetMusicUseCase {

    private MusicRepository musicRepository;

    public GetMusicUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public Music execute (String id){
        return this.musicRepository.getMusic(id);
    }

}

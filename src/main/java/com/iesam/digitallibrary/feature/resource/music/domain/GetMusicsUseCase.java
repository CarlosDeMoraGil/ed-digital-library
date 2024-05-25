package com.iesam.digitallibrary.feature.resource.music.domain;


public class GetMusicsUseCase {

    private MusicRepository musicRepository;

    public GetMusicsUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public void execute(){
        this.musicRepository.getMusics();
    }

}

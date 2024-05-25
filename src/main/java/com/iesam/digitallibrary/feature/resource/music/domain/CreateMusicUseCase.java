package com.iesam.digitallibrary.feature.resource.music.domain;

public class CreateMusicUseCase {

    private MusicRepository musicRepository;

    public CreateMusicUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public void execute(Music Music){
        this.musicRepository.addMusic(Music);
    }

}

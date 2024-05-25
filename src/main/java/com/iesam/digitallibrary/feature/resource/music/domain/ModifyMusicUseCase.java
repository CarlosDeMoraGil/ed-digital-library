package com.iesam.digitallibrary.feature.resource.music.domain;


public class ModifyMusicUseCase {

    private MusicRepository musicRepository;

    public ModifyMusicUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public void execute (String isbn, Music music){
        this.musicRepository.modifyMusic(isbn, music);
    }

}

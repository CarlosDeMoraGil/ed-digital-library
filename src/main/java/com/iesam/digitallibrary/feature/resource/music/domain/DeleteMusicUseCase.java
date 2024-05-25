package com.iesam.digitallibrary.feature.resource.music.domain;


public class DeleteMusicUseCase {

    private MusicRepository musicRepository;

    public DeleteMusicUseCase(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public void execute (String isbn){
        this.musicRepository.deleteMusic(isbn);
    }

}

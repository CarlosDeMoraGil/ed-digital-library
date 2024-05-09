package com.iesam.digitallibrary.feature.digitalBook.domain;

public class DeleteDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;

    public DeleteDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute (String isbn){
        this.digitalBookRepository.deleteDigitalBook(isbn);
    }

}

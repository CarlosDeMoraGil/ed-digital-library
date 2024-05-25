package com.iesam.digitallibrary.feature.resource.digitalBook.domain;

public class ModifyDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;

    public ModifyDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute (String isbn, DigitalBook digitalBook){
        this.digitalBookRepository.modifyDigitalBook(isbn, digitalBook);
    }

}

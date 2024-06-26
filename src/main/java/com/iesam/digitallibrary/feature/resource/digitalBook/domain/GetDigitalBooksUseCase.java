package com.iesam.digitallibrary.feature.resource.digitalBook.domain;

public class GetDigitalBooksUseCase {

    private DigitalBookRepository digitalBookRepository;

    public GetDigitalBooksUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute(){
        this.digitalBookRepository.getDigitalBooks();
    }

}

package com.iesam.digitallibrary.feature.resource.digitalBook.domain;

public class GetDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;

    public GetDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public DigitalBook execute (String id){
        return this.digitalBookRepository.getDigitalBook(id);
    }

}

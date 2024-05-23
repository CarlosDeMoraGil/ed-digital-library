package com.iesam.digitallibrary.feature.resource.digitalBook.domain;

public class CreateDigitalBookUseCase {

    private DigitalBookRepository digitalBookRepository;

    public CreateDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute(DigitalBook DigitalBook){
        this.digitalBookRepository.addDigitalBook(DigitalBook);
    }

}

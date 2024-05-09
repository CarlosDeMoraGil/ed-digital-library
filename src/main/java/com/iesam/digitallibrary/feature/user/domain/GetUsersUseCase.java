package com.iesam.digitallibrary.feature.user.domain;

public class GetUsersUseCase {

    private UserRepository userRepository;

    public GetUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execeute(){
        this.userRepository.getUsers();
    }

}

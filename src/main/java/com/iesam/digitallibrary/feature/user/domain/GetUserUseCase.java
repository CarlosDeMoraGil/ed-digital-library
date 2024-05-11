package com.iesam.digitallibrary.feature.user.domain;

public class GetUserUseCase {

    private UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String id){
        return this.userRepository.getUser(id);
    }

}

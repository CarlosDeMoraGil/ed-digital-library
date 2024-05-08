package com.iesam.digitallibrary.feature.user.domain;

public class ModifyUserUseCase {

    private UserRepository userRepository;

    public ModifyUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(String id, User user){
        this.userRepository.modifyUser(id, user);
    }

}

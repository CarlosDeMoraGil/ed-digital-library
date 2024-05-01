package com.iesam.digitalLibrary.feature.user.domain;

public class CreateUserUserCase {

    private UserRepository userRepository;

    public CreateUserUserCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user){
        this.userRepository.addUser(user);
    }

}

package com.iesam.digitallibrary.feature.user.domain;

public interface UserRepository {

    void addUser(User user);

    void deleteUser(String id);


}

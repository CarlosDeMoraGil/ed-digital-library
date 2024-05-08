package com.iesam.digitallibrary.feature.user.data;

import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.User;
import com.iesam.digitallibrary.feature.user.domain.UserRepository;

public class UserDataRepository implements UserRepository {


    private UserFileLocalDataSource userFileLocalDataSource;

    public UserDataRepository(UserFileLocalDataSource userFileLocalDataSource) {
        this.userFileLocalDataSource = userFileLocalDataSource;
    }


    @Override
    public void addUser(User user) {
        userFileLocalDataSource.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userFileLocalDataSource.delete(id);
    }

}
package com.iesam.digitalLibrary.feature.user.data;

import com.iesam.digitalLibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitalLibrary.feature.user.domain.User;
import com.iesam.digitalLibrary.feature.user.domain.UserRepository;

public class UserDataRepository implements UserRepository {


    private UserFileLocalDataSource userFileLocalDataSource;

    public UserDataRepository(UserFileLocalDataSource userFileLocalDataSource) {
        this.userFileLocalDataSource = userFileLocalDataSource;
    }


    @Override
    public void addUser(User user) {
        userFileLocalDataSource.save(user);
    }

}
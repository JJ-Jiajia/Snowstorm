package com.jiajia.Snowstorm.manager;

import com.jiajia.Snowstorm.beans.User;
import com.jiajia.Snowstorm.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by evenj on 2016/12/25.
 */
@Service
public class UserManagerImpl {
    @Autowired
    private UserDaoImpl userDao;

    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void deleteUserById(String id) {
        userDao.deleteUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }
}

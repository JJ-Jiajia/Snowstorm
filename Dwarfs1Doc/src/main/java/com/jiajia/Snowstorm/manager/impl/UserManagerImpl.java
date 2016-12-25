package com.jiajia.Snowstorm.manager.impl;

import com.jiajia.Snowstorm.beans.User;
import com.jiajia.Snowstorm.dao.UserDao;
import com.jiajia.Snowstorm.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by evenj on 2016/12/25.
 */
@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserDao userDao;

    public UserManagerImpl() {
        System.out.println("UserManagerImpl");
    }

    public void addUser() {

    }

    public void deleteUser() {

    }

    public String updateUser() {
        return null;
    }

    public User queryUser() {
        System.out.println("manager:queryUser");
        userDao.queryUser();
        return null;
    }

}

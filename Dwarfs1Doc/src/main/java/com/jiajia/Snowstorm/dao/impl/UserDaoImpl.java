package com.jiajia.Snowstorm.dao.impl;

import com.jiajia.Snowstorm.beans.User;
import com.jiajia.Snowstorm.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Created by evenj on 2016/12/25.
 */
@Repository
public class UserDaoImpl implements UserDao {
    public UserDaoImpl(){
        System.out.println("UserDaoImpl");
    }
    public void addUser() {
    }

    public void deleteUser() {
    }

    public String updateUser() {
        return null;
    }

    public User queryUser() {
        System.out.println("UserDao:queryUser");
        return null;
    }
}

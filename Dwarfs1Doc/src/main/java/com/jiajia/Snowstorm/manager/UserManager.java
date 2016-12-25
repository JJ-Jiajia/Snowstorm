package com.jiajia.Snowstorm.manager;

import com.jiajia.Snowstorm.beans.User;

/**
 * Created by evenj on 2016/12/25.
 */
public interface UserManager {
    public void addUser();
    public void deleteUser();
    public String updateUser();
    public User queryUser();

}

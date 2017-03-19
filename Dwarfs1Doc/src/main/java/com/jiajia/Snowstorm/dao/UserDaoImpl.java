package com.jiajia.Snowstorm.dao;

import com.jiajia.Snowstorm.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by evenj on 2016/12/25.
 */
@Repository
public class UserDaoImpl {
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getUserById(String id) {
        return (User) this.getSession().createQuery("from User where id= ?").setParameter(0, id).uniqueResult();
    }

    public List<User> getUsers() {
        return (List<User>) this.getSession().createCriteria(User.class).list();
    }

    public void addUser(User user) {
        this.getSession().save(user);

    }

    public void updateUser(User user) {
        this.getSession().update(user);

    }

    public void deleteUserById(String id) {
        this.getSession().createQuery("delete User where id = ? ").setParameter(0, id).executeUpdate();
    }

    public User isExitUser(String username, String password) {
        User user = (User) this.getSession()
                .createQuery("FROM User WHERE USERNAME= ? AND PASSWORDS= ?")
                .setParameter(0, username)
                .setParameter(1, password)
                .uniqueResult();
        if (user != null && user.getId() != null)
            return user;
        else return null;


    }


}

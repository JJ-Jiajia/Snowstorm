package com.jiajia.Snowstorm.action;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jiajia.Snowstorm.beans.User;
import com.jiajia.Snowstorm.manager.UserManagerImpl;
import com.mysql.cj.x.json.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiajia19889 on 2016/12/23.
 * 处理dwarfs请求
 */
@Controller
public class DwarfsAction {
    @Autowired
    private UserManagerImpl userManager;

    @RequestMapping(value = "/getUsers" , method = RequestMethod.POST)
    @ResponseBody
    public List<User> getUsers() {
        ArrayList<User> users= (ArrayList<User>) userManager.getUsers();
        JsonArray   ja= new JsonArray();

        return users;

    }

    @RequestMapping( "/getUserById")
    @ResponseBody
    public User getUserById(String id) {
        return userManager.getUserById(id);
    }

    @RequestMapping("/addUser")
    public void addUser(User user) {
        userManager.addUser(user);
    }

    @RequestMapping( "/deleteUserById")
    public void deleteUserById(String id) {
        userManager.deleteUserById(id);
    }

    @RequestMapping( "/updateUser")
    public void updateUser(User user) {
        userManager.updateUser(user);
    }
    @RequestMapping( "/userslist")
    public void userslist() {
        System.out.println("1111");
        System.out.println("1111");
        System.out.println("1111");
        System.out.println("1111");
        System.out.println("1111");
    }
    @RequestMapping( "/demo")
    public void demo() {

    }
}



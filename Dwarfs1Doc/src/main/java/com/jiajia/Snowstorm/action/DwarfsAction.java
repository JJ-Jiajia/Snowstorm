package com.jiajia.Snowstorm.action;

import com.jiajia.Snowstorm.beans.User;
import com.jiajia.Snowstorm.manager.UserManagerImpl;
import com.mysql.cj.x.json.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public User getUserById(Integer id) {
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
    @RequestMapping( "/userslist.htm")
    public void userslist() {
        System.out.println("1111");
    }
    @RequestMapping(value = "/checklogin.json")
    public String checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=userManager.isExitUser(username,password);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            return "index";
        }else return "login";
    }
}



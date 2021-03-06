package com.jiajia.Snowstorm.action;

import com.jiajia.Snowstorm.beans.User;
import com.jiajia.Snowstorm.manager.UserManagerImpl;
import com.jiajia.Snowstorm.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=userManager.isExitUser(username,password);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/index.htm");
        }else response.sendRedirect("index");
    }

    @RequestMapping(value = "/login.htm")
    public void login() {
    }

    @RequestMapping(value = "/logout.json")
    @ResponseBody
    public Map<String, String> logout(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> result=new HashMap<String, String>();
        System.out.println(request.getSession().getAttribute("user"));
        request.getSession().removeAttribute("user");
        System.out.println(request.getSession().getAttribute("user"));
        result.put("OK","OK");
        return result;
    }

    @RequestMapping(value = "/register.htm")
    public void register() {

    }
    @RequestMapping(value = "/index.htm")
    public void index() {

    }

    @RequestMapping(value = "/register.json")
    public void registerToDB(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException, InvocationTargetException, IntrospectionException, InstantiationException, IllegalAccessException {
        User u = BeanUtil.mapToBean(BeanUtil.getParameterMap(request), User.class);
        userManager.addUser(u);
        response.getWriter().print("OK");
        response.getWriter().flush();
    }
}



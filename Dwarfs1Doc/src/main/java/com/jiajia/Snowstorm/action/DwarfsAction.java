package com.jiajia.Snowstorm.action;

import com.jiajia.Snowstorm.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jiajia19889 on 2016/12/23.
 * 处理dwarfs请求
 */
@Controller
public class DwarfsAction {
    @Autowired
    private UserManager userManager;

    @RequestMapping("/getdwarfs")
    public void getDwarfs() {
        userManager.queryUser();
    }

    @RequestMapping("/addDwarfs")
    public void addDwarfs() {
    }

    @RequestMapping("/delDwarfs")
    public void delDwarfs() {
    }

    @RequestMapping("/updateDwarfs")
    public void updateDwarfs() {
    }
}

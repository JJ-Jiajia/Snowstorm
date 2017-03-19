package com.jiajia.Snowstorm.action;

import com.jiajia.Snowstorm.beans.Goods;
import com.jiajia.Snowstorm.beans.Page;
import com.jiajia.Snowstorm.manager.GoodsManagerImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by jiajia19889 on 2016/12/23.
 * 处理dwarfs请求
 */
@Controller
public class GoodsAction {
    @Autowired
    private GoodsManagerImpl GoodsManager;

    @RequestMapping(value = "/getGoods.json", method = RequestMethod.POST)
    @ResponseBody
    public Page<Goods> getGoodss(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String pageSize = request.getParameter("pageSize");
        String currentPage = request.getParameter("currentPage");
        Page<Goods> page = GoodsManager.getGoodsList(Integer.parseInt(pageSize), Integer.parseInt(currentPage));
        return page;

    }

    @RequestMapping(value = "/login.htm")
    public String login() {
        return "login";
    }



    @RequestMapping(value = "/addgoods.json", method = RequestMethod.POST)
    public String addGoods(@RequestParam("picture") CommonsMultipartFile[] files, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (files != null) {
            for (CommonsMultipartFile file : files) {
                String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                String filename = "userid" + System.currentTimeMillis() + type;
                String path = request.getSession().getServletContext().getRealPath("/imgs");
                File desFile = new File(path);
                FileUtils.copyInputStreamToFile(file.getInputStream(),desFile);

            }
        }
        return null;
    }

    @RequestMapping(value = "/addgoods.htm")
    public String addGoodsView(HttpServletRequest request) throws IOException {
        String username=(String)request.getSession().getAttribute("username");
        if(username!=null){
            return "addgoods";
        }else return "login";
    }

}



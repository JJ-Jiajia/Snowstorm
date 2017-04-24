package com.jiajia.Snowstorm.action;

import com.jiajia.Snowstorm.beans.GoodPicture;
import com.jiajia.Snowstorm.beans.Goods;
import com.jiajia.Snowstorm.beans.Page;
import com.jiajia.Snowstorm.beans.User;
import com.jiajia.Snowstorm.manager.GoodsManagerImpl;
import com.jiajia.Snowstorm.manager.UserManagerImpl;
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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jiajia19889 on 2016/12/23.
 * 处理dwarfs请求
 */
@Controller
public class GoodsAction {
    @Autowired
    private GoodsManagerImpl goodsManager;

    @Autowired
    private UserManagerImpl userManager;

    @RequestMapping(value = "/getGoods.json", method = RequestMethod.POST)
    @ResponseBody
    public Page<Goods> getGoodss(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String pageSize = request.getParameter("pageSize");
        String currentPage = request.getParameter("currentPage");
        Page<Goods> page = goodsManager.getGoodsList(Integer.parseInt(pageSize), Integer.parseInt(currentPage));
        return page;

    }

    @RequestMapping(value = "/login.htm")
    public void login() {
    }
    @RequestMapping(value = "/register.htm")
    public void register() {
    }
    @RequestMapping(value = "/register.json")
    public void registerToDB(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
    }


    @RequestMapping(value = "/savegoods.json", method = RequestMethod.POST)
    public void saveGoods(@RequestParam("picture") CommonsMultipartFile[] files, HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean flag = true;
        Goods goods=new Goods();
        User user = (User) request.getSession().getAttribute("user");
        Map<String,String[]> condition = request.getParameterMap();
        List<GoodPicture>  pictureList=new ArrayList<GoodPicture>() ;

        if (files != null) {
            for (CommonsMultipartFile file : files) {
                String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                String filename = user.getId().toString() + System.currentTimeMillis() + type;
                String path = request.getSession().getServletContext().getRealPath("/imgs");
                String desPath = path + "/" + filename;
                String savePath="imgs/"+filename;
                File desFile = new File(desPath);
                FileUtils.copyInputStreamToFile(file.getInputStream(), desFile);
                if(flag){
                    flag=false;
                    goods.setPicture(savePath);
                    goods.setGoodClass(condition.get("class")[0]);
                    goods.setMemo(condition.get("memo")[0]);
                    goods.setName(condition.get("name")[0]);
                    goods.setCreatetime(new Date());
                    goods.setUserId(user.getId());
                    goods.setOwnername(user.getUsername());
                    goodsManager.saveGood(goods);
                }else {
                    GoodPicture goodPicture= new GoodPicture();
                    goodPicture.setGoodCode(goods.getGoodcode());
                    goodPicture.setPicturePath(savePath);
                    pictureList.add(goodPicture);
                }
            }
        }
        goodsManager.saveGoodPicture(pictureList);
        response.getWriter().print("OK");
        response.getWriter().flush();
    }

    @RequestMapping(value = "/addgoods.htm")
    public void addgoods() {
    }
    @RequestMapping(value = "/goodsdetial.htm")
    public void goodsdetial(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
        String goodscode=request.getParameter("goodscode");
        Goods goods= goodsManager.getGoods(goodscode);
        List pictures=goodsManager.getGoodsPictureList(goodscode);
        modelMap.put("goodsInfo",goods);
        modelMap.put("pictures",pictures);
    }

}



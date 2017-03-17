package com.jiajia.Snowstorm.action;

import com.jiajia.Snowstorm.beans.Goods;
import com.jiajia.Snowstorm.beans.Page;
import com.jiajia.Snowstorm.manager.GoodsManagerImpl;
import com.mysql.cj.x.json.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jiajia19889 on 2016/12/23.
 * 处理dwarfs请求
 */
@Controller
public class GoodsAction {
    @Autowired
    private GoodsManagerImpl GoodsManager;

    @RequestMapping(value = "/getGoods" , method = RequestMethod.POST)
    @ResponseBody
    public Page<Goods> getGoodss(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String pageSize=request.getParameter("pageSize");
        String currentPage= request.getParameter("currentPage");
        Page<Goods>  page= GoodsManager.getGoodsList(Integer.parseInt(pageSize),Integer.parseInt(currentPage));
        return page;

    }
    @RequestMapping(value = "/login")
    public String login()  {
        return "login";
    }

    @RequestMapping(value = "/checklogin")
    public String checklogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map map=request.getParameterMap();
        response.getWriter().print("132132123132132132123132132132");
        return "/index";
    }

//    @RequestMapping( "/getGoodsById")
//    @ResponseBody
//    public Goods getGoodsById(String id) {
//        return GoodsManager.getGoodsById(id);
//    }
//
//    @RequestMapping("/addGoods")
//    public void addGoods(Goods Goods) {
//        GoodsManager.addGoods(Goods);
//    }
//
//    @RequestMapping( "/deleteGoodsById")
//    public void deleteGoodsById(String id) {
//        GoodsManager.deleteGoodsById(id);
//    }
//
//    @RequestMapping( "/updateGoods")
//    public void updateGoods(Goods Goods) {
//        GoodsManager.updateGoods(Goods);
//    }
//    @RequestMapping( "/Goodsslist")
//    public void Goodsslist() {
//        System.out.println("1111");
//        System.out.println("1111");
//        System.out.println("1111");
//        System.out.println("1111");
//        System.out.println("1111");
//    }
//    @RequestMapping( "/demo")
//    public void demo() {
//
//    }
}



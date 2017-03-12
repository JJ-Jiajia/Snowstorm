package com.jiajia.Snowstorm.dao;

import com.jiajia.Snowstorm.beans.Goods;
import com.jiajia.Snowstorm.beans.Page;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by jim on 17-3-12.
 */
@Repository
public class GoodsDaoImpl {
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    public Page<Goods> getGoodsList(int pageSize,int currentPage){
        StringBuilder sql=new StringBuilder("from Goods");
        ArrayList<Goods> goodsList= (ArrayList<Goods>)this.getSession().createCriteria(Goods.class).list();
        Page<Goods> page =new Page<Goods>(goodsList,pageSize,currentPage);
        return page;
    }
}

package com.jiajia.Snowstorm.dao;

import com.jiajia.Snowstorm.beans.GoodPicture;
import com.jiajia.Snowstorm.beans.Goods;
import com.jiajia.Snowstorm.beans.Page;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public void saveGood(Goods goods){
        this.getSession().save(goods);
    }

    public void saveGoodPicture(List<GoodPicture> pictureList){
         Iterator it= pictureList.iterator();
         while (it.hasNext()){
             this.getSession().save(it.next());
         }
    }

    public Goods getGoods(String goodscode){
        String hql="from Goods where id = ?";
        return (Goods) this.getSession().createQuery(hql).setParameter(0,goodscode).uniqueResult();

    }

    public List getGoodsPictureList(String goodscode){
        String hql ="from GoodPicture where id= ? ";
        return this.getSession().createQuery(hql).setParameter(0,goodscode).list();
    }

}

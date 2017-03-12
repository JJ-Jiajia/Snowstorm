package com.jiajia.Snowstorm.manager;

import com.jiajia.Snowstorm.beans.Goods;
import com.jiajia.Snowstorm.beans.Page;
import com.jiajia.Snowstorm.dao.GoodsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by jim on 17-3-12.
 */
@Service
public class GoodsManagerImpl {

    @Autowired
    private GoodsDaoImpl goodsDao;

    public Page<Goods> getGoodsList(int pageSize, int currentPage){
        return goodsDao.getGoodsList(pageSize,currentPage);
    }
}

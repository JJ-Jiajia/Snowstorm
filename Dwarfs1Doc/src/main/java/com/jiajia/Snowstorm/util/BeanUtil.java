package com.jiajia.Snowstorm.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by jiajia19889 on 2017/4/24.
 */
public class BeanUtil<T> {
    public static <T> T mapToBean(Map m,T bean){
        Method[] methods=bean.getClass().getMethods();
        for (Method me:methods
             ) {
            try {
                me.invoke(bean,m.get(me.getName().toLowerCase().substring(3)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}

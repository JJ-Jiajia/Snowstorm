package com.jiajia.Snowstorm.util;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiajia19889 on 2017/4/24.
 */
public class BeanUtil {

    /**
     * 将一个JavaBean 对象转化为一个 Map
     *
     * @param bean 要转化的JavaBean
     * @return 转化出来的 Map 对象
     * @throws IntrospectionException    如果分析类属性失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map beanToMap(Object bean) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        HashMap map = new HashMap();
        Class type = bean.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor desc : descriptors) {
            String key = desc.getName();
            Object value = desc.getReadMethod().invoke(bean, new Object[0]);
            map.put(key, value);
        }
        return map;
    }


    /**
     * 将一个 Map 对象转化为一个 JavaBean
     *
     * @param type 要转化的类型
     * @param map  包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException    如果分析类属性失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InstantiationException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static <T> T mapToBean(Map map, Class<T> type) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取类属性信息
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        //创建javaBean对象
        T obj = type.newInstance();
        //获取封装属性get set 方法的 一个抽象成的对象 的数组
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        //遍历并调用其中的方法
        for (PropertyDescriptor desc : propertyDescriptors) {
            String propertyName = desc.getName();
            if (map.containsKey(propertyName)) {
                Object[] args = {map.get(propertyName)};
                desc.getWriteMethod().invoke(obj, args);
            }
        }

        return obj;
    }

    public static Map<String, String> getParameterMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();

        Enumeration e = request.getParameterNames();

        while (e != null && e.hasMoreElements()) {
            Object o = e.nextElement();
            map.put(o.toString(), request.getParameter(o.toString()));
        }

        return map;
    }
}

package com.jarluo.mybatis.executor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: 对结果集的处理
 * @author: jar luo
 * @date: 2019/7/16 23:26
 */
public class ResultSetHandler {
    public <T> T handle(ResultSet resultSet,Class type){
        //直接调用Class的方法产生一个实例
        Object pojo = null;
        try {
            pojo = type.newInstance();
            //遍历结果集
            if(resultSet.next()){
                for (Field field : pojo.getClass().getDeclaredFields()) {
                    setValue(pojo,field,resultSet);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)pojo;

    }

    private void setValue(Object pojo, Field field, ResultSet resultSet) {
        try {
            Method setMethod = pojo.getClass().getMethod("set"+firstWordCapital(field.getName()));
            setMethod.invoke(pojo,getResult(resultSet,field));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @desc 根据反射判断类型，从ResultSet中取对应的类型参数
     * @param resultSet
     * @param field
     * @return
     */
    private Object getResult(ResultSet resultSet, Field field) {
        Class type = field.getType();
        String dataName = HumpToUnderline(field.getName());
        return null;

    }

    /**
     * @desc java驼峰命名转数据库下划线
     * @param name
     * @return
     */
    private String HumpToUnderline(String name) {
        return null;
    }

    private String firstWordCapital(String word) {
        return word.substring(0,1).toUpperCase()+word.substring(1);
    }
}

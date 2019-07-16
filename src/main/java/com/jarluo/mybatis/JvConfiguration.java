package com.jarluo.mybatis;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class JvConfiguration {

    public final static ResourceBundle sqlMappings;

    static{
        sqlMappings = ResourceBundle.getBundle("jvsql");
    }
    /**
     * @desc 返回接口的代理类对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz,JvSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader()
                                        ,new Class[]{clazz}
                                        ,new JvMapperProxy(sqlSession));

    }
}

package com.jarluo.mybatis.binding;

import com.jarluo.mybatis.session.JvDefaultSqlSession;

import java.lang.reflect.Proxy;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: 用于生成MapperProxy代理类
 * @author: jar luo
 * @date: 2019/7/20 9:12
 */
public class JvMapperProxyFactory<T> {
    private Class<T> mapperInterface;
    private Class object;

    public JvMapperProxyFactory(Class<T> mapperInterface, Class object) {
        this.mapperInterface = mapperInterface;
        this.object = object;
    }

    public T newInstance(JvDefaultSqlSession sqlSession){
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader()
                ,new Class[]{mapperInterface}
                ,new JvMapperProxy(sqlSession,object));
    }
}

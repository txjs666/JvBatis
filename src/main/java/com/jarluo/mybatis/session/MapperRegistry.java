package com.jarluo.mybatis.session;

import com.jarluo.mybatis.binding.JvMapperProxyFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: 维护接口类和工厂类的关系，用于获取MapperProxy代理对象
 *        工厂类指定了Pojo类型，用于处理结果集返回
 * @author: jar luo
 * @date: 2019/7/19 21:12
 */
public class MapperRegistry {
    //接口类和工厂类的映射关系
    private final Map<Class<?>, JvMapperProxyFactory> knownMappers = new HashMap<>();

    /**
     * @desc 在Configuration中解析接口上的注解时，存入接口和工厂类的映射关系
     * 此处传入pojo类型，是为了最终处理结果集的时候将结果转换为POJO类型
     * @param clazz
     * @param pojo
     * @param <T>
     */
    public <T> void addMapper(Class<T> clazz,Class pojo){
        knownMappers.put(clazz,new JvMapperProxyFactory(clazz,pojo));
    }

    public <T> T getMapper(Class<T> clazz, JvDefaultSqlSession sqlSession){
        JvMapperProxyFactory proxyFactory = knownMappers.get(clazz);
        if(proxyFactory == null){
            throw new RuntimeException("Type"+clazz+"can not find");
        }
        return (T)proxyFactory.newInstance(sqlSession);
    }
}

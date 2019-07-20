package com.jarluo.mybatis.binding;

import com.jarluo.mybatis.session.JvDefaultSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: MapperProxy代理类，用于代理Mapper接口
 * @author: jar luo
 * @date: 2019/7/20 9:16
 */
public class JvMapperProxy implements InvocationHandler {
    private JvDefaultSqlSession sqlSession;
    private Class object;

    public JvMapperProxy(JvDefaultSqlSession sqlSession, Class object) {
        this.sqlSession = sqlSession;
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statementId = method.getDeclaringClass().getName() +"."+method.getName();
        //如果根据接口类型+方法名能找到映射的SQL，则执行SQL
        if(sqlSession.getConfiguration().hasStatement(statementId)){
            return sqlSession.selectOne(statementId,args,object);
        }
        //否则直接执行被代理对象的原方法
        return method.invoke(proxy,args);
    }
}

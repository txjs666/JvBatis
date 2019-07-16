package com.jarluo.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JvMapperProxy implements InvocationHandler {
    private JvSqlSession sqlSession;
    public JvMapperProxy(JvSqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statementId = method.getDeclaringClass().getName()+"."+method.getName();
        return sqlSession.selectOne(statementId,args[0]);
    }
}

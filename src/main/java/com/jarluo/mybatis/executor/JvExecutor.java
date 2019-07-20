package com.jarluo.mybatis.executor;


public interface JvExecutor {
    <T> T query(String statement, Object[] parameter,Class pojo) ;
}

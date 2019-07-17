package com.jarluo.mybatis.executor;

import com.jarluo.mybatis.Blog;

import java.sql.*;

public interface JvExecutor {
    <T> T query(String statement, Object[] parameter,Class pojo) ;
}

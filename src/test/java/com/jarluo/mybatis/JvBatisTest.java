package com.jarluo.mybatis;

import com.jarluo.mybatis.executor.JvExecutor;
import com.jarluo.mybatis.mapper.BlogMapper;

public class JvBatisTest {
    public static void main(String[] args) {
        JvSqlSession sqlSession = new JvSqlSession(new JvConfiguration(),new JvExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }

}

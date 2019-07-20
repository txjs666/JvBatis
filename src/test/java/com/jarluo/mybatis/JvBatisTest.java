package com.jarluo.mybatis;

import com.jarluo.mybatis.mapper.BlogMapper;
import com.jarluo.mybatis.session.JvDefaultSqlSession;
import com.jarluo.mybatis.session.JvSqlSessionFactory;

public class JvBatisTest {
    public static void main(String[] args) {
        JvSqlSessionFactory factory = new JvSqlSessionFactory();
        JvDefaultSqlSession sqlSession = factory.build().openSqlSesison();
        //获取MapperProxy代理
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        mapper.selectBlogById(1);

    }

}

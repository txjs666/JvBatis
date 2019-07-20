package com.jarluo.mybatis;

import com.jarluo.mybatis.mapper.User;
import com.jarluo.mybatis.mapper.UserMapper;
import com.jarluo.mybatis.session.JvDefaultSqlSession;
import com.jarluo.mybatis.session.JvSqlSessionFactory;

public class JvBatisTest {
    public static void main(String[] args) {
        JvSqlSessionFactory factory = new JvSqlSessionFactory();
        JvDefaultSqlSession sqlSession = factory.build().openSqlSesison();
        //获取MapperProxy代理
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user =mapper.selectUserById(1);
        System.out.println(user);
    }

}

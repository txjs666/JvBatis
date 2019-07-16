package com.jarluo.mybatis;

public class JvBatisTest {
    public static void main(String[] args) {
        JvSqlSession sqlSession = new JvSqlSession(new JvConfiguration(),new JvExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }

}

package com.jarluo.mybatis.session;


import com.jarluo.mybatis.executor.JvSimpleExecutor;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: 会话工厂类，用于解析配置文件，产生SqlSession
 * @author: jar luo
 * @date: 2019/7/20 8:59
 */
public class JvSqlSessionFactory {
    private JvConfiguration configuration;

    /**
     * @desc build方法用于初始化Configuration，解析配置文件的工作在Configuration的构造函数中
     * @return
     */
    public JvSqlSessionFactory build(){
        configuration = new JvConfiguration();
        return this;
    }

    public JvDefaultSqlSession openSqlSesison(){
        return new JvDefaultSqlSession(configuration,new JvSimpleExecutor());
    }


}

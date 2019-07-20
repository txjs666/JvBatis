package com.jarluo.mybatis.session;

import com.jarluo.mybatis.executor.JvExecutor;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: TODO
 * @author: jar luo
 * @date: 2019/7/19 21:34
 */
public class JvDefaultSqlSession {
    /**
     * 配置类
     */
    private JvConfiguration configuration;

    /**
     * 执行器
     */
    private JvExecutor executor;

    public JvDefaultSqlSession(JvConfiguration configuration,JvExecutor executor){
        this.configuration = configuration;
        this.executor  = executor;
    }

    public JvConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * @desc 调用executor执行单条查询
     * @param statementId
     * @param parameter
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId,Object[] parameter,Class clazz){
        String sql = JvConfiguration.sqlMappings.getString(statementId).split("--")[0];
        return executor.query(sql,parameter,clazz);
    }

    /**
     * @desc 获取一个代理对象
     * @param clazz
     * @param <T>
     */
    public <T> T getMapper(Class clazz){

        return configuration.getMapper(clazz,this);
    }
}

package com.jarluo.mybatis;

/**
 * @desc 入口 会话
 *
 */
public class JvSqlSession {
    /**
     * 配置类
     */
    private JvConfiguration configuration;
    /**
     * 执行器
     */
    private JvExecutor executor;

    /**
     * @desc 调用executor执行单条查询
     * @param statementId
     * @param parameter
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId,Object parameter){
        String sql = statementId;
        return executor.query(sql,parameter);
    }

    /**
     * @desc 获取一个代理对象
     * @param clazz
     * @param <T>
     */
    public <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz);
    }
}

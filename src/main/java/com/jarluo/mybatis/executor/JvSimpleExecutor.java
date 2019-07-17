package com.jarluo.mybatis.executor;

import java.util.concurrent.Executor;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: TODO
 * @author: jar luo
 * @date: 2019/7/17 21:53
 */
public class JvSimpleExecutor implements JvExecutor {

    @Override
    public <T> T query(String sql, Object[] parameter, Class pojo) {
        JvStatementHandler statementHandler = new JvStatementHandler();
        return statementHandler.query(sql,parameter,pojo);
    }
}

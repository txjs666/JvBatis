package com.jarluo.mybatis.executor;

import com.jarluo.mybatis.parameter.JvParameterHandler;
import sun.rmi.runtime.NewThreadAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: TODO
 * @author: jar luo
 * @date: 2019/7/17 21:39
 */
public class JvStatementHandler {
    private ResultSetHandler resultSetHandler = new ResultSetHandler();

    public <T> T query(String sql,Object[] parameter,Class pojo){
        Connection conn = null;
        PreparedStatement pstm = null;
        Object result = null;
        try {
            conn = getConnection();
            pstm = conn.prepareStatement(sql);
            JvParameterHandler parameterHandler = new JvParameterHandler(pstm);
            parameterHandler.setParameters(parameter);
            pstm.execute();
            result = resultSetHandler.handle(pstm.getResultSet(),pojo);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn !=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return  (T)result;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/my_app","root","okmijn");
        return conn;
    }
}

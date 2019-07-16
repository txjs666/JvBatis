package com.jarluo.mybatis;

import java.sql.*;

public class JvExecutor {
    public <T> T query(String sql, Object parameter) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        Blog blog = new Blog();
        try {
            //注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");

            //打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_app","root","okmijn");

            //执行查询
            stmt =conn.createStatement();
            resultSet = stmt.executeQuery(String.format(sql,parameter));

            //获取结果集
            while (resultSet.next()){
                Integer bid = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String authorId = resultSet.getString("password");
                blog.setBid(bid);
                blog.setName(name);
                blog.setAuthorId(authorId);

            }
            System.out.println(blog);

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return (T)blog;
    }
}

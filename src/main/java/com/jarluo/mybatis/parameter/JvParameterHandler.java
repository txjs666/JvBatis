package com.jarluo.mybatis.parameter;

import java.sql.PreparedStatement;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: TODO
 * @author: jar luo
 * @date: 2019/7/16 23:02
 */
public class JvParameterHandler {
    private PreparedStatement psmt;
    public JvParameterHandler(PreparedStatement statement){
        this.psmt = statement;
    }

    /**
     * @desc 从方法中获取参数，遍历设置SQL中的？占位符
     * @param parameters
     */
    public void setParameters(Object[] parameters){
        try{
            //PreparedStatement的序号是从1开始的
            for (int i = 0; i < parameters.length ; i++) {
                int k = i+1;
                if(parameters[i] instanceof Integer){
                    psmt.setInt(k,(Integer)parameters[i]);
                }else if(parameters[i] instanceof Long){
                    psmt.setLong(k,(Long)parameters[i]);
                }else if(parameters[i] instanceof Boolean){
                    psmt.setBoolean(k,(Boolean)parameters[i]);
                }else{
                    psmt.setString(k,String.valueOf(parameters[i]));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

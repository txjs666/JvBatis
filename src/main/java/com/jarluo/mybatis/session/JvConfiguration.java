package com.jarluo.mybatis.session;

import com.jarluo.mybatis.JvMapperProxy;
import com.jarluo.mybatis.JvSqlSession;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class JvConfiguration {

    public final static ResourceBundle sqlMappings;
    public JvConfiguration(){
        //Note:在properties和注解中重复配置SQL会覆盖
        //1.解析sql.properties
        for (String key : sqlMappings.keySet()) {
            String statement = sqlMappings.getString(key);

        }


    }


    static{
        sqlMappings = ResourceBundle.getBundle("jvsql");
    }
    /**
     * @desc 返回接口的代理类对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz,JvSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader()
                                        ,new Class[]{clazz}
                                        ,new JvMapperProxy(sqlSession));

    }
}

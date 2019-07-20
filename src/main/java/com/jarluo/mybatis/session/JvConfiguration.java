package com.jarluo.mybatis.session;

import com.jarluo.mybatis.binding.JvMapperProxy;
import com.jarluo.mybatis.executor.CachingExecutor;
import com.jarluo.mybatis.executor.JvExecutor;
import com.jarluo.mybatis.executor.JvSimpleExecutor;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class JvConfiguration {

    public static final  ResourceBundle sqlMappings;
    public static final  ResourceBundle properties;
    private static final MapperRegistry mapperRegistry =  new MapperRegistry();
    private final Map<String, String> mappedStatements = new HashMap<>();

    static{
        sqlMappings = ResourceBundle.getBundle("jvsql");
        properties = ResourceBundle.getBundle("JvBatis");
    }



    public JvConfiguration(){
        //Note:在properties和注解中重复配置SQL会覆盖
        //1.解析sql.properties
        String statement;
        String pojoStr;
        Class mapper = null;
        Class pojo = null;
        for (String key : sqlMappings.keySet()) {
            //propertie中的value用--隔开，第一个是SQL语句
            statement = sqlMappings.getString(key).split("--")[0];
            //第二个是需要转换的POJO类型
            pojoStr = sqlMappings.getString(key).split("--")[1];
            //properties中的key是接口类型+方法,从接口类型+方法中截取接口类型
            try {
                mapper = Class.forName(key.substring(0,key.lastIndexOf(".")));
                pojo = Class.forName(pojoStr);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //接口与返回的实体类关系
            mapperRegistry.addMapper(mapper,pojo);
            //接口方法与SQL的关系
            mappedStatements.put(key,statement);
        }



    }

    /**
     * @desc 返回接口的代理类对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz,JvDefaultSqlSession sqlSession) {
        return (T) mapperRegistry.getMapper(clazz,sqlSession);

    }

    public boolean hasStatement(String statementName){
        return mappedStatements.containsKey(statementName);
    }

    public JvExecutor newExecutor(){
        JvExecutor executor = null;
        if(properties.getString("cache.enabled").equals("true")){
            executor = new CachingExecutor(new JvSimpleExecutor());
        }else{
            executor = new JvSimpleExecutor();
        }
        return executor;
    }
}

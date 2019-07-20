package com.jarluo.mybatis.executor;

import com.jarluo.mybatis.cache.CacheKey;

import java.util.HashMap;
import java.util.Map;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: TODO
 * @author: jar luo
 * @date: 2019/7/20 16:52
 */
public class CachingExecutor implements JvExecutor {
    private JvExecutor delegate;
    private Map cache = new HashMap();

    public CachingExecutor(JvSimpleExecutor delegate) {
        this.delegate  = delegate;
    }

    @Override
    public <T> T query(String statement, Object[] parameter, Class pojo) {
        //计算cacheKey
        CacheKey cacheKey = new CacheKey();
        cacheKey.update(statement);
        cacheKey.update(joinStr(parameter));
        //是否拿到缓存
        if(cache.containsKey(cacheKey.getHashCode())){
            //命中缓存
            System.out.println("【命中缓存】");
            return (T)cache.get(cacheKey.getHashCode());
        }else{
            //没有命中的话 调用被装饰
            Object obj = delegate.query(statement,parameter,pojo);
            cache.put(cacheKey.getHashCode(),obj);
            return (T)obj;
        }
    }

    public String joinStr(Object[] objects){
        StringBuffer stringBuffer = new StringBuffer();
        if(objects != null && objects.length >0){
            for (Object object : objects) {
                stringBuffer.append(object.toString() +",");
            }
        }
        int len = stringBuffer.length();
        if(len > 0){
            stringBuffer.deleteCharAt(len-1);
        }
        return stringBuffer.toString();
    }


}

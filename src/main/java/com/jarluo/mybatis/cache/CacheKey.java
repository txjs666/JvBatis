package com.jarluo.mybatis.cache;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: 缓存key
 * @author: jar luo
 * @date: 2019/7/20 16:58
 */
public class CacheKey {
    public static final int DEFAULT_HASHCODE = 17;
    public static final int DEFAULT_MULTIPLIER = 37;
    private int hashCode;
    private int count;
    private int multiplier;

    public CacheKey() {
        this.hashCode = DEFAULT_HASHCODE;
        this.count = 0;
        this.multiplier = DEFAULT_MULTIPLIER;

    }

    public int getHashCode() {
        return hashCode;
    }

    public void update(Object object){
        int baseHashCode  = object == null? 1 : object.hashCode();
        count++;
        baseHashCode *= count;
        hashCode = multiplier * hashCode + baseHashCode;
    }

}

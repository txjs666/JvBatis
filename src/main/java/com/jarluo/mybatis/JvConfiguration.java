package com.jarluo.mybatis;

import java.lang.reflect.Proxy;

public class JvConfiguration {
    /**
     * @desc 返回接口的代理类对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader()
                                        ,new Class[]{clazz}
                                        ,new JvMapperProxy());

    }
}

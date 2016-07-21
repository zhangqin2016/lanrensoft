package com.lz.log;

/**
 * Created by tech6 on 2016/7/20.
 */
public class JdkLogFactory implements ILogFactory {

    public Log getLog(Class<?> clazz) {
        return new JdkLog(clazz);
    }

    public Log getLog(String name) {
        return new JdkLog(name);
    }
}
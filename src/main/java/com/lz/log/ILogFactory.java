package com.lz.log;

/**
 * Created by tech6 on 2016/7/20.
 */
public interface ILogFactory {

    Log getLog(Class<?> clazz);

    Log getLog(String name);
}

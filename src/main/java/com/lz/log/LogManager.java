package com.lz.log;

/**
 * Created by tech6 on 2016/7/22.
 */
public class LogManager {

    private static final LogManager me = new LogManager();

    private LogManager() {}

    public static LogManager me() {
        return me;
    }

    public void init() {
        Log.init();
    }

    public void setDefaultLogFactory(ILogFactory defaultLogFactory) {
        Log.setDefaultLogFactory(defaultLogFactory);
        LogKit.synchronizeLog();
    }
}

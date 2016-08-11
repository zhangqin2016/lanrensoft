package com.lz.auto.model;

/**
 * Created by tech6 on 2016/7/29.
 */
public class ControllerQueryModel {
    private String tableName;
    private String tableCaseName;
    private String where;
    private String whereSql;
    private String basePackage;
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableCaseName() {
        return tableCaseName;
    }

    public void setTableCaseName(String tableCaseName) {
        this.tableCaseName = tableCaseName;
    }


    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getWhereSql() {
        return whereSql;
    }

    public void setWhereSql(String whereSql) {
        this.whereSql = whereSql;
    }
}

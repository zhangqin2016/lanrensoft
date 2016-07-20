package com.lz.auto.model;

import java.util.List;

public class Table {

    private String tableName;
    private String key;
    private List<TableColumn> listColumn;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<TableColumn> getListColumn() {
        return listColumn;
    }

    public void setListColumn(List<TableColumn> listColumn) {
        this.listColumn = listColumn;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}

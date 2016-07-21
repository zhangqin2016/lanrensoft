package com.lz.auto.utils;

import com.lz.auto.model.Table;
import com.lz.auto.model.TableColumn;
import com.lz.mybatis.generator.util.PropertiesUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tech6 on 2016/6/16.
 */
public class GetTable {
    private static DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;

    static {
        Map<String, String> cfgMap = PropertiesUtil.readProperties("mybatis-generator"+ File.separator+"cfg.properties");
        dataSource = getDataSource(cfgMap);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private static DriverManagerDataSource getDataSource(Map<String, String> map) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(map.get("jdbc.driverClassName"));
        dataSource.setUrl(map.get("jdbc.url"));
        dataSource.setUsername(map.get("jdbc.username"));
        dataSource.setPassword(map.get("jdbc.password"));
        return dataSource;
    }
    public static List<Table> tables() {

        List<Table> listTable = new ArrayList<Table>();
        Connection connection = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            DatabaseMetaData dbMeta = connection.getMetaData();
            String schemaPattern = dbMeta.getUserName();
            ResultSet rs = dbMeta.getTables(connection.getCatalog(), schemaPattern, null, new String[]{"TABLE", "VIEW"});

            while (rs.next()) {
                Table table = new Table();
                String table_name = rs.getString("TABLE_NAME");
                table.setTableName(table_name);
                DatabaseMetaData databaseMetaData = connection.getMetaData();
                List<TableColumn> lc = new ArrayList<TableColumn>();
                ResultSet keySet = databaseMetaData.getPrimaryKeys(null, null, table_name);
                while (keySet.next()) {
                    if (table.getKey() == null) {
                        table.setKey(keySet.getString("COLUMN_NAME"));
                    }
                    TableColumn column = new TableColumn();
                    String columnName = keySet.getString("COLUMN_NAME");
                    column.setColumnName(columnName);
                    lc.add(column);
                }
                ResultSet columnSet = databaseMetaData.getColumns(null, "%",
                        table_name, "%");
                while (columnSet.next()) {
                    TableColumn column = new TableColumn();
                    String columnName = columnSet.getString("COLUMN_NAME");
                    column.setType(columnSet.getInt("DATA_TYPE"));
                    String remarks = columnSet.getString("REMARKS").trim().length() == 0 ? columnName : columnSet.getString("REMARKS");
                    column.setColumnName(columnName);
                    column.setRemarks(remarks);
                    column.setTypeName(new TableColumnTool().getJavaType(column));
                    column.setJavaTypeName(new TableColumnTool().getJavaType(column));
                    column.setLength(columnSet.getInt("COLUMN_SIZE"));
                    if (!lc.contains(column)) {

                        lc.add(column);
                    } else {
                        lc.remove(column);
                        column.setIsKey(true);
                        lc.add(column);
                    }

                }

                table.setListColumn(lc);
                listTable.add(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return listTable;
    }

    public static void main(String[] args) {
        tables();
    }
}

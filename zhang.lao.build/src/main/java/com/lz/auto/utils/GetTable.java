package com.lz.auto.utils;

import com.google.common.collect.Lists;
import com.lz.auto.model.Table;
import com.lz.auto.model.TableColumn;
import com.lz.kit.LogKit;
import com.lz.kit.Prop;
import com.lz.kit.PropKit;
import com.lz.tool.ListUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
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
        Prop prop = PropKit.use("jdbc.properties");
        dataSource = getDataSource(prop);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private static DriverManagerDataSource getDataSource(Prop map) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(map.get("jdbc.driver"));
        dataSource.setUrl(map.get("jdbc.url"));
        dataSource.setUsername(map.get("jdbc.username"));
        dataSource.setPassword(map.get("jdbc.password"));
        return dataSource;
    }
    public static List<Table> tables() throws SQLException {
        Prop prop = PropKit.use("jdbc.properties");
        if(prop.get("jdbc.type").equals("oracle")){
            return getOracleTable();
        }else {
            return getMysqltables();
        }
    }

    public static List<Table> getMysqltables() throws SQLException {

        List<Table> listTable = new ArrayList<Table>();
        Connection connection = null;

            connection = jdbcTemplate.getDataSource().getConnection();
            DatabaseMetaData dbMeta = connection.getMetaData();
            String schemaPattern = dbMeta.getUserName();
            ResultSet rs = dbMeta.getTables(connection.getCatalog(), schemaPattern, null, new String[]{"TABLE", "VIEW"});
            while (rs.next()) {
                try {
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
                }
                ResultSet columnSet = databaseMetaData.getColumns(null, "%",
                        table_name, "%");
                while (columnSet.next()) {
                    TableColumn column = new TableColumn();
                    String columnName = columnSet.getString("COLUMN_NAME").toLowerCase();
                    column.setType(columnSet.getInt("DATA_TYPE"));
                    String remarks = columnSet.getString("REMARKS").trim().length() == 0 ? columnName : columnSet.getString("REMARKS");
                    column.setColumnName(columnName);
                    column.setRemarks(remarks);
                    column.setTypeName(new TableColumnTool().getJavaType(column));
                    column.setJavaTypeName(new TableColumnTool().getJavaType(column));
                    column.setLength(columnSet.getInt("COLUMN_SIZE"));
                    if(table.getKey().toLowerCase().equals(columnName.toLowerCase())){
                        column.setIsKey(true);
                    }
                        lc.add(column);
                }

                table.setListColumn(lc);
                listTable.add(table);
            } catch (Exception e) {
                LogKit.error(e.getMessage());
            } finally {
                if (connection != null)
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
            }

        return listTable;
    }

    public static void main(String[] args) throws SQLException {
        tables();
    }

    public static List<Table>  getOracleTable() {
        Connection connection =null;

        List<Table> listTable = new ArrayList<Table>();
        String listTableSql = "select table_name from user_tables";
        List<Map<String,Object>> listTableMap = jdbcTemplate.queryForList(listTableSql);
        for (Map<String, Object> stringObjectMap : listTableMap) {
            try {
            Table table = new Table();
            String tableName = stringObjectMap.get("TABLE_NAME").toString();
            table.setTableName(tableName);
            connection=jdbcTemplate.getDataSource().getConnection();
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
            String sql2 = "select cu.* from user_cons_columns cu, user_constraints au where cu.constraint_name = au.constraint_name and au.constraint_type = 'P' and au.table_name ='"+tableName+"'";
            Map<String,Object> key = ListUtils.getFirst(jdbcTemplate.queryForList(sql2));
            if(key!=null) {
                table.setKey(key.get("COLUMN_NAME").toString().toLowerCase());
            }
            List<TableColumn> listTableColumn = Lists.newArrayList();
            while (rs.next()) {
                TableColumn tableColumn = new TableColumn();
                String cName= rs.getString("COLUMN_NAME").toLowerCase();
                tableColumn.setLength(rs.getInt("COLUMN_SIZE"));
                tableColumn.setXiaoshu(rs.getInt("DECIMAL_DIGITS"));
                if(cName.equals(table.getKey())){
                    tableColumn.setIsKey(true);
                }else{
                    tableColumn.setIsKey(false);
                }
                tableColumn.setColumnName(cName);
                tableColumn.setType(rs.getInt("DATA_TYPE"));
                tableColumn.setTypeName(new TableColumnTool().getJavaType(tableColumn));
                tableColumn.setJavaTypeName(new TableColumnTool().getJavaType(tableColumn));

                String sql = "  select COMMENTS from user_col_comments where table_name = '"+tableName.toUpperCase()+"' and COLUMN_NAME = '"+cName.toUpperCase()+"'";
                String remarks ="";
                try {
                    remarks= ListUtils.getFirst(jdbcTemplate.queryForList(sql)).get("COMMENTS").toString();
                }catch (Exception e){

                }
                tableColumn.setRemarks(remarks);
                if(listTableColumn.contains(tableColumn)){
                    continue;
                }else {
                    listTableColumn.add(tableColumn);
                }
            }

            table.setListColumn(listTableColumn);

            if(org.apache.commons.lang3.StringUtils.isBlank(table.getKey())){
                continue;
            }else{
                listTable.add(table);
            }
            }catch (Exception e){
                LogKit.error(e.getMessage());
                return null;
            }finally {
                if(connection!=null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return listTable;

    }
}

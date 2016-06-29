package auto.utils;

import auto.model.TableColumn;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tech6 on 2016/6/17.
 */
public class TableColumnTool {
    protected Map<Integer, String> javaTypeMap;

    public String getJavaType(TableColumn tableColumn) {

        return javaTypeMap.get(tableColumn.getType());
    }

    public TableColumnTool() {
        javaTypeMap = new HashMap<Integer, String>();

        javaTypeMap.put(Types.ARRAY, "Object");
        javaTypeMap.put(Types.BIGINT, "Long");
        javaTypeMap.put(Types.BINARY, "byte[]"); //$NON-NLS-1$
        javaTypeMap.put(Types.BIT, "Boolean");
        javaTypeMap.put(Types.BLOB, "byte[]"); //$NON-NLS-1$
        javaTypeMap.put(Types.BOOLEAN, "Boolean");
        javaTypeMap.put(Types.CHAR, "String");
        javaTypeMap.put(Types.CLOB, "String");
        javaTypeMap.put(Types.DATALINK, "Object");
        javaTypeMap.put(Types.DATE, "Date");
        javaTypeMap.put(Types.DECIMAL, "BigDecimal");
        javaTypeMap.put(Types.DISTINCT, "Object");
        javaTypeMap.put(Types.DOUBLE, "Double");
        javaTypeMap.put(Types.FLOAT, "Double");
        javaTypeMap.put(Types.INTEGER, "Integer");
        javaTypeMap.put(Types.JAVA_OBJECT, "Object");
        javaTypeMap.put(Types.LONGNVARCHAR, "String");
        javaTypeMap.put(Types.LONGVARBINARY, "byte[]"); //$NON-NLS-1$
        javaTypeMap.put(Types.LONGVARCHAR, "String");
        javaTypeMap.put(Types.NCHAR, "String");
        javaTypeMap.put(Types.NCLOB, "String");
        javaTypeMap.put(Types.NVARCHAR, "String");
        javaTypeMap.put(Types.NULL, "Object");
        javaTypeMap.put(Types.NUMERIC, "BigDecimal");
        javaTypeMap.put(Types.OTHER, "Object");
        javaTypeMap.put(Types.REAL, "Float");
        javaTypeMap.put(Types.REF, "Object");
        javaTypeMap.put(Types.SMALLINT, "Short");
        javaTypeMap.put(Types.STRUCT, "Object");
        javaTypeMap.put(Types.TIME, "Date");
        javaTypeMap.put(Types.TIMESTAMP, "Date");
        javaTypeMap.put(Types.TINYINT, "Byte");
        javaTypeMap.put(Types.VARBINARY, "byte[]"); //$NON-NLS-1$
        javaTypeMap.put(Types.VARCHAR, "String");

    }
}

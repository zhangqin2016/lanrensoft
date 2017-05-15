package zhang.lao.build.auto.model;

public class TableColumn {

    private String columnName;
    private String typeName;
    private String javaTypeName;
    private String remarks;
    private boolean isKey;
    private boolean canQuery;
    private int length;
    private int xiaoshu;

    public boolean isCanQuery() {
        if(typeName.equals("text")||typeName.equals("clob")||typeName.equals("blob")){
            return false;
        }else{
            return true;
        }
    }

    public void setCanQuery(boolean canQuery) {
        this.canQuery = canQuery;
    }

    public int getXiaoshu() {
        return xiaoshu;
    }

    public void setXiaoshu(int xiaoshu) {
        this.xiaoshu = xiaoshu;
    }

    public String getColumnName() {
        return columnName.toLowerCase();
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setIsKey(boolean isKey) {
        this.isKey = isKey;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((columnName == null) ? 0 : columnName.hashCode());
        result = prime * result + (isKey ? 1231 : 1237);
        result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
        result = prime * result
                + ((typeName == null) ? 0 : typeName.hashCode());
        return result;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TableColumn other = (TableColumn) obj;
        if (columnName == null) {
            if (other.columnName != null)
                return false;
        } else if (!columnName.equals(other.columnName))
            return false;
        return true;

    }


    public void setKey(boolean isKey) {
        this.isKey = isKey;
    }

    public String getJavaTypeName() {
        return javaTypeName;
    }

    public void setJavaTypeName(String javaTypeName) {
        this.javaTypeName = javaTypeName;
    }
}

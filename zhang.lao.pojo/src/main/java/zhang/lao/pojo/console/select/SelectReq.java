package zhang.lao.pojo.console.select;

/**
 * Created by Administrator on 2016/8/7.
 */
public class SelectReq {

    private String table;
    private String valueField;
    private String showValueField;
    private String where;
    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;
    }

    public String getShowValueField() {
        return showValueField;
    }

    public void setShowValueField(String showValueField) {
        this.showValueField = showValueField;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}

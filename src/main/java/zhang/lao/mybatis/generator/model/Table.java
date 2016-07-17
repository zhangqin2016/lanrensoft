package zhang.lao.mybatis.generator.model;


import auto.utils.BuildNameTool;
import org.springframework.util.StringUtils;


public class Table {
    private String tableName;
    private String modelName;

    public Table(String tableName) {
        super();
        this.tableName = tableName;
        this.modelName = StringUtils.capitalize(BuildNameTool.getName(tableName));
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}

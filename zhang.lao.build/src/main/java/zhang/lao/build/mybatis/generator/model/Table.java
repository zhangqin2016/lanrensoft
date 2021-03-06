package zhang.lao.build.mybatis.generator.model;


import zhang.lao.build.auto.utils.BuildNameTool;
import org.springframework.util.StringUtils;


public class Table {
    private String tableName;
    private String modelName;

    public Table(String tableName) {
        super();
        this.tableName = tableName;
        this.modelName = StringUtils.capitalize(BuildNameTool.getName(getTableName()));
    }

    public String getTableName() {
        return tableName.toLowerCase();
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

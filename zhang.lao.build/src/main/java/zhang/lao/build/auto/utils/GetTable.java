package zhang.lao.build.auto.utils;

import com.google.common.collect.Lists;
import org.codehaus.plexus.util.StringUtils;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.auto.model.TableColumn;
import zhang.lao.build.kit.LogKit;
import zhang.lao.build.kit.Prop;
import zhang.lao.build.kit.PropKit;
import zhang.lao.build.mybatis.generator.util.StringUtil;
import zhang.lao.build.tool.ListUtils;
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


public class GetTable {
    public static List<Table> tables() throws SQLException {
        Prop prop = PropKit.use("jdbc.properties");
        if(prop.get("jdbc.type").equals("oracle")){
            GetTableFactory getTableFactory = new GetTableMysql();
            return getTableFactory.getTable();
        }else {
            GetTableFactory getTableFactory = new GetTableOracle();
            return getTableFactory.getTable();
        }
    }
}

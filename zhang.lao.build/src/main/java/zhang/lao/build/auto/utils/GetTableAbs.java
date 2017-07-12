package zhang.lao.build.auto.utils;/**
 * Created by zhangqin on 2017/5/12.
 */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import zhang.lao.build.auto.model.Table;
import zhang.lao.build.kit.Prop;
import zhang.lao.build.kit.PropKit;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author 张钦
 * @create 2017-05-12 9:20
 **/
public abstract class GetTableAbs implements GetTableFactory {
    protected static DataSource dataSource;
    protected static JdbcTemplate jdbcTemplate;

    static {
        Prop prop = PropKit.use("sys.properties");
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
    @Override
    public abstract List<Table> getTable();
}

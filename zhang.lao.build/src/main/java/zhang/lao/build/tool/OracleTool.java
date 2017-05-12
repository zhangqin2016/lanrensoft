package zhang.lao.build.tool;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/7/23.
 */
@Component
public class OracleTool {

    @Resource
    private JdbcTemplate jdbcTemplate;
    public String getNextStringNumber(String sequenceName) {
        String sqls = "select count(*) from user_sequences where SEQUENCE_NAME='"+sequenceName.toUpperCase()+"' ";
        if(jdbcTemplate.queryForObject(sqls,BigDecimal.class).intValue()==0){
            String sqlSeq = "create sequence " + sequenceName + " increment by 1 start with 1 NOMAXVALUE NOCYCLE CACHE 10";
            jdbcTemplate.update(sqlSeq);
        }else{
            //DO NOTHING
        }
        String sql = "select " + sequenceName + ".nextVal from dual";
        return String.valueOf(jdbcTemplate.queryForObject(sql,BigDecimal.class));
    }
    public Long getNextLongNumber(String sequenceName) {
        String sqls = "select count(*) from user_sequences where SEQUENCE_NAME='"+sequenceName.toUpperCase()+"' ";
        if(jdbcTemplate.queryForObject(sqls,BigDecimal.class).intValue()==0){
            String sqlSeq = "create sequence " + sequenceName + " increment by 1 start with 1 NOMAXVALUE NOCYCLE CACHE 10";
            jdbcTemplate.execute(sqlSeq);
        }else{
            //DO NOTHING
        }
        String sql = "select " + sequenceName + ".nextVal from dual";
        return jdbcTemplate.queryForObject(sql,BigDecimal.class).longValue();
    }
    public BigDecimal getNextNumber(String sequenceName) {
        String sqls = "select count(*) from user_sequences where SEQUENCE_NAME='"+sequenceName.toUpperCase()+"' ";
        if(jdbcTemplate.queryForObject(sqls,BigDecimal.class).intValue()==0){
            String sqlSeq = "create sequence " + sequenceName + " increment by 1 start with 1 NOMAXVALUE NOCYCLE CACHE 10";
            jdbcTemplate.update(sqlSeq);
        }else{
            //DO NOTHING
        }
        String sql = "select " + sequenceName + ".nextVal from dual";
        return jdbcTemplate.queryForObject(sql,BigDecimal.class);
    }
}

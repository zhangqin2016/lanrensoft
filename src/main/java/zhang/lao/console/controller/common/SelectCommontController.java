package zhang.lao.console.controller.common;

import com.lz.kit.LogKit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.console.model.select.SelectReq;
import zhang.lao.pojo.resp.CommonResp;
import zhang.lao.pojo.resp.HttpResult;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/8/7.
 */
@Controller
public class SelectCommontController {

    @Resource
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/console/select/json")
    public @ResponseBody
    HttpResult json(SelectReq selectReq){
        try{
            String where = selectReq.getWhere();
            where=where==null?"":where;
            String sql = "select "+selectReq.getShowValueField()+" as s,"+selectReq.getValueField()+" as v from  "+selectReq.getTable()+" "+where;
            return CommonResp.getSuccessByData(jdbcTemplate.queryForList(sql));
        }catch(Exception e){
            LogKit.error(e.getMessage());
            return CommonResp.getError();
        }

    }
}

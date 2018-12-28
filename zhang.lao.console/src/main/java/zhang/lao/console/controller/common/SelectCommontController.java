package zhang.lao.console.controller.common;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.pojo.console.resp.HttpResultUtil;
import zhang.lao.pojo.console.select.SelectReq;

import zhang.lao.pojo.console.resp.HttpResult;

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
            String where = selectReq.getWhere();
            where=where==null?"":where;
            String sql = "select "+selectReq.getShowValueField()+" as s,"+selectReq.getValueField()+" as v from  "+selectReq.getTable()+" "+where;
            return HttpResultUtil.buildSuccess(jdbcTemplate.queryForList(sql));
    }
}

package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import zhang.lao.dao.base.BoTest2Dao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTest2;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTest2Example;
import zhang.lao.build.tool.LzStringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.build.mybatis.jdbc.auto.tool.ControllerQueryTool;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.HttpResultUtil;
import zhang.lao.pojo.console.resp.HttpResult;
import javax.annotation.Resource;
import java.util.List;
import zhang.lao.build.tool.UUIDTool;
/**
* 
* @author 
* @create 
**/
 @Service
public class BoTest2Service{
	@Resource
	private BoTest2Dao boTest2Dao;

	public String add(){
		return "console/boTest2/boTest2_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boTest2", boTest2Dao.selectByPrimaryKey(id));
		return "console/boTest2/boTest2_form";
	}

	public String list(){
		return "console/boTest2/boTest2_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoTest2Example boTest2Example = new BoTest2Example();
        ControllerQueryTool.setBoTest2Criteria(bootGridReq.getQuery(),boTest2Example.createCriteria());
		List<BoTest2> boTest2List = boTest2Dao.selectByExample(boTest2Example);
		return new BootStrapGridResp(page.getTotal(),boTest2List);
	}

	public HttpResult save(String formObjectJson){
		BoTest2 boTest2= JSON.parseObject(formObjectJson,BoTest2.class);
			java.lang.String id=boTest2.getId();
		if (id!=null) {
			boTest2Dao.updateByPrimaryKeySelective(boTest2);
		}else{
		    id=UUIDTool.getUUID();
			boTest2.setId(id);
			boTest2Dao.insertSelective(boTest2);
		}
		return HttpResultUtil.buildSuccess(id);

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boTest2Dao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import zhang.lao.dao.base.BoContactUsDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoContactUs;
import zhang.lao.build.mybatis.jdbc.auto.model.BoContactUsExample;
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
public class BoContactUsService{
	@Resource
	private BoContactUsDao boContactUsDao;

	public String add(){
		return "console/boContactUs/boContactUs_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boContactUs", boContactUsDao.selectByPrimaryKey(id));
		return "console/boContactUs/boContactUs_form";
	}

	public String list(){
		return "console/boContactUs/boContactUs_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoContactUsExample boContactUsExample = new BoContactUsExample();
        ControllerQueryTool.setBoContactUsCriteria(bootGridReq.getQuery(),boContactUsExample.createCriteria());
		List<BoContactUs> boContactUsList = boContactUsDao.selectByExample(boContactUsExample);
		return new BootStrapGridResp(page.getTotal(),boContactUsList);
	}

	public HttpResult save(String formObjectJson){
		BoContactUs boContactUs= JSON.parseObject(formObjectJson,BoContactUs.class);
			java.lang.String id=boContactUs.getId();
		if (id!=null) {
			boContactUsDao.updateByPrimaryKeySelective(boContactUs);
		}else{
		    id=UUIDTool.getUUID();
			boContactUs.setId(id);
			boContactUsDao.insertSelective(boContactUs);
		}
		return HttpResultUtil.buildSuccess(id);

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boContactUsDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

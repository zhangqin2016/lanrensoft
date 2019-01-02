package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import zhang.lao.dao.base.BoTestUserDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTestUser;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTestUserExample;
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
public class BoTestUserService{
	@Resource
	private BoTestUserDao boTestUserDao;

	public String add(){
		return "console/boTestUser/boTestUser_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
		modelMap.put("boTestUser", boTestUserDao.selectByPrimaryKey(id));
		return "console/boTestUser/boTestUser_form";
	}

	public String list(){
		return "console/boTestUser/boTestUser_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoTestUserExample boTestUserExample = new BoTestUserExample();
        ControllerQueryTool.setBoTestUserCriteria(bootGridReq.getQuery(),boTestUserExample.createCriteria());
		List<BoTestUser> boTestUserList = boTestUserDao.selectByExample(boTestUserExample);
		return new BootStrapGridResp(page.getTotal(),boTestUserList);
	}

	public HttpResult save(String formObjectJson){
		BoTestUser boTestUser= JSON.parseObject(formObjectJson,BoTestUser.class);
			java.lang.String id=boTestUser.getId();
		if (id!=null) {
			boTestUserDao.updateByPrimaryKeySelective(boTestUser);
		}else{
		    id=UUIDTool.getUUID();
			boTestUser.setId(id);
			boTestUserDao.insertSelective(boTestUser);
		}
		return HttpResultUtil.buildSuccess(id);

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boTestUserDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

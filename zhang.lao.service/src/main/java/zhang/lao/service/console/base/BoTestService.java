package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import zhang.lao.dao.base.BoTestDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTest;
import zhang.lao.build.mybatis.jdbc.auto.model.BoTestExample;
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
public class BoTestService{
	@Resource
	private BoTestDao boTestDao;

	public String add(){
		return "console/boTest/boTest_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boTest", boTestDao.selectByPrimaryKey(id));
		return "console/boTest/boTest_form";
	}

	public String list(){
		return "console/boTest/boTest_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoTestExample boTestExample = new BoTestExample();
        ControllerQueryTool.setBoTestCriteria(bootGridReq.getQuery(),boTestExample.createCriteria());
		List<BoTest> boTestList = boTestDao.selectByExample(boTestExample);
		return new BootStrapGridResp(page.getTotal(),boTestList);
	}

	public HttpResult save(String formObjectJson){
		BoTest boTest= JSON.parseObject(formObjectJson,BoTest.class);
			java.lang.String id=boTest.getId();
		if (id!=null) {
			boTestDao.updateByPrimaryKeySelective(boTest);
		}else{
			boTest.setId(UUIDTool.getUUID());
			boTestDao.insertSelective(boTest);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boTestDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

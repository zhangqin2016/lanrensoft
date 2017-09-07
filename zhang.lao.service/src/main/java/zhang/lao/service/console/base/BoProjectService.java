package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.BoProjectDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProject;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectExample;
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
public class BoProjectService{
	@Resource
	private BoProjectDao boProjectDao;

	public String add(){
		return "console/boProject/boProject_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boProject", boProjectDao.selectByPrimaryKey(id));
		return "console/boProject/boProject_form";
	}

	public String list(){
		return "console/boProject/boProject_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoProjectExample boProjectExample = new BoProjectExample();
        ControllerQueryTool.setBoProjectCriteria(bootGridReq.getQuery(),boProjectExample.createCriteria());
		List<BoProject> boProjectList = boProjectDao.selectByExample(boProjectExample);
		return new BootStrapGridResp(page.getTotal(),boProjectList);
	}

	public HttpResult save(String formObjectJson){
		BoProject boProject= JSON.parseObject(formObjectJson,BoProject.class);
			java.lang.String id=boProject.getId();
		if (id!=null) {
			boProjectDao.updateByPrimaryKeySelective(boProject);
		}else{
			boProject.setId(UUIDTool.getUUID());
			boProjectDao.insertSelective(boProject);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boProjectDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

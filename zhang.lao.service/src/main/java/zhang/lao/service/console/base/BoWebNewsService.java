package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import zhang.lao.dao.base.BoWebNewsDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebNews;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebNewsExample;
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
public class BoWebNewsService{
	@Resource
	private BoWebNewsDao boWebNewsDao;

	public String add(){
		return "console/boWebNews/boWebNews_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boWebNews", boWebNewsDao.selectByPrimaryKey(id));
		return "console/boWebNews/boWebNews_form";
	}

	public String list(){
		return "console/boWebNews/boWebNews_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoWebNewsExample boWebNewsExample = new BoWebNewsExample();
        ControllerQueryTool.setBoWebNewsCriteria(bootGridReq.getQuery(),boWebNewsExample.createCriteria());
		List<BoWebNews> boWebNewsList = boWebNewsDao.selectByExample(boWebNewsExample);
		return new BootStrapGridResp(page.getTotal(),boWebNewsList);
	}

	public HttpResult save(String formObjectJson){
		BoWebNews boWebNews= JSON.parseObject(formObjectJson,BoWebNews.class);
			java.lang.String id=boWebNews.getId();
		if (id!=null) {
			boWebNewsDao.updateByPrimaryKeySelective(boWebNews);
		}else{
		    id=UUIDTool.getUUID();
			boWebNews.setId(id);
			boWebNewsDao.insertSelective(boWebNews);
		}
		return HttpResultUtil.buildSuccess(id);

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boWebNewsDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

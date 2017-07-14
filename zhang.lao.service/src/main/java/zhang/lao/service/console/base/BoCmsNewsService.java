package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.BoCmsNewsDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoCmsNews;
import zhang.lao.build.mybatis.jdbc.auto.model.BoCmsNewsExample;
import zhang.lao.build.tool.LzStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.build.mybatis.jdbc.auto.tool.ControllerQueryTool;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;

import zhang.lao.pojo.console.resp.HttpResult;
import javax.annotation.Resource;
import java.util.List;
import zhang.lao.build.tool.UUIDTool;
import zhang.lao.pojo.console.resp.HttpResultUtil;

/**
* 
* @author 
* @create 
**/
 @Service
public class BoCmsNewsService{
	@Resource
	private BoCmsNewsDao boCmsNewsDao;

	public String add(){
		return "console/boCmsNews/boCmsNews_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boCmsNews", boCmsNewsDao.selectByPrimaryKey(id));
		return "console/boCmsNews/boCmsNews_form";
	}

	public String list(){
		return "console/boCmsNews/boCmsNews_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoCmsNewsExample boCmsNewsExample = new BoCmsNewsExample();
        ControllerQueryTool.setBoCmsNewsCriteria(bootGridReq.getQuery(),boCmsNewsExample.createCriteria());
		List<BoCmsNews> boCmsNewsList = boCmsNewsDao.selectByExample(boCmsNewsExample);
		return new BootStrapGridResp(page.getTotal(),boCmsNewsList);
	}

	public HttpResult save(String formObjectJson){
		BoCmsNews boCmsNews= JSON.parseObject(formObjectJson,BoCmsNews.class);
			java.lang.String id=boCmsNews.getId();
		if (id!=null) {
			boCmsNewsDao.updateByPrimaryKeySelective(boCmsNews);
		}else{
			boCmsNews.setId(UUIDTool.getUUID());
			boCmsNewsDao.insertSelective(boCmsNews);
		}
		return HttpResultUtil.buildSuccess();

	}

	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boCmsNewsDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.BoAppBannerDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoAppBanner;
import zhang.lao.build.mybatis.jdbc.auto.model.BoAppBannerExample;
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
public class BoAppBannerService{
	@Resource
	private BoAppBannerDao boAppBannerDao;


	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boAppBanner", boAppBannerDao.selectByPrimaryKey(id));
		return "console/boAppBanner/boAppBanner_form";
	}

	public String list(){
		return "console/boAppBanner/boAppBanner_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoAppBannerExample boAppBannerExample = new BoAppBannerExample();
        ControllerQueryTool.setBoAppBannerCriteria(bootGridReq.getQuery(),boAppBannerExample.createCriteria());
		List<BoAppBanner> boAppBannerList = boAppBannerDao.selectByExample(boAppBannerExample);
		return new BootStrapGridResp(page.getTotal(),boAppBannerList);
	}

	public HttpResult save(String formObjectJson){
		BoAppBanner boAppBanner= JSON.parseObject(formObjectJson,BoAppBanner.class);
			java.lang.String id=boAppBanner.getId();
		if (id!=null) {
			boAppBannerDao.updateByPrimaryKeySelective(boAppBanner);
		}else{
			boAppBanner.setId(UUIDTool.getUUID());
			boAppBannerDao.insertSelective(boAppBanner);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boAppBannerDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

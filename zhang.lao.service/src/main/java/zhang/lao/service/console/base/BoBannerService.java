package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import zhang.lao.dao.base.BoBannerDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoBanner;
import zhang.lao.build.mybatis.jdbc.auto.model.BoBannerExample;
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
public class BoBannerService{
	@Resource
	private BoBannerDao boBannerDao;

	public String add(){
		return "console/boBanner/boBanner_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boBanner", boBannerDao.selectByPrimaryKey(id));
		return "console/boBanner/boBanner_form";
	}

	public String list(){
		return "console/boBanner/boBanner_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoBannerExample boBannerExample = new BoBannerExample();
        ControllerQueryTool.setBoBannerCriteria(bootGridReq.getQuery(),boBannerExample.createCriteria());
		List<BoBanner> boBannerList = boBannerDao.selectByExample(boBannerExample);
		return new BootStrapGridResp(page.getTotal(),boBannerList);
	}

	public HttpResult save(String formObjectJson){
		BoBanner boBanner= JSON.parseObject(formObjectJson,BoBanner.class);
			java.lang.String id=boBanner.getId();
		if (id!=null) {
			boBannerDao.updateByPrimaryKeySelective(boBanner);
		}else{
		    id=UUIDTool.getUUID();
			boBanner.setId(id);
			boBannerDao.insertSelective(boBanner);
		}
		return HttpResultUtil.buildSuccess(id);

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boBannerDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

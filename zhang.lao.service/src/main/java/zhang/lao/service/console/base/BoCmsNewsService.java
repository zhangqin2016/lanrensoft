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
import zhang.lao.pojo.console.resp.CommonResp;
import zhang.lao.pojo.console.resp.HttpResult;
import javax.annotation.Resource;
import java.util.List;

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

	public String edit(ModelMap modelMap,String id){
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
		try{
		BoCmsNews boCmsNews= JSON.parseObject(formObjectJson,BoCmsNews.class);
			String id=boCmsNews.getId();
		if (id!=null) {
			boCmsNewsDao.updateByPrimaryKeySelective(boCmsNews);
			return CommonResp.getSuccess();
		}else{
			boCmsNewsDao.insertSelective(boCmsNews);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage(),e);
			return CommonResp.getError();
		}

	}

	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boCmsNewsDao.deleteByPrimaryKey(String.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}

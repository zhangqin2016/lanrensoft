package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.AppTokenDao;
import zhang.lao.build.mybatis.jdbc.auto.model.AppToken;
import zhang.lao.build.mybatis.jdbc.auto.model.AppTokenExample;
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
public class AppTokenService{
	@Resource
	private AppTokenDao appTokenDao;

	public String add(){
		return "console/appToken/appToken_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("appToken", appTokenDao.selectByPrimaryKey(id));
		return "console/appToken/appToken_form";
	}

	public String list(){
		return "console/appToken/appToken_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		AppTokenExample appTokenExample = new AppTokenExample();
        ControllerQueryTool.setAppTokenCriteria(bootGridReq.getQuery(),appTokenExample.createCriteria());
		List<AppToken> appTokenList = appTokenDao.selectByExample(appTokenExample);
		return new BootStrapGridResp(page.getTotal(),appTokenList);
	}

	public HttpResult save(String formObjectJson){
		AppToken appToken= JSON.parseObject(formObjectJson,AppToken.class);
			java.lang.String id=appToken.getId();
		if (id!=null) {
			appTokenDao.updateByPrimaryKeySelective(appToken);
			return HttpResultUtil.buildSuccess();
		}else{
			appToken.setId(UUIDTool.getUUID());
			appTokenDao.insertSelective(appToken);
			return HttpResultUtil.buildSuccess();
		}


	}

	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		appTokenDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

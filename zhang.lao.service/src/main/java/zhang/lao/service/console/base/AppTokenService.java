package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import zhang.lao.dao.base.AppTokenDao;
import com.lz.mybatis.jdbc.auto.model.AppToken;
import com.lz.mybatis.jdbc.auto.model.AppTokenExample;
import com.lz.tool.LzStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.dao.ControllerQueryTool;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.CommonResp;
import zhang.lao.pojo.console.resp.HttpResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * title:
 * </p>
 * <p>
 * description:
 * </p>
 *
 * @create 张钦
 * @update
 * @version 1.0
 * @date
 */
public class AppTokenService{
	@Resource
	private AppTokenDao appTokenDao;

	public String add(){
		return "console/appToken/appToken_form";
	}

	public String edit(ModelMap modelMap,Integer id){
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
		try{
		AppToken appToken= JSON.parseObject(formObjectJson,AppToken.class);
			Integer id=appToken.getId();
		if (id!=null) {
			appTokenDao.updateByPrimaryKeySelective(appToken);
			return CommonResp.getSuccess();
		}else{
			appTokenDao.insertSelective(appToken);
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
		appTokenDao.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}

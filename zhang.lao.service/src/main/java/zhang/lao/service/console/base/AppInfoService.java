package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import zhang.lao.dao.base.AppInfoDao;
import com.lz.mybatis.jdbc.auto.model.AppInfo;
import com.lz.mybatis.jdbc.auto.model.AppInfoExample;
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
public class AppInfoService{
	@Resource
	private AppInfoDao appInfoDao;

	public String add(){
		return "console/appInfo/appInfo_form";
	}

	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("appInfo", appInfoDao.selectByPrimaryKey(id));
		return "console/appInfo/appInfo_form";
	}

	public String list(){
		return "console/appInfo/appInfo_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		AppInfoExample appInfoExample = new AppInfoExample();
        ControllerQueryTool.setAppInfoCriteria(bootGridReq.getQuery(),appInfoExample.createCriteria());
		List<AppInfo> appInfoList = appInfoDao.selectByExample(appInfoExample);
		return new BootStrapGridResp(page.getTotal(),appInfoList);
	}

	public HttpResult save(String formObjectJson){
		try{
		AppInfo appInfo= JSON.parseObject(formObjectJson,AppInfo.class);
			Integer id=appInfo.getAppId();
		if (id!=null) {
			appInfoDao.updateByPrimaryKeySelective(appInfo);
			return CommonResp.getSuccess();
		}else{
			appInfoDao.insertSelective(appInfo);
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
		appInfoDao.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}

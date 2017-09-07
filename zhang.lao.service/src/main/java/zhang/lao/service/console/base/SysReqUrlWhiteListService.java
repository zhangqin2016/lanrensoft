package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.SysReqUrlWhiteListDao;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlWhiteList;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlWhiteListExample;
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
public class SysReqUrlWhiteListService{
	@Resource
	private SysReqUrlWhiteListDao sysReqUrlWhiteListDao;

	public String add(){
		return "console/sysReqUrlWhiteList/sysReqUrlWhiteList_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("sysReqUrlWhiteList", sysReqUrlWhiteListDao.selectByPrimaryKey(id));
		return "console/sysReqUrlWhiteList/sysReqUrlWhiteList_form";
	}

	public String list(){
		return "console/sysReqUrlWhiteList/sysReqUrlWhiteList_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysReqUrlWhiteListExample sysReqUrlWhiteListExample = new SysReqUrlWhiteListExample();
        ControllerQueryTool.setSysReqUrlWhiteListCriteria(bootGridReq.getQuery(),sysReqUrlWhiteListExample.createCriteria());
		List<SysReqUrlWhiteList> sysReqUrlWhiteListList = sysReqUrlWhiteListDao.selectByExample(sysReqUrlWhiteListExample);
		return new BootStrapGridResp(page.getTotal(),sysReqUrlWhiteListList);
	}

	public HttpResult save(String formObjectJson){
		SysReqUrlWhiteList sysReqUrlWhiteList= JSON.parseObject(formObjectJson,SysReqUrlWhiteList.class);
			java.lang.String id=sysReqUrlWhiteList.getId();
		if (id!=null) {
			sysReqUrlWhiteListDao.updateByPrimaryKeySelective(sysReqUrlWhiteList);
		}else{
			sysReqUrlWhiteList.setId(UUIDTool.getUUID());
			sysReqUrlWhiteListDao.insertSelective(sysReqUrlWhiteList);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		sysReqUrlWhiteListDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

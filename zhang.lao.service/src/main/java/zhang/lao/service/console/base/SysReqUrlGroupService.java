package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.SysReqUrlGroupDao;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlGroup;
import zhang.lao.build.mybatis.jdbc.auto.model.SysReqUrlGroupExample;
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
public class SysReqUrlGroupService{
	@Resource
	private SysReqUrlGroupDao sysReqUrlGroupDao;

	public String add(){
		return "console/sysReqUrlGroup/sysReqUrlGroup_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("sysReqUrlGroup", sysReqUrlGroupDao.selectByPrimaryKey(id));
		return "console/sysReqUrlGroup/sysReqUrlGroup_form";
	}

	public String list(){
		return "console/sysReqUrlGroup/sysReqUrlGroup_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysReqUrlGroupExample sysReqUrlGroupExample = new SysReqUrlGroupExample();
        ControllerQueryTool.setSysReqUrlGroupCriteria(bootGridReq.getQuery(),sysReqUrlGroupExample.createCriteria());
		List<SysReqUrlGroup> sysReqUrlGroupList = sysReqUrlGroupDao.selectByExample(sysReqUrlGroupExample);
		return new BootStrapGridResp(page.getTotal(),sysReqUrlGroupList);
	}

	public HttpResult save(String formObjectJson){
		SysReqUrlGroup sysReqUrlGroup= JSON.parseObject(formObjectJson,SysReqUrlGroup.class);
			java.lang.String id=sysReqUrlGroup.getId();
		if (id!=null) {
			sysReqUrlGroupDao.updateByPrimaryKeySelective(sysReqUrlGroup);
		}else{
			sysReqUrlGroup.setId(UUIDTool.getUUID());
			sysReqUrlGroupDao.insertSelective(sysReqUrlGroup);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		sysReqUrlGroupDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

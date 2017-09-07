package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.BoUserDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoUser;
import zhang.lao.build.mybatis.jdbc.auto.model.BoUserExample;
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
public class BoUserService{
	@Resource
	private BoUserDao boUserDao;

	public String add(){
		return "console/boUser/boUser_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boUser", boUserDao.selectByPrimaryKey(id));
		return "console/boUser/boUser_form";
	}

	public String list(){
		return "console/boUser/boUser_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoUserExample boUserExample = new BoUserExample();
        ControllerQueryTool.setBoUserCriteria(bootGridReq.getQuery(),boUserExample.createCriteria());
		List<BoUser> boUserList = boUserDao.selectByExample(boUserExample);
		return new BootStrapGridResp(page.getTotal(),boUserList);
	}

	public HttpResult save(String formObjectJson){
		BoUser boUser= JSON.parseObject(formObjectJson,BoUser.class);
			java.lang.String id=boUser.getId();
		if (id!=null) {
			boUserDao.updateByPrimaryKeySelective(boUser);
		}else{
			boUser.setId(UUIDTool.getUUID());
			boUserDao.insertSelective(boUser);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boUserDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

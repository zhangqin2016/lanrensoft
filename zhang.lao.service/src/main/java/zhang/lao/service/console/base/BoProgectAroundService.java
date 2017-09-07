package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.BoProgectAroundDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectAround;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectAroundExample;
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
public class BoProgectAroundService{
	@Resource
	private BoProgectAroundDao boProgectAroundDao;

	public String add(){
		return "console/boProgectAround/boProgectAround_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boProgectAround", boProgectAroundDao.selectByPrimaryKey(id));
		return "console/boProgectAround/boProgectAround_form";
	}

	public String list(){
		return "console/boProgectAround/boProgectAround_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoProgectAroundExample boProgectAroundExample = new BoProgectAroundExample();
        ControllerQueryTool.setBoProgectAroundCriteria(bootGridReq.getQuery(),boProgectAroundExample.createCriteria());
		List<BoProgectAround> boProgectAroundList = boProgectAroundDao.selectByExample(boProgectAroundExample);
		return new BootStrapGridResp(page.getTotal(),boProgectAroundList);
	}

	public HttpResult save(String formObjectJson){
		BoProgectAround boProgectAround= JSON.parseObject(formObjectJson,BoProgectAround.class);
			java.lang.String id=boProgectAround.getId();
		if (id!=null) {
			boProgectAroundDao.updateByPrimaryKeySelective(boProgectAround);
		}else{
			boProgectAround.setId(UUIDTool.getUUID());
			boProgectAroundDao.insertSelective(boProgectAround);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boProgectAroundDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

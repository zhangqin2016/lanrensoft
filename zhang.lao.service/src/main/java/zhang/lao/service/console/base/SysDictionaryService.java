package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.SysDictionaryDao;
import zhang.lao.build.mybatis.jdbc.auto.model.SysDictionary;
import zhang.lao.build.mybatis.jdbc.auto.model.SysDictionaryExample;
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
import zhang.lao.build.tool.UUIDTool;
/**
* 
* @author 
* @create 
**/
 @Service
public class SysDictionaryService{
	@Resource
	private SysDictionaryDao sysDictionaryDao;

	public String add(){
		return "console/sysDictionary/sysDictionary_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("sysDictionary", sysDictionaryDao.selectByPrimaryKey(id));
		return "console/sysDictionary/sysDictionary_form";
	}

	public String list(){
		return "console/sysDictionary/sysDictionary_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysDictionaryExample sysDictionaryExample = new SysDictionaryExample();
        ControllerQueryTool.setSysDictionaryCriteria(bootGridReq.getQuery(),sysDictionaryExample.createCriteria());
		List<SysDictionary> sysDictionaryList = sysDictionaryDao.selectByExample(sysDictionaryExample);
		return new BootStrapGridResp(page.getTotal(),sysDictionaryList);
	}

	public HttpResult save(String formObjectJson){
		try{
		SysDictionary sysDictionary= JSON.parseObject(formObjectJson,SysDictionary.class);
			java.lang.String id=sysDictionary.getId();
		if (id!=null) {
			sysDictionaryDao.updateByPrimaryKeySelective(sysDictionary);
			return CommonResp.getSuccess();
		}else{
			sysDictionary.setId(UUIDTool.getUUID());
			sysDictionaryDao.insertSelective(sysDictionary);
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
		sysDictionaryDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}

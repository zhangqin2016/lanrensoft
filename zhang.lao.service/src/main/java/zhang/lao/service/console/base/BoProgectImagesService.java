package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.BoProgectImagesDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectImages;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectImagesExample;
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
public class BoProgectImagesService{
	@Resource
	private BoProgectImagesDao boProgectImagesDao;

	public String add(){
		return "console/boProgectImages/boProgectImages_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boProgectImages", boProgectImagesDao.selectByPrimaryKey(id));
		return "console/boProgectImages/boProgectImages_form";
	}

	public String list(){
		return "console/boProgectImages/boProgectImages_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoProgectImagesExample boProgectImagesExample = new BoProgectImagesExample();
        ControllerQueryTool.setBoProgectImagesCriteria(bootGridReq.getQuery(),boProgectImagesExample.createCriteria());
		List<BoProgectImages> boProgectImagesList = boProgectImagesDao.selectByExample(boProgectImagesExample);
		return new BootStrapGridResp(page.getTotal(),boProgectImagesList);
	}

	public HttpResult save(String formObjectJson){
		BoProgectImages boProgectImages= JSON.parseObject(formObjectJson,BoProgectImages.class);
			java.lang.String id=boProgectImages.getId();
		if (id!=null) {
			boProgectImagesDao.updateByPrimaryKeySelective(boProgectImages);
		}else{
			boProgectImages.setId(UUIDTool.getUUID());
			boProgectImagesDao.insertSelective(boProgectImages);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boProgectImagesDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

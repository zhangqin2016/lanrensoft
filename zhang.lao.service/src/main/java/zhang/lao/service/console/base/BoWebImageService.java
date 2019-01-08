package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import zhang.lao.dao.base.BoWebImageDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebImage;
import zhang.lao.build.mybatis.jdbc.auto.model.BoWebImageExample;
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
public class BoWebImageService{
	@Resource
	private BoWebImageDao boWebImageDao;

	public String add(){
		return "console/boWebImage/boWebImage_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boWebImage", boWebImageDao.selectByPrimaryKey(id));
		return "console/boWebImage/boWebImage_form";
	}

	public String list(){
		return "console/boWebImage/boWebImage_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoWebImageExample boWebImageExample = new BoWebImageExample();
        ControllerQueryTool.setBoWebImageCriteria(bootGridReq.getQuery(),boWebImageExample.createCriteria());
		List<BoWebImage> boWebImageList = boWebImageDao.selectByExample(boWebImageExample);
		return new BootStrapGridResp(page.getTotal(),boWebImageList);
	}

	public HttpResult save(String formObjectJson){
		BoWebImage boWebImage= JSON.parseObject(formObjectJson,BoWebImage.class);
			java.lang.String id=boWebImage.getId();
		if (id!=null) {
			boWebImageDao.updateByPrimaryKeySelective(boWebImage);
		}else{
		    id=UUIDTool.getUUID();
			boWebImage.setId(id);
			boWebImageDao.insertSelective(boWebImage);
		}
		return HttpResultUtil.buildSuccess(id);

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boWebImageDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

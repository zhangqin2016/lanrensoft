package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.BoProgectGoodsImagesDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectGoodsImages;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProgectGoodsImagesExample;
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
public class BoProgectGoodsImagesService{
	@Resource
	private BoProgectGoodsImagesDao boProgectGoodsImagesDao;

	public String add(){
		return "console/boProgectGoodsImages/boProgectGoodsImages_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boProgectGoodsImages", boProgectGoodsImagesDao.selectByPrimaryKey(id));
		return "console/boProgectGoodsImages/boProgectGoodsImages_form";
	}

	public String list(){
		return "console/boProgectGoodsImages/boProgectGoodsImages_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoProgectGoodsImagesExample boProgectGoodsImagesExample = new BoProgectGoodsImagesExample();
        ControllerQueryTool.setBoProgectGoodsImagesCriteria(bootGridReq.getQuery(),boProgectGoodsImagesExample.createCriteria());
		List<BoProgectGoodsImages> boProgectGoodsImagesList = boProgectGoodsImagesDao.selectByExample(boProgectGoodsImagesExample);
		return new BootStrapGridResp(page.getTotal(),boProgectGoodsImagesList);
	}

	public HttpResult save(String formObjectJson){
		BoProgectGoodsImages boProgectGoodsImages= JSON.parseObject(formObjectJson,BoProgectGoodsImages.class);
			java.lang.String id=boProgectGoodsImages.getId();
		if (id!=null) {
			boProgectGoodsImagesDao.updateByPrimaryKeySelective(boProgectGoodsImages);
		}else{
			boProgectGoodsImages.setId(UUIDTool.getUUID());
			boProgectGoodsImagesDao.insertSelective(boProgectGoodsImages);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boProgectGoodsImagesDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

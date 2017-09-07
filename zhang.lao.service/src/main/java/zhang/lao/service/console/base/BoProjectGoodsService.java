package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import zhang.lao.build.kit.LogKit;
import zhang.lao.dao.base.BoProjectGoodsDao;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectGoods;
import zhang.lao.build.mybatis.jdbc.auto.model.BoProjectGoodsExample;
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
public class BoProjectGoodsService{
	@Resource
	private BoProjectGoodsDao boProjectGoodsDao;

	public String add(){
		return "console/boProjectGoods/boProjectGoods_form";
	}

	public String edit(ModelMap modelMap,java.lang.String id){
			modelMap.put("boProjectGoods", boProjectGoodsDao.selectByPrimaryKey(id));
		return "console/boProjectGoods/boProjectGoods_form";
	}

	public String list(){
		return "console/boProjectGoods/boProjectGoods_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		BoProjectGoodsExample boProjectGoodsExample = new BoProjectGoodsExample();
        ControllerQueryTool.setBoProjectGoodsCriteria(bootGridReq.getQuery(),boProjectGoodsExample.createCriteria());
		List<BoProjectGoods> boProjectGoodsList = boProjectGoodsDao.selectByExample(boProjectGoodsExample);
		return new BootStrapGridResp(page.getTotal(),boProjectGoodsList);
	}

	public HttpResult save(String formObjectJson){
		BoProjectGoods boProjectGoods= JSON.parseObject(formObjectJson,BoProjectGoods.class);
			java.lang.String id=boProjectGoods.getId();
		if (id!=null) {
			boProjectGoodsDao.updateByPrimaryKeySelective(boProjectGoods);
		}else{
			boProjectGoods.setId(UUIDTool.getUUID());
			boProjectGoodsDao.insertSelective(boProjectGoods);
		}
		return HttpResultUtil.buildSuccess();

	}

	@Transactional
	public HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		boProjectGoodsDao.deleteByPrimaryKey(java.lang.String.valueOf(id));
		}
		return HttpResultUtil.buildSuccess();
	}
}

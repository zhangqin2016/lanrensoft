package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.console.model.bootgrid.BootGridModel;
import zhang.lao.mybatis.auto.dao.BrandInfoMapper;
import zhang.lao.mybatis.auto.model.BrandInfo;
import zhang.lao.mybatis.auto.model.BrandInfoExample;
import zhang.lao.pojo.resault.CommonResp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@Controller
public class BrandInfoController{
	@Resource
	private BrandInfoMapper modelMapper;

	@RequestMapping("/sunarvr/console/brand_info/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/brandInfo/brandInfo_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/sunarvr/console/brand_info/edit")
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("brandInfo", modelMapper.selectByPrimaryKey(id));
		return "console/brandInfo/brandInfo_form";
	}

	@RequestMapping("/sunarvr/console/brand_info/list")
	public String list(){
		return "console/brandInfo/brandInfo_table";
	}

	@RequestMapping("/sunarvr/console/brand_info/json")
	public @ResponseBody String json(HttpServletRequest request,String querys,int current,int rowCount,String searchPhrase){
		BrandInfoExample brandInfoExample = new BrandInfoExample();
		getCriteria(querys,brandInfoExample.createCriteria());
		Page page = PageHelper.startPage(current, rowCount);
		modelMapper.selectByExample(brandInfoExample);
		List<BrandInfo> brandInfoList = modelMapper.selectByExample(brandInfoExample);
		return CommonResp.objectToJson(new BootGridModel(current, rowCount, brandInfoList, page.getTotal()));
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/sunarvr/console/brand_info/save")
	public @ResponseBody String save(String formObjectJson){
		try{
		BrandInfo brandInfo= JSON.parseObject(formObjectJson,BrandInfo.class);
			Integer id=brandInfo.getBrandId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(brandInfo);
			return CommonResp.getJson(CommonResp.getSuccess());
		}else{
			modelMapper.insertSelective(brandInfo);
			return CommonResp.getJson(CommonResp.getSuccess());
		}
		}catch(Exception e){
			e.printStackTrace();
			return CommonResp.getJson(CommonResp.getError());
		}

	}

	@RequestMapping("/sunarvr/console/brand_info/delete")
	public @ResponseBody String delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getJson(CommonResp.getSuccess());
	}

	private BrandInfoExample.Criteria getCriteria(String querys,BrandInfoExample.Criteria criteria){
		BrandInfo brandInfo = JSON.parseObject(querys,BrandInfo.class);
		if(brandInfo.getShopId()!=null){
    criteria.andShopIdEqualTo(brandInfo.getShopId());
}
if(brandInfo.getName()!=null){
    criteria.andNameEqualTo(brandInfo.getName());
}
if(brandInfo.getLogo()!=null){
    criteria.andLogoEqualTo(brandInfo.getLogo());
}
if(brandInfo.getStatus()!=null){
    criteria.andStatusEqualTo(brandInfo.getStatus());
}
if(brandInfo.getRecommendTime()!=null){
    criteria.andRecommendTimeEqualTo(brandInfo.getRecommendTime());
}
if(brandInfo.getRecommend()!=null){
    criteria.andRecommendEqualTo(brandInfo.getRecommend());
}

		return criteria;
	}
}

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
import zhang.lao.mybatis.auto.dao.SysNavMapper;
import zhang.lao.mybatis.auto.model.SysNav;
import zhang.lao.mybatis.auto.model.SysNavExample;
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
public class SysNavController{
	@Resource
	private SysNavMapper modelMapper;

	@RequestMapping("/sunarvr/console/sys_nav/add")
	@RepeatSubmit(isAdd = true)
	public String add(){
		return "console/sysNav/sysNav_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/sunarvr/console/sys_nav/edit")
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysNav", modelMapper.selectByPrimaryKey(id));
		return "console/sysNav/sysNav_form";
	}

	@RequestMapping("/sunarvr/console/sys_nav/list")
	public String list(){
		return "console/sysNav/sysNav_table";
	}

	@RequestMapping("/sunarvr/console/sys_nav/json")
	public @ResponseBody String json(HttpServletRequest request,String querys,int current,int rowCount,String searchPhrase){
		SysNavExample sysNavExample = new SysNavExample();
        setCriteria(querys,sysNavExample.createCriteria());
		Page page = PageHelper.startPage(current, rowCount);
		List<SysNav> sysNavList = modelMapper.selectByExample(sysNavExample);
		return CommonResp.objectToJson(new BootGridModel(current, rowCount, sysNavList, page.getTotal()));
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/sunarvr/console/sys_nav/save")
	public @ResponseBody String save(String formObjectJson){
		try{
		SysNav sysNav= JSON.parseObject(formObjectJson,SysNav.class);
			Integer id=sysNav.getNavId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysNav);
			return CommonResp.getJson(CommonResp.getSuccess());
		}else{
			modelMapper.insertSelective(sysNav);
			return CommonResp.getJson(CommonResp.getSuccess());
		}
		}catch(Exception e){
			e.printStackTrace();
			return CommonResp.getJson(CommonResp.getError());
		}

	}

	@RequestMapping("/sunarvr/console/sys_nav/delete")
	public @ResponseBody String delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getJson(CommonResp.getSuccess());
	}

	private SysNavExample.Criteria setCriteria(String querys,SysNavExample.Criteria criteria){
		SysNav sysNav = JSON.parseObject(querys,SysNav.class);
		       if(sysNav.getName()!=null){
           criteria.andNameEqualTo(sysNav.getName());
          }
       if(sysNav.getUrl()!=null){
           criteria.andUrlEqualTo(sysNav.getUrl());
          }
       if(sysNav.getUrlTarget()!=null){
           criteria.andUrlTargetEqualTo(sysNav.getUrlTarget());
          }
       if(sysNav.getIconUrl()!=null){
           criteria.andIconUrlEqualTo(sysNav.getIconUrl());
          }
       if(sysNav.getSort()!=null){
           criteria.andSortEqualTo(sysNav.getSort());
          }
       if(sysNav.getpId()!=null){
           criteria.andPIdEqualTo(sysNav.getpId());
          }
       if(sysNav.getStatus()!=null){
           criteria.andStatusEqualTo(sysNav.getStatus());
          }
       if(sysNav.getLevel()!=null){
           criteria.andLevelEqualTo(sysNav.getLevel());
          }
       if(sysNav.getIsShow()!=null){
           criteria.andIsShowEqualTo(sysNav.getIsShow());
          }

		return criteria;
	}
}

package zhang.lao.console.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.log.LogKit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.lao.annotation.RepeatSubmit;
import zhang.lao.console.model.bootgrid.BootGridModel;
import zhang.lao.mybatis.auto.dao.SysNavMapper;
import zhang.lao.mybatis.auto.model.SysNav;
import zhang.lao.mybatis.auto.model.SysNavExample;
import zhang.lao.pojo.resp.CommonResp;
import zhang.lao.pojo.resp.HttpResult;
import com.lz.tool.UUIDTool;

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

	@RequestMapping("/console/sys_nav/add")
	@RepeatSubmit(isAdd = true)
	public String add(int p_id,Short level,ModelMap model){
		SysNav nav=new SysNav();
		nav.setpId(p_id);
		nav.setLevel(level);
		model.put("sysNav", nav);
		return "console/sysNav/sysNav_form";
	}

	@RepeatSubmit(isAdd = true)
	@RequestMapping("/console/sys_nav/edit")
	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysNav", modelMapper.selectByPrimaryKey(id));
		return "console/sysNav/sysNav_form";
	}

	@RequestMapping("/console/sys_nav/list")
	public String list(Integer p_id,Short level,ModelMap modelMap)
	{
		modelMap.put("p_id",p_id);
		modelMap.put("level",level);
		return "console/sysNav/sysNav_table";
	}

	@RequestMapping("/console/sys_nav/json")
	public @ResponseBody BootGridModel json(HttpServletRequest request,String querys,int current,int rowCount,String searchPhrase){
		rowCount=rowCount==-1?0:rowCount;
		SysNavExample sysNavExample = new SysNavExample();
        setCriteria(querys,sysNavExample.createCriteria());
		Page page = PageHelper.startPage(current, rowCount);
		List<SysNav> sysNavList = modelMapper.selectByExample(sysNavExample);
		return new BootGridModel(current, rowCount, sysNavList, page.getTotal());
	}

	@RepeatSubmit(isAdd = false)
	@RequestMapping("/console/sys_nav/save")
	public @ResponseBody
	HttpResult save(String formObjectJson){
		try{
		SysNav sysNav= JSON.parseObject(formObjectJson,SysNav.class);
			Integer id=sysNav.getNavId();
		if (id!=null) {
			modelMapper.updateByPrimaryKeySelective(sysNav);
			return CommonResp.getSuccess();
		}else{
			sysNav.setUuid(UUIDTool.getUUID());
			modelMapper.insertSelective(sysNav);
			return CommonResp.getSuccess();
		}
		}catch(Exception e){
			LogKit.error(e.getMessage());
			return CommonResp.getError();
		}

	}

	@RequestMapping("/console/sys_nav/delete")
	public @ResponseBody HttpResult delete(String ids){
		String[]idsa=ids.split(",");
		for (String id : idsa) {
		modelMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
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

package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import zhang.lao.dao.base.SysReqUrlDao;
import com.lz.mybatis.jdbc.auto.model.SysReqUrl;
import com.lz.mybatis.jdbc.auto.model.SysReqUrlExample;
import com.lz.tool.LzStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.dao.ControllerQueryTool;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;
import zhang.lao.pojo.console.resp.CommonResp;
import zhang.lao.pojo.console.resp.HttpResult;

import javax.annotation.Resource;
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
public class SysReqUrlService{
	@Resource
	private SysReqUrlDao sysReqUrlDao;

	public String add(){
		return "console/sysReqUrl/sysReqUrl_form";
	}

	public String edit(ModelMap modelMap,String id){
			modelMap.put("sysReqUrl", sysReqUrlDao.selectByPrimaryKey(id));
		return "console/sysReqUrl/sysReqUrl_form";
	}

	public String list(){
		return "console/sysReqUrl/sysReqUrl_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysReqUrlExample sysReqUrlExample = new SysReqUrlExample();
        ControllerQueryTool.setSysReqUrlCriteria(bootGridReq.getQuery(),sysReqUrlExample.createCriteria());
		List<SysReqUrl> sysReqUrlList = sysReqUrlDao.selectByExample(sysReqUrlExample);
		return new BootStrapGridResp(page.getTotal(),sysReqUrlList);
	}

	public HttpResult save(String formObjectJson){
		try{
		SysReqUrl sysReqUrl= JSON.parseObject(formObjectJson,SysReqUrl.class);
			String id=sysReqUrl.getId();
		if (id!=null) {
			sysReqUrlDao.updateByPrimaryKeySelective(sysReqUrl);
			return CommonResp.getSuccess();
		}else{
			sysReqUrlDao.insertSelective(sysReqUrl);
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
		sysReqUrlDao.deleteByPrimaryKey(String.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}

package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lz.kit.LogKit;
import zhang.lao.dao.base.SysUserDao;
import com.lz.mybatis.jdbc.auto.model.SysUser;
import com.lz.mybatis.jdbc.auto.model.SysUserExample;
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
public class SysUserService{
	@Resource
	private SysUserDao sysUserDao;

	public String add(){
		return "console/sysUser/sysUser_form";
	}

	public String edit(ModelMap modelMap,Integer id){
			modelMap.put("sysUser", sysUserDao.selectByPrimaryKey(id));
		return "console/sysUser/sysUser_form";
	}

	public String list(){
		return "console/sysUser/sysUser_table";
	}

	public BootStrapGridResp json(BootStrapGridReq bootGridReq){
		Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
    	if(bootGridReq.getSort()!=null) {
    		page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
    	}
		SysUserExample sysUserExample = new SysUserExample();
        ControllerQueryTool.setSysUserCriteria(bootGridReq.getQuery(),sysUserExample.createCriteria());
		List<SysUser> sysUserList = sysUserDao.selectByExample(sysUserExample);
		return new BootStrapGridResp(page.getTotal(),sysUserList);
	}

	public HttpResult save(String formObjectJson){
		try{
		SysUser sysUser= JSON.parseObject(formObjectJson,SysUser.class);
			Integer id=sysUser.getSuId();
		if (id!=null) {
			sysUserDao.updateByPrimaryKeySelective(sysUser);
			return CommonResp.getSuccess();
		}else{
			sysUserDao.insertSelective(sysUser);
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
		sysUserDao.deleteByPrimaryKey(Integer.valueOf(id));
		}
		return CommonResp.getSuccess();
	}
}

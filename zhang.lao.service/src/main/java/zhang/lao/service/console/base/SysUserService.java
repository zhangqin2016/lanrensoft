package zhang.lao.service.console.base;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;
import zhang.lao.build.kit.LogKit;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserRole;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserRoleExample;
import zhang.lao.build.tool.MD5;
import org.springframework.web.bind.annotation.RequestMapping;
import zhang.lao.build.tool.UUIDTool;
import zhang.lao.dao.base.SysUserDao;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUser;
import zhang.lao.build.mybatis.jdbc.auto.model.SysUserExample;
import zhang.lao.build.tool.LzStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import zhang.lao.build.mybatis.jdbc.auto.tool.ControllerQueryTool;
import zhang.lao.dao.base.SysUserRoleDao;
import zhang.lao.pojo.console.common.ConsoleContext;
import zhang.lao.pojo.console.req.BootStrapGridReq;
import zhang.lao.pojo.console.resp.BootStrapGridResp;

import zhang.lao.pojo.console.resp.HttpResult;
import zhang.lao.pojo.console.resp.HttpResultEnum;
import zhang.lao.pojo.console.resp.HttpResultUtil;

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
@Service
public class SysUserService{
	@Resource
	private SysUserDao sysUserDao;
	@Resource
	private SysUserRoleDao sysUserRoleDao;
		public String add(){
			return "console/sysUser/sysUser_form";
		}

		public String edit(ModelMap modelMap,String id){
			modelMap.put("sysUser", sysUserDao.selectByPrimaryKey(id));
			return "console/sysUser/sysUser_form";
		}
		public String select(){
			return "console/sysUser/sysUserSelect_table";
		}
		public String list(){
			return "console/sysUser/sysUser_table";
		}

		public
		BootStrapGridResp json(BootStrapGridReq bootGridReq){
			Page page = PageHelper.offsetPage(bootGridReq.getOffset(), bootGridReq.getLimit());
			if(bootGridReq.getSort()!=null) {
				page.setOrderBy(LzStringUtils.chageStringUpCaseAnd_(bootGridReq.getSort()) + " " + bootGridReq.getOrder());
			}
			SysUserExample sysUserExample = new SysUserExample();
			ControllerQueryTool.setSysUserCriteria(bootGridReq.getQuery(),sysUserExample.createCriteria());
			List<SysUser> sysUserList = sysUserDao.selectByExample(sysUserExample);
			return new BootStrapGridResp(page.getTotal(),sysUserList);
		}

		@RequestMapping("/console/sys_user/save")
		public
		HttpResult save(String formObjectJson){
				SysUser sysUser= JSON.parseObject(formObjectJson,SysUser.class);
				String id=sysUser.getSuId();
				if (id!=null) {
					sysUserDao.updateByPrimaryKeySelective(sysUser);
					return HttpResultUtil.buildSuccess();
				}else{
					sysUser.setUserType((short) 2);
					sysUser.setUserPassword(MD5.MD5Encode("123456"));
					sysUser.setSuId(UUIDTool.getUUID());
					sysUserDao.insertSelective(sysUser);
					return HttpResultUtil.buildSuccess();
				}
		}

		@Transactional
		public HttpResult delete(String ids){
			String[]idsa=ids.split(",");
			for (String id : idsa) {
				if(id.equals("1")){
					continue;
				}
				SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
				sysUserRoleExample.createCriteria().andSuIdEqualTo(id);
				sysUserRoleDao.deleteByExample(sysUserRoleExample);
				sysUserDao.deleteByPrimaryKey(String.valueOf(id));
			}
			return HttpResultUtil.buildSuccess();
		}

		public String base(){
			return "console/sysUser/sys_user_base";
		}

		public String changepass(){
			return "console/sysUser/sys_user_change_pass";
		}

		public
		HttpResult dochangepass(String old_password, String new_password, ConsoleContext consoleContext){
			SysUserExample sysUserExample=new SysUserExample();
			sysUserExample.createCriteria().andSuIdEqualTo(consoleContext.getUserId()).andUserPasswordEqualTo(MD5.MD5Encode(old_password));
			if(sysUserDao.countByExample(sysUserExample)>0){
				SysUser sysUser=sysUserDao.selectByPrimaryKey(consoleContext.getUserId());
				sysUser.setUserPassword(MD5.MD5Encode(new_password));
				sysUserDao.updateByPrimaryKeySelective(sysUser);
				return HttpResultUtil.buildSuccess();
			}else{
				return HttpResultUtil.buildError(HttpResultEnum.OLDPASSWORDERROR);
			}
		}
	}


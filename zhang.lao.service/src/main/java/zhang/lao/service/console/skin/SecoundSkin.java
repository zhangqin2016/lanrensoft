package zhang.lao.service.console.skin;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import zhang.lao.dao.base.SysNavDao;
import zhang.lao.pojo.console.ConsoleCacheNameContanst;
import zhang.lao.pojo.console.login.LoginUserModel;
import zhang.lao.service.console.NavService;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNav;
import zhang.lao.build.mybatis.jdbc.auto.model.SysNavExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * title:第二款皮肤获取类
 * </p>
 * <p>
 * description:
 * </p>
 *
 * @author 2016 北京太阳花互动科技有限公司 All Rights Reserved.
 * @create zhangqin
 * @update
 * @version 1.0
 * @date 2016年3月9日
 */
@Service(value = "secoundSkin")
public class SecoundSkin implements SkinNav{
	@Resource
	private SecondSkinTool secondSkinTool;
	@Resource
	private SysNavDao sysNavDao;
	@Resource
	private NavService navService;

	@Override
	/**
	 * 获取页面导航根据系统id
	 */
	@Cacheable(value = ConsoleCacheNameContanst.consoleServiceName)
	public String gethtml(String sys_id, LoginUserModel user_id, String ctxPath) {
		StringBuffer buffer=new StringBuffer();
		SysNavExample sysNavExample = new SysNavExample();
		sysNavExample.createCriteria().andLevelsEqualTo((short) 2).andPidEqualTo(sys_id).andStatusEqualTo((short) 1);
		sysNavExample.setOrderByClause("sort asc");
			if(navService.permissions(sys_id, user_id)) {
			List<SysNav> listNav = sysNavDao.selectByExample(sysNavExample);
			for (SysNav sysNav : listNav) {
				if(navService.permissions(sysNav.getNavId(), user_id)) {
					buffer.append(secondSkinTool.getNav(sysNav, user_id, ctxPath));
				}
			}
		}
		
		return buffer.toString();
	}

}

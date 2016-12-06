package zhang.lao.console.skin;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import zhang.lao.console.cache.ConsoleCacheNameContanst;
import zhang.lao.console.service.NavService;
import com.lz.mybatis.jdbc.auto.dao.SysNavMapper;
import com.lz.mybatis.jdbc.auto.model.SysNav;
import com.lz.mybatis.jdbc.auto.model.SysNavExample;

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
	private SysNavMapper sysNavMapper;
	@Resource
	private NavService navService;
	
	@Override
	/**
	 * 获取页面导航根据系统id
	 */
	@Cacheable(value = ConsoleCacheNameContanst.consoleServiceName)
	public String gethtml(Integer sys_id,Integer user_id,String ctxPath) {
		StringBuffer buffer=new StringBuffer();
		SysNavExample sysNavExample = new SysNavExample();
		sysNavExample.createCriteria().andLevelsEqualTo((short) 2).andPidEqualTo(sys_id).andStatusEqualTo((short) 1);
		if(navService.permissions(sys_id, user_id)) {
			List<SysNav> listNav = sysNavMapper.selectByExample(sysNavExample);
			for (SysNav sysNav : listNav) {
				if(navService.permissions(sysNav.getNavId(), user_id)) {
					buffer.append(secondSkinTool.getNav(sysNav, user_id, ctxPath));
				}
			}
		}
		
		return buffer.toString();
	}

}

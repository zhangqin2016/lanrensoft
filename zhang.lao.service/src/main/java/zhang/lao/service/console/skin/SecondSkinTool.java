package zhang.lao.service.console.skin;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import zhang.lao.dao.base.SysNavDao;
import zhang.lao.pojo.console.ConsoleCacheNameContanst;
import zhang.lao.service.console.NavService;
import com.lz.mybatis.jdbc.auto.model.SysNav;
import com.lz.mybatis.jdbc.auto.model.SysNavExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * title:第二款皮肤工具类
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

@Component
public class SecondSkinTool {

	@Resource
	private NavService navService;
	@Resource
	private SysNavDao navDao;

	public  String getNav(SysNav sysNav, Integer user_id, String ctxPath){
		if(navService.hasNext(sysNav.getNavId())){
			return getThreeNav(user_id,sysNav, ctxPath);
		}else{
			return getSecoundNav(sysNav,ctxPath);
		}
	}

	/**
	 * 获取一级菜单
	 * @return
	 */
	@Cacheable(value = ConsoleCacheNameContanst.consoleServiceName)
	public  String getFirstNav(Integer user_id,String ctxPath){
		StringBuffer sb=new StringBuffer();
		SysNavExample sysNavExample = new SysNavExample();
		sysNavExample.createCriteria().andPidEqualTo(new Integer("0")).andStatusEqualTo(new Short("1"));
		sysNavExample.setOrderByClause("sort asc");
		List<SysNav> list = navDao.selectByExample(sysNavExample);
		for (SysNav nav : list) {
			if(navService.permissions(nav.getNavId(), user_id)){
				if(navService.hasNext(nav.getNavId())){
					sb.append("<li> \r\n");
					sb.append("<a  name='first_nav' id='first_"+nav.getNavId()+"' href=\""+ctxPath+"/console/nav/trun/first?nav_id="+nav.getNavId()+"\">"+nav.getName()+"</a>\r\n");
					sb.append("</li> \r\n");
				}else{
					sb.append("<li > \r\n");
					sb.append("<a name='first_nav' id='"+nav.getNavId()+"' href=\""+ctxPath+nav.getUrl()+"\">"+nav.getName()+"</a>\r\n");
					sb.append("</li> \r\n");
				}
			}
		}
		return sb.toString();

	}

	/**
	 * 获取二级菜单
	 * @param sysNav
	 * @return
	 */
	public  String getSecoundNav(SysNav sysNav, String ctxPath){
		StringBuffer sb=new StringBuffer();
		sb.append("<li  class=\"bg-palette2\">                                                       \r\n");
		sb.append("<a name='second_nav' id='second_"+sysNav.getNavId()+"' href=\""+ctxPath+sysNav.getUrl()+"\">                                                                    \r\n");
		sb.append("	<span class=\"menu-content block\">                                             \r\n");
		sb.append("		<span class=\"menu-icon\"><span class=\""+sysNav.getIconUrl()+"\"></span></span>\r\n");
		sb.append("		<span class=\"text m-left-sm\">"+sysNav.getName()+"</span>                                     \r\n");
		sb.append("	</span>                                                                         \r\n");
		sb.append("	<span class=\"menu-content-hover block\">                                       \r\n");
		sb.append("		"+sysNav.getName()+"                                                                     \r\n");
		sb.append("	</span>                                                                         \r\n");
		sb.append("</a>                                                                             \r\n");
		sb.append("</li>                                                                             \r\n");
		return sb.toString();

	}
	/**
	 * 获取三级菜单
	 * @param sysNav
	 * @return
	 */
	public  String getThreeNav(Integer user_id ,SysNav sysNav, String ctxPath){
		StringBuffer sb=new StringBuffer();
		sb.append("<li  class=\"openable bg-palette3\">                                                       \r\n");
		sb.append("<a href=\"#\" name='second_three_nav' id='second_"+sysNav.getNavId()+"' >                                                                    \r\n");
		sb.append("	<span class=\"menu-content block\">                                             \r\n");
		sb.append("		<span class=\"menu-icon\"><i class=\""+sysNav.getIconUrl()+"\"></i></span>\r\n");
		sb.append("		<span class=\"text m-left-sm\">"+sysNav.getName()+"</span>                                     \r\n");
		sb.append("<span class=\"submenu-icon\"></span>  \r\n");
		sb.append("	</span>                                                                         \r\n");
		sb.append("	<span class=\"menu-content-hover block\">                                       \r\n");
		sb.append("		"+sysNav.getName()+"                                                                     \r\n");
		sb.append("	</span>                                                                         \r\n");
		sb.append("</a>                                                                             \r\n");
		sb.append("<ul class=\"submenu\">\r\n");
		SysNavExample sys_nav_query=new SysNavExample();
		sys_nav_query.createCriteria().andStatusEqualTo((short) 1).andPidEqualTo(sysNav.getNavId());
		sys_nav_query.setOrderByClause("sort asc");
		List<SysNav>listNav= navDao.selectByExample(sys_nav_query);
		for (SysNav sysNav2 : listNav) {
			if(navService.permissions(sysNav.getNavId(), user_id)) {
				sb.append("<li ><a  name='three_nav' id='three_"+sysNav2.getNavId()+"' href=\"" + ctxPath + sysNav2.getUrl() + "\"><span class=\"submenu-label\">" + sysNav2.getName() + "</span></a></li>\r\n");
			}
		}
		sb.append("</ul>     \r\n");
		sb.append("</li>                                                                             \r\n");
		return sb.toString();

	}
}
